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
 * clase que representa un pqr
 */
public class PQR 
{
    private String numero;
    private String fecha;
    private String tipo;
    private String contenido;
    private String estado;
    private String cedula;
    private String nombre;
    private String sede;

    public PQR(String fecha, String tipo, String contenido, String estado, String cedula, String nombre, String sede) {
	this.fecha = fecha;
	this.tipo = tipo;
	this.contenido = contenido;
	this.estado = estado;
	this.cedula = cedula;
	this.nombre = nombre;
	this.sede = sede;
    }

    public PQR(String numero, String fecha, String tipo, String contenido, String estado, String cedula, String nombre, String sede) {
	this.numero = numero;
	this.fecha = fecha;
	this.tipo = tipo;
	this.contenido = contenido;
	this.estado = estado;
	this.cedula = cedula;
	this.nombre = nombre;
	this.sede = sede;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public String getFecha() {
	return fecha;
    }

    public void setFecha(String fecha) {
	this.fecha = fecha;
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

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
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
}