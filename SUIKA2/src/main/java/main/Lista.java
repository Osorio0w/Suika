/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.lang.Math;
import java.util.*;
/**
 *
 * @author Andrès Osorio
 */
public class Lista {

    Animacion animator;
    double areaWidth, areaHeight;
    Vector2D gravity = new Vector2D(0,-9.82);

    ArrayList<Bola> balls = new ArrayList<Bola>();

    Lista(double ancho, double alto, Animacion anim) {
        areaWidth = ancho;
        areaHeight = alto;
        animator = anim;
    }

    void step(double deltaT) {

        int subSteps = 32;
        double subDetlaT = deltaT / subSteps;
        for (int i = subSteps; i > 0; --i){

            aplicarGravedad();
            applyConstraint();
            solveCollisions();
            actualizarPosicion(subDetlaT);
        }
    }


    private void solveCollisions() {
        int numberOfObjects = balls.size();
        if (numberOfObjects > 1) {
            for (int i = 0; i < numberOfObjects; ++i) {
                for (int j = 0; j < numberOfObjects; j++) {
                    if(i != j) {
                        if(!balls.get(i).outOfGame && !balls.get(j).outOfGame ) {
                            double collisionAxisX = balls.get(i).position_current.getX() - balls.get(j).position_current.getX();
                            double collisionAxisY = balls.get(i).position_current.getY() - balls.get(j).position_current.getY();
                            Vector2D collsionAxis = new Vector2D(collisionAxisX, collisionAxisY);
                            double dist = Math.sqrt(Math.pow(collisionAxisX, 2) + Math.pow(collisionAxisY, 2));
                            double minDist = balls.get(i).radius + balls.get(j).radius;
                            if (dist < minDist) {
                                if (balls.get(i).radius == balls.get(j).radius) {
                                    merge(balls.get(i), balls.get(j)); //¿Podemos agregar un bool para outOfGame?
                                } else {
                                    Vector2D n = collsionAxis.divide(dist);
                                    double overlap = minDist - dist;
                                    if(overlap < 0.001) {
                                        
                                        //if(!balls.get(i).intersectWithOtherBall && balls.get(j).intersectWithOtherBall){
                                        
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 1) {
                                            if (balls.get(i).mass > balls.get(j).mass) {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.45 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.55 * overlap));
                                            } else {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.55 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.45 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 2) {
                                            if (balls.get(i).mass > balls.get(j).mass) {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.35 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.65 * overlap));
                                            } else {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.65 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.35 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 3) {
                                            if (balls.get(i).mass > balls.get(j).mass) {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.20 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.80 * overlap));
                                            } else {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.80 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.20 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 4) {
                                            if (balls.get(i).mass > balls.get(j).mass) {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.10 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.90 * overlap));
                                            } else {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.90 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.10 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 5) {
                                            if (balls.get(i).mass > balls.get(j).mass) {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.05 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.95 * overlap));
                                            } else {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0.95 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0.05 * overlap));
                                            }

                                        }
                                        if (Math.abs(balls.get(i).mass - balls.get(j).mass) == 6) {
                                            if (balls.get(i).mass > balls.get(j).mass) {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(0 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(1 * overlap));
                                            } else {
                                                balls.get(i).position_current = balls.get(i).position_current.add(n.multiply(1 * overlap));
                                                balls.get(j).position_current = balls.get(j).position_current.subtract(n.multiply(0 * overlap));
                                            }

                                        }
                                    }
                                    
                                    else{
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 1) {
                                            if(balls.get(i).mass > balls.get(j).mass){
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
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 2) {
                                            if(balls.get(i).mass > balls.get(j).mass){
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
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 3) {
                                            if(balls.get(i).mass > balls.get(j).mass){
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
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 4) {
                                            if(balls.get(i).mass > balls.get(j).mass){
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
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 5) {
                                            if(balls.get(i).mass > balls.get(j).mass){
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
                                        if(Math.abs(balls.get(i).mass - balls.get(j).mass) == 6) {
                                            if(balls.get(i).mass > balls.get(j).mass){
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

    private void merge(Bola ball, Bola ball1) {

        Vector2D collisionLine = new Vector2D(ball.position_current.getX() - ball1.position_current.getX(), ball.position_current.getY() - ball1.position_current.getY());
        double collisionLineLength = Math.sqrt(Math.pow(ball.position_current.getX() - ball1.position_current.getX(), 2) + Math.pow(ball.position_current.getY() - ball1.position_current.getY(), 2));
        //Normalizar collisionLine
        Vector2D n = collisionLine.divide(collisionLineLength);
        Vector2D collsisionPoint = n.multiply(ball.radius);
        Vector2D correctCollisionPoint = collsisionPoint.add(ball1.position_current);


        if (ball instanceof Datil){
            if(correctCollisionPoint.getX() > 4.8){
                animator.ballFactory.crearMamon(correctCollisionPoint.getX() - ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearMamon(correctCollisionPoint.getX() + ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Mamon){
            if(correctCollisionPoint.getX() > 4.8){
                animator.ballFactory.crearMamey(correctCollisionPoint.getX() - ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearMamey(correctCollisionPoint.getX() + ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Mamey){
            if(correctCollisionPoint.getX() > 4.8){
                animator.ballFactory.crearCereza(correctCollisionPoint.getX() - ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearCereza(correctCollisionPoint.getX() + ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Cereza){
            if(correctCollisionPoint.getX() > 4.8){
                animator.ballFactory.crearPumalaca(correctCollisionPoint.getX() - ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearPumalaca(correctCollisionPoint.getX() + ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Pumalaca){
            if(correctCollisionPoint.getX() > 4.8){
                animator.ballFactory.crearKiwi(correctCollisionPoint.getX() - ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearKiwi(correctCollisionPoint.getX() + ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
        }

        if (ball instanceof Kiwi){
            if(correctCollisionPoint.getX() > 4.8){
                animator.ballFactory.crearParchita(correctCollisionPoint.getX() - ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
            else {
                animator.ballFactory.crearParchita(correctCollisionPoint.getX() + ball1.radius * 0.5, correctCollisionPoint.getY() + ball1.radius * 0.5);
            }
        }

        ball.setOutOfGame(true);
        ball1.setOutOfGame(true);
        ball.position_current.set(99999.9,99999.9);
        ball.position_old.set(99999.9,99999.9);
        ball1.position_current.set(99999.9,99999.9);
        ball1.position_old.set(99999.9,99999.9);
    }

    private void applyConstraint() {
        double maxX = 1320.0/200;
        double minX = 600.0/200;
        double minY = 190.0/200;
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

            if (b.position_current.getX() < minX + b.radius){
                Vector2D n = toMinX.divide(distMinX);
                double correctionScalar = b.radius - distMinX;
                Vector2D correctionshit = n.multiply(correctionScalar);
                b.position_current = b.position_current.add(correctionshit);
            }
            if (b.position_current.getX() > maxX - b.radius){
                Vector2D n = toMaxX.divide(distMaxX);
                double correctionScalar = -b.radius + distMaxX;
                Vector2D correctionshit = n.multiply(correctionScalar);
                b.position_current = b.position_current.add(correctionshit);
            }
            if (b.position_current.getY() < minY + b.radius){ // Las coordenadas Y están invertidas
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

    private void actualizarPosicion(double deltaT) {
        for (Bola b : balls){
            b.updatePosition(deltaT);
        }
    }

    private void aplicarGravedad() {
        for (Bola b : balls){
            
            //if(!b.outOfConstraint)
            
            b.accelerate(gravity);
        }
    }
}
