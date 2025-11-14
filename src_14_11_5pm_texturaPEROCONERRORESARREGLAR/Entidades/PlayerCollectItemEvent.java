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
 * Evento: Player coleccionó item
 */
public class PlayerCollectItemEvent extends GameEvent {
    private final String itemType;
    private final int pointsGained;
    
    public PlayerCollectItemEvent(Player source, String itemType, int points) {
        super(source);
        this.itemType = itemType;
        this.pointsGained = points;
    }
    
    public String getItemType() { return itemType; }
    public int getPointsGained() { return pointsGained; }
}
