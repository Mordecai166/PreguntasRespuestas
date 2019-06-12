package es.maestredam.qa.persistence;

import es.maestredam.qa.model.Pregunta;
import es.maestredam.util.LinkedList;
import es.maestredam.util.LinkedList.Nodo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Clase para guardar objetos User en un fichero
 *
 * @author franh
 * @version 1.0
 */
public class PreguntaWriter {
    
    // Ruta/nombre de fichero donde escribir
    private String filename;
    
    // Constructor
    public PreguntaWriter(String filename){
        this.filename = filename;
    }
    
    /**
     * Escribe en el fichero el objeto pasado por parámetro
     * 
     * @param preg un objeto Pregunta
     * @param append boolean que indica si sobreescribir o no (true=si || false=no)
     */
    public void escribir(Pregunta preg, boolean append){
        LinkedList<Pregunta> usu = new LinkedList<>();
        usu.add(preg);
        escribir(usu, append);
    }
    
    /**
     * Escribe en el fichero cada objeto Pregunta de la lista pasada por parámetro
     * 
     * @param pregList lista de objetos Pregunta
     * @param append boolean que indica si sobreescribir o no (true=si || false=no)
     */
    public void escribir(LinkedList<Pregunta> pregList, boolean append){
        File fichero = new File(filename);
        if (!fichero.exists()){
            try {
                fichero.createNewFile();
            }catch (IOException ioe){
                System.out.println("No se ha creado el archivo");
            }
            append = false;
        }
        if (!append){ // Escribir la lista borrando lo que hubiera anteriormente
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
                Nodo aux = pregList.primero;
                for (int i=0; i<pregList.size(); i++){
                    oos.writeObject(aux);
                    aux = aux.sig;
                }
            }catch (FileNotFoundException fnf){
                System.out.println("Fichero no encontrado");
            }catch (IOException ioe){
                System.out.printf("ERROR E/S: %s%n", ioe);
            }
        }
        else{ // Escribir la lista manteniendo lo que hubiera anteriormente
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))){
                Nodo aux = pregList.primero;
                for (int i=0; i<pregList.size(); i++){
                    oos.writeObject(aux);
                    aux = aux.sig;
                }
            }catch (FileNotFoundException fnf){
                System.out.println("Fichero no encontrado");
            }catch (IOException ioe){
                System.out.printf("ERROR E/S: %s%n", ioe);
            }
        }
    }
    
}
