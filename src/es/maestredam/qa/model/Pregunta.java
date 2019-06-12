package es.maestredam.qa.model;

import java.util.Date;

/**
 * Clase que implementa objetos Pregunta
 * 
 * @author franh
 * @version 1.00
 */
public abstract class Pregunta {
    
    // Constantes para las valoraciones mínima y máxima por pregunta
    public static final int VALMAX=5;
    public static final int VALMIN=0;
    
    private String categoria;
    private String enunciado;
    private String respuestaValida;
    private String respuestaA;
    private String respuestaB;
    private String respuestaC;
    private int valoracion;
    private int cuentaExt;
    
    /**
     * Constructor de objetos Pregunta
     * 
     * @param enunciado enunciado del objeto Pregunta
     */
    public Pregunta(String enunciado){
        this.enunciado=enunciado;
    }
    
    /**
     * Constructor de objetos Pregunta
     * 
     * @param enunciado enunciado del objeto Pregunta
     * @param categoria categoría del objeto Pregunta
     */
    public Pregunta(String enunciado, String categoria){
        this.enunciado=enunciado;
        this.categoria=categoria;
    }
    
    /**
     * Constructor de objetos Pregunta de tipo corta
     * 
     * @param enunciado enunciado del objeto Pregunta
     * @param categoria categoría del objeto Pregunta
     * @param respuestaA respuesta del objeto Pregunta
     */
    public Pregunta (String enunciado, String categoria, String respuestaA){
        this.enunciado = enunciado;
        this.categoria = categoria;
        this.respuestaA = respuestaA;
    }
    
    /**
     * Constructor de objetos Pregunta de tipo test
     * 
     * 
     * @param enunciado enunciado del objeto Pregunta
     * @param categoria categoría del objeto pregunta
     * @param respuestaValida respuesta válida del objeto Pregunta
     * @param respuestaA primera respuesta del objeto Pregunta
     * @param respuestaB segunda respuesta del objeto Pregunta
     * @param respuestaC tercera respuesta del objeto Pregunta
     */
    public Pregunta(String categoria, String enunciado, String respuestaValida, String respuestaA, String respuestaB, String respuestaC){
        this.categoria = categoria;
        this.enunciado = enunciado;
        this.respuestaValida = respuestaValida;
        this.respuestaA = respuestaA;
        this.respuestaB = respuestaB;
        this.respuestaC = respuestaC;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEnunciado() {
        return enunciado;
    }
    
    public String getRespuestaValida(){
        return respuestaValida;
    }

    public String getRespuestaA() {
        return respuestaA;
    }

    public String getRespuestaB() {
        return respuestaB;
    }

    public String getRespuestaC() {
        return respuestaC;
    }

    public int getValoracion() {
        return valoracion;
    }

    public static int getVALMAX() {
        return VALMAX;
    }

    public static int getVALMIN() {
        return VALMIN;
    }

    public int getCuentaExt() {
        return cuentaExt;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setRespuestaValida(String respuestaValida) {
        this.respuestaValida = respuestaValida;
    }

    public void setRespuestaA(String respuestaA) {
        this.respuestaA = respuestaA;
    }

    public void setRespuestaB(String respuestaB) {
        this.respuestaB = respuestaB;
    }

    public void setRespuestaC(String respuestaC) {
        this.respuestaC = respuestaC;
    }
    
    public boolean corregirTest(String respuesta, Pregunta pregunta){
        boolean correcta;
        if (respuesta.equals(pregunta.getRespuestaValida())){
            correcta = true;
            System.out.println("Respuesta correcta");
        }
        else{
            correcta = false;
            System.out.println("Respuesta incorrecta");
        }
        return correcta;
    }
    
    public boolean corregirCorta(String respuesta, Pregunta pregunta){
        boolean correcta;
        if (respuesta.equalsIgnoreCase(pregunta.getRespuestaA())){
            correcta = true;
            System.out.println("Respuesta correcta");
        }
        else{
            correcta = false;
            System.out.println("Respuesta incorrecta");
        }
        return correcta;
    }
    
    /**
     * Método que convierte a String la información de un objeto Pregunta
     * 
     * @return cadena con la información del objeto Pregunta
     */
    @Override
    public String toString(){
        return "Pregunta{" + "Enunciado=" + enunciado + ", Valoración=" + VALMAX;
    }
    
    abstract public void mostrarEnConsola();
}
