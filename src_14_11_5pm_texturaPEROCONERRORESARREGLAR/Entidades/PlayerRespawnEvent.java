/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author LENOVO
 */
/**
 * Evento: Player respawneó
 */
public class PlayerRespawnEvent extends GameEvent {
    private final float spawnX;
    private final float spawnY;
    
    public PlayerRespawnEvent(Player source, float x, float y) {
        super(source);
        this.spawnX = x;
        this.spawnY = y;
    }
    
    public float getSpawnX() { return spawnX; }
    public float getSpawnY() { return spawnY; }
}
