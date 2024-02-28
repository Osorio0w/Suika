package main;

import java.awt.image.BufferedImage;

// Clase declararAssets que extiende Object (el tutorial que vi lo hizo así y yo lo dejé igual)
public class declararAssets extends Object {
    
    // Variables estáticas para almacenar las imágenes de los assets
    public static BufferedImage apple;
    public static BufferedImage fondo;
    
    
    public static BufferedImage datil;
    public static BufferedImage mamon;
    public static BufferedImage mamey;
    public static BufferedImage cereza;
    public static BufferedImage pumalaca;
    public static BufferedImage kiwi;
    public static BufferedImage parchita;
    public static BufferedImage mango;
    public static BufferedImage coco;
    public static BufferedImage patilla;
    
    // Método para inicializar los assets
    public static void init() {
        // Cargar las imágenes desde archivos
        fondo      = CargadorImagenes.cargarImagen("src/main/java/images/fondofeo.jpg");
        
        datil     = CargadorImagenes.cargarImagen("src/main/java/images/m_cherry_view.png");
        mamon     = CargadorImagenes.cargarImagen("src/main/java/images/m_strawberry_view.png");
        mamey     = CargadorImagenes.cargarImagen("src/main/java/images/m_grape_view.png");
        cereza    = CargadorImagenes.cargarImagen("src/main/java/images/m_lemon_view.png");
        pumalaca  = CargadorImagenes.cargarImagen("src/main/java/images/m_orange_view.png");
        kiwi      = CargadorImagenes.cargarImagen("src/main/java/images/m_apple_view.png");
        parchita  = CargadorImagenes.cargarImagen("src/main/java/images/m_peach_view.png");
        mango     = CargadorImagenes.cargarImagen("src/main/java/images/m_pineapple_view.png");
        coco      = CargadorImagenes.cargarImagen("src/main/java/images/m_melon_view.png");
        patilla   = CargadorImagenes.cargarImagen("src/main/java/images/m_watermelon_view.png");
    }
}
