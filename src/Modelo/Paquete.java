/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: Paquete.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Modelo;

/**
 * clase que representa un Paquete
 */
public class Paquete
{
    private String venta;
    private int numero;
    private double volumen;
    private double peso;
    private String descripcion;
    private double costo;
    
        /**
     * Constructor para crear una sede dados los datos 
     * @param venta : Venta la que pertenece el Paquete
     * @param numero : numero que identifica el paquete
     * @param volumen : volumen que ocupa el paquete
     * @param peso : peso del paquete
     * @param descripcion : descripcion del contenido del paquete
     * @param costo : costo del  envio del paquete
     */

    public Paquete(String venta, int numero, double volumen, double peso, String descripcion, double costo) 
    {
        this.venta = venta;
        this.numero = numero;
        this.volumen = volumen;
        this.peso = peso;
        this.descripcion = descripcion;
        this.costo = costo;
    }
    /***
     * Metodos Get y Set encargador de la modificacion y consulta de los atributos 
     */
    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
