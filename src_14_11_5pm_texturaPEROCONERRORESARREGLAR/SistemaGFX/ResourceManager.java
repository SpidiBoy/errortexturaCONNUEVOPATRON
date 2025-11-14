/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGFX;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author LENOVO
 */
public class ResourceManager {
    private final CargadorImagenes imageLoader;
    private final Map<String, SpriteRepository> repositories;
    private int currentLevel;
    
    /**
     * Constructor con Dependency Injection
     */
    public ResourceManager(CargadorImagenes imageLoader) {
        this.imageLoader = imageLoader;
        this.repositories = new HashMap<>();
        this.currentLevel = 1;
    }
    
    /**
     * Inicializa TODOS los recursos del juego
     */
    public void initialize() {
        System.out.println("[RESOURCE] Inicializando sistema de recursos...");
        
        loadGlobalResources();
        loadLevel(1); // Nivel inicial
        
        System.out.println("[RESOURCE] ✓ Sistema inicializado");
    }
    
    /**
     * Carga recursos globales (independientes del nivel)
     */
    public void loadGlobalResources() {
        System.out.println("[RESOURCE] Cargando recursos globales...");
        
        // Player
        loadPlayerResources();
        
        // Enemigos
        loadEnemyResources();
        
        // Items
        loadItemResources();
        
        // NPCs
        loadNPCResources();
        
        System.out.println("[RESOURCE] ✓ Recursos globales cargados");
    }
    
    private void loadPlayerResources() {
        SpriteLoader loader = new PlayerSpriteLoader(imageLoader);
        Map<String, BufferedImage> sprites = loader.loadSprites();
        repositories.put("player", new PlayerSpriteRepository(sprites));
    }
    
    private void loadEnemyResources() {
        SpriteLoader loader = new EnemySpriteLoader(imageLoader);
        Map<String, BufferedImage> sprites = loader.loadSprites();
        repositories.put("enemies", new EnemySpriteRepository(sprites));
    }
    
    private void loadItemResources() {
        SpriteLoader loader = new ItemSpriteLoader(imageLoader);
        Map<String, BufferedImage> sprites = loader.loadSprites();
        repositories.put("items", new ItemSpriteRepository(sprites));
    }
    
    private void loadNPCResources() {
        SpriteLoader loader = new NPCSpriteLoader(imageLoader);
        Map<String, BufferedImage> sprites = loader.loadSprites();
        repositories.put("npcs", new NPCSpriteRepository(sprites));
    }
    
    /**
     * Carga recursos específicos de un nivel
     */
    public void loadLevel(int level) {
        System.out.println("[RESOURCE] Cargando nivel " + level + "...");
        
        SpriteLoader loader = new TilesetLoader(imageLoader, level);
        Map<String, BufferedImage> tiles = loader.loadSprites();
        repositories.put("tileset", new TilesetRepository(tiles));
        
        this.currentLevel = level;
        
        System.out.println("[RESOURCE] ✓ Nivel " + level + " cargado");
    }
    
    // ==================== ACCESO A REPOSITORIOS ====================
    
    public PlayerSpriteRepository getPlayerRepository() {
        return (PlayerSpriteRepository) repositories.get("player");
    }
    
    public EnemySpriteRepository getEnemyRepository() {
        return (EnemySpriteRepository) repositories.get("enemies");
    }
    
    public ItemSpriteRepository getItemRepository() {
        return (ItemSpriteRepository) repositories.get("items");
    }
    
    public NPCSpriteRepository getNPCRepository() {
        return (NPCSpriteRepository) repositories.get("npcs");
    }
    
    public TilesetRepository getTilesetRepository() {
        return (TilesetRepository) repositories.get("tileset");
    }
    
    // ==================== MÉTODOS DE COMPATIBILIDAD (Legacy) ====================
    
    /**
     * Compatibilidad con código legacy que usa Texturas
     * @deprecated Usar getPlayerRepository().getWalkingAnimation()
     */
    @Deprecated
    public BufferedImage[] getMarioS() {
        return getPlayerRepository().getWalkingAnimation();
    }
    
    /**
     * @deprecated Usar getTilesetRepository().getTileByID(id)
     */
    @Deprecated
    public BufferedImage getSpritePorID(int tileID) {
        return getTilesetRepository().getTileByID(tileID);
    }
    
    // ==================== GESTIÓN ====================
    
    public int getCurrentLevel() {
        return currentLevel;
    }
    
    /**
     * Libera recursos (para cambios de nivel)
     */
    public void unloadLevel() {
        repositories.remove("tileset");
        System.out.println("[RESOURCE] Nivel descargado");
    }
    
    /**
     * Debug info
     */
    public String getInfo() {
        return String.format(
            "ResourceManager [Nivel: %d, Repositorios: %d]",
            currentLevel,
            repositories.size()
        );
    }
}
