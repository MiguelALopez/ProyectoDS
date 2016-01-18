/**
 * *********************************************
 * Autor: Camilo Ruiz Casanova - 1324486 Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539 Autor: Cristian Camilo Jurado -
 * 1324366 Fecha: 09-oct-2015 Nombre del Archivo: .java Plan: Ingeniería de
 * Sistemas - 3743 Institución Educativa: Universidad del Valle
 *********************************************
 */
package Modelo;

/**
 *
 * @author Cristian Jurado
 */
public class Paquete
{

	private int costo;
	private String cod;

	public Paquete(String cod, int costo)
	{
		this.cod = cod;
		this.costo = costo;

	}

	/**
	 * Getters and setters para los atributos de la clase *
	 */
	public int getCosto()
	{
		return costo;
	}

	public void setCosto(int costo)
	{
		this.costo = costo;
	}

	public String getCod()
	{
		return cod;
	}

	public void setCod(String cod)
	{
		this.cod = cod;
	}

}
