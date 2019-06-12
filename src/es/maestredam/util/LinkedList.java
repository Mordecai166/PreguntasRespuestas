package es.maestredam.util;

/**
 * Clase que implementa una EDD tipo Lista Enlazada
 * 
 * @author franh
 * @version 1.00
 * @param <E>
 */
public class LinkedList<E>{
    
    /**
     * Clase anidada que permite crear nodos dónde almacenar objetos
     */
    //Clase anidada NODO
    public class Nodo{
        private E objeto;
        private Nodo sig;
        
        public Nodo(E info){
            this.objeto = info;
            this.sig = null;
        }
    }//Fin Clase NODO
    
    public Nodo primero;
    public int numNodos;
    
    public LinkedList(){
        primero = null;
        numNodos = 0;
    }
    
    public int size(){
        return numNodos;
    }
    
    /**
     * Método que comprueba si la lista está vacía
     * 
     * @return true si la lista está vacía, false si no está vacía
     */
    public boolean isEmpty(){
        return primero==null;
    }
    
    /**
     * Método que añade un nuevo objeto al final de la lista
     * 
     * @param element objeto a añadir
     * @throws NullPointerException
     */
    public void add(E element){
        // El elemento es nulo
        if (element == null){
            throw new NullPointerException();
        }
        //Creo un nuevo Nodo
        Nodo nuevo = new Nodo(element);
        
        //ENLACE
        //Si Lista vacía
        if (isEmpty()){
            primero = nuevo;
            numNodos++;
        }
        else{
            //Si no esta vacía busco el último nodo
            Nodo aux = primero;
            while (aux.sig != null){
                aux = aux.sig;
            }
            // aux contiene ref. al último nodo
            // enlazo el último nodo con el nuevo
            aux.sig = nuevo;
            numNodos++;
        }
    }
    
    /**
     * Método que añade un nuevo objeto en una posición de la lista concreta
     * 
     * @param index índice dónde almacenar el nuevo objeto
     * @param element objeto a almacenar en la lista
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException 
     */
    public void add(int index, E element)throws NullPointerException, IndexOutOfBoundsException{
        //El elemento es nulo
        if(element == null){
            throw new NullPointerException();
        }
        
        //El indice está fuera del rango alcanzable
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        
        Nodo toAdd = new Nodo(element);
        
        //Alcanza la posición indicada por el índice
        Nodo actual=primero;
        Nodo anterior=null;
        for(int i=0; i<index;i++){
            anterior = actual;
            actual = actual.sig;
        }
        
        //Caso 1: Es el primer nodo:       
        if(anterior == null){
            toAdd.sig = primero;
            primero = toAdd;
            numNodos++;
            return;
        }
        
        //Caso 2: Es el ultimo nodo:
        if(actual.sig == null){
            actual.sig = toAdd;
            return;
        }
        
        //Caso 3 (General): El nodo esta en el medio:
        anterior.sig = toAdd;
        toAdd.sig = actual;        
    }
    
    /**
     * Método que escribe en consola todos los objetos de la lista haciendo uso del toString()
     */
    public void print(){
        if (isEmpty()){
            System.out.println("La lista está vacía");
            System.out.println("Número de nodos: "+numNodos);
        }
        else{
            Nodo aux = primero;
            System.out.println(aux.objeto);
            while (aux.sig != null){
                aux=aux.sig;
                System.out.println(aux.objeto);
            }
            System.out.println("Número de nodos: "+numNodos);
        }
    }
    
    /**
     * Método que devuelve el objeto ubicado en el nodo indicado por el índice ((NO IMPLEMENTADA EXCEPCIÖN))
     * 
     * @param index índice dónde buscar
     * @return objeto ubicado en el índice
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        
        Nodo aux = null;
        
        if (index == 0){
            if (primero==null){
                System.out.println("La lista está vacía");
            }
            else{
                aux = primero;
            }
        }
        else{
            aux = primero;
            for (int i=1; i<=index; i++){
                aux=aux.sig;
            }
        }
        return aux.objeto;
    }
    
    /**
     * Método que elimina el objeto ubicado en el nodo indicado por el índice
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public E remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        
        Nodo actual = primero;
        Nodo anterior = null;
        
        //Encontrar el nodo actual y el nodo anterior;
        for(int i=0; i<index; i++){
            anterior = actual;
            actual = actual.sig;
        }
        E data = actual.objeto;
        
        //Reconectar la lista: casos:
        //Caso Especial: Es el primer nodo:
        if(actual.sig != null && anterior == null){
            primero = actual.sig;
            numNodos--;
            return data;
        }        
        //Caso General: Nodo en el medio:
        anterior.sig = actual.sig;
        numNodos--;
        return data;
    }
    
    /**
     * Método que limpia la lista
     */
    public void clear(){
        this.primero = null;
    }
    
    /**
     * Método que devuelve el índice del objeto pasado por parámetro
     * 
     * @param element objeto a buscar
     * @return posición del elemento, -1 si no se ha encontrado (la lista está vacía o no está en ella)
     */
    public int indexOf(E element){
        //Lista vacía
        if(isEmpty())
            return -1;
        
        //Buscamos el elemento en la lista
        Nodo aux = primero;
        int posicion = 0;
        while(aux.sig != null){
            if(aux.objeto.equals(element)){
                return posicion;
            }
            aux = aux.sig;
            posicion++;
        }
        //Comprobar si es el ultimo elemento
        if(aux.objeto.equals(element))
            return posicion;
        //Si no se ha encontrado
        return -1;
    }

    
}
