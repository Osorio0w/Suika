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
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

// Clase principal que extiende JPanel e implementa ActionListener
public class Animacion extends JPanel implements ActionListener 
{

    declararAssets assets;
    // Variables de coordenadas del cursor
    public static int cursorX;
    private static int cursorY;

    // Clase para controlar el siguiente elemento
    private Siguiente siguiente = null;
    
    // Variable para almacenar la información del datil
    private assetDatil datil;
    
    //Contador de Clicks
    private int clickCounter;
    private Colisiones colisiones;
    
    // GameOver
    //private boolean gameOver = false;
        public Animacion(Colisiones colisiones )
    {
        this.colisiones = colisiones;
    }
        
        
    // Constructor de la clase
    public Animacion(int pixelWidth, int pixelHeight, int fps) 
    {
        super(true);
        // Configuración del temporizador para la animación
        this.timer = new Timer(1000 / fps, this);
        this.deltaT = 1.0 / fps;
        
        // Creación de la lista de bolas
        this.lista = new Colisiones(pixelWidth / pixelsPerMeter, pixelHeight / pixelsPerMeter, this);
        
        // Configuración del JPanel
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(pixelWidth, pixelHeight));
        
        // Inicialización de la clase Siguiente
        siguiente = new Siguiente();
        
        // Inicialización del GeneradorFrutas
        ballFactory = new GeneradorFrutas(lista, siguiente);
        assets.init();
    }

    // Factor de conversión de píxeles a metros
    private static final double pixelsPerMeter = 200;
    private Colisiones lista;
    GeneradorFrutas ballFactory = null;
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

    public int getClickCounter()
    {
        return clickCounter;
    }
    public void setClickCounter(int clickCounter)
    {
        this.clickCounter = clickCounter;
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
        for (Bola b : lista.Bolas) 
        {
            double x = b.posicionActual.getX() - b.radio;
            double y = b.posicionActual.getY() + b.radio;

            // Coordenadas Y invertidas
            Ellipse2D.Double e = new Ellipse2D.Double(
                    x * pixelsPerMeter,
                    this.getHeight() - (y * pixelsPerMeter),
                    b.radio * 2 * pixelsPerMeter,
                    b.radio * 2 * pixelsPerMeter);
                
            // Asignación de colores según el tipo de bola
           // if (colisiones.isGameOver())
           // {
           //     abrirVentanaGameOver();
           //     System.out.println(colisiones.isGameOver() +"<----Game Over");
           // }
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
            if (b instanceof Mango)
            {
                g2.setColor(Color.ORANGE);
            }

            if (b instanceof Coco)
            {
                g2.setColor(Color.LIGHT_GRAY);
            }

            if (b instanceof Patilla)
            {
                g2.setColor(Color.MAGENTA);
            }

            // Rellenar y dibujar la elipse correspondiente
            g2.fill(e);
        }

        // Dibujar vista previa de la bola
        drawBolaSiguiente(g2);

        // Dibujar contorno de un "jar"
        g2.setColor(Color.black);
        Path2D jar = new Path2D.Double();
        jar.moveTo(600,10);
        jar.lineTo(600,870);
        jar.lineTo(1320,870);
        jar.lineTo(1320,10);

        g2.draw(jar);
        Toolkit.getDefaultToolkit().sync();
        g.setColor(Color.BLACK);
        g.drawString("Turnos: " + clickCounter, 20, 20);
    }

    private void abrirVentanaGameOver()
    {
        JFrame ventanaGameOver = new JFrame("Game Over!");
        JLabel etiquetaGameOver = new JLabel("¡Game Over! Tu puntaje final es:");
        ventanaGameOver.add(etiquetaGameOver);
        ventanaGameOver.pack();
        ventanaGameOver.setVisible(true);
    }
    
    private int calcularPuntajeFinal()
    {
        return 1000; //Falta poner el método para calcular el puntaje
    }
    
    // Método para dibujar la vista previa de la próxima bola
    private void drawBolaSiguiente(Graphics2D g2) 
    {
        double minX = 620;
        double maxX = 1240;
        double y = 10;
        
        if (cursorX >= minX && cursorX <= maxX)
        { 
            switch (ballFactory.siguiente.getValue())
        {
            case "Datil":
                if(cursorX > 620 && cursorX < 1300)
                {
                    Ellipse2D.Double datil = new Ellipse2D.Double( cursorX - (0.103 * 2 * (pixelsPerMeter/2)) , y , 0.103 * 2 * pixelsPerMeter ,0.103 * 2 * pixelsPerMeter);
                    g2.setColor(Color.BLUE);
                    g2.fill(datil);
                }
            break;
            
            case "Mamon":
                if(cursorX > 640 && cursorX < 1280)
                {
                    Ellipse2D.Double mamon = new Ellipse2D.Double( cursorX - (0.207 * 2 * (pixelsPerMeter/2)) , y , 0.207 * 2 * pixelsPerMeter ,0.207 * 2 * pixelsPerMeter);
                    g2.setColor(Color.RED);
                    g2.fill(mamon);
                    break;
                }
            
            case "Mamey":
                if(cursorX > 660 && cursorX < 1260)
                {
                    Ellipse2D.Double mamey = new Ellipse2D.Double( cursorX - (0.310 * 2 * (pixelsPerMeter/2)) , y , 0.310 * 2 * pixelsPerMeter ,0.310 * 2 * pixelsPerMeter);
                    g2.setColor(Color.black);
                    g2.fill(mamey);
                }
            break;
            
            case "Cereza":
                if(cursorX > 680 && cursorX < 1240)
                {
                    Ellipse2D.Double cereza = new Ellipse2D.Double( cursorX - (0.414 * 2 * (pixelsPerMeter/2)) , y , 0.414 * 2 * pixelsPerMeter ,0.414 * 2 * pixelsPerMeter);
                    g2.setColor(Color.yellow);
                    g2.fill(cereza);
                    break;
                }
        }    
    } 
        }

    // Método que se llama en cada paso de la animación
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            lista.step(deltaT);
        } catch (IOException ex) {
        }
        this.repaint();
    }
    // Método principal
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
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
