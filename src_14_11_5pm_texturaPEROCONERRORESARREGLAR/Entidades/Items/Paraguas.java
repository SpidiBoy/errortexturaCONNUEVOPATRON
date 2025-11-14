package Entidades.Items;

import Entidades.Items.Item;
import Entidades.Player;
import SistemaDeSoporte.Handler;
import SistemaGFX.ResourceManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mariotest.Juego;

/**
 * Item Paraguas - Coleccionable de bonificación
 * 
 * 
 * 
 * @author LENOVO
 */
public class Paraguas extends Item {
    BufferedImage sprites;
    ResourceManager resources;
    private static final float WIDTH = 16f;
    private static final float HEIGHT = 16f;
    private static final int VALOR_PUNTOS = 600;
    
    public Paraguas(float x, float y, int scale, Handler handler) {
        super(x, y, WIDTH, HEIGHT, scale, handler, VALOR_PUNTOS);
        this.flotar = true;
        this.resources = resources;
        this.desapareceDespuesDeRecoger = true;
        cargarSprites();
    }

    private void cargarSprites() {
        try {
            sprites = resources.getItemRepository().getUmbrellaSprite();
            
            if (this.sprites != null) {
            System.out.println("[Paraguas] Sprite estático cargado correctamente");
        } else {
            // El repositorio imprime un error si no encuentra el sprite
            System.err.println("[Paraguas] ERROR: El sprite es nulo."); 
        }
    } catch (Exception e) {
        System.err.println("[Paraguas] Error cargando sprites: " + e.getMessage());
        e.printStackTrace();
        this.sprites = null;
    }
    }
    
    @Override
    protected void aplicarEfecto(Player player) {
        // Solo da puntos (podría dar protección temporal contra caídas)
        System.out.println("[PARAGUAS] ¡Recolectado!");
    }
    
    @Override
    protected void renderPlaceholder(Graphics g) {
        // Paraguas cerrado
        g.setColor(new Color(255, 0, 0)); // Rojo
        
        // Tela del paraguas
        int[] xPoints = {(int)getX() + 8, (int)getX() + 2, (int)getX() + 14};
        int[] yPoints = {(int)getY() + 2, (int)getY() + 6, (int)getY() + 6};
        g.fillPolygon(xPoints, yPoints, 3);
        
        // Mango
        g.setColor(new Color(139, 69, 19));
        g.fillRect((int)getX() + 7, (int)getY() + 6, 2, 8);
        
        // Gancho
        g.drawArc((int)getX() + 5, (int)getY() + 12, 6, 4, 180, 180);
    }
}