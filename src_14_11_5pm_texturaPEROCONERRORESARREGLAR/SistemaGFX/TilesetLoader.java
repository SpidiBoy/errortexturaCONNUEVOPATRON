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
public class TilesetLoader implements SpriteLoader {
    private final CargadorImagenes imageLoader;
    private final int level;
    private final Map<Integer, String> levelPaths = Map.of(
        1, "/Imagenes/bloques2.png",
        2, "/Imagenes/bloques3.png",
        3, "/Imagenes/bloques4.png"
    );
    
    public TilesetLoader(CargadorImagenes imageLoader, int level) {
        this.imageLoader = imageLoader;
        this.level = level;
    }
    
    @Override
    public Map<String, BufferedImage> loadSprites() {
        Map<String, BufferedImage> sprites = new HashMap<>();
        
        String path = levelPaths.get(level);
        if (path == null) {
            System.err.println("[LOADER] Nivel " + level + " no existe");
            return sprites;
        }
        
        BufferedImage sheet = imageLoader.loadImage(path);
        if (sheet == null) return sprites;
        
        // Extraer tiles del tileset
        extractTiles(sheet, sprites);
        
        System.out.println("[LOADER] Tileset nivel " + level + ": " + 
                          sprites.size() + " tiles cargados");
        return sprites;
    }
    
    private void extractTiles(BufferedImage sheet, Map<String, BufferedImage> sprites) {
        final int tileWidth = 8;
        final int tileHeight = 8;
        final int firstgid = 1;
        final int numFilas = 5;
        
        int currentTileID = firstgid;
        
        for (int fila = 0; fila < numFilas; fila++) {
            int y = fila * tileHeight;
            if (y + tileHeight > sheet.getHeight()) break;
            
            for (int x = 0; x + tileWidth <= sheet.getWidth(); x += tileWidth) {
                String key = "tile_" + currentTileID;
                sprites.put(key, sheet.getSubimage(x, y, tileWidth, tileHeight));
                currentTileID++;
            }
        }
    }
    
    @Override
    public String getLoaderName() {
        return "TilesetLoader (Level " + level + ")";
    }
}
