package Entidades.Items;

import SistemaDeSoporte.Handler;
import Entidades.Items.Item;
import Entidades.Player;
import SistemaGFX.ResourceManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mariotest.*;

/**
 * Item Sombrero - Coleccionable de bonificación
 * 
 * 
 * 
 * @author LENOVO
 */
public class Sombrero extends Item {
    BufferedImage sprites;
    ResourceManager resources;
    private static final float WIDTH = 16f;
    private static final float HEIGHT = 16f;
    private static final int VALOR_PUNTOS = 500;
    
    public Sombrero(float x, float y, int scale, Handler handler) {
        super(x, y, WIDTH, HEIGHT, scale, handler, VALOR_PUNTOS);
        this.flotar = true;
        this.resources = resources;
        this.desapareceDespuesDeRecoger = true;
        cargarSprites();
    }
    
        private void cargarSprites() {
           try {
        // 1. Obtener el sprite (que es un solo BufferedImage)
        this.sprites = resources.getItemRepository().getHatSprite(); //
           
        // 2. Comprobar si se obtuvo la imagen (si no es null)
        if (this.sprites != null) {
            System.out.println("[SOMBRERO] Sprite estático cargado correctamente");
        } else {
            // El repositorio imprime un error si no encuentra el sprite
            System.err.println("[SOMBRERO] ERROR: El sprite es nulo."); 
        }
    } catch (Exception e) {
        System.err.println("[SOMBRERO] Error cargando sprites: " + e.getMessage());
        e.printStackTrace();
        this.sprites = null;
    }
    }
    
    @Override
    protected void aplicarEfecto(Player player) {
        System.out.println("[SOMBRERO] ¡Recolectado!");
    }
    
    @Override
    protected void renderPlaceholder(Graphics g) {
        // Copa del sombrero
        g.setColor(Color.BLACK);
        g.fillRect((int)getX() + 4, (int)getY() + 2, 8, 8);
        // Ala
        g.fillRect((int)getX() + 2, (int)getY() + 9, 12, 3);
    }
}