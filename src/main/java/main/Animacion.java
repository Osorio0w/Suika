// Importación de paquetes y clases necesarias
package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Queue;
import javax.swing.JPanel;
import javax.swing.Timer;
import main.declararAssets;
import main.GeneradorFrutas;

// Clase principal que extiende JPanel e implementa ActionListener
public class Animacion extends JPanel implements ActionListener 
{
    // Variables de coordenadas del cursor
    public static int cursorX;
    private static int cursorY;

    // Clase para controlar el siguiente elemento
    private Siguiente siguiente = null;
    
    //Fuente para el contador de click y puntaje
    Font Arial24 = new Font("Arial",Font.BOLD, 24);
    
    //Contador de Clicks
    private int clickCounter;

    GeneradorFrutas generadorFrutas;
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
        
        //Cargar assets
        declararAssets.init();
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
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(declararAssets.fondo,0,0,this);

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

            if (b instanceof Datil) 
            {
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.datil.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.datil.getHeight()/2;
                g.drawImage(declararAssets.datil, xPos, yPos, this);
            }   
            if (b instanceof Mamon)
            {   
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.mamon.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.mamon.getHeight()/2;
                g.drawImage(declararAssets.mamon, xPos, yPos, this);
            }   
            if (b instanceof Mamey)
            {
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.mamey.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.mamey.getHeight()/2;
                g.drawImage(declararAssets.mamey, xPos, yPos, this);
            }   
            if (b instanceof Cereza)
            {
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.cereza.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.cereza.getHeight()/2;
                g.drawImage(declararAssets.cereza, xPos, yPos, this);
            }   
            if (b instanceof Pumalaca)
            {
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.pumalaca.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.pumalaca.getHeight()/2;
                g.drawImage(declararAssets.pumalaca, xPos, yPos, this);
            }
            if (b instanceof Kiwi){
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.kiwi.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.kiwi.getHeight()/2;
                g.drawImage(declararAssets.kiwi, xPos, yPos, this);
            }
            if (b instanceof Parchita)
            {
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.parchita.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.parchita.getHeight()/2;
                g.drawImage(declararAssets.parchita, xPos, yPos, this);
            }
            if (b instanceof Mango)
            {
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.mango.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.mango.getHeight()/2;
                g.drawImage(declararAssets.mango, xPos, yPos, this);
            }

            if (b instanceof Coco)
            {
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.coco.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.coco.getHeight()/2;
                g.drawImage(declararAssets.coco, xPos, yPos, this);
            }

            if (b instanceof Patilla)
            {
                int xPos = (int) (b.posicionActual.getX() * pixelsPerMeter) - declararAssets.patilla.getWidth()/2;
                int yPos = this.getHeight() - (int) (b.posicionActual.getY() * pixelsPerMeter) - declararAssets.patilla.getHeight()/2;
                g.drawImage(declararAssets.patilla, xPos, yPos, this);
            }
        }

        // Dibujar la cajita donde caen las frutas
        // Dibujar la cajita donde caen las frutas
        g2.setColor(Color.black);
        BasicStroke grosorLinea = new BasicStroke(5);
        g2.setStroke(grosorLinea);
        Path2D jar = new Path2D.Double();

        // Parte izquierda
        jar.moveTo(600, 10);
        jar.lineTo(600, 870);

        // Parte derecha
        jar.lineTo(1320, 870);
        jar.lineTo(1320, 10);
        
        
        jar.closePath();

        g2.draw(jar);
        Toolkit.getDefaultToolkit().sync();

        //Mostrar el contador de turnos y el puntaje del jugador
        g.setFont(Arial24);
        g.setColor(Color.BLACK);
        g.drawString("Turnos: " + clickCounter, 60, 40);
        g.drawString("Puntaje:" + lista.obtenerPuntaje(), 60, 120);
        previewFruta(g2);
    }
    
    // Métodos para dibujar la vista previa de la próxima bola
    public void previewFruta(Graphics2D g2)
        {   Queue<String> colaBolas = ballFactory.getColaBolas();
            if (!colaBolas.isEmpty())
            {
                String proximaFruta  = colaBolas.peek();
                switch (proximaFruta)
                {
                    case "Datil":
                        g2.drawImage(declararAssets.datil, cursorX - declararAssets.datil.getWidth()/2, 9, null);
                        break;

                    case "Mamon":
                        g2.drawImage(declararAssets.mamon, cursorX - declararAssets.mamon.getWidth()/2, 9, null);
                        break;

                    case "Mamey":
                        g2.drawImage(declararAssets.mamey, cursorX - declararAssets.mamey.getWidth()/2, 9, null);
                        break;

                    case "Cereza":
                        g2.drawImage(declararAssets.cereza, cursorX - declararAssets.cereza.getWidth()/2, 9, null);
                        break;

                    case "Pumalaca":
                        g2.drawImage(declararAssets.pumalaca, cursorX - declararAssets.pumalaca.getWidth()/2, 9, null);
                        break;
                        
                    case "Kiwi":
                        g2.drawImage(declararAssets.kiwi, cursorX - declararAssets.kiwi.getWidth()/2, 9, null);
                        break;
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
    
    // Método para crear la ventana
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                // Creación de la animación
                Animacion anim = new Animacion(1440, 900, 120);
                
                // Configuración de los listeners del mouse
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
