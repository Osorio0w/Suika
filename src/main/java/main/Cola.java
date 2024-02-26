package main;
import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private Queue<String> Cola; // Declara la cola como un miembro privado

    public Cola() {
        Cola = new LinkedList<>(); // Inicializa la cola en el constructor
    }

    // Método para agregar elementos a la cola
    public void aniadirFondo(String element) {
        Cola.add(element);
    }

    // Método para remover y devolver el primer elemento de la cola
    public String remover() {
        return Cola.remove();
    }

    // Método para obtener el primer elemento de la cola sin removerlo
    public String verTope() {
        return Cola.peek();
    }

    // Método para obtener el tamaño de la cola
    public int verTamanio() {
        return Cola.size();
    }

    // Método para verificar si la cola está vacía
    public boolean esVacia() {
        return Cola.isEmpty();
    }
    public String removerTope()
    {
        return Cola.poll();
    }
}
