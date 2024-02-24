
package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

// Clase que representa una bola específica llamada Pumalaca
public class Pumalaca extends Bola{
    // Constructor de la clase Pumalaca
    Pumalaca(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall, BufferedImage pumalacaImage) throws IOException {
        // Llama al constructor de la superclase Bola
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall, pumalacaImage);
        // Establece el radio y la masa específica de la bola Pumalaca
        this.radius = 0.50625;
        this.mass = 5;
    }
}