/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Andrès Osorio
 */
public class Mamey extends Bola{
    Mamey(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall, BufferedImage mameyImage) throws IOException {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall, mameyImage);
        this.radius = 0.225;
        this.mass = 3;
    }
}
