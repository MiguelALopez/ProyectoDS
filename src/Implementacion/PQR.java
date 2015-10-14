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
public class PQR {
    private String numero;
    private String cedula;
    private String nombre;
    private String sede;
    private String tipo;
    private String contenido;

    public PQR(String numero, String cedula, String nombre, String sede, String tipo, String contenido) {
        this.numero = numero;
        this.cedula = cedula;
        this.nombre = nombre;
        this.sede = sede;
        this.tipo = tipo;
        this.contenido = contenido;
    }
    
    public PQR() {
        this.numero = null;
        this.cedula = null;
        this.nombre = null;
        this.sede = null;
        this.tipo = null;
        this.contenido = null;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
