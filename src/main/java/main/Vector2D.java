package main;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Método para restar otro vector de este
    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    // método para agregar otro vector a este
    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }
    // Método para multiplicar este vector por un escalar
    public Vector2D multiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    // Método para dividir este vector por un escalar
    public Vector2D divide(double scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return new Vector2D(this.x / scalar, this.y / scalar);
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

