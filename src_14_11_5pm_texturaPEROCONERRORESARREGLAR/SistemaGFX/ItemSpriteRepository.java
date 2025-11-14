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
public class ItemSpriteRepository implements SpriteRepository {
     private final Map<String, BufferedImage> sprites;
    
    public ItemSpriteRepository(Map<String, BufferedImage> sprites) {
        this.sprites = sprites;
    }
    
    @Override
    public BufferedImage getSprite(String name) {
        BufferedImage sprite = sprites.get(name);
        if (sprite == null) {
            System.err.println("[REPO] Item sprite no encontrado: " + name);
        }
        return sprite;
    }
    
    @Override
    public BufferedImage[] getAllSprites() {
        return sprites.values().toArray(new BufferedImage[0]);
    }
    
    @Override
    public boolean hasSprite(String name) {
        return sprites.containsKey(name);
    }
    
    // ==================== MÉTODOS ESPECÍFICOS ====================
    
    public BufferedImage getHammerSprite() {
        return getSprite("hammer");
    }
    
    public BufferedImage getUmbrellaSprite() {
        return getSprite("umbrella");
    }
    
    public BufferedImage getPurseSprite() {
        return getSprite("purse");
    }
    
    public BufferedImage getHatSprite() {
        return getSprite("hat");
    }
    
    public BufferedImage getHeartSprite() {
        return getSprite("heart");
    }
    
    public BufferedImage getBrokenHeartSprite() {
        return getSprite("broken_heart");
    } 
}
