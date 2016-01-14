/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: .java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Modelo;

/**
 *
 * @author Cristian Jurado
 */

public class Paquete {
    
    private int costo;
    private String seguro;
    private String impuesto;
    
    
    public Paquete() 
    {
        this.costo = 0;
        this.seguro = null;
        this.impuesto = null;        
    }
    
    public Paquete(int costo, String seguro, String impuesto) 
    {
        this.costo = costo;
        this.seguro = seguro;
        this.impuesto = impuesto;
    }
    
    
     /**
     * Getters and setters para los atributos de la clase
     *      * 
     */
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }
    
    
       
}
