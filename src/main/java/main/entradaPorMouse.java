/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class entradaPorMouse extends MouseAdapter {
    private Animacion animator;
    private double pixelPerMeter;

    public entradaPorMouse(Animacion animator, double pixelPerMeter) {
        this.animator = animator;
        this.pixelPerMeter = pixelPerMeter;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed at: " + e.getX() + ", " + "10");
        animator.ballFactory.crearFruta(e.getX(), 10, pixelPerMeter);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released at: " + e.getX() + ", " + e.getY());
    }
}
