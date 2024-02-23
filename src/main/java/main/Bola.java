/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.ArrayList;
import java.util.Vector;
/**
 *
 * @author Andrès Osorio
 */
public class Bola {

    public void setOutOfGame(boolean outOfGame) {
        this.outOfGame = outOfGame;
    }

    public void setIntersectWithOtherBall(boolean intersectWithOtherBall) {
        this.intersectWithOtherBall = intersectWithOtherBall;
    }

    Bola(double x, double y, double ax, double ay, double r, double m, boolean outOfConstraint, boolean outOfGame, boolean intersectWithOtherBall) {
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

    void updatePosition(double dt){
        if(!outOfGame) {
            Vector2D velocity = position_current.subtract(position_old);
            // Guardar posición actual
            position_old = position_current;
            // Integración verlet
            Vector2D deltaAcc = acceleration.multiply(dt).multiply(dt);
            Vector2D deltaPos = velocity.add(deltaAcc);
            position_current = position_current.add(deltaPos);
            // Reiniciar aceleración
            acceleration.set(0, 0);
        }
    }

    void accelerate(Vector2D acc){
        acceleration = acceleration.add(acc);
    }

    double x, y, ax, ay, radius, mass;
    Vector2D position_current;
    Vector2D position_old;
    Vector2D acceleration;
    boolean outOfConstraint;
    boolean outOfGame;
    boolean intersectWithOtherBall;
}
