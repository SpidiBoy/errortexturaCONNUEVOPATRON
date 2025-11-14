/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import SistemaDeSoporte.EstadoJuego;

/**
 *
 * @author LENOVO
 */
public class GameStateListener extends PlayerEventAdapter {
    private final EstadoJuego estadoJuego;
    
    public GameStateListener(EstadoJuego estadoJuego) {
        this.estadoJuego = estadoJuego;
    }
    
    @Override
    public void onPlayerDamaged(PlayerDamagedEvent event) {
        System.out.println("[GAME STATE] Player recibió daño");
        estadoJuego.perderVida();
        estadoJuego.resetearRacha();
    }
    
    @Override
    public void onPlayerCollectItem(PlayerCollectItemEvent event) {
        System.out.println("[GAME STATE] Player colectó: " + event.getItemType());
        estadoJuego.sumarPuntos(event.getPointsGained());
    }
}
