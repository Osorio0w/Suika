/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Loader {

    public static BufferedImage ImageLoader(String path)
    {
        try {
            File apple = new File(path);
            return ImageIO.read(apple);
        }catch (IOException e)
        {
        }
        return null;

    }

}
