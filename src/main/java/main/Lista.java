package main;

import java.io.IOException;
import java.util.*;

public class Lista 
{

    Animacion animator; // Referencia al objeto Animacion
    double anchoDelArea, alturaDelArea; // Dimensiones del área de juego
    Vector2D gravity = new Vector2D(0,-9.82); // Gravedad aplicada a las bolas

    ArrayList<Bola> balls = new ArrayList<Bola>(); // Lista de bolas en el área de juego

        /**
     * Constructor de la clase Lista.
     * @param ancho Ancho del área de juego.
     * @param alto Alto del área de juego.
     * @param anim Referencia al objeto Animacion.
     */
    
    Lista(double ancho, double alto, Animacion anim) 
    {
        anchoDelArea = ancho;
        alturaDelArea = alto;
        animator = anim;
    }

    void step(double deltaT) throws IOException 
    {

        int subSteps = 32;
        double subDetlaT = deltaT / subSteps;
        for (int i = subSteps; i > 0; --i){

            aplicarGravedad();
            applyConstraint();
            solveCollisions();
            actualizarPosicion(subDetlaT);
        }
    }

    /**
     * Método que realiza un paso de la simulación del juego.
     * @param deltaT Intervalo de tiempo.
     * @throws IOException Excepción de E/S.
     */
    private void solveCollisions() throws IOException 
    {
        int numeroDeObjetos = balls.size();
        if (numeroDeObjetos > 1) 
        {
            for (int i = 0; i < numeroDeObjetos; ++i) 
            {
                for (int j = 0; j < numeroDeObjetos; j++) 
                {
                    if(i != j) {
                        if(!balls.get(i).outOfGame && !balls.get(j).outOfGame ) 
                        {
                             // Detectar colisión entre las bolas i y j
                            // Resolver colisión según las características de las bolas
                            double collisionAxisX = balls.get(i).position_current.getX() - balls.get(j).position_current.getX();
                            double collisionAxisY = balls.get(i).position_current.getY() - balls.get(j).position_current.getY();
                            Vector2D collsionAxis = new Vector2D(collisionAxisX, collisionAxisY);
                            double dist = Math.sqrt(Math.pow(collisionAxisX, 2) + Math.pow(collisionAxisY, 2));
                            double minDist = balls.get(i).radius + balls.get(j).radius;
                            //Se detecta una colisión cuando la distancia que separa a las bolas es menor a la suma de sus radios
                            if (dist < minDist) 
                            {
                                if (balls.get(i).radius == balls.get(j).radius) 
                                {
                                    fusionar(balls.get(i), balls.get(j)); //¿Podemos agregar un bool para outOfGame?
                                } else 
                                {
                                    Vector2D n = collsionAxis.divide(dist);
                                    double overlap = minDist - dist;
                                    if(overlap < 0.001) 
                                    {
                                        
                                        //if(!balls.get(i).intersectWithOtherBall && balls.get(j).intersectWithOtherBall){
                                        
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 1) 
                                        {
                                            if (balls.get(i).mass > balls.get(j).mass) 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.45 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.55 * overlap));
                                            } else 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.55 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.45 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 2) 
                                        {
                                            if (balls.get(i).mass > balls.get(j).mass) 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.35 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.65 * overlap));
                                            } else 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.65 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.35 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 3) 
                                        {
                                            if (balls.get(i).mass > balls.get(j).mass) 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.20 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.80 * overlap));
                                            } else 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.80 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.20 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 4) 
                                        {
                                            if (balls.get(i).mass > balls.get(j).mass) 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.10 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.90 * overlap));
                                            } else 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.90 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.10 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 5) 
                                        {
                                            if (balls.get(i).mass > balls.get(j).mass) 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.05 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.95 * overlap));
                                            } else 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.95 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.05 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 6) 
                                        {
                                            if (balls.get(i).mass > balls.get(j).mass) 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(1 * overlap));
                                            } else 
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(1 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0 * overlap));
                                            }

                                        }
                                    }
                                    
                                    else{
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 1) 
                                        {
                                            if(balls.get(i).mass > balls.get(j).mass)
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.45 * overlap * 0.01));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.55 * overlap * 0.01));
                                                balls.get(i).position_old = balls.get(i).position_current;
                                                balls.get(j).position_old = balls.get(j).position_current;
                                            }
                                            balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.45 * overlap * 0.01));
                                            balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.55 * overlap * 0.01));
                                            balls.get(i).position_old = balls.get(i).position_current;
                                            balls.get(j).position_old = balls.get(j).position_current;

                                        }
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 2) 
                                        {
                                            if(balls.get(i).mass > balls.get(j).mass)
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.35 * overlap * 0.01));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.65 * overlap * 0.01));
                                                balls.get(i).position_old = balls.get(i).position_current;
                                                balls.get(j).position_old = balls.get(j).position_current;
                                            }
                                            balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.65 * overlap * 0.01));
                                            balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.35 * overlap * 0.01));
                                            balls.get(i).position_old = balls.get(i).position_current;
                                            balls.get(j).position_old = balls.get(j).position_current;
                                        }
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 3) 
                                        {
                                            if(balls.get(i).mass > balls.get(j).mass)
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.80 * overlap * 0.01));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.20 * overlap * 0.01));
                                                balls.get(i).position_old = balls.get(i).position_current;
                                                balls.get(j).position_old = balls.get(j).position_current;
                                            }
                                            balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.80 * overlap * 0.01));
                                            balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.20 * overlap * 0.01));
                                            balls.get(i).position_old = balls.get(i).position_current;
                                            balls.get(j).position_old = balls.get(j).position_current;
                                        }
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 4) 
                                        {
                                            if(balls.get(i).mass > balls.get(j).mass)
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.10 * overlap * 0.01));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.9 * overlap * 0.01));
                                                balls.get(i).position_old = balls.get(i).position_current;
                                                balls.get(j).position_old = balls.get(j).position_current;
                                            }
                                            balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.9 * overlap * 0.01));
                                            balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.1 * overlap * 0.01));
                                            balls.get(i).position_old = balls.get(i).position_current;
                                            balls.get(j).position_old = balls.get(j).position_current;
                                        }
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 5) 
                                        {
                                            if(balls.get(i).mass > balls.get(j).mass)
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.05 * overlap * 0.01));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.95 * overlap * 0.01));
                                                balls.get(i).position_old = balls.get(i).position_current;
                                                balls.get(j).position_old = balls.get(j).position_current;
                                            }
                                            balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.95 * overlap * 0.01));
                                            balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.05 * overlap * 0.01));
                                            balls.get(i).position_old = balls.get(i).position_current;
                                            balls.get(j).position_old = balls.get(j).position_current;
                                        }
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 6) 
                                        {
                                            if(balls.get(i).mass > balls.get(j).mass)
                                            {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0 * overlap * 0.01));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(1 * overlap * 0.01));
                                                balls.get(i).position_old = balls.get(i).position_current;
                                                balls.get(j).position_old = balls.get(j).position_current;
                                            }
                                            balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(1 * overlap * 0.01));
                                            balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0 * overlap * 0.01));
                                            balls.get(i).position_old = balls.get(i).position_current;
                                            balls.get(j).position_old = balls.get(j).position_current;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

        /**
     * Método para fusionar dos bolas después de una colisión.
     * @param ball Primera bola.
     * @param ball1 Segunda bola.
     * @throws IOException Excepción de E/S.
     */
     // Lógica para fusionar dos bolas después de una colisión
    private void fusionar(Bola ball, Bola ball1) throws IOException 
    {

        Vector2D posicionColision = new Vector2D(ball.position_current.getX() - ball1.position_current.getX(), ball.position_current.getY() - ball1.position_current.getY());
        double distanciaColision = Math.sqrt(Math.pow(ball.position_current.getX() - ball1.position_current.getX(), 2) + Math.pow(ball.position_current.getY() - ball1.position_current.getY(), 2));
        //Normalizar collisionLine
        Vector2D n = posicionColision.divide(distanciaColision);
        Vector2D puntoDeColision = n.multiply(ball.radius);
        Vector2D corregirPuntoDeColision = puntoDeColision.add(ball1.position_current);

 
        if (ball instanceof Datil)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearMamon(corregirPuntoDeColision.getX() - ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
            else 
            {
                animator.ballFactory.crearMamon(corregirPuntoDeColision.getX() + ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Mamon)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearMamey(corregirPuntoDeColision.getX() - ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearMamey(corregirPuntoDeColision.getX() + ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Mamey)
        {
            if(corregirPuntoDeColision.getX() > 4.8){
                animator.ballFactory.crearCereza(corregirPuntoDeColision.getX() - ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearCereza(corregirPuntoDeColision.getX() + ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Cereza)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearPumalaca(corregirPuntoDeColision.getX() - ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
            else 
            {
                animator.ballFactory.crearPumalaca(corregirPuntoDeColision.getX() + ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Pumalaca)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearKiwi(corregirPuntoDeColision.getX() - ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearKiwi(corregirPuntoDeColision.getX() + ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Kiwi)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearParchita(corregirPuntoDeColision.getX() - ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearParchita(corregirPuntoDeColision.getX() + ball1.radius * 0.5, corregirPuntoDeColision.getY() + ball1.radius * 0.5);
            }
        }

        ball.setOutOfGame(true);
        ball1.setOutOfGame(true);
        ball.position_current.set(99999.9,99999.9);
        ball.position_old.set(99999.9,99999.9);
        ball1.position_current.set(99999.9,99999.9);
        ball1.position_old.set(99999.9,99999.9);
    }

    
    // Aplicar restricciones de movimiento a las bolas dentro del área de juego
    private void applyConstraint() 
    {
        double maxX = 1320.0/200;
        double minX = 600.0/200;
        double minY = 30.0/200;
        for (Bola b : balls){
            double toMinYY = b.position_current.getY() - minY;
            double toMinYX = 0;
            Vector2D toMinY = new Vector2D(toMinYX,toMinYY);
            double distMinY = Math.sqrt(Math.pow(toMinYX, 2) + Math.pow(toMinYY, 2));

            double toMinXY = 0;
            double toMinXX = b.position_current.getX() - minX;
            Vector2D toMinX = new Vector2D(toMinXX,toMinXY);
            double distMinX = Math.sqrt(Math.pow(toMinXX, 2) + Math.pow(toMinXY, 2));

            double toMaxXY = 0;
            double toMaxXX = maxX - b.position_current.getX();
            Vector2D toMaxX = new Vector2D(toMaxXX,toMaxXY);
            double distMaxX = Math.sqrt(Math.pow(toMaxXX, 2) + Math.pow(toMaxXY, 2));

            if (b.position_current.getX() < minX + b.radius)
            {
                Vector2D n = toMinX.divide(distMinX);
                double correctionScalar = b.radius - distMinX;
                Vector2D correctionshit = n.multiply(correctionScalar);
                b.position_current = b.position_current.add(correctionshit);
            }
            if (b.position_current.getX() > maxX - b.radius)
            {
                Vector2D n = toMaxX.divide(distMaxX);
                double correctionScalar = -b.radius + distMaxX;
                Vector2D correctionshit = n.multiply(correctionScalar);
                b.position_current = b.position_current.add(correctionshit);
            }
            if (b.position_current.getY() < minY + b.radius)
            { // Las coordenadas Y están invertidas
                Vector2D n = toMinY.divide(distMinY);
                double correctionScalar = b.radius - distMinY;
                Vector2D correction = n.multiply(correctionScalar);
                
                //if(correctionScalar > 0.0000000002){
                //    b.position_current = b.position_current.add(correction);
                //    b.position_old = b.position_current;
                //}
                
                b.position_current = b.position_current.add(correction);
            }
        }
    }

       /**
     * Método para actualizar la posición de las bolas en función del tiempo.
     * @param deltaT Intervalo de tiempo.
     */
    private void actualizarPosicion(double deltaT) 
    {
        for (Bola b : balls)
        {
            b.updatePosition(deltaT);
        }
    }

    
    /**
     * Método para aplicar la gravedad a las bolas.
     */
    private void aplicarGravedad() 
    {
        for (Bola b : balls)
        {
            
            //if(!b.outOfConstraint)
            
            b.accelerate(gravity);
        }
    }
}
