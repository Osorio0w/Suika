package main;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mango extends Bola {
      Mango (double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall, BufferedImage mangoImage) throws IOException {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall, mangoImage);
        this.radio = 0.829;
        this.masa = 8;
    }
}
