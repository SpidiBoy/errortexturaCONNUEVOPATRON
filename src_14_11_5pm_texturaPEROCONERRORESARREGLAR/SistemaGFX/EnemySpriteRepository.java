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
public class EnemySpriteRepository implements SpriteRepository{
    private final Map<String, BufferedImage> sprites;
    
    public EnemySpriteRepository(Map<String, BufferedImage> sprites) {
        this.sprites = sprites;
    }
    
    @Override
    public BufferedImage getSprite(String name) {
        return sprites.get(name);
    }
    
    @Override
    public BufferedImage[] getAllSprites() {
        return sprites.values().toArray(new BufferedImage[0]);
    }
    
    @Override
    public boolean hasSprite(String name) {
        return sprites.containsKey(name);
    }
    
    // ==================== MÉTODOS ESPECÍFICOS DE ENEMIGOS ====================
    
    public BufferedImage[] getBarrelAnimation() {
        BufferedImage[] barrel = new BufferedImage[8];
        for (int i = 0; i < 8; i++) {
            barrel[i] = getSprite("barrel_" + i);
        }
        return barrel;
    }
    
    public BufferedImage[] getFireAnimation() {
        BufferedImage[] fire = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            fire[i] = getSprite("fire_" + i);
        }
        return fire;
    }
    
    public BufferedImage[] getFlameAnimation() {
        BufferedImage[] flame = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            flame[i] = getSprite("flame_" + i);
        }
        return flame;
    }
}
