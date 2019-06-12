package es.maestredam.qa.persistence;

import es.maestredam.qa.model.User;
import es.maestredam.util.LinkedList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;

/**
 * Clase para crear objetos lectores de objetos usuario
 * 
 * @author franh
 */
public class UserReader {
    
    private String filename;
    
    public UserReader(String filename){
        this.filename = filename;
    }
    
    /**
     * Lee los objetos Usuario de un fichero
     * 
     * @return LinkedList de objetos Usuario
     */
    public LinkedList<User> leer(){
        User objLeido = null;
        LinkedList<User> usuarios = new LinkedList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            while (true){
                objLeido = (User)ois.readObject();
                usuarios.add(objLeido);
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
            return usuarios;
        }
    }
    
}
