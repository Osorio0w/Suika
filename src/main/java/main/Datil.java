
package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Datil extends Bola{
    Datil(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall, BufferedImage datilImage) throws IOException 
    {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall, datilImage);
        this.radius = 0.1;
        this.mass = 1;
        datilImage = ImageIO.read(new File("src/main/java/images/cherry_view.png"));
    }
}
