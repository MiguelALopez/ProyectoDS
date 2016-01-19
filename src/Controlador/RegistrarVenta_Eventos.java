/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Modelo.Paquete;
import Modelo.Venta;
import Modelo.VentaDAO;
import Vista.RegistrarVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AndresFelipe
 */
public class RegistrarVenta_Eventos
{
    private final RegistrarVenta registrarVenta;
    private ArrayList<Paquete> paquetes;
    private Paquete selected;

    public RegistrarVenta_Eventos(final RegistrarVenta registrarVenta)
    {
        this.registrarVenta = registrarVenta;
        this.paquetes = new ArrayList();
        this.selected = null;

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
	
	this.registrarVenta.bRegistrarVenta.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    agregaVenta();
                }
            }
        );
	
	actualizaPOS();
    }
    
    private void actualizaPOS()
    {
	ArrayList<POS> pos = new POSDAO().getListaPOS();
	
	if (pos != null)
	{
	    this.registrarVenta.cbPOS.removeAllItems();
        
	    for (POS p : pos)
	    {
		this.registrarVenta.cbPOS.addItem(p.getId());
	    }
	}
    }

    public void cerrarFormulario()
    {
        this.registrarVenta.setVisible(false);
    }

    public void seleccion()
    {
        int index = this.registrarVenta.cbPaquetes.getSelectedIndex();
        
        if (index != -1)
        {
            this.selected = this.paquetes.get(index);
        
            if (selected != null)
            {
                this.registrarVenta.tfVerVolumen.setText(selected.getVolumen()+"");
                this.registrarVenta.tfVerPeso.setText(selected.getPeso()+"");
                this.registrarVenta.taVerDescripcion.setText(selected.getDescripcion());
                this.registrarVenta.tfVerCosto.setText(selected.getCosto()+"");
            }
        }
        else
        {
            this.selected = null;
        }
    }

    public void eliminaPaquete()
    {
        if (this.selected != null)
        {
            int index = this.registrarVenta.cbPaquetes.getSelectedIndex();
            this.paquetes.remove(index);
            
	    for (int i = index; i < this.paquetes.size(); i++)
            {
                  this.paquetes.get(i).setNumero(this.paquetes.get(i).getNumero()-1);
            }
            
            borrarCamposPaquete();
            actualizaLista();
            
            calcular();
        }
    }

    public void agregaPaquete()
    {
        try
        {
            int numero = this.paquetes.size()+1;
            double volumen = Double.parseDouble(this.registrarVenta.tfAgregarVolumen.getText());
            double peso = Double.parseDouble(this.registrarVenta.tfAgregarPeso.getText());
            String descripcion = this.registrarVenta.taAgregarDescripcion.getText();
            double costo = Double.parseDouble(this.registrarVenta.tfCosto.getText());

            Paquete insert = new Paquete("", numero, volumen, peso, descripcion, costo);
            this.paquetes.add(insert);
            
            borrarCamposPaquete();
            actualizaLista();

            // Autoseleccionar ultimo item agregado
            this.registrarVenta.cbPaquetes.setSelectedIndex(numero-1);
            
            calcular();
        }
        catch(Exception ex)
        {
            Logger.getLogger(RegistrarVenta_Eventos.class.getName()).log(Level.SEVERE, null, ex);            
	    JOptionPane.showMessageDialog(registrarVenta, "Por favor digite todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregaVenta()
    {
	String pos = (String) this.registrarVenta.cbPOS.getSelectedItem();
	String cedula = this.registrarVenta.tfCedula.getText();
	String nombre = this.registrarVenta.tfNombre.getText();
	String direccion = this.registrarVenta.tfDireccion.getText();
	
	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	String fecha = df.format(Calendar.getInstance().getTime());
	
	String metodo = "";
	
	if (this.registrarVenta.rbEfectivo.isSelected())
	{
	    metodo = this.registrarVenta.rbEfectivo.getText();
	}
	else if (this.registrarVenta.rbCredito.isSelected())
	{
	    metodo = this.registrarVenta.rbCredito.getText();
	}
	else if (this.registrarVenta.rbDebito.isSelected())
	{
	    metodo = this.registrarVenta.rbDebito.getText();
	}
	
	boolean seguro = this.registrarVenta.cbSeguro.isSelected();

	double subtotal = Double.parseDouble(this.registrarVenta.tfSubtotal.getText());
	double iva = Double.parseDouble(this.registrarVenta.tfIVA.getText());
	double total = Double.parseDouble(this.registrarVenta.tfTotal.getText());
	
	Venta venta = new Venta(cedula, nombre, direccion, fecha, metodo, seguro, subtotal, iva, total, pos, this.paquetes);
	
	boolean exito = new VentaDAO().insertarVenta(venta);
	
	if (exito)
	{
	    JOptionPane.showMessageDialog(registrarVenta, "Venta registrada correctamente.", "", JOptionPane.INFORMATION_MESSAGE);
	}
	else
	{
	    JOptionPane.showMessageDialog(registrarVenta, "Error al registrar la Venta.", "Error", JOptionPane.ERROR_MESSAGE);
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
        double iva;
        double subtotal = 0;
        
        for (Paquete p : this.paquetes)
        {
            subtotal += p.getCosto();
        }
        
        iva = subtotal*0.16;
        double total = subtotal + iva;
        
        this.registrarVenta.tfSubtotal.setText("" + subtotal);
        this.registrarVenta.tfIVA.setText("" + iva);
        this.registrarVenta.tfTotal.setText(total+"");
    }
    
    public void registrarVenta()
    {
	double total = Integer.parseInt(this.registrarVenta.tfTotal.getText());
	
	
	
	borrarCamposVenta();
    }
    
    public void borrarCamposVenta()
    {
	this.registrarVenta.cbPOS.setSelectedIndex(0);
	this.registrarVenta.tfCedula.setText("");
	this.registrarVenta.tfNombre.setText("");
	this.registrarVenta.tfDireccion.setText("");
	this.paquetes = new ArrayList();
	actualizaLista();
	borrarCamposPaquete();
	this.registrarVenta.buttonGroup1.clearSelection();
	this.registrarVenta.cbSeguro.setSelected(false);
	this.registrarVenta.tfSubtotal.setText("");
	this.registrarVenta.tfIVA.setText("");
	this.registrarVenta.tfTotal.setText("");
    }

    public void borrarCamposPaquete()
    {
        this.registrarVenta.taAgregarDescripcion.setText("");
        this.registrarVenta.taVerDescripcion.setText("");
        this.registrarVenta.tfAgregarPeso.setText("");
        this.registrarVenta.tfAgregarVolumen.setText("");
        this.registrarVenta.tfCosto.setText("");
        this.registrarVenta.tfVerPeso.setText("");
        this.registrarVenta.tfVerVolumen.setText("");
        this.registrarVenta.tfVerCosto.setText("");
    }
}
