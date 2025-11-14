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
public class ItemSpriteLoader implements SpriteLoader{
    private final CargadorImagenes imageLoader;
    private final String sheetPath = "/Imagenes/testt.png";
    
    public ItemSpriteLoader(CargadorImagenes imageLoader) {
        this.imageLoader = imageLoader;
    }
    
    @Override
    public Map<String, BufferedImage> loadSprites() {
        Map<String, BufferedImage> sprites = new HashMap<>();
        
        BufferedImage sheet = imageLoader.loadImage(sheetPath);
        if (sheet == null) {
            System.err.println("[LOADER] Error cargando sheet de items");
            return sprites;
        }
        
        // Martillo
        extractSprite(sheet, sprites, "hammer", 1, 55, 16, 16);
        
        // Paraguas
        extractSprite(sheet, sprites, "umbrella", 145, 157, 16, 16);
        
        // Bolso
        extractSprite(sheet, sprites, "purse", 145 + 18*2, 157, 16, 16);
        
        // Sombrero
        extractSprite(sheet, sprites, "hat", 145 + 18, 157, 16, 16);
        
        // Sprites de victoria
        extractSprite(sheet, sprites, "heart", 109, 157, 16, 16);
        extractSprite(sheet, sprites, "broken_heart", 127, 157, 16, 16);
        
        System.out.println("[LOADER] Items: " + sprites.size() + " sprites cargados");
        return sprites;
    }
    
    private void extractSprite(BufferedImage sheet, Map<String, BufferedImage> sprites,
                               String name, int x, int y, int width, int height) {
        try {
            sprites.put(name, sheet.getSubimage(x, y, width, height));
        } catch (Exception e) {
            System.err.println("[LOADER] Error extrayendo sprite: " + name);
        }
    }
    
    @Override
    public String getLoaderName() {
        return "ItemSpriteLoader";
    }
}
