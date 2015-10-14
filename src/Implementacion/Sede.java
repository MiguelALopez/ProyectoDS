/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

/**
 *
 * @author AndrésFelipe
 */
public class Sede {    
    private String numero;
    private String nombre;
    private String direccion;
    private String presupuesto;
    private String camiones;

    public Sede() {
        this.numero = null;
        this.nombre = null;
        this.direccion = null;
        this.presupuesto = null;
        this.camiones = null;
    }
    
    

    public Sede(String numero, String nombre, String direccion, String presupuesto, String camiones) {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
        this.presupuesto = presupuesto;
        this.camiones = camiones;
    }

    
    
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
 