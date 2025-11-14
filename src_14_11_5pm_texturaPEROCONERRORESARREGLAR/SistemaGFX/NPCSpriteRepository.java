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
public class NPCSpriteRepository implements SpriteRepository {
     private final Map<String, BufferedImage> sprites;
    
    public NPCSpriteRepository(Map<String, BufferedImage> sprites) {
        this.sprites = sprites;
    }
    
    @Override
    public BufferedImage getSprite(String name) {
        BufferedImage sprite = sprites.get(name);
        if (sprite == null) {
            System.err.println("[REPO] NPC sprite no encontrado: " + name);
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
    
    // ==================== DIEGO KONG ====================
    
    public BufferedImage[] getDiegoKongSprites() {
        BufferedImage[] sprites = new BufferedImage[8];
        for (int i = 0; i < 8; i++) {
            sprites[i] = getSprite("dk_" + i);
        }
        return sprites;
    }
    
    public BufferedImage[] getDKGrabAnimation() {
        BufferedImage[] sprites = new BufferedImage[6];
        for (int i = 0; i < 6; i++) {
            sprites[i] = getSprite("dk_grab_" + i);
        }
        return sprites;
    }
    
    // ==================== PRINCESA ====================
    
    public BufferedImage[] getPrincessSprites() {
        BufferedImage[] sprites = new BufferedImage[8];
        for (int i = 0; i < 8; i++) {
            sprites[i] = getSprite("princess_" + i);
        }
        return sprites;
    }
}
