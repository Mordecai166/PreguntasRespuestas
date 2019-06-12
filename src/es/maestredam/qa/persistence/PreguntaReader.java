package es.maestredam.qa.persistence;

import es.maestredam.qa.model.Pregunta;
import es.maestredam.util.LinkedList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;

/**
 * Clase para crear objetos lectores de objetos Pregunta
 * 
 * @author franh
 */
public class PreguntaReader {
    
    private String filename;
    
    public PreguntaReader(String filename){
        this.filename = filename;
    }
    
    /**
     * Lee los objetos Pregunta de un fichero
     * 
     * @return LinkedList de objetos Pregunta
     */
    public LinkedList<Pregunta> leer(){
        Pregunta objLeido = null;
        LinkedList<Pregunta> preguntas = new LinkedList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            while (true){
                objLeido = (Pregunta)ois.readObject();
                preguntas.add(objLeido);
            }
                
        }catch (ClassNotFoundException cnfe){
            System.out.printf("ERROR en casting: %s%n", cnfe);    
        }catch (FileNotFoundException fnfe){
            System.out.printf("ERROR: el fichero no existe: %s%n", fnfe);
        }catch (EOFException eof){
            System.out.printf("ERROR: fichero vacío: %s%n", eof);
        }catch (IOException ioe){
            System.out.printf("ERROR E/S: %s%n", ioe);
        }finally{
            return preguntas;
        }
    }
    
}
