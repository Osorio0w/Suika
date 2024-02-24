/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Clase para cargar imágenes desde archivos.
 */
public class CargadorImagenes {

     /**
     * Método para cargar una imagen desde un archivo.
     * 
     * @param path La ruta del archivo de la imagen.
     * @return La imagen cargada como un objeto BufferedImage.
     */
    public static BufferedImage cargarImagen(String path)
    {
        try 
        {
            // Se intenta leer la imagen desde el archivo en la ruta especificada
            File cherry = new File(path);
            return ImageIO.read(cherry);
           // caso de error al cargar la imagen, se captura la excepción
        } catch (IOException e)
        {
        }
        return null; // Si ocurre un error, se devuelve null

    }

}
