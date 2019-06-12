package es.maestredam.qa.model;

import es.maestredam.qa.persistence.PreguntaReader;
import es.maestredam.qa.persistence.PreguntaWriter;
import es.maestredam.qa.persistence.UserReader;
import es.maestredam.qa.persistence.UserWriter;
import es.maestredam.util.LinkedList;

/**
 * Clase que implementa el Gestor de Información para leer y escribir objetos Usuario y Pregunta
 * 
 * @author franh
 * @version 1.00
 */
public class GestorInfo {
    public static final String FICHERO_USUARIOS = "usuarios.dam";
    public static final String FICHERO_PREGUNTAS = "preguntas.dam";
    
    public GestorInfo(String ruta){
        UserWriter escritorUser = new UserWriter(ruta);
        UserReader lectorUser = new UserReader(ruta);
        PreguntaWriter escritorPreg = new PreguntaWriter(ruta);
        PreguntaReader lectorPreg = new PreguntaReader(ruta);
    }
    
    /**
     * Metodo para guardar un objeto Usuario en el fichero
     * 
     * @param usuario objeto Usuario a guardar
     * @param append boolean que indica si sobreescribir o no (true=si || false=no)
     */
    public static void guardarUsuario(User usuario, boolean append){
        UserWriter escritor = new UserWriter(FICHERO_USUARIOS);
        escritor.escribir(usuario, append);
    }
    
    /**
     * Metodo para guardar una lista de objetos Usuario en el fichero
     * 
     * @param usuarios LinkedList de objetos Usuario a guardar
     */
    public static void guardarListaUsuarios(LinkedList<User> usuarios, boolean append){
        UserWriter escritor = new UserWriter(FICHERO_USUARIOS);
        escritor.escribir(usuarios, append);
    }
    
    /**
     * Metodo para guardar un objeto Pregunta en el fichero
     * 
     * @param pregunta objeto Pregunta a guardar
     */
    public static void guardarPregunta(Pregunta pregunta, boolean append){
        PreguntaWriter escritor = new PreguntaWriter(FICHERO_PREGUNTAS);
        escritor.escribir(pregunta, append);
    }
    
    /**
     * Método para guardar una lista de objetos Pregunta en el fichero
     * 
     * @param preguntas LinkedList de objetos Pregunta a guardar
     */
    public static void guardarListaPreguntas(LinkedList<Pregunta> preguntas, boolean append){
        PreguntaWriter escritor = new PreguntaWriter(FICHERO_PREGUNTAS);
        escritor.escribir(preguntas, append);
    }
    
    /**
     * Método para recuperar todos los usuarios del fichero
     * 
     * @return LinkedList de objetos Usuario a recuperar
     */    
    public static LinkedList<User> leerUsuarios(){
        UserReader lector = new UserReader(FICHERO_USUARIOS);
        LinkedList usuarios = lector.leer();
        return usuarios;
    }
    
    /**
     * Método para recuperar todos los objetos Pregunta del fichero
     * 
     * @return LinkedList de objetos Pregunta a recuperar
     */
    public static LinkedList<Pregunta> leerPreguntas(){
        PreguntaReader lector = new PreguntaReader(FICHERO_PREGUNTAS);
        LinkedList preguntas = lector.leer();
        return preguntas;
    }
    
}
