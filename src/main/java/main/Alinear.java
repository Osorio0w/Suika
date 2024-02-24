package main;

public class Alinear {

    Alinear(double x, double y) { // Coordenadas x e y del punto
        this.x = x;
        this.y = y;
    }

    double x, y;

        /**
     * Método para obtener la coordenada x del punto.
     * 
     * @return La coordenada x del punto.
     */
    double getX(){
        return this.x;
    }

     /**
     * Método para obtener la coordenada y del punto.
     * 
     * @return La coordenada y del punto.
     */
    double getY(){
        return this.y;
    }
}

