/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *Patrón: Observer

 * @author LENOVO
 */
public class PowerUpListener  extends PlayerEventAdapter{
    @Override
    public void onPlayerDamaged(PlayerDamagedEvent event) {
        Player player = event.getSource();
        
        if (player.tieneMartillo()) {
            player.getPoderMartillo().desactivar();
            System.out.println("[POWERUP] Martillo desactivado por daño");
        }
    }
    
    @Override
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getSource();
        
        if (player.tieneMartillo()) {
            player.getPoderMartillo().desactivar();
        }
        
        System.out.println("[POWERUP] Power-ups reseteados");
    }
    
    @Override
    public void onPlayerPowerUp(PlayerPowerUpEvent event) {
        System.out.println("[POWERUP] Activado: " + event.getPowerUpType());
    }
}
