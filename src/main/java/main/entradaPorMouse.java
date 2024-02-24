/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class entradaPorMouse extends MouseAdapter {
    private Animacion animator;
    private double pixelPerMeter;

    public entradaPorMouse(Animacion animator, double pixelPerMeter) {
        this.animator = animator;
        this.pixelPerMeter = pixelPerMeter;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Limito el area en que se puede hacer click pq si no sucede el bug que manda las bolas al otro lado de la caja
        if(e.getX() > 640 && e.getX() < 1279)
        {
        System.out.println("Mouse Pressed at: " + e.getX() + ", " + "10");
            try {
                animator.ballFactory.crearFruta(e.getX(), 10, pixelPerMeter);
            } catch (IOException ex) {
                Logger.getLogger(entradaPorMouse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released at: " + e.getX() + ", " + e.getY());
    }
}
