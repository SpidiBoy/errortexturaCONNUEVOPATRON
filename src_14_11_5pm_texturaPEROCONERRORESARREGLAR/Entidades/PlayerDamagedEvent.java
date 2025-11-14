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
 * Evento: Player recibió daño
 */
public class PlayerDamagedEvent extends GameEvent {
    private final JuegoObjetos attacker; // Puede ser null (caída)
    private final int damageAmount;
    
    public PlayerDamagedEvent(Player source, JuegoObjetos attacker) {
        super(source);
        this.attacker = attacker;
        this.damageAmount = 1; // Por ahora siempre es 1
    }
    
    public JuegoObjetos getAttacker() { return attacker; }
    public int getDamageAmount() { return damageAmount; }
    public boolean isFallDamage() { return attacker == null; }
}
