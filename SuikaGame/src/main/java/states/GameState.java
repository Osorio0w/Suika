/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package states;
import gameObjects.Background;
import gameObjects.Apple;
import gameObjects.Watermelon;
import graphics.Assets;
import java.awt.Graphics;
import math.Vector2D;

/**
 *
 * @author Andrès Osorio
 */
public class GameState extends Object {
    
    private final Apple apple;
    private final Background background;
    private final Watermelon watermelon;
    
    public GameState()
    {
        apple      = new Apple(new Vector2D(150,0), Assets.apple);
        background = new Background(new Vector2D(0,0), Assets.background);
        watermelon = new Watermelon(new Vector2D(100, 400), Assets.watermelon);
    }
    
    public void update()
    {
        apple.update();
        background.update();
    }
    
    
    public void draw(Graphics g)
    {
        background.draw(g);
        apple.draw(g);
        watermelon.draw(g);
    }
}
