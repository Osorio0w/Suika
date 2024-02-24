package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

// Clase que representa una bola específica
public class Cereza extends Bola{
    // Constructor de la clase
    Cereza(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall, BufferedImage cerezaImage) throws IOException {
        // Llama al constructor de la superclase Bola
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall, cerezaImage);
        // Establece el radio y la masa específica de la bola 
        this.radius = 0.3375;
        this.mass = 4;
    }
}