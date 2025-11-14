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
public class PlayerSpriteRepository implements SpriteRepository{
    private final Map<String, BufferedImage> sprites;
    
    public PlayerSpriteRepository(Map<String, BufferedImage> sprites) {
        this.sprites = sprites;
    }
    
    @Override
    public BufferedImage getSprite(String name) {
        BufferedImage sprite = sprites.get(name);
        if (sprite == null) {
            System.err.println("[REPO] Sprite no encontrado: " + name);
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
    
    // ==================== MÉTODOS ESPECÍFICOS DE PLAYER ====================
    
    public BufferedImage[] getWalkingAnimation() {
        return new BufferedImage[] {
            getSprite("player_walk_1"),
            getSprite("player_walk_2"),
            getSprite("player_walk_3")
        };
    }
    
    public BufferedImage[] getHammerAnimation() {
        BufferedImage[] hammer = new BufferedImage[6];
        for (int i = 0; i < 6; i++) {
            hammer[i] = getSprite("player_hammer_" + i);
        }
        return hammer;
    }
    
    public BufferedImage[] getDeathAnimation() {
        BufferedImage[] death = new BufferedImage[6];
        for (int i = 0; i < 6; i++) {
            death[i] = getSprite("player_death_" + i);
        }
        return death;
    }
    
    public BufferedImage[] getLadderAnimation() {
        return new BufferedImage[] {
            getSprite("player_ladder_1"),
            getSprite("player_ladder_2")
        };
    }
}
