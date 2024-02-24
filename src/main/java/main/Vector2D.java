package main;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Método para restar otro vector de este
    public Vector2D restar(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    // método para agregar otro vector a este
    public Vector2D sumar(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }
    // Método para multiplicar este vector por un escalar
    public Vector2D multiplicar(double escalar) {
        return new Vector2D(this.x * escalar, this.y * escalar);
    }

    // Método para dividir este vector por un escalar
    public Vector2D dividir(double escalar) {
        if (escalar == 0) {
            throw new IllegalArgumentException("No puedes dividir por cero.");
        }
        return new Vector2D(this.x / escalar, this.y / escalar);
    }

    // Método para establecer la coordenada x
    public void setX(double x) {
        this.x = x;
    }

    //Método para establecer la coordenada y
    public void setY(double y) {
        this.y = y;
    }

    // Método para establecer ambas coordenadas a la vez
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // Método para obtener la coordenada X
    public double getX() {
        return this.x;
    }

    // Método para obtener la coordenada Y
    public double getY() {
        return this.y;
    }
}

