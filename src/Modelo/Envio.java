/**
 * *********************************************
 * Autor: Camilo Ruiz Casanova - 1324486 Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539 Autor: Cristian Camilo Jurado -
 * 1324366 Fecha: 09-oct-2015 Nombre del Archivo: .java Plan: Ingeniería de
 * Sistemas - 3743 Institución Educativa: Universidad del Valle
 *********************************************
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Cristian Jurado
 */
public class Envio
{

	private String usuario;
	private int costo;
	private int seguro;
	private int impuesto;
	private String estado;
	private String fecha;
	private ArrayList<Paquete> paquetes;

	public Envio(String usuario, int costo, int impuesto, int seguro, String estado, String fecha, ArrayList<Paquete> paquetes)
	{
		this.usuario = usuario;
		this.costo = costo;
		this.impuesto = impuesto;
		this.seguro = seguro;
		this.estado = estado;
		this.fecha = fecha;
		this.paquetes = paquetes;
	}

	/**
	 * Getters and setters para los atributos de la clase *
	 */
	public String getUsuario()
	{
		return usuario;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public int getCosto()
	{
		return costo;
	}

	public void setCosto(int costo)
	{
		this.costo = costo;
	}

	public int getSeguro()
	{
		return seguro;
	}

	public void setSeguro(int seguro)
	{
		this.seguro = seguro;
	}

	public int getImpuesto()
	{
		return impuesto;
	}

	public void setImpuesto(int impuesto)
	{
		this.impuesto = impuesto;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}

	public ArrayList<Paquete> getPaquetes()
	{
		return paquetes;
	}

	public void setPaquetes(ArrayList<Paquete> paquetes)
	{
		this.paquetes = paquetes;
	}

}
