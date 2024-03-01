package main;

import java.io.IOException;

public class Mamon extends Fruta 
{
    Mamon(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) throws IOException 
    {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall);
        this.radio = 0.24344;
        this.masa = 2;
    }
}
