package main;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mango extends Fruta {
      Mango (double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) throws IOException {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall);
        this.radio = 0.73;
        this.masa = 8;
    }
}
