/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameObjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Vector2D;
/**
 *
 * @author Andrès Osorio
 */
public class Background extends GameObject {
    
    public Background(Vector2D position, BufferedImage texture)
    {
        super(position, texture);
    }
    
    @Override
    public void update() 
    {  
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
