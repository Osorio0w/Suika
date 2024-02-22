/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graficos;

/**
 *
 * @author Andrès Osorio
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Vector2D;

/**
 * 
 * @author Andrès Osorio
 */
public class declararAssets extends Object{
    
    public static BufferedImage apple;
    public static BufferedImage background;
    public static BufferedImage watermelon;
    public static BufferedImage cherry;
    
    public static void init()
    {
        background = CargadorImagenes.cargarImagen("src/main/java/Images/background_view.png");
        apple      = CargadorImagenes.cargarImagen("src/main/java/Images/apple_view.png");
        watermelon = CargadorImagenes.cargarImagen("src/main/java/Images/watermelon_view.png");
            cherry = CargadorImagenes.cargarImagen("src/main/java/Images/cherry_view.png");
    }
}
