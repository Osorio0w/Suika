/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.image.BufferedImage;


/**
 * 
 * @author Andrès Osorio
 */
public class Assets extends Object{
    public static BufferedImage apple;
    public static BufferedImage background;
    public static BufferedImage watermelon;
    
    public static void init()
    {
        background = Loader.ImageLoader("src/main/java/Images/background_view.png");
        apple = Loader.ImageLoader("src/main/java/Images/apple_view.png");
        watermelon = Loader.ImageLoader("src/main/java/Images/watermelon_view.png");
    }
}
