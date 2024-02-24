/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Andrès Osorio
 */
public class assetBackground extends gameObject 
{
        public assetBackground(Vector2D position, BufferedImage texture)
    {
        super (position, texture);
    }

    @Override
    public void update() 
    {
        
    }

    @Override
    public void draw(Graphics g) 
    {
        g.drawImage(texture, (int) position.getX(), (int) position.getY(), null);
    }
}
