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
 * @author AndresFelipe
 * 
 * La clase sede se crea con el fin de utilizan el patron de diseño DAO
 */
public class Sede 
{    
    /**
     * Campos que representan una sede, también deben encontrarse en la base
     * de datos
     */
    private String numero;
    private String nombre;
    private String gerente;    
    private String presupuesto;
    private int camiones;
    private String direccion;

    /**
     * Constructor para crear una sede con datos nulos
     */
    public Sede() 
    {
        this.numero = null;
        this.nombre = null;
        this.gerente = null;        
        this.presupuesto = null;
        this.camiones = 0;
        this.direccion = null;
    }

    public Sede(String numero, String nombre, String direccion) {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Constructor para crear una sede dados los datos 
     * @param numero : numero unico que identifica la sede
     * @param nombre : nombre de la sede
     * @param direccion : direccion de la sede
     * @param presupuesto : presupuesto asignado a la sede
     * @param camiones : camiones asignados a la sede
     * @param gerente
     */

    public Sede(String numero, String nombre, String gerente, String presupuesto, int camiones, String direccion)
    {
        this.numero = numero;
        this.nombre = nombre;
        this.gerente = gerente;        
        this.presupuesto = presupuesto;
        this.camiones = camiones;
        this.direccion = direccion;
    }

    /**
     * Getters and setters para los atributos de la clase
     *      * 
     */
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getCamiones() {
        return camiones;
    }

    public void setCamiones(int camiones) {
        this.camiones = camiones;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }    
}
 