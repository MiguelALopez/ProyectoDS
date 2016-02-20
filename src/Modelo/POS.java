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
 * clase que representa un pos
 */
public class POS 
{    
    private String id;
    private String nombre;
    private String direccion;
    
    public POS()            
    {
        this.id = null;
        this.nombre = null;
        this.direccion = null;
    }   
    
    public POS(String codigo, String nombre, String direccion)
    {
        this.id = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }  
}
