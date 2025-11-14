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
public class EnemySpriteLoader implements SpriteLoader{
    private final CargadorImagenes imageLoader;
    private final String sheetPath = "/Imagenes/testt.png";
    
    public EnemySpriteLoader(CargadorImagenes imageLoader) {
        this.imageLoader = imageLoader;
    }
    
    @Override
    public Map<String, BufferedImage> loadSprites() {
        Map<String, BufferedImage> sprites = new HashMap<>();
        
        BufferedImage sheet = imageLoader.loadImage(sheetPath);
        if (sheet == null) return sprites;
        
        // Extraer sprites de barriles
        extractBarrelSprites(sheet, sprites);
        
        // Extraer sprites de fuego
        extractFireSprites(sheet, sprites);
        
        // Extraer sprites de llama
        extractFlameSprites(sheet, sprites);
        
        System.out.println("[LOADER] Enemigos: " + sprites.size() + " sprites cargados");
        return sprites;
    }
    
    private void extractBarrelSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int x_off = 1, y_off = 229, width = 16, height = 16;
        
        for (int i = 0; i < 8; i++) {
            String key = "barrel_" + i;
            sprites.put(key, sheet.getSubimage(x_off + i * (width + 2), y_off, width, height));
        }
    }
    
    private void extractFireSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int x_off = 1, y_off = 193, width = 16, height = 16;
        
        for (int i = 0; i < 4; i++) {
            String key = "fire_" + i;
            sprites.put(key, sheet.getSubimage(x_off + i * (width + 2), y_off, width, height));
        }
    }
    
    private void extractFlameSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int x_off = 163, y_off = 193, width = 16, height = 16;
        
        for (int i = 0; i < 4; i++) {
            String key = "flame_" + i;
            sprites.put(key, sheet.getSubimage(x_off + i * (width + 2), y_off, width, height));
        }
    }
    
    @Override
    public String getLoaderName() {
        return "EnemySpriteLoader";
    }
}
