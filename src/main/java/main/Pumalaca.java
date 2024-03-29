
package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

// Clase que representa una bola específica llamada Pumalaca
public class Pumalaca extends Fruta{
    // Constructor de la clase Pumalaca
    Pumalaca(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) throws IOException {
        // Llama al constructor de la superclase Fruta
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall);
        // Establece el radio y la masa específica de la bola Pumalaca
        this.radio = 0.412;
        this.masa = 5;
    }
}