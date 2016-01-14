/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.RegistrarVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author AndresFelipe
 */
public class RegistrarVenta_Eventos
{

	private RegistrarVenta registrarVenta;

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
		
		this.registrarVenta.tTotal.addActionListener(
			new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					calcular();
				}
			}
		);

	}

	public void cerrarFormulario()
	{
		this.registrarVenta.setVisible(false);
	}
	
	public void calcular(){
		int total = Integer.parseInt(this.registrarVenta.tTotal.getText());
		int iva, subtotal;
		subtotal = (total*100/116);
		iva = total - subtotal;
		this.registrarVenta.tSubtotal.setText(""+subtotal);
		this.registrarVenta.tIva.setText(""+iva);
	}
}
