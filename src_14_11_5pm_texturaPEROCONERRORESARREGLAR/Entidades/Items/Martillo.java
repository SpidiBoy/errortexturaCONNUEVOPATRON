package Entidades.Items;


import Entidades.Items.Item;
import Entidades.Player;
import SistemaDeSoporte.Handler;
import SistemaGFX.ResourceManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mariotest.*;

/**
 * Item Martillo - Power-up principal
 * 
 * 
 * 
 * @author LENOVO
 */
public class Martillo extends Item {
    BufferedImage sprites;
    ResourceManager resources;
    private static final float WIDTH = 16f;
    private static final float HEIGHT = 16f;
    private static final int VALOR_PUNTOS = 300;
    private static final int DURACION_PODER = 600; // 10 segundos
    
    public Martillo(float x, float y, int scale, Handler handler) {
        super(x, y, WIDTH, HEIGHT, scale, handler, VALOR_PUNTOS);
        this.flotar = true;
        this.desapareceDespuesDeRecoger = true;
        this.tieneGravedad = false;
        cargarSprites();
    }

    private void cargarSprites() {
        try {
            sprites = resources.getItemRepository().getHammerSprite();
            
            if (this.sprites != null) {
            System.out.println("[Martillo] Sprite estático cargado correctamente");
        } else {
            // El repositorio imprime un error si no encuentra el sprite
            System.err.println("[Martillo] ERROR: El sprite es nulo."); 
        }
    } catch (Exception e) {
        System.err.println("[Martillo] Error cargando sprites: " + e.getMessage());
        e.printStackTrace();
        this.sprites = null;
    }
    }
    
    @Override
    protected void aplicarEfecto(Player player) {
        // Activar el poder del martillo
        player.activarMartillo(DURACION_PODER / 60); // Convertir ticks a segundos
        
        System.out.println("[MARTILLO] ¡Power-up activado! Duración: " + 
                          (DURACION_PODER / 60) + " segundos");
    }
    
    @Override
    protected void renderPlaceholder(Graphics g) {
    }
    
    @Override
    public void tick() {
        super.tick();
        
        // Rotación suave para efecto visual (si tuvieras animación)
        if (animacion != null) {
            animacion.runAnimacion();
        }
    }
}