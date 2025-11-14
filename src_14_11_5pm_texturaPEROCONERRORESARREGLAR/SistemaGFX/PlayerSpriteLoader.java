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
public class PlayerSpriteLoader implements SpriteLoader{
    private final CargadorImagenes imageLoader;
    private final String sheetPath = "/Imagenes/testt.png";
    
    public PlayerSpriteLoader(CargadorImagenes imageLoader) {
        this.imageLoader = imageLoader;
    }
    
    @Override
    public Map<String, BufferedImage> loadSprites() {
        Map<String, BufferedImage> sprites = new HashMap<>();
        
        BufferedImage sheet = imageLoader.loadImage(sheetPath);
        if (sheet == null) {
            System.err.println("[LOADER] Error cargando sheet de player");
            return sprites;
        }
        
        // Extraer sprites normales (16x16)
        extractNormalSprites(sheet, sprites);
        
        // Extraer sprites de martillo (32x32)
        extractHammerSprites(sheet, sprites);
        
        // Extraer sprites de muerte
        extractDeathSprites(sheet, sprites);
        
        System.out.println("[LOADER] Player: " + sprites.size() + " sprites cargados");
        return sprites;
    }
    
    private void extractNormalSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int x_off = 1, y_off = 1, width = 16, height = 16;
        
        sprites.put("player_idle", sheet.getSubimage(x_off, y_off, width, height));
        sprites.put("player_walk_1", sheet.getSubimage(x_off + 18, y_off, width, height));
        sprites.put("player_walk_2", sheet.getSubimage(x_off + 36, y_off, width, height));
        sprites.put("player_walk_3", sheet.getSubimage(x_off + 54, y_off, width, height));
        sprites.put("player_jump", sheet.getSubimage(x_off + 72, y_off, width, height));
        
        // Sprites de escalera
        sprites.put("player_ladder_1", sheet.getSubimage(x_off + 90, y_off, width, height));
        sprites.put("player_ladder_2", sheet.getSubimage(x_off + 108, y_off, width, height));
    }
    
    private void extractHammerSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int x_off = 1, y_off = 73, width = 32, height = 32;
        
        for (int i = 0; i < 6; i++) {
            String key = "player_hammer_" + i;
            sprites.put(key, sheet.getSubimage(x_off + i * (width + 2), y_off, width, height));
        }
    }
    
    private void extractDeathSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int x_off = 1, y_off = 37, width = 16, height = 16;
        
        for (int i = 0; i < 6; i++) {
            String key = "player_death_" + i;
            sprites.put(key, sheet.getSubimage(x_off + i * (width + 2), y_off, width, height));
        }
    }
    
    @Override
    public String getLoaderName() {
        return "PlayerSpriteLoader";
    }
}
