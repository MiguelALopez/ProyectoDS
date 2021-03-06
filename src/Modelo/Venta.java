/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: Venta.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Modelo;

import java.util.ArrayList;

/**
 * clase que representa una venta
 */
public class Venta
{
    /**
    * Campos que representan una venta, también deben encontrarse en la base
    * de datos
    */
    private String id;
    private String cedula;
    private String nombre;
    private String direccion;
    private String fecha;
    private String metodo;
    private double seguro;
    private double subtotal;
    private double iva;
    private double total;
    private String pos;
    private ArrayList<Paquete> paquetes;
    
    /**
     * Constructor para crear un usuario dados los datos
     * @param id : identificador unico de la venta
     * @param cedula : cedula del cliente de la venta
     * @param nombre : nombre del cliente de la venta
     * @param direccion : direccion del cliente de la venta
     * @param fecha : fecha en que se realiza la venta
     * @param metodo : metodo de pago seleccionado por el cliente 
     * @param seguro : seguro de la venta
     * @param subtotal : subtotal de la venta
     * @param iva : valor del iva de la venta
     * @param total : precio total de la venta
     * @param pos : pos en que se realiza la venta
     * @param paquetes : listado de paquetes asociados a la venta
     */
    
    public Venta(String cedula, String nombre, String direccion, String fecha, String metodo, double seguro, double subtotal, double iva, double total, String pos, ArrayList<Paquete> paquetes) 
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha = fecha;
        this.metodo = metodo;
        this.seguro = seguro;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.pos = pos;
        this.paquetes = paquetes;
    } 

    public Venta(String id, String cedula, String nombre, String direccion, String fecha, String metodo, double seguro, double subtotal, double iva, double total, String pos, ArrayList<Paquete> paquetes) 
    {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha = fecha;
        this.metodo = metodo;
        this.seguro = seguro;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.pos = pos;
        this.paquetes = paquetes;
    }   

    /**
     * Getters and Setters de los atributos de la clase
     * 
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getSeguro() {
	return seguro;
    }

    public void setSeguro(double seguro) {
	this.seguro = seguro;
    }    

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
}
