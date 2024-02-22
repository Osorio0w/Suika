/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graficos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Vector2D;
/**
 *
 * @author Andrès Osorio
 */
public abstract class gameObject {
    
    protected BufferedImage texture;
    public Vector2D position;
    
    public gameObject(Vector2D position, BufferedImage texture)
    {
        this.position = position;
        this.texture = texture;
    }
        public abstract void update();
        public abstract void draw(Graphics g);

    public Vector2D getPosition() {
        return position;
    }
        
    public void setPosition(Vector2D position) {
        this.position = position;
    }
}
