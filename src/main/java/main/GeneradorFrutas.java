package main;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// Clase encargada de generar frutas en el juego
public class GeneradorFrutas
{
    Colisiones model;       // Añade una lista
    double  alturaDelArea;  // Altura del juego
    double areaWidth;       // Ancho del juego
    int contador = 0;       // Contador que suma 1 por cada click, se utiliza para generar las bolas
    private Queue<String> colaBolas = new LinkedList<>();
    // Constructor de la clase GeneradorFrutas
    GeneradorFrutas(Colisiones model)
    {
        this.model = model; 
        this.alturaDelArea = model.alturaDelArea;
        this.areaWidth = model.anchoDelArea;
        inicializarCola(); //Inicializa la cola con los tipos de fruta
    }
    
    private void inicializarCola()
    {
        colaBolas.add("Kiwi");
        colaBolas.add("Cereza");
    }
    public Queue<String> getColaBolas()
    {
        return colaBolas;
    }
    
    // Métodos para crear diferentes tipos de frutas con las coordenadas del mouse
    void crearDatil(BufferedImage img, double x, double y) throws IOException
    {
        System.out.println("Se crea un dátil");
        model.Bolas.add(new Datil(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearMamon(double x, double y) throws IOException
    {
        System.out.println("Se crea un mamón");
        model.Bolas.add(new Mamon(x, y, 0, 0, 0.1, 1, false, false, false));// (No sé si es un error)
    }
    void crearMamey(double x, double y) throws IOException
    {
        System.out.println("Se crea un mamey"); 
        model.Bolas.add(new Mamey(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearCereza(double x, double y) throws IOException
    {
        System.out.println("Se crea una cereza");
        model.Bolas.add(new Cereza(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearPumalaca(double x, double y) throws IOException
    {
        System.out.println("Se crea una pumalaca");
        model.Bolas.add(new Pumalaca(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearKiwi(double x, double y) throws IOException
    {
        System.out.println("Se crea un kiwi");
        model.Bolas.add(new Kiwi(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearParchita(double x, double y) throws IOException
    {
        System.out.println("Se crea una parchita");
        model.Bolas.add(new Parchita(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearMango(double x, double y) throws IOException
    {
        System.out.println("Se crea un mango");
        model.Bolas.add(new Mango(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearCoco(double x, double y) throws IOException
    {
        System.out.println("Se crea un coco");
        model.Bolas.add(new Coco(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    void crearPatilla(double x, double y) throws IOException
    {
        System.out.println("Se crea una patilla");
        model.Bolas.add(new Patilla(x, y, 0, 0, 0.1, 1, false, false, false));
    }
    
    // Método para crear una fruta en una posición específica, con conversión de coordenadas
    void crearFruta(double x, double y, double pixelsPerMeter) throws IOException
    {
        System.out.println("Se crea una fruta");
        
        // Convertir coordenadas de píxeles a coordenadas del modelo
        double xModel = (x / pixelsPerMeter);
        System.out.println(xModel + "<--- xModel");
        
        double yModel = (alturaDelArea - (y / pixelsPerMeter) - 0.3);
        
        // Verifica si la colaBolas tiene menos de 2 elementos
        while (colaBolas.size() < 10) 
        {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(5) + 1; // Genera un número aleatorio entre 1 y 5

            // Asocia cada número con un tipo de fruta y agrega las frutas correspondientes a la cola
            switch (numeroAleatorio) 
            {
                case 1 -> colaBolas.add("Datil");
                case 2 -> colaBolas.add("Mamon");
                case 3 -> colaBolas.add("Mamey");
                case 4 -> colaBolas.add("Cereza");
                case 5 -> colaBolas.add("Kiwi");
            }
        }
            
            String tipoFruta = colaBolas.poll();
        // Determinar el tipo de fruta a crear basado en el contador
            switch(tipoFruta)
            {
                case "Datil" -> 
                    model.Bolas.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                    
                case "Mamon" -> 
                    model.Bolas.add(new Mamon(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                    
                case "Mamey" -> 
                    model.Bolas.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
            
                case "Cereza" -> 
                    model.Bolas.add(new Cereza(xModel, yModel, 0, 0, 0.1, 1,false, false, false));
                    
                case "Kiwi" -> 
                    model.Bolas.add(new Kiwi(xModel, yModel, 0, 0, 0.1, 1, false, false, false));
            
            } 
            System.out.println(tipoFruta + "<--- Bola siguiente");
            System.out.println(colaBolas.toString() + "<--- Cola"); 
    }
    
        
}
