package main;

import java.awt.Graphics;

// Clase GameState que extiende Object
public class GameState extends Object {
    
    // Declaración de una instancia de assetDatil, inicializada como null
    private final assetDatil datil = null;
    
    // Constructor de GameState
    public GameState() {
       
        // datil = new assetDatil(new Vector2D((int) (x * pixelsPerMeter),0), declararAssets.apple); (no lo he hecho funcionar)
    }
    
    // Método para actualizar el estado del juego
    public void update() {
        // Llama al método de actualización de datil (que está inicializado como null)
        datil.update();
    }
    
    // Método para dibujar el estado del juego
    public void draw(Graphics g) {
        // Llama al método de dibujo de datil (que está inicializado como null)
        datil.draw(g);
    }
}
