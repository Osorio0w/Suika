package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mamon extends Bola {
    Mamon(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall, BufferedImage mamonImage) throws IOException {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall, mamonImage);
        this.radio = 0.207;
        this.masa = 2;
    }
}
