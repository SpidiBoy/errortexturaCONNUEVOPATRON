/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import SistemaDeSoporte.Handler;
import SistemaDeSoporte.ObjetosID;

/**
 *
 * @author LENOVO
 */
public class PlayerCollisionComponent {
   private final Player player;
    private final Handler handler;
    private final PlayerLadderComponent ladderComponent;
    private final PlayerPhysicsComponent physicsComponent;
    
    public PlayerCollisionComponent(Player player, Handler handler, 
                                   PlayerLadderComponent ladderComponent,
                                   PlayerPhysicsComponent physicsComponent) {
        this.player = player;
        this.handler = handler;
        this.ladderComponent = ladderComponent;
        this.physicsComponent = physicsComponent;
    }
    
    public void procesarColisiones() {
        for (JuegoObjetos temp : handler.getGameObjs()) {
            if (temp == null) continue;
            
            if (temp.getId() == ObjetosID.TileVisual) {
                continue;
            }
            
            if (temp.getId() == ObjetosID.Bloque || temp.getId() == ObjetosID.Pipe) {
                // Ignorar colisiones en escalera
                if (ladderComponent.isEnEscalera() && 
                    (ladderComponent.isBajandoEscalera() || ladderComponent.isSubiendoEscalera())) {
                    continue;
                }
                
                // ✅ COLISIÓN INFERIOR (aterrizar en plataforma)
                if (player.getBounds().intersects(temp.getBounds())) {
                    player.setY(temp.getY() - player.getHeight());
                    player.setVely(0);
                    // ✅ CRÍTICO: Marcar que aterrizó (resetear salto)
                    if (physicsComponent != null) {
                        physicsComponent.aterrizar();
                    }
                }
                
                // Colisión superior (cabeza)
                if (player.getBoundsTop().intersects(temp.getBounds())) {
                    player.setY(temp.getY() + temp.getHeight());
                    player.setVely(0);
                }
                
                // Colisión derecha
                if (player.getBoundsRight().intersects(temp.getBounds())) {
                    player.setX(temp.getX() - player.getWidth());
                }
                
                // Colisión izquierda
                if (player.getBoundsLeft().intersects(temp.getBounds())) {
                    player.setX(temp.getX() + temp.getWidth());
                }
            }
        }
    }
}
