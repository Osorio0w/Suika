/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameObjects;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import math.Vector2D;
/**
 *
 * @author Andrès Osorio
 */
public class Watermelon extends GameObject {
    ImageIcon Dimensions = new ImageIcon("src/main/java/Images/watermelon_view.png");
    public double ImgWidth = Dimensions.getIconWidth();
    
    public double getRadio()
    {
        return ImgWidth/2;
    }
    public Watermelon(Vector2D position, BufferedImage texture)
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
