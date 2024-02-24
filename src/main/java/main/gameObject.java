package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class gameObject 
{
    
    protected BufferedImage texture;// Posición del objeto representada como un Vector
    public Vector2D position;        // La imagen que llevará el objeto
    
    // Esta clase la estoy creando buscando maneras de añadir los assets del juego, 
    // sientanse libres de eliminarla si quieren, no dañará nada del código (creo)
    
    // Constructor de la clase
    public gameObject(Vector2D position, BufferedImage texture)
    {
        this.position = position;
        this.texture = texture;
    }
        // Método abstracto para actualizar el objeto
        public abstract void update();
        
        // Método abstracto para dibujar el objeto en pantalla
        public abstract void draw(Graphics g);

        
         // Getter para obtener la posición del objeto
    public Vector2D getPosition() 
    {
        return position;
    }
        
    // Setter para establecer la posición del objeto
    public void setPosition(Vector2D position) 
    {
        this.position = position;
    }
}
