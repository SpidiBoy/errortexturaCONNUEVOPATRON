/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import SistemaDeSoporte.Handler;

/**
 *
 * @author LENOVO
 */
public class PlayerPhysicsComponent {
    private final Player player;
    private final Handler handler;
    
    private static final float VELOCIDAD_CAMINAR = 2.2f;
    private static final float VELOCIDAD_ESCALERA = 1f;
    private static final float FUERZA_SALTO = -7.5f;
    private static final float GRAVEDAD = 0.5f;
    
    private boolean salto = false;
    
    public PlayerPhysicsComponent(Player player, Handler handler) {
        this.player = player;
        this.handler = handler;
    }
    
    public void tick() {
        // Aplicar movimiento
        player.setX(player.getVelX() + player.getX());
        player.setY(player.getVely() + player.getY());
        
        // Límite de seguridad
        if (player.getY() > 2000) {
            System.err.println("[PHYSICS] Player cayó fuera del mapa");
            return;
        }
    }
    
    public void aplicarGravedad() {
        if (!salto) {
            player.setVely(player.getVely() + GRAVEDAD);
        } else {
            // Aplicar gravedad reducida durante el salto para mejor control
            player.setVely(player.getVely() + GRAVEDAD);
        }
    }
    
    public void iniciarSalto() {
        if (!salto) {
            player.setVely(FUERZA_SALTO);
            salto = true;
        }
    }
    
    public void aterrizar() {
        salto = false;
    }
    
    public void moverIzquierda() {
        player.setVelX(-VELOCIDAD_CAMINAR);
    }
    
    public void moverDerecha() {
        player.setVelX(VELOCIDAD_CAMINAR);
    }
    
    public void detenerMovimiento() {
        player.setVelX(0);
    }
    
    public boolean hasSalto() { return salto; }
    public void setSalto(boolean salto) { this.salto = salto; }
    
    public float getVelocidadEscalera() { return VELOCIDAD_ESCALERA; }
    
}