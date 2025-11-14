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
 * Item BolsoDama - Coleccionable de bonificación
 * 
 * 
 * 
 * @author LENOVO
 */
public class BolsoDama extends Item {
    BufferedImage sprites;
    ResourceManager resources;
    private static final float WIDTH = 16f;
    private static final float HEIGHT = 16f;
    private static final int VALOR_PUNTOS = 400;
    
    public BolsoDama(float x, float y, int scale, Handler handler) {
        super(x, y, WIDTH, HEIGHT, scale, handler, VALOR_PUNTOS);
        this.flotar = true;
        this.desapareceDespuesDeRecoger = true;
        cargarSprites();
    }

    private void cargarSprites() {
        try {
            sprites = resources.getItemRepository().getPurseSprite();
            
      if (this.sprites != null) {
            System.out.println("[BolsoDama] Sprite estático cargado correctamente");
        } else {
            // El repositorio imprime un error si no encuentra el sprite
            System.err.println("[BolsoDama] ERROR: El sprite es nulo."); 
        }
    } catch (Exception e) {
        System.err.println("[BolsoDama] Error cargando sprites: " + e.getMessage());
        e.printStackTrace();
        this.sprites = null;
    }
    }
    
    @Override
    protected void aplicarEfecto(Player player) {
        // Solo da puntos
        System.out.println("[BOLSO] ¡Recolectado!");
    }
    
    @Override
    protected void renderPlaceholder(Graphics g) {
        g.setColor(new Color(255, 192, 203)); // Rosa
        g.fillRect((int)getX() + 2, (int)getY() + 4, 12, 10);
        g.setColor(Color.BLACK);
        g.drawRect((int)getX() + 2, (int)getY() + 4, 12, 10);
        g.drawArc((int)getX() + 4, (int)getY(), 8, 6, 0, 180);
    }
}