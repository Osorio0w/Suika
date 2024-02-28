package main;

import java.io.IOException;
import java.util.*;

public class Colisiones 
{
    Animacion animator; // Referencia al objeto Animacion
    double anchoDelArea, alturaDelArea; // Dimensiones del área de juego
    Vector2D gravedad = new Vector2D(0,-10); // Gravedad aplicada a las bolas
    private int contadorPuntaje;
    
    public int obtenerPuntaje()
    {
        return contadorPuntaje;
    }
    
    
    ArrayList<Bola> Bolas = new ArrayList<Bola>(); // Lista de bolas en el área de juego
        /**
        * Constructor de la clase Lista.
        * @param ancho Ancho del área de juego.
        * @param alto Alto del área de juego.
        * @param anim Referencia al objeto Animacion.
        **/
    Colisiones(double ancho, double alto, Animacion anim) 
    {
        anchoDelArea = ancho;
        alturaDelArea = alto;
        animator = anim;
    }
    void step(double deltaT) throws IOException 
    {
        int subSteps = 32;
        double subDeltaT = deltaT / subSteps;
        for (int i = subSteps; i > 0; --i){
            aplicarGravedad();
            aplicarRestriccion();
            detectarColisiones();
            actualizarPosicion(subDeltaT);
        }
    }
    /**
     * Método que realiza un paso de la simulación del juego.
     * @param deltaT Intervalo de tiempo.
     * @throws IOException Excepción de E/S.
     */
    private void detectarColisiones() throws IOException 
    {
        int numeroDeObjetos = Bolas.size();
        if (numeroDeObjetos > 1) 
        {
            for (int i = 0; i < numeroDeObjetos; ++i) 
            {
                for (int j = 0; j < numeroDeObjetos; j++) 
                {
                    if(i != j) {
                        if( !(Bolas.get(i).fuera_del_juego && Bolas.get(j).fuera_del_juego) ) 
                        {
                              // Detectar colisión entre las bolas i y j
                             // Resolver colisión según las características de las bolas
                            double colisionEjeX = Bolas.get(i).posicionActual.getX() - Bolas.get(j).posicionActual.getX();
                            double colisionEjeY = Bolas.get(i).posicionActual.getY() - Bolas.get(j).posicionActual.getY();
                            Vector2D vectorColision = new Vector2D(colisionEjeX, colisionEjeY);
                            double dist = Math.sqrt( Math.pow(colisionEjeX, 2) + Math.pow(colisionEjeY, 2)); //Calcula distancia euclidiana (la distancia entre dos puntos, pero decir euclidiana suena pro)
                            double minDist = Bolas.get(i).radio + Bolas.get(j).radio;
                            //Se detecta una colisión cuando la distancia que separa a las bolas es menor que la suma de sus radios (distancia mínima)
                            if (dist < minDist) 
                            {
                                if (Bolas.get(i).radio == Bolas.get(j).radio) 
                                {
                                    fusionar(Bolas.get(i), Bolas.get(j));
                                } else 
                                {
                                    Vector2D n = vectorColision.dividir(dist); //Vector unitario
                                    double superposicion = minDist - dist;
                                    if(superposicion < 0.001) //De no existir superposición...
                                    {
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 1) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa)  
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.45 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.55 * superposicion));
                                                //Utilizamos el vector unitario para representar la dirección de la colisión
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.55 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.45 * superposicion));
                                            }
                                        }
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 2) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa) 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.35 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.65 * superposicion));
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.65 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.35 * superposicion));
                                            }
                                        }
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 3) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa) 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.20 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.80 * superposicion));
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.80 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.20 * superposicion));
                                            }

                                        }
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 4) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa) 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.10 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.90 * superposicion));
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.90 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.10 * superposicion));
                                            }

                                        }
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 5) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa) 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.05 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.95 * superposicion));
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.95 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.05 * superposicion));
                                            }

                                        }
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 6) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa) 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(1 * superposicion));
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(1 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0 * superposicion));
                                            }
                                        }
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 7) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa) 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(1 * superposicion));
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(1 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0 * superposicion));
                                            }
                                        }
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 8) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa) 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(1 * superposicion));
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(1 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0 * superposicion));
                                            }
                                        }
                                        if (Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 9) 
                                        {
                                            if (Bolas.get(i).masa > Bolas.get(j).masa) 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(1 * superposicion));
                                            } else 
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(1 * superposicion));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0 * superposicion));
                                            }
                                        }
                                    }
                                    
                                    else{ // De existir superposición...
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 1) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.45 * superposicion * 0.01));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.55 * superposicion * 0.01));
                                                Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                                Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.45 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.55 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;

                                        }
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 2) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.35 * superposicion * 0.01));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.65 * superposicion * 0.01));
                                                Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                                Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.65 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.35 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                        }
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 3) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.80 * superposicion * 0.01));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.20 * superposicion * 0.01));
                                                Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                                Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.80 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.20 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                        }
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 4) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.10 * superposicion * 0.01));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.9 * superposicion * 0.01));
                                                Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                                Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.9 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.1 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                        }
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 5) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.05 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.95 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0.95 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0.05 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                        }
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 6) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0 * superposicion * 0.01));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(1 * superposicion * 0.01));
                                                Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                                Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(1 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                        }
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 7) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0 * superposicion * 0.01));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(1 * superposicion * 0.01));
                                                Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                                Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(1 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                        }
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 8) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0 * superposicion * 0.01));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(1 * superposicion * 0.01));
                                                Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                                Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(1 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                        }
                                        if(Math.abs(Bolas.get(i).masa - Bolas.get(j).masa) == 9) 
                                        {
                                            if(Bolas.get(i).masa > Bolas.get(j).masa)
                                            {
                                                Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(0 * superposicion * 0.01));
                                                Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(1 * superposicion * 0.01));
                                                Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                                Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                            }
                                            Bolas.get(i).posicionActual = Bolas.get(i).posicionActual.sumar(n.multiplicar(1 * superposicion * 0.01));
                                            Bolas.get(j).posicionActual = Bolas.get(j).posicionActual.restar(n.multiplicar(0 * superposicion * 0.01));
                                            Bolas.get(i).posicionAntigua = Bolas.get(i).posicionActual;
                                            Bolas.get(j).posicionAntigua = Bolas.get(j).posicionActual;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
        /**
        * Método para fusionar dos bolas después de una colisión.
        * @param bola1 Primera bola.
        * @param bola2 Segunda bola.
        * @throws IOException Excepción de E/S.
        **/
     // Lógica para fusionar dos bolas después de una colisión
    private void fusionar(Bola bola1, Bola bola2) throws IOException 
    {

        Vector2D posicionColision = new Vector2D(bola1.posicionActual.getX() - bola2.posicionActual.getX(), bola1.posicionActual.getY() - bola2.posicionActual.getY());
        double distanciaColision = Math.sqrt(Math.pow(bola1.posicionActual.getX() - bola2.posicionActual.getX(), 2) + Math.pow(bola1.posicionActual.getY() - bola2.posicionActual.getY(), 2));
        //Normalizar collisionLine
        Vector2D n = posicionColision.dividir(distanciaColision);
        Vector2D puntoDeColision = n.multiplicar(bola1.radio);
        Vector2D corregirPuntoDeColision = puntoDeColision.sumar(bola2.posicionActual);

 
        if (bola1 instanceof Datil)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearMamon(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 20;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else 
            {
                animator.ballFactory.crearMamon(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 20;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }

        if (bola1 instanceof Mamon)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearMamey(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 40;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else {
                animator.ballFactory.crearMamey(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 40;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }

        if (bola1 instanceof Mamey)
        {
            if(corregirPuntoDeColision.getX() > 4.8){
                animator.ballFactory.crearCereza(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 60;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else {
                animator.ballFactory.crearCereza(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 60;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }

        if (bola1 instanceof Cereza)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearPumalaca(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 80;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else 
            {
                animator.ballFactory.crearPumalaca(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 80;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }

        if (bola1 instanceof Pumalaca)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearKiwi(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 100;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else {
                animator.ballFactory.crearKiwi(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 100;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }

        if (bola1 instanceof Kiwi)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearParchita(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 120;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else {
                animator.ballFactory.crearParchita(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 120;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }
        if (bola1 instanceof Parchita)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearMango(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 140;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else {
                animator.ballFactory.crearMango(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 140;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }
        if (bola1 instanceof Mango)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearCoco(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 160;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else {
                animator.ballFactory.crearCoco(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 160;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }
        if (bola1 instanceof Coco)
        {
            if(corregirPuntoDeColision.getX() > 4.8)
            {
                animator.ballFactory.crearPatilla(corregirPuntoDeColision.getX() - bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 180;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
            else {
                animator.ballFactory.crearPatilla(corregirPuntoDeColision.getX() + bola2.radio * 0.5, corregirPuntoDeColision.getY() + bola2.radio * 0.5);
                contadorPuntaje += 180;
                System.out.println(contadorPuntaje + "<--- Puntaje");
            }
        }

        bola1.setFuera_del_juego(true);
        bola2.setFuera_del_juego(true);
        bola1.posicionActual.set(99999.9,99999.9);
        bola1.posicionAntigua.set(99999.9,99999.9);
        bola2.posicionActual.set(99999.9,99999.9);
        bola2.posicionAntigua.set(99999.9,99999.9);
    }
    // Aplicar restricciones de movimiento a las bolas dentro del área de juego
    private void aplicarRestriccion() 
    {
        double maxX = 1320.0/200;
        double minX = 600.0/200;
        double minY = 30.0/200;
        for (Bola b : Bolas)
        {
            double toMinYY = b.posicionActual.getY() - minY;
            double toMinYX = 0;
            Vector2D toMinY = new Vector2D(toMinYX,toMinYY);
            double distMinY = Math.sqrt(Math.pow(toMinYX, 2) + Math.pow(toMinYY, 2));

            double toMinXY = 0;
            double toMinXX = b.posicionActual.getX() - minX;
            Vector2D toMinX = new Vector2D(toMinXX,toMinXY);
            double distMinX = Math.sqrt(Math.pow(toMinXX, 2) + Math.pow(toMinXY, 2));

            double toMaxXY = 0;
            double toMaxXX = maxX - b.posicionActual.getX();
            Vector2D toMaxX = new Vector2D(toMaxXX,toMaxXY);
            double distMaxX = Math.sqrt(Math.pow(toMaxXX, 2) + Math.pow(toMaxXY, 2));

            if (b.posicionActual.getX() < minX + b.radio)
            {
                Vector2D n = toMinX.dividir(distMinX);
                double correctionScalar = b.radio - distMinX;
                Vector2D correctionshit = n.multiplicar(correctionScalar);
                b.posicionActual = b.posicionActual.sumar(correctionshit);
            }
            if (b.posicionActual.getX() > maxX - b.radio)
            {
                Vector2D n = toMaxX.dividir(distMaxX);
                double correctionScalar = -b.radio + distMaxX;
                Vector2D correctionshit = n.multiplicar(correctionScalar);
                b.posicionActual = b.posicionActual.sumar(correctionshit);
            }
            if (b.posicionActual.getY() < minY + b.radio)
            { // Las coordenadas Y están invertidas
                Vector2D n = toMinY.dividir(distMinY);
                double correctionScalar = b.radio - distMinY;
                Vector2D correction = n.multiplicar(correctionScalar);
                
               //if(correctionScalar > 0.0000000002){
               //    b.posicionActual = b.posicionActual.sumar(correction);
               //   b.posicionAntigua = b.posicionActual;
               // }
                
                b.posicionActual = b.posicionActual.sumar(correction);
            }
        }
    }
       /**
         * Método para actualizar la posición de las bolas en función del tiempo.
         * @param deltaT Intervalo de tiempo.
         **/
    private void actualizarPosicion(double deltaT) 
    {
        for (Bola b : Bolas)
        {
            b.actualizarPosicion(deltaT);
        }
    }
    /**
     * Método para aplicar la gravedad a las bolas.
     */
    private void aplicarGravedad() 
    {
        for (Bola b : Bolas)
        {
            //if(!b.outOfConstraint)
            
            b.acelerar(gravedad);
        }
    }
}