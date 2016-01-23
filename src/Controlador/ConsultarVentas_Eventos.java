/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Paquete;
import Modelo.Venta;
import Modelo.VentaDAO;
import Vista.ConsultarVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ConsultarVentas_Eventos 
{
    private final ConsultarVentas consultarVentas;    
    private ArrayList<Paquete> paquetes;
    
    public ConsultarVentas_Eventos(final ConsultarVentas consultarVentas)
    {
        this.consultarVentas = consultarVentas;
        this.paquetes = new ArrayList();
        
        consultarVentas.bActualizar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        consultarVentas();
                    }
                }
        );
        
        consultarVentas.bDetalles.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        verDetalles();
                    }
                }
        );
        
        consultarVentas.cbPaquetes.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        verPaquete();
                    }
                }
        );
        
        consultarVentas.bCerrar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarDetalles();
                    }
                }
        );
	
	consultarVentas.bGenerar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        generarRecibo();
                    }
                }
        );
        
        consultarVentas();
    }
    
    private void consultarVentas()
    {
        ArrayList<Venta> listaVentas = new VentaDAO().getListaVentas(); // aqui metodo DAO para obtener todos los Ventas de la BD
        //ArrayList<Venta> listaVentas = new ArrayList();
        
        if (listaVentas != null)
        {
            DefaultTableModel model = (DefaultTableModel) this.consultarVentas.tVentas.getModel();
            model.setRowCount(listaVentas.size());

            for (int i = 0; i < listaVentas.size(); i++) 
            {
                this.consultarVentas.tVentas.setValueAt(listaVentas.get(i).getId(), i, 0);
                this.consultarVentas.tVentas.setValueAt(listaVentas.get(i).getFecha(), i, 1);
                this.consultarVentas.tVentas.setValueAt(listaVentas.get(i).getPos(), i, 2);
                this.consultarVentas.tVentas.setValueAt(listaVentas.get(i).getTotal(), i, 3);
            }
        }
    }
    
    public void cerrarVentana()
    {
	this.consultarVentas.setVisible(false);
	//this.consultarVentas.fDetalles.setVisible(false);
    }
    
    public void verDetalles()
    {
        int row = this.consultarVentas.tVentas.getSelectedRow();
        
        if (row != -1)
        {
            String id = (String) this.consultarVentas.tVentas.getValueAt(row, 0);
            
            Venta venta = new VentaDAO().consultarVenta(id);
            
            if (venta != null)
            {                
		this.consultarVentas.tfID.setText(venta.getId());
		this.consultarVentas.tfFecha.setText(venta.getFecha());
                this.consultarVentas.tfPOS.setText(venta.getPos());
                this.consultarVentas.tfCedula.setText(venta.getCedula());
                this.consultarVentas.tfNombre.setText(venta.getNombre());
                this.consultarVentas.tfDireccion.setText(venta.getDireccion());
                
                this.paquetes = venta.getPaquetes();
                this.consultarVentas.cbPaquetes.removeAllItems();
                for (Paquete p : this.paquetes)
                {
                    this.consultarVentas.cbPaquetes.addItem(p.getNumero()+"");
                }
                
                this.consultarVentas.tfMetodo.setText(venta.getMetodo());
		this.consultarVentas.tfSeguro.setText(String.valueOf(venta.getSeguro()));
                this.consultarVentas.tfSubtotal.setText(String.valueOf(venta.getSubtotal()));
                this.consultarVentas.tfIVA.setText(String.valueOf(venta.getIva()));
                this.consultarVentas.tfTotal.setText(String.valueOf(venta.getTotal()));
                
                this.consultarVentas.fDetalles.setLocationRelativeTo(this.consultarVentas);
                this.consultarVentas.fDetalles.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(consultarVentas, "Error al consultar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(consultarVentas, "Seleccione una Venta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void verPaquete()
    {
        int index = this.consultarVentas.cbPaquetes.getSelectedIndex();
        
        if (index != -1)
        {
            Paquete p = this.paquetes.get(index);
            
            this.consultarVentas.tfVerVolumen.setText(String.valueOf(p.getVolumen()));
            this.consultarVentas.tfVerPeso.setText(String.valueOf(p.getPeso()));
            this.consultarVentas.taVerDescripcion.setText(p.getDescripcion());
        }
    }
    
    public void limpiarDetalles()
    {
        this.consultarVentas.tfID.setText("");
	this.consultarVentas.tfFecha.setText("");
	this.consultarVentas.tfPOS.setText("");
	this.consultarVentas.tfCedula.setText("");
	this.consultarVentas.tfNombre.setText("");
	this.consultarVentas.tfDireccion.setText("");

	this.paquetes = new ArrayList();
	this.consultarVentas.cbPaquetes.removeAllItems();

	this.consultarVentas.tfMetodo.setText("");
	this.consultarVentas.tfSeguro.setText("");
	this.consultarVentas.tfSubtotal.setText("");
	this.consultarVentas.tfIVA.setText("");
	this.consultarVentas.tfTotal.setText("");
    }
    
    public void cerrarDetalles()
    {
        this.consultarVentas.fDetalles.setVisible(false);
	limpiarDetalles();
    }
    
    public void generarRecibo()
    {
	String id = this.consultarVentas.tfID.getText();
	
	RegistrarVenta_Eventos.generaRecibo(new VentaDAO().consultarVenta(id));
    }
}
