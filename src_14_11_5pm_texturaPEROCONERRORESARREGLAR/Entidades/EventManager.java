/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Gestor central de eventos del juego
 * Patrón: Mediator + Observer
 * Principio: SRP - Solo gestiona suscripciones y notificaciones
 * 
 * Thread-safe usando CopyOnWriteArrayList
 */
public class EventManager {
    private static EventManager instance;
    private final List<PlayerEventListener> playerListeners;
    
    private EventManager() {
        this.playerListeners = new CopyOnWriteArrayList<>();
    }
    
    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }
    
    public void registerPlayerListener(PlayerEventListener listener) {
        if (!playerListeners.contains(listener)) {
            playerListeners.add(listener);
            System.out.println("[EVENT] Listener registrado: " + 
                             listener.getClass().getSimpleName());
        }
    }
    
    public void unregisterPlayerListener(PlayerEventListener listener) {
        playerListeners.remove(listener);
    }
    
    public void clearAllListeners() {
        playerListeners.clear();
    }
    
    public void firePlayerDamaged(PlayerDamagedEvent event) {
        for (PlayerEventListener listener : playerListeners) {
            try {
                listener.onPlayerDamaged(event);
            } catch (Exception e) {
                System.err.println("[EVENT] Error en listener: " + e.getMessage());
            }
        }
    }
    
    public void firePlayerDeath(PlayerDeathEvent event) {
        for (PlayerEventListener listener : playerListeners) {
            try {
                listener.onPlayerDeath(event);
            } catch (Exception e) {
                System.err.println("[EVENT] Error en listener: " + e.getMessage());
            }
        }
    }
    
    public void firePlayerRespawn(PlayerRespawnEvent event) {
        for (PlayerEventListener listener : playerListeners) {
            try {
                listener.onPlayerRespawn(event);
            } catch (Exception e) {
                System.err.println("[EVENT] Error en listener: " + e.getMessage());
            }
        }
    }
    
    public void firePlayerCollectItem(PlayerCollectItemEvent event) {
        for (PlayerEventListener listener : playerListeners) {
            try {
                listener.onPlayerCollectItem(event);
            } catch (Exception e) {
                System.err.println("[EVENT] Error en listener: " + e.getMessage());
            }
        }
    }
    
    public void firePlayerPowerUp(PlayerPowerUpEvent event) {
        for (PlayerEventListener listener : playerListeners) {
            try {
                listener.onPlayerPowerUp(event);
            } catch (Exception e) {
                System.err.println("[EVENT] Error en listener: " + e.getMessage());
            }
        }
    }
    
    public int getListenerCount() {
        return playerListeners.size();
    }
}
