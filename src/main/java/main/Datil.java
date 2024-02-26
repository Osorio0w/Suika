
package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Datil extends Bola{
    Datil(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) throws IOException 
    {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall);
        this.radio = 0.103;
        this.masa = 1;
    }
}
