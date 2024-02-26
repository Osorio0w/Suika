package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Clase que representa una bola en el programa
public class Bola 
{
    // Constructor de la clase Bola
    Bola(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) throws IOException 
    {
        // Inicialización de los atributos de la bola
        this.x = x;
        this.y = y;
        this.ax = ax;
        this.ay = ay;
        this.radio = r;
        this.masa = m;
        this.posicionActual = new Vector2D(x,y);
        this.posicionAntigua = new Vector2D(x,y);
        this.aceleracion = new Vector2D(0,0);
        this.fuera_de_restricciones = outOfConstraint;
        this.fuera_del_juego = outOfGame;
        this.interseccionConOtraBola = intersectWithOtherBall;
    }

    // Método para actualizar la posición de la bola en función del tiempo
    void actualizarPosicion(double dt)
    {
        if(!fuera_del_juego) 
        {
             // Calcular la velocidad actual
            Vector2D velocidad = posicionActual.restar(posicionAntigua);
            // Guardar posición actual
            posicionAntigua = posicionActual;
             // Integración Verlet para actualizar la posición
            Vector2D deltaAcc = aceleracion.multiplicar(dt).multiplicar(dt);
            Vector2D deltaPos = velocidad.sumar(deltaAcc);
            posicionActual = posicionActual.sumar(deltaPos);
            // Reiniciar aceleración
            aceleracion.set(0, 0);
        }
    }

    // Método para aplicar una aceleración a la bola
    void acelerar(Vector2D acc)
    {
        aceleracion = aceleracion.sumar(acc);
    }
    
    // Métodos para establecer el estado de la bola
        public void setFuera_del_juego(boolean outOfGame) 
    {
        this.fuera_del_juego = outOfGame;
    }
        
    public void setIntersectWithOtherBall(boolean intersectWithOtherBall) 
    {
        this.interseccionConOtraBola = intersectWithOtherBall;
    }
    
    double x, y, ax, ay, radio, masa;
    Vector2D posicionActual;
    Vector2D posicionAntigua;
    Vector2D aceleracion;
    boolean fuera_de_restricciones;
    boolean fuera_del_juego;
    boolean interseccionConOtraBola;
}
