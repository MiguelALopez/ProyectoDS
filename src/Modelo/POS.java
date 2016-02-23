/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: POS.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Modelo;

/**
 * Clase que representa un Pos 
 */
public class POS 
{    
    private String id;
    private String nombre;
    private String direccion;
    
    /***
     * Constructores para crear un POS de datos nulos 
     */
    
    public POS()            
    {
        this.id = null;
        this.nombre = null;
        this.direccion = null;
    }   
     /**
     * Constructor para crear una sede dados los datos 
     * @param codigo : numero unico que identifica la POS
     * @param nombre : nombre del POS
     * @param direccion : direccion del POS
     */

    public POS(String codigo, String nombre, String direccion)
    {
        this.id = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }   
    
    /***
     * Metodos Get y Set encargador de la modificacion y consulta de los atributos 
     */
    
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
