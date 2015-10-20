/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author AndrésFelipe
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
    private String direccion;
    private String presupuesto;
    private String camiones;

    /**
     * Constructor para crear una sede con datos nulos
     */
    public Sede() 
    {
        this.numero = null;
        this.nombre = null;
        this.direccion = null;
        this.presupuesto = null;
        this.camiones = null;
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
     */

    public Sede(String numero, String nombre, String direccion, String presupuesto, String camiones) 
    {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
        this.presupuesto = presupuesto;
        this.camiones = camiones;
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

    public String getCamiones() {
        return camiones;
    }

    public void setCamiones(String camiones) {
        this.camiones = camiones;
    }
}
 