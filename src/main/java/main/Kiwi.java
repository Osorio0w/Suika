/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Kiwi extends Bola{
    Kiwi(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall, BufferedImage kiwiImage) throws IOException {
        super(x, y, ax, ay, r, m, outOfConstraint, outOfGame, intersectWithOtherBall, kiwiImage);
        this.radio = 0.621;
        this.masa = 6;
    }
}
