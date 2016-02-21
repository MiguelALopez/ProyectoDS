/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: ConsultarVentas_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.Paquete;
import Modelo.ReportesPDF;
import Modelo.Venta;
import Modelo.VentaDAO;
import Vista.ConsultarVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * clase para manejar los eventos de consultar ventas
 */
public class ConsultarVentas_Eventos 
{
    private final ConsultarVentas consultarVentas;    
    private ArrayList<Paquete> paquetes;
    
    public ConsultarVentas_Eventos(final ConsultarVentas consultarVentas)
    {
        this.consultarVentas = consultarVentas;
        this.paquetes = new ArrayList();
	
	consultarVentas.bCerrarMain.addActionListener(
	    new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
		    cerrarVentana();
		}
	    }
        );
        
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
	
	consultarVentas.addWindowListener(
	    new WindowListener()
	    {
		@Override
		public void windowOpened(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) 
		{
		    cerrarVentana();
		}

		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}
	    }
        );
        
        consultarVentas();
    }
    
    private void consultarVentas()
    {
        ArrayList<Venta> listaVentas = new VentaDAO().getListaVentas(); // aqui metodo DAO para obtener todos los Ventas de la BD
        
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
	this.consultarVentas.fDetalles.setVisible(false);
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
	
	ReportesPDF.generarRecibo(new VentaDAO().consultarVenta(id));
    }
}
