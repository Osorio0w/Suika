// Importación de paquetes y clases necesarias
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;

// Clase principal que extiende JPanel e implementa ActionListener
public class Animacion extends JPanel implements ActionListener 
{
    // Variables de coordenadas del cursor
    public static int cursorX;
    private static int cursorY;

    // Clase para controlar el siguiente elemento
    private final Siguiente siguiente;
    
    // Variable para almacenar la información del datil
    private assetDatil datil;
    
    // Constructor de la clase
    public Animacion(int pixelWidth, int pixelHeight, int fps) 
    {
        super(true);
        // Configuración del temporizador para la animación
        this.timer = new Timer(100 / fps, this);
        this.deltaT = 1.0 / fps;
        
        // Creación de la lista de bolas
        this.lista = new Lista(pixelWidth / pixelsPerMeter, pixelHeight / pixelsPerMeter, this);
        
        // Configuración del JPanel
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(pixelWidth, pixelHeight));
        
        // Inicialización de la clase Siguiente
        this.siguiente = new Siguiente();
        
        // Inicialización del GeneradorFrutas
        this.ballFactory = new GeneradorFrutas(lista, siguiente);
    }

    // Factor de conversión de píxeles a metros
    private static final double pixelsPerMeter = 200;
    private Lista lista;
    final GeneradorFrutas ballFactory;
    private Timer timer;
    private double deltaT;

    // Método para iniciar la animación
    public void start() 
    {
        timer.start();
    }

    // Método para detener la animación
    public void stop() 
    {
        timer.stop();
    }

    // Método para dibujar las bolas en el panel
    @Override
    protected void paintComponent(Graphics g) 
    {
        // Dibujar fondo 
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());

        // Dibujar cada bola en la lista
        for (Bola b : lista.balls) 
        {
            double x = b.position_current.getX() - b.radius;
            double y = b.position_current.getY() + b.radius;

            // Coordenadas Y invertidas
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x * pixelsPerMeter,
                    this.getHeight() - (y * pixelsPerMeter),
                    b.radius * 2 * pixelsPerMeter,
                    b.radius * 2 * pixelsPerMeter);
                
            // Asignación de colores según el tipo de bola
            if (b instanceof Datil) 
            {
                 g2.setColor(Color.blue);
            }   
            if (b instanceof Mamon)
            {
                g2.setColor(Color.RED);
            }   
            if (b instanceof Mamey)
            {
                g2.setColor(Color.BLACK);
            }   
            if (b instanceof Cereza)
            {
                g2.setColor(Color.YELLOW);
            }   
            if (b instanceof Pumalaca)
            {
                g2.setColor(Color.GREEN);
            }
            if (b instanceof Kiwi){
                g2.setColor(Color.pink);
            }
            if (b instanceof Parchita)
            {
                g2.setColor(Color.CYAN);
            }
            // Código similar para otros tipos de bolas

            // Rellenar y dibujar la elipse correspondiente
            g2.fill(e);
        }

        // Dibujar vista previa de la bola
        drawPreviewBall(g2);

        // Dibujar contorno de un "jar"
        g2.setColor(Color.black);
        Path2D jar = new Path2D.Double();
        jar.moveTo(600,10);
        jar.lineTo(600,870);
        jar.lineTo(1320,870);
        jar.lineTo(1320,10);

        g2.draw(jar);
        Toolkit.getDefaultToolkit().sync();
    }

    // Método para dibujar la vista previa de la próxima bola
    private void drawPreviewBall(Graphics2D g2) 
    {
        // Código para dibujar la vista previa de diferentes tipos de bolas
         // if(Objects.equals(ballFactory.siguiente.getValue(), "Datil"))
    }

    // Método que se llama en cada paso de la animación
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            lista.step(deltaT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.repaint();
    }

    // Método principal
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() {
                // Creación de la animación
                Animacion anim = new Animacion(1440, 900, 120);
                
                // Configuración de los listeners de ratón
                anim.addMouseListener(new entradaPorMouse(anim, pixelsPerMeter));
                anim.addMouseMotionListener(new MouseMotionAdapter() 
                {
                    @Override
                    public void mouseMoved(MouseEvent e) 
                    {
                        cursorX = e.getX();
                        cursorY = e.getY();
                    }
                });
                
                // Configuración del JFrame y visualización de la animación
                JFrame frame = new JFrame("Suika game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(anim);
                frame.pack();
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                // Inicio de la animación
                anim.start();
            }
        });
    }
}
