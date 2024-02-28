package main;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class entradaPorMouse extends MouseAdapter {
    private Animacion animator;
    private double pixelPerMeter;
    private long lastClickTime; // Variable para almacenar el tiempo del último clic
    private long cooldown = 500; // Tiempo de enfriamiento en milisegundos (0.2 segundos)
    private int clickCounter; // Contador de clics
    private Colisiones lista;

    public entradaPorMouse(Animacion animator, double pixelPerMeter) {
        this.animator = animator;
        this.pixelPerMeter = pixelPerMeter;
        this.lastClickTime = 0;
        this.clickCounter = 0; // Inicializamos el contador de clics
    }

    @Override
    public void mousePressed(MouseEvent e) {
        long currentTime = System.currentTimeMillis(); // Obtenemos el tiempo actual
        
        // Verificamos si el tiempo transcurrido desde el último clic es mayor que el cooldown
        if (currentTime - lastClickTime >= cooldown) 
        {
            // Actualizamos el tiempo del último clic
            lastClickTime = currentTime;
            
            // Incrementamos el contador de clics
            clickCounter++;
            
            // Limito el área en que se puede hacer clic para evitar bugs
            if(e.getX() > 600 && e.getX() < 1400)
            {
                System.out.println("Mouse presionado en:" + e.getX() + ", " + "10");
                try 
                {
                    animator.ballFactory.crearFruta(e.getX(), 10, pixelPerMeter);
                } catch (IOException ex) 
                {
                    Logger.getLogger(entradaPorMouse.class.getName()).log(Level.SEVERE, null, ex);
                }
                animator.setClickCounter(animator.getClickCounter() + 1);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        System.out.println("Mouse liberado en: " + e.getX() + ", " + e.getY());
    }
}
