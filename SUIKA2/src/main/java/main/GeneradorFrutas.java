/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.Arrays;

/**
 *
 * @author Andrès Osorio
 */
public class GeneradorFrutas {


    Lista model;
    double  alturaDelArea;
    double areaWidth;
    int contador = 0;
    Siguiente siguiente;
    //Constructor
    GeneradorFrutas(Lista model, Siguiente nextBall){
        this.model = model;
        this.alturaDelArea = model.areaHeight;
        this.areaWidth = model.areaWidth;
        this.siguiente = nextBall;
    }

    void crearDatil(double x, double y){
        System.out.println("Se crea un dátil");

        model.balls.add(new Datil(x, y, 0, 0, 0.1, 1, false, false, false));
    }

    void crearMamon(double x, double y){
        System.out.println("Se crea un mamón");

        model.balls.add(new Mamon(x, y, 0, 0, 0.1, 1, false, false, false));// (No sé si es un error)
    }
    void crearMamey(double x, double y){
        System.out.println("Se crea un mamey");

        model.balls.add(new Mamey(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearCereza(double x, double y){
        System.out.println("Se crea una cereza");

        model.balls.add(new Cereza(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearPumalaca(double x, double y){
        System.out.println("Se crea una pumalaca");

        model.balls.add(new Pumalaca(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearKiwi(double x, double y){
        System.out.println("Se crea un kiwi");

        model.balls.add(new Kiwi(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearParchita(double x, double y){
        System.out.println("Se crea una parchita");

        model.balls.add(new Parchita(x, y, 0, 0, 0.1, 1, false, false, false));
    }


    void crearFruta(double x, double y, double pixelsPerMeter){
        System.out.println("Se crea una fruta");

        // Convertir coordenadas de píxeles a coordenadas del modelo
        double xModel = x / pixelsPerMeter;
        double yModel = alturaDelArea - (y / pixelsPerMeter);
        contador++;
            if((contador % 7) == 0){
                model.balls.add(new Mamon(xModel, yModel, 0, 0, 0.1, 1, false, false, false));
                siguiente.setValue("VerySmallBall");
            }
            if((contador % 7) == 1){
                model.balls.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                siguiente.setValue("NormalBall");
            }
            if((contador % 7) == 2){
                model.balls.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                siguiente.setValue("NormalBall");
            }
            if((contador % 7) == 3){
                model.balls.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                siguiente.setValue("NormalBall");
            }
            if((contador % 7) == 4){
                model.balls.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                siguiente.setValue("VerySmallBall");
            }
            if((contador % 7) == 5){
                model.balls.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                siguiente.setValue("VerySmallBall");
            }
            if((contador % 7) == 6){
                model.balls.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                siguiente.setValue("SmallBall");
            }
    }
}
