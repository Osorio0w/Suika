/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrès Osorio
 */
package main;
import gameObjects.Apple;
import gameObjects.Watermelon;
import graphics.Assets;
import input.KeyBoard;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import math.Calcs;
import math.Vector2D;

import javax.swing.JFrame;
import states.GameState;

public class Window extends JFrame implements Runnable{
	
	public static final int WIDTH = 1280, HEIGHT = 720;
	private final Canvas canvas;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	private final int FPS = 60;
	private final double TARGETTIME = 1000000000/FPS;
	private double delta = 0;
	private int AVERAGEFPS = FPS;
	private GameState gameState;
        private KeyBoard keyBoard;
        
	public Window()
	{
		setTitle("Suika Game");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		canvas = new Canvas();
                keyBoard = new KeyBoard();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		add(canvas);
		canvas.addKeyListener(keyBoard);
	}

	public static void main(String[] args) {
		new Window().start();
	}
        
	private void update(){
            keyBoard.update();
            gameState.update();
        }

	private void draw(){
		bs = canvas.getBufferStrategy();
		
		if(bs == null)
		{
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
                g.setColor(Color.BLACK);
                g.fillRect(0,0,WIDTH,HEIGHT);
                gameState.draw(g);
                g.setColor(Color.WHITE);
		g.drawString(""+AVERAGEFPS, 10, 20);
		g.dispose();
		bs.show();
	}
	
        private void init()
        {
            Assets.init();
            gameState  = new GameState();
     //       double distance = calculateDistance(Apple.getX(), Apple.getY(),
      //              Watermelon.getX(), Watermelon.getY());
      //      while(distance < Apple.getRadio() + Watermelon.getRadio())
            {  
                
            }
        }
        
	
	@Override
	public void run() {
		
		long now = 0;
		long lastTime = System.nanoTime();
		int frames = 0;
		long time = 0;
		
            init();    
                
		while(running)
		{
                    now = System.nanoTime();
                    delta += (now - lastTime)/TARGETTIME;
                    time += (now - lastTime);
                    lastTime = now;


                    if(delta >= 1)
                    {		 
                            update();
                            draw();
                            delta --;
                            frames ++;
                    }
                    if(time >= 1000000000)
                    {
                            AVERAGEFPS = frames;
                            frames = 0;
                            time = 0;
                    }
		}
		stop();
	}
	
	private void start()
        {	
		thread = new Thread(this);
		thread.start();
		running = true;
	}
        
	private void stop(){
            try {
                thread.join();
                running = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}