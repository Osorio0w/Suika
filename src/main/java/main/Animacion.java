/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import graficos.assetCherry;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import graficos.declararAssets;
import static graficos.declararAssets.cherry;
/**
 *
 * @author Andrès Osorio
 */
public class Animacion extends JPanel implements ActionListener{
    private static int cursorX;
    private static int cursorY;
    private final Siguiente siguiente;

    public Animacion(int pixelWidth, int pixelHeight, int fps) {
        super(true);
        this.timer = new Timer(1000 / fps, this);
        this.deltaT = 1.0 / fps;
        this.lista = new Lista(pixelWidth / pixelsPerMeter, pixelHeight / pixelsPerMeter, this);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(pixelWidth, pixelHeight));
        this.siguiente = new Siguiente();
        this.ballFactory = new GeneradorFrutas(lista, siguiente);
    }

    private static final double pixelsPerMeter = 200;
    private Lista lista;

    GeneradorFrutas ballFactory;
    private Timer timer;
    private double deltaT;

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        //Aquí hay un rectángulo grande. Es posible que esto no funcione con Onclick.
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
            
        // dibujar bolas (no homo)
        for (Bola b : lista.balls) 
        {
            double x = b.position_current.getX() - b.radius;
            double y = b.position_current.getY() + b.radius;
            // las coordenadas en Y están invertidas
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x * pixelsPerMeter,
                    this.getHeight() - (y * pixelsPerMeter),
                    b.radius * 2 * pixelsPerMeter,
                    b.radius * 2 * pixelsPerMeter);
            
            if (b instanceof Datil){
                g2.setColor(Color.blue);
            }
            if (b instanceof Mamon){
                g2.setColor(Color.RED);
            }
            if (b instanceof Mamey){
                g2.setColor(Color.BLACK);
            }
            if (b instanceof Cereza){
                g2.setColor(Color.YELLOW);
            }
            if (b instanceof Pumalaca){
                g2.setColor(Color.GREEN);
            }
            if (b instanceof Kiwi){
                g2.setColor(Color.pink);
            }
            if (b instanceof Parchita){
                g2.setColor(Color.CYAN);
            }
            g2.fill(e);
        }
        drawPreviewBall(g2);
        g2.setColor(Color.BLACK);
        Path2D jar = new Path2D.Double();
        jar.moveTo(600,10);
        jar.lineTo(600,870);
        jar.lineTo(1320,870);
        jar.lineTo(1320,10);

        g2.draw(jar);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawPreviewBall(Graphics2D g2) {
        if(Objects.equals(ballFactory.siguiente.getValue(), "Datil")){
            double x = cursorX;
            double y = 10;
           // las coordenadas en Y están invertidas
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x,
                    this.getHeight() - (y),
                    0.1 * 2 * pixelsPerMeter,
                    0.1 * 2 * pixelsPerMeter);
            g2.setColor(Color.BLUE);
            g2.fill(e);
        }
        if(Objects.equals(ballFactory.siguiente.getValue(), "Mamon")){
            double x = cursorX;
            double y = 10;
           // las coordenadas en Y están invertidas
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x,
                    this.getHeight() - (y),
                    0.15 * 2 * pixelsPerMeter,
                    0.15 * 2 * pixelsPerMeter);
            g2.setColor(Color.RED);
            g2.fill(e);

        }
        if(Objects.equals(ballFactory.siguiente.getValue(), "Mamey")){
            double x = cursorX;
            double y = 10;
           // las coordenadas en Y están invertidas
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x,
                    this.getHeight() - (y),
                    0.225 * 2 * pixelsPerMeter,
                    0.225 * 2 * pixelsPerMeter);
            g2.setColor(Color.BLACK);
            g2.fill(e);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.step(deltaT);
        this.repaint();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Animacion anim = new Animacion(1920, 1080, 120);
                anim.addMouseListener(new entradaPorMouse(anim, pixelsPerMeter));
                anim.addMouseMotionListener(new MouseMotionAdapter(){
                    @Override
                    public void mouseMoved(MouseEvent e){
                        cursorX = e.getX();
                        cursorY = e.getY();
                    }
                });
                JFrame frame = new JFrame("Suika game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(anim);
                frame.pack();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                anim.start();
                
            }
        });
    }
}


