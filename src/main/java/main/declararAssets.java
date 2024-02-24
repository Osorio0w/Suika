package main;

import java.awt.image.BufferedImage;

// Clase declararAssets que extiende Object (el tutorial que vi lo hizo así y yo lo dejé igual)
public class declararAssets extends Object {
    
    // Variables estáticas para almacenar las imágenes de los assets
    public static BufferedImage apple;
    public static BufferedImage background;
    public static BufferedImage watermelon;
    public static BufferedImage cherry;
    
    // Método para inicializar los assets
    public static void init() {
        // Cargar las imágenes desde archivos
        background = CargadorImagenes.cargarImagen("src/main/java/images/cosechaFrutas.jpg");
        apple      = CargadorImagenes.cargarImagen("src/main/java/images/apple_view.png");
        watermelon = CargadorImagenes.cargarImagen("src/main/java/images/watermelon_view.png");
        cherry     = CargadorImagenes.cargarImagen("src/main/java/images/cherry_view.png");
    }
}
