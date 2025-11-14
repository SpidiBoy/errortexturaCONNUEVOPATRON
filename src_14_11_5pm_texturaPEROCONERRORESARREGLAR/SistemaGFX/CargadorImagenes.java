package SistemaGFX;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author LENOVO
 */
public class CargadorImagenes {
public BufferedImage loadImage(String path) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResource(path));
            
            if (image == null) {
                System.err.println("[IMAGE LOADER] No se pudo cargar: " + path);
            }
            
            return image;
            
        } catch (IOException e) {
            System.err.println("[IMAGE LOADER] Error al cargar " + path + ": " + e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("[IMAGE LOADER] Archivo no encontrado: " + path);
            return null;
        }
    }
    
    /**
     * Verifica si una ruta existe
     */
    public boolean resourceExists(String path) {
        return getClass().getResource(path) != null;
    }
}
