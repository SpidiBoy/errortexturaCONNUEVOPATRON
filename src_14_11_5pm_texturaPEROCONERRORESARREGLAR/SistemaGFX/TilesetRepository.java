/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGFX;
import java.awt.image.BufferedImage;
import java.util.Map;
/**
 *
 * @author LENOVO
 */
public class TilesetRepository implements SpriteRepository {
    private final Map<String, BufferedImage> tiles;
    
    public TilesetRepository(Map<String, BufferedImage> tiles) {
        this.tiles = tiles;
    }
    
    @Override
    public BufferedImage getSprite(String name) {
        return tiles.get(name);
    }
    
    @Override
    public BufferedImage[] getAllSprites() {
        return tiles.values().toArray(new BufferedImage[0]);
    }
    
    @Override
    public boolean hasSprite(String name) {
        return tiles.containsKey(name);
    }
    
    // ==================== MÉTODO ESPECÍFICO DE TILESETS ====================
    
    /**
     * Obtiene tile por ID (compatibilidad con código legacy)
     */
    public BufferedImage getTileByID(int tileID) {
        return getSprite("tile_" + tileID);
    }

}
