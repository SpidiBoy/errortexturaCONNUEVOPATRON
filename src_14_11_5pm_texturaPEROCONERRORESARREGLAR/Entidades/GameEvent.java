/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author LENOVO
 */
public abstract class GameEvent {
    private final long timestamp;
    private final Player source;
    
    protected GameEvent(Player source) {
        this.source = source;
        this.timestamp = System.currentTimeMillis();
    }
    
    public Player getSource() { return source; }
    public long getTimestamp() { return timestamp; }
}
