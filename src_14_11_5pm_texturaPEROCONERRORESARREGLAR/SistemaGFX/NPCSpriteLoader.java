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
public class NPCSpriteLoader implements SpriteLoader{
    private final CargadorImagenes imageLoader;
    private final String sheetPath = "/Imagenes/testt.png";
    
    public NPCSpriteLoader(CargadorImagenes imageLoader) {
        this.imageLoader = imageLoader;
    }
    
    @Override
    public Map<String, BufferedImage> loadSprites() {
        Map<String, BufferedImage> sprites = new HashMap<>();
        
        BufferedImage sheet = imageLoader.loadImage(sheetPath);
        if (sheet == null) {
            System.err.println("[LOADER] Error cargando sheet de NPCs");
            return sprites;
        }
        
        // Diego Kong (48x32, 2 filas)
        extractDiegoKongSprites(sheet, sprites);
        
        // Diego Kong agarrando princesa (48x40)
        extractDKGrabSprites(sheet, sprites);
        
        // Princesa (16x32)
        extractPrincesaSprites(sheet, sprites);
        
        System.out.println("[LOADER] NPCs: " + sprites.size() + " sprites cargados");
        return sprites;
    }
    
    private void extractDiegoKongSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int width = 48, height = 32;
        
        // Fila 1 (4 sprites)
        int x_off_fila1 = 1, y_off_fila1 = 258;
        for (int i = 0; i < 4; i++) {
            String key = "dk_" + i;
            sprites.put(key, sheet.getSubimage(
                x_off_fila1 + i * (width + 2), y_off_fila1, width, height
            ));
        }
        
        // Fila 2 (4 sprites)
        int x_off_fila2 = 1, y_off_fila2 = 292;
        for (int i = 0; i < 4; i++) {
            String key = "dk_" + (i + 4);
            sprites.put(key, sheet.getSubimage(
                x_off_fila2 + i * (width + 2), y_off_fila2, width, height
            ));
        }
    }
    
    private void extractDKGrabSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int x_base = 1, y_base = 368;
        int width = 48, height = 40, spacing = 2;
        
        for (int i = 0; i < 6; i++) {
            String key = "dk_grab_" + i;
            int x = x_base + i * (width + spacing);
            
            try {
                sprites.put(key, sheet.getSubimage(x, y_base, width, height));
            } catch (Exception e) {
                System.err.println("[LOADER] Error en frame dk_grab_" + i);
            }
        }
    }
    
    private void extractPrincesaSprites(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        int x_off = 1, y_off = 141, width = 16, height = 32;
        
        for (int i = 0; i < 8; i++) {
            String key = "princess_" + i;
            sprites.put(key, sheet.getSubimage(
                x_off + i * (width + 2), y_off, width, height
            ));
        }
    }
    
    @Override
    public String getLoaderName() {
        return "NPCSpriteLoader";
    }
}
