/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Andrès Osorio
 */
public class KeyBoard implements KeyListener {
    
    private boolean[] keys = new boolean[256];
    
    public static boolean UP,LEFT,RIGHT, ENTER; 
    
    public KeyBoard()
    {
        LEFT = false;
        RIGHT = false;
        ENTER = false;
        UP = false;
    }
    
    public void update()
    {   
        UP = keys[KeyEvent.VK_UP];
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
        ENTER = keys[KeyEvent.VK_ENTER];
    }

    @Override
    public void keyPressed(KeyEvent e) {
       keys[e.getKeyCode()] = true; 
    }

    @Override
    public void keyReleased(KeyEvent e) {
       keys[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
