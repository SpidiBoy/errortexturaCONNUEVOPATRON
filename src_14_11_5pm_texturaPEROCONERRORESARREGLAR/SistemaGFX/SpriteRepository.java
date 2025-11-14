/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SistemaGFX;

import java.awt.image.BufferedImage;

/**
 * Interface para Repositorios (Repository Pattern)
 * @author LENOVO
 */
public interface SpriteRepository {
    BufferedImage getSprite(String name);
    BufferedImage[] getAllSprites();
    boolean hasSprite(String name);
}
