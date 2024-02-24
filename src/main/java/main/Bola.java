package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Clase que representa una bola en el programa
public class Bola 
{
    

    // Constructor de la clase Bola
    Bola(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall, BufferedImage image) throws IOException 
    {
        // Inicialización de los atributos de la bola
        this.x = x;
        this.y = y;
        this.ax = ax;
        this.ay = ay;
        this.radius = r;
        this.mass = m;
        this.position_current = new Vector2D(x,y);
        this.position_old = new Vector2D(x,y);
        this.acceleration = new Vector2D(0,0);
        this.outOfConstraint = outOfConstraint;
        this.outOfGame = outOfGame;
        this.intersectWithOtherBall = intersectWithOtherBall;
    }

    // Método para actualizar la posición de la bola en función del tiempo
    void updatePosition(double dt)
    {
        if(!outOfGame) 
        {
             // Calcular la velocidad actual
            Vector2D velocity = position_current.subtract(position_old);
            // Guardar posición actual
            position_old = position_current;
             // Integración Verlet para actualizar la posición
            Vector2D deltaAcc = acceleration.multiply(dt).multiply(dt);
            Vector2D deltaPos = velocity.add(deltaAcc);
            position_current = position_current.add(deltaPos);
            // Reiniciar aceleración
            acceleration.set(0, 0);
        }
    }

    // Método para aplicar una aceleración a la bola
    void accelerate(Vector2D acc)
    {
        acceleration = acceleration.add(acc);
    }
    
    // Métodos para establecer el estado de la bola
        public void setOutOfGame(boolean outOfGame) 
    {
        this.outOfGame = outOfGame;
    }
        
    public void setIntersectWithOtherBall(boolean intersectWithOtherBall) 
    {
        this.intersectWithOtherBall = intersectWithOtherBall;
    }
    
    double x, y, ax, ay, radius, mass;
    Vector2D position_current;
    Vector2D position_old;
    Vector2D acceleration;
    boolean outOfConstraint;
    boolean outOfGame;
    boolean intersectWithOtherBall;
}
