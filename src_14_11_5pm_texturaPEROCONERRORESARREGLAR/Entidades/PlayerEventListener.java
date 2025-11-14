/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Entidades;

/** Interfaz para observadores de eventos de Player
 * Patrón: Observer Pattern
 * @author LENOVO
 */
public interface PlayerEventListener {
    void onPlayerDamaged(PlayerDamagedEvent event);
    void onPlayerDeath(PlayerDeathEvent event);
    void onPlayerRespawn(PlayerRespawnEvent event);
    void onPlayerCollectItem(PlayerCollectItemEvent event);
    void onPlayerPowerUp(PlayerPowerUpEvent event);
}
