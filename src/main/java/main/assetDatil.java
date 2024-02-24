package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

// Clase assetDatil que hereda de gameObject
public class assetDatil extends gameObject 
{

    // Constructor de assetDatil
    public assetDatil(Vector2D position, BufferedImage texture) 
    {
        // Llama al constructor de la clase base gameObject
        super(position, texture);
    }

    // Método de actualización (no implementado)
    @Override
    public void update() 
    {
        // No hay implementación en este método
    }

    // Método para dibujar el assetDatil en el contexto gráfico
    @Override
    public void draw(Graphics g) 
    {
        // Dibuja la textura en la posición dada
        g.drawImage(texture, (int) position.getX(), (int) position.getY(), null);
    }
}