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
 * Evento: Player murió
 */
public class PlayerDeathEvent extends GameEvent {
    private final JuegoObjetos killer;
    
    public PlayerDeathEvent(Player source, JuegoObjetos killer) {
        super(source);
        this.killer = killer;
    }
    
    public JuegoObjetos getKiller() { return killer; }
}