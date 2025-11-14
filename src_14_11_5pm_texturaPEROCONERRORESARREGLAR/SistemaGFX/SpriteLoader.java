/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SistemaGFX;
import java.awt.image.BufferedImage;
import java.util.Map;
/**
 * Interface para Loaders (Strategy Pattern)
 * Principio: ISP - Interface segregada y específica
 * @author LENOVO
 */
public interface SpriteLoader {
    Map<String, BufferedImage> loadSprites();
    String getLoaderName();
}
