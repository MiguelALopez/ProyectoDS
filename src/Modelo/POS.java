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

import java.util.ArrayList;

/**
 *
 * @author Cristian Jurado
 */

public class POS {
    
    private String codigo;
    private String direccion;
    private ArrayList<Envio> envios;
    
    public POS()            
    {
        this.codigo = null;
        this.direccion = null;  
        this.envios = null;
    }   
    
     public POS(String codigo, String direccion, ArrayList<Envio> envios)            
    {
        this.codigo = codigo;
        this.direccion = direccion;  
        this.envios = envios;
    }   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(ArrayList<Envio> envios) {
        this.envios = envios;
    }
     
     /**
     * Getters and setters para los atributos de la clase
     *      * 
     */
     
     
}
