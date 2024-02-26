package main;

import java.awt.image.BufferedImage;

// Clase declararAssets que extiende Object (el tutorial que vi lo hizo así y yo lo dejé igual)
public class declararAssets extends Object {
    
    // Variables estáticas para almacenar las imágenes de los assets
    public static BufferedImage fondo;
    
    public static BufferedImage datilImage;
    public static BufferedImage mamonImage;
    public static BufferedImage mameyImage;
    public static BufferedImage cerezaImage;
    public static BufferedImage pumalacaImage;
    public static BufferedImage kiwiImage;
    public static BufferedImage parchitaImage;
    public static BufferedImage mangoImage;
    public static BufferedImage cocoImage;
    public static BufferedImage patillaImage;
    
    // Método para inicializar los assets
    public static void init() {
        // Cargar las imágenes desde archivos 
        fondo = CargadorImagenes.cargarImagen("src/main/java/images/cosechaFrutas.jpg");
        
           datilImage = CargadorImagenes.cargarImagen("src/main/java/images/cherry_view.png");
           mamonImage = CargadorImagenes.cargarImagen("src/main/java/images/strawberry_view.png");
           mameyImage = CargadorImagenes.cargarImagen("src/main/java/images/grape_view.png");
          cerezaImage = CargadorImagenes.cargarImagen("src/main/java/images/lemon_view.png");
        pumalacaImage = CargadorImagenes.cargarImagen("src/main/java/images/orange_view.png");
            kiwiImage = CargadorImagenes.cargarImagen("src/main/java/images/apple_view.png");
        parchitaImage = CargadorImagenes.cargarImagen("src/main/java/images/pear_view.png");
           mangoImage = CargadorImagenes.cargarImagen("src/main/java/images/peach_view.png");
            cocoImage = CargadorImagenes.cargarImagen("src/main/java/images/pineapple_view.png");
         patillaImage = CargadorImagenes.cargarImagen("src/main/java/images/watermelon_view.png");
    }
}
