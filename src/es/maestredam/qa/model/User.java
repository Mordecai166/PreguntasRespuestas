package es.maestredam.qa.model;

import java.util.Objects;

/**
 * Clase que implementa objetos Usuario
 *
 * @author franh
 * @version 1.00
 */
public class User {
    
    private String nombre;
    private String password;
    private String nombreCompleto;
    private int puntuacionTotal;
    private int ultimaPuntuacion;
    private int numJugadas;
    private boolean admin;
    
    /**
     * Constructor de objetos Usuario
     * 
     * @param id id del objeto Usuario
     */
    public User(String nombre){
        this (nombre, "password");
    }
    
    /**
     * Constructor de objetos Usuario
     * 
     * @param id identificador del objeto Usuario
     * @param password contraseña del objeto Usuario
     */
    public User(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
    
    /**
     * Constructor de objetos Usuario
     * 
     * @param nombre identificador del objeto Usuario
     * @param nombreCompleto nombre completo del objeto Usuario
     * @param password contraseña del objeto Usuario
     * @param admin boolean que indica si el objeto Usuario es administrador o no
     */
    public User(String nombre, String nombreCompleto, String password, boolean admin){
        this.nombre = nombre;
        this.nombreCompleto = nombreCompleto;
        this.password = password;
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public int getUltimaPuntuacion() {
        return ultimaPuntuacion;
    }

    public int getNumJugadas() {
        return numJugadas;
    }
    
    public boolean isAdmin(){
        return admin;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public void setUltimaPuntuacion(int ultimaPuntuacion) {
        this.ultimaPuntuacion = ultimaPuntuacion;
    }

    public void setNumJugadas(int numJugadas) {
        this.numJugadas = numJugadas;
    }
    
    /**
     * Método que comprueba si dos objetos Usuario son iguales 
     * 
     * @param obj objeto a comparar
     * @return true si son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    /**
     * Método que convierte a String la información de un objeto Usuario
     * 
     * @return la cadena con la información del objeto Usuario
     */
    @Override
    public String toString() {
        return "User{" + "nombre=" + nombre + ", password=" + password + "puntuación total=" + puntuacionTotal + ", última puntuación=" + ultimaPuntuacion +"}";
    }
    
}