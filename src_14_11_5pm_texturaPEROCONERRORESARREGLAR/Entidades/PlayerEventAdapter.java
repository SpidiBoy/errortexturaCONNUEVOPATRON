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
 * Adapter para implementar solo los eventos necesarios
 * Patrón: Adapter Pattern
 */
public abstract class PlayerEventAdapter implements PlayerEventListener {
    @Override
    public void onPlayerDamaged(PlayerDamagedEvent event) {}
    
    @Override
    public void onPlayerDeath(PlayerDeathEvent event) {}
    
    @Override
    public void onPlayerRespawn(PlayerRespawnEvent event) {}
    
    @Override
    public void onPlayerCollectItem(PlayerCollectItemEvent event) {}
    
    @Override
    public void onPlayerPowerUp(PlayerPowerUpEvent event) {}
}
