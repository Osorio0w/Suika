package main;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

// Clase encargada de generar frutas en el juego
public class GeneradorFrutas extends declararAssets
{
    declararAssets assets;
    Colisiones model;       // Añade una lista
    double  alturaDelArea;  // Altura del juego
    double areaWidth;       // Ancho del juego
    int contador = 0;       // Contador que suma 1 por cada click, se utiliza para generar las bolas
    Siguiente siguiente;    // Siguiente tipo de fruta a generar (esto es un string) (no lo he hecho funcionar todavía)
    private Queue<String> colaBolas = new LinkedList<>();
    Cola cola;
    // Constructor de la clase GeneradorFrutas
    GeneradorFrutas(Colisiones model, Siguiente bolaSiguiente)
    {
        this.model = model; 
        this.alturaDelArea = model.alturaDelArea;
        this.areaWidth = model.anchoDelArea; 
        this.siguiente = bolaSiguiente;
        cola = new Cola();
        
    }
    // Métodos para crear diferentes tipos de frutas con las coordenadas del mouse
    void crearDatil(BufferedImage img, double x, double y) throws IOException
    {
        System.out.println("Se crea un dátil");
        model.Bolas.add(new Datil(x, y, 0, 0, 0.1, 1, false, false, false, img));
    }
    void crearMamon(double x, double y) throws IOException
    {
        System.out.println("Se crea un mamón");
        model.Bolas.add(new Mamon(x, y, 0, 0, 0.1, 1, false, false, false, mamonImage));// (No sé si es un error)
    }
    void crearMamey(double x, double y) throws IOException
    {
        System.out.println("Se crea un mamey"); 
        model.Bolas.add(new Mamey(x, y, 0, 0, 0.1, 1, false, false, false, mameyImage));
    }
    void crearCereza(double x, double y) throws IOException
    {
        System.out.println("Se crea una cereza");
        model.Bolas.add(new Cereza(x, y, 0, 0, 0.1, 1, false, false, false, cerezaImage));
    }
    void crearPumalaca(double x, double y) throws IOException
    {
        System.out.println("Se crea una pumalaca");
        model.Bolas.add(new Pumalaca(x, y, 0, 0, 0.1, 1, false, false, false, pumalacaImage));
    }
    void crearKiwi(double x, double y) throws IOException
    {
        System.out.println("Se crea un kiwi");
        model.Bolas.add(new Kiwi(x, y, 0, 0, 0.1, 1, false, false, false, kiwiImage));
    }
    void crearParchita(double x, double y) throws IOException
    {
        System.out.println("Se crea una parchita");
        model.Bolas.add(new Parchita(x, y, 0, 0, 0.1, 1, false, false, false, parchitaImage));
    }
    void crearMango(double x, double y) throws IOException
    {
        System.out.println("Se crea un mango");
        model.Bolas.add(new Mango(x, y, 0, 0, 0.1, 1, false, false, false, mangoImage));
    }
    void crearCoco(double x, double y) throws IOException
    {
        System.out.println("Se crea un coco");
        model.Bolas.add(new Coco(x, y, 0, 0, 0.1, 1, false, false, false, cocoImage));
    }
    void crearPatilla(double x, double y) throws IOException
    {
        System.out.println("Se crea una patilla");
        model.Bolas.add(new Patilla(x, y, 0, 0, 0.1, 1, false, false, false, patillaImage));
    }

    // Método para agregar la bola a la cola
    private void agregarBolaACola(String bola) 
    {
        colaBolas.add(bola);
    }
    
    
    // Método para crear una fruta en una posición específica, con conversión de coordenadas
    void crearFruta(double x, double y, double pixelsPerMeter) throws IOException
    {
        System.out.println("Se crea una fruta");
        // Convertir coordenadas de píxeles a coordenadas del modelo
        double xModel = (x / pixelsPerMeter);
        
        assets.init();
        
        System.out.println(xModel + " wasa");
        double yModel = (alturaDelArea - (y / pixelsPerMeter) - 0.3);
        contador++;
        // Determinar el tipo de fruta a crear basado en el contador
            System.out.println(contador + "<--- contador");
            if((contador % 7) == 0)
            {
                model.Bolas.add(new Mamon(xModel, yModel, 0, 0, 0.1, 1, false, false, false, mamonImage));
                siguiente.setValue("Mamon");
            }
            if((contador % 7) == 1)
            {
                model.Bolas.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false, datilImage));
                siguiente.setValue("Datil");
            }
            if((contador % 7) == 2)
            {
                model.Bolas.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false, mameyImage));
                siguiente.setValue("Mamey");
            }
            if((contador % 7) == 3)
            {
                model.Bolas.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false, mameyImage));
                siguiente.setValue("Mamey");
            }
            if((contador % 7) == 4)
            {
                model.Bolas.add(new Cereza(xModel, yModel, 0, 0, 0.1, 1,false, false, false, cerezaImage));
                siguiente.setValue("Cereza");
            }
            if((contador % 7) == 5)
            {
                model.Bolas.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false, datilImage));
                siguiente.setValue("Datil");
            }
            System.out.println(siguiente.getValue() + "<--- siguiente");
    }
}
