/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Paquete;
import Vista.RegistrarVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author AndresFelipe
 */
public class RegistrarVenta_Eventos
{

	private final RegistrarVenta registrarVenta;
	private ArrayList<Paquete> paquetes = new ArrayList<>();
	private Paquete selected = null;

	public RegistrarVenta_Eventos(final RegistrarVenta registrarVenta)
	{
		this.registrarVenta = registrarVenta;

		this.registrarVenta.bCancelar.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					cerrarFormulario();
				}
			}
		);

		this.registrarVenta.tfTotal.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					calcular();
				}
			}
		);

		this.registrarVenta.cbPaquetes.addActionListener(
			new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					seleccion();
				}
			}
		);
		
		this.registrarVenta.bEliminarPaquete.addActionListener(
			new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					eliminaPaquete();
				}
			}
		);
		
		this.registrarVenta.bAgregarPaquete.addActionListener(
			new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					agregaPaquete();
				}
			}
		);
	}

	public void cerrarFormulario()
	{
		this.registrarVenta.setVisible(false);
	}

	public void seleccion()
	{
		int item = this.registrarVenta.cbPaquetes.getSelectedIndex()+1;
		this.selected = buscarPaquete(item);
		if (selected != null)
		{
			this.registrarVenta.tfVerVolumen.setText(selected.getVolumen()+"");
			this.registrarVenta.tfVerPeso.setText(selected.getPeso()+"");
			this.registrarVenta.taVerDescripcion.setText(selected.getDescripcion());
		}
		
	}

	public Paquete buscarPaquete(int numero)
	{
		for (Paquete i : this.paquetes)
		{
			if(i.getNumero() == numero)
				return i;
		}
		return null;
	}
	
	public void eliminaPaquete(){
		if (this.selected != null)
		{
			int index = this.selected.getNumero()-1;
			this.paquetes.remove(index);
			for (int i = index; i < this.paquetes.size(); i++)
			{
				this.paquetes.get(i).setNumero(index+1);
			}
			borrarCamposPaquete();
			actualizaLista();
			this.selected = null;
		}
		
	}
	
	public void agregaPaquete(){
		try
		{
			
		
		double volumen = Double.parseDouble(this.registrarVenta.tfAgregarVolumen.getText());
		double peso = Double.parseDouble(this.registrarVenta.tfAgregarPeso.getText());
		String descripcion = this.registrarVenta.taAgregarDescripcion.getText();
		
		int numero = this.paquetes.size()+1;
		
		Paquete insert = new Paquete("000", numero, volumen, peso, descripcion);
		this.paquetes.add(insert);
		this.selected = insert;
		
		borrarCamposPaquete();
		actualizaLista();
		
		// Autoseleccionar ultimo item agregado
		this.registrarVenta.cbPaquetes.setSelectedIndex(numero-1);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(registrarVenta, "Todos los campos del paquete son obligatorios","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void actualizaLista()
	{
		this.registrarVenta.cbPaquetes.removeAllItems();
		for (Paquete i : this.paquetes)
		{
			this.registrarVenta.cbPaquetes.addItem(i.getNumero()+"");
		}
	}

	public void calcular()
	{
		//Cambiar total por la suma 
		int total = Integer.parseInt(this.registrarVenta.tfTotal.getText());
		int iva, subtotal;
		subtotal = (total * 100 / 116);
		iva = total - subtotal;
		this.registrarVenta.tfSubtotal.setText("" + subtotal);
		this.registrarVenta.tfIVA.setText("" + iva);
	}
	
	public void borrarCamposPaquete()
	{
		this.registrarVenta.taAgregarDescripcion.setText("");
		this.registrarVenta.taVerDescripcion.setText("");
		this.registrarVenta.tfAgregarPeso.setText("");
		this.registrarVenta.tfAgregarVolumen.setText("");
		this.registrarVenta.tfVerPeso.setText("");
		this.registrarVenta.tfVerVolumen.setText("");
	}
}
