package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Parchita extends Bola{
    Parchita(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) throws IOException {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall);
        this.radio = 0.58522;
        this.masa = 7;
    }
}
