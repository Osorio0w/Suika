/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gameObjects;

import input.KeyBoard;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Vector2D;

/**
 *
 * @author Andrès Osorio
 */

public class Apple extends GameObject{
    
  //  public Apple getBounds()
  //  {
  //      return new Apple(position.getX(),position.getY(),102,103actuall);
 //   }
    public Apple(Vector2D position, BufferedImage texture)
    {
        super(position, texture);
    }
    @Override
    public void update()
    {
        if(KeyBoard.RIGHT)
        {
            position.setX(position.getX() + 2);
        }
        if (KeyBoard.LEFT)
        {
            position.setX(position.getX() - 2);
        }
        if (KeyBoard.ENTER)
        {
            position.setY(position.getY() + 8);
        }
        if (KeyBoard.UP)
        {
            position.setY(position.getY() - 8);
        }

        
    }
    
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
    
}
