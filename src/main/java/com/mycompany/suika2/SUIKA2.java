/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.suika2;

import javax.swing.SwingUtilities;
import main.Inicio;

/**
 *
 * @author Andrès Osorio
 */
public class SUIKA2 {

     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicio();
            }
        });
    }
}
