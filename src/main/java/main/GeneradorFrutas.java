package main;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Clase encargada de generar frutas en el juego
public class GeneradorFrutas 
{


    Lista model;//Añade una lista
    double  alturaDelArea;  // Altura del juego
    double areaWidth; // Ancho del juego
    int contador = 0; 
    Siguiente siguiente;  //  siguiente tipo de fruta a generar (esto es un string) (no lo he hecho funcionar todavía)
    
    // Constructor de la clase GeneradorFrutas
    GeneradorFrutas(Lista model, Siguiente bolaSiguiente)
    {
        this.model = model; 
        this.alturaDelArea = model.alturaDelArea;
        this.areaWidth = model.anchoDelArea; 
        this.siguiente = bolaSiguiente;
    }

    // Métodos para crear diferentes tipos de frutas con las coordenadas del mouse
    void crearDatil(double x, double y) throws IOException
    {
        System.out.println("Se crea un dátil");
        BufferedImage datilImage = ImageIO.read(new File("src/main/java/images/cherry_view.png"));
        model.balls.add(new Datil(x, y, 0, 0, 0.1, 1, false, false, false, datilImage));
    }

    void crearMamon(double x, double y) throws IOException
    {
        System.out.println("Se crea un mamón");
        BufferedImage mamonImage    = ImageIO.read(new File("src/main/java/images/strawberry_view.png"));
        model.balls.add(new Mamon(x, y, 0, 0, 0.1, 1, false, false, false, mamonImage));// (No sé si es un error)
    }
    void crearMamey(double x, double y) throws IOException
    {
        System.out.println("Se crea un mamey");
        BufferedImage mameyImage    = ImageIO.read(new File("src/main/java/images/grape_view.png"));
        model.balls.add(new Mamey(x, y, 0, 0, 0.1, 1, false, false, false, mameyImage));
    }
    void crearCereza(double x, double y) throws IOException
    {
        System.out.println("Se crea una cereza");
        BufferedImage cerezaImage   = ImageIO.read(new File("src/main/java/images/lemon_view.png"));
        model.balls.add(new Cereza(x, y, 0, 0, 0.1, 1, false, false, false, cerezaImage));
    }
    void crearPumalaca(double x, double y) throws IOException
    {
        System.out.println("Se crea una pumalaca");
        BufferedImage pumalacaImage = ImageIO.read(new File("src/main/java/images/orange_view.png"));
        model.balls.add(new Pumalaca(x, y, 0, 0, 0.1, 1, false, false, false, pumalacaImage));
    }
    void crearKiwi(double x, double y) throws IOException
    {
        System.out.println("Se crea un kiwi");
        BufferedImage kiwiImage     = ImageIO.read(new File("src/main/java/images/apple_view.png"));
        model.balls.add(new Kiwi(x, y, 0, 0, 0.1, 1, false, false, false, kiwiImage));
    }
    void crearParchita(double x, double y) throws IOException
    {
        System.out.println("Se crea una parchita");
        BufferedImage parchitaImage = ImageIO.read(new File("src/main/java/images/pear_view.png"));
        model.balls.add(new Parchita(x, y, 0, 0, 0.1, 1, false, false, false, parchitaImage));
    }

    // Método para crear una fruta en una posición específica, con conversión de coordenadas
    void crearFruta(double x, double y, double pixelsPerMeter) throws IOException
    {
        System.out.println("Se crea una fruta");

        // Convertir coordenadas de píxeles a coordenadas del modelo
        double xModel = x / pixelsPerMeter;
        double yModel = alturaDelArea - (y / pixelsPerMeter);
        contador++;
        // Determinar el tipo de fruta a crear basado en el contador
            System.out.println(contador);
            if((contador % 7) == 0)
            {
                BufferedImage mamonImage    = ImageIO.read(new File("src/main/java/images/strawberry_view.png"));
                model.balls.add(new Mamon(xModel, yModel, 0, 0, 0.1, 1, false, false, false, mamonImage));
                siguiente.setValue("Mamon");
            }
            if((contador % 7) == 1)
            {
                BufferedImage datilImage = ImageIO.read(new File("src/main/java/images/cherry_view.png"));
                model.balls.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false, datilImage));
                siguiente.setValue("Datil");
            }
            if((contador % 7) == 2)
            {
               BufferedImage mameyImage    = ImageIO.read(new File("src/main/java/images/grape_view.png"));
                model.balls.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false, mameyImage));
                siguiente.setValue("Mamey");
            }
            if((contador % 7) == 3)
            {
                BufferedImage mameyImage    = ImageIO.read(new File("src/main/java/images/grape_view.png"));
                model.balls.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false, mameyImage));
                siguiente.setValue("Mamey");
            }
            if((contador % 7) == 4)
            {
                BufferedImage mameyImage    = ImageIO.read(new File("src/main/java/images/grape_view.png"));
                model.balls.add(new Mamey(xModel, yModel, 0, 0, 0.1, 1,false, false, false, mameyImage));
                siguiente.setValue("Mamey");
            }
            if((contador % 7) == 5)
            {
                BufferedImage datilImage = ImageIO.read(new File("src/main/java/images/cherry_view.png"));
                model.balls.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false, datilImage));
                siguiente.setValue("Datil");
            }
            if((contador % 7) == 6)
            {   
                BufferedImage datilImage = ImageIO.read(new File("src/main/java/images/cherry_view.png"));
                model.balls.add(new Datil(xModel, yModel, 0, 0, 0.1, 1,false, false, false, datilImage));
                siguiente.setValue("Datil");
            }
    }
}
