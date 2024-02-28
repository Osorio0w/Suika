package main;
import java.io.IOException;

public class Patilla extends Bola {
      Patilla (double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) throws IOException {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall);
        this.radio = 1.059;
        this.masa = 10;
    }
}
