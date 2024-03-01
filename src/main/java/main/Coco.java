package main;
import java.io.IOException;

public class Coco extends Fruta {
      Coco (double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) throws IOException {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall);
        this.radio = 0.88;
        this.masa = 9;
    }
}
