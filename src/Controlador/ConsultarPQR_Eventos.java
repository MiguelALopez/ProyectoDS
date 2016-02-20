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

package Controlador;

import Vista.ConsultarPQR;
import Modelo.PQR;
import Modelo.PQRDAO;
import Modelo.ReportesPDF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian Jurado
 * clase para manejar los eventos de consultar pqr
 */
public class ConsultarPQR_Eventos 
{
    private final ConsultarPQR consultarPQR;
        
    public ConsultarPQR_Eventos(final ConsultarPQR consultarPQR)
    {
        this.consultarPQR = consultarPQR;
        
        consultarPQR.bCerrar.addActionListener(
	    new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
		    cerrarVentana();
		}
	    }
        );
        
        consultarPQR.bActualizarPQR.addActionListener(
	    new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
		    consultarPQR();
		}
	    }
        );
        
        consultarPQR.bVerPQR.addActionListener(
	    new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
		    verPQR();
		}
	    }
        );
	
	consultarPQR.bCerrarDetalles.addActionListener(
	    new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
		    cerrarDetalles();
		}
	    }
        );
	
	consultarPQR.bGenerarRecibo.addActionListener(
	    new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
		    generarRecibo();
		}
	    }
        );
        
        consultarPQR();
    }  
        
    private void consultarPQR()  
    {
        ArrayList<PQR> listaPQR = new PQRDAO().getListaPQR(); // aqui metodo DAO para obtener todos los PQR de la BD
        
        DefaultTableModel model = (DefaultTableModel) this.consultarPQR.tPQR.getModel();
        model.setRowCount(listaPQR.size());
        
        for (int i = 0; i < listaPQR.size(); i++) 
        {
            this.consultarPQR.tPQR.setValueAt(listaPQR.get(i).getNumero(), i, 0);
            this.consultarPQR.tPQR.setValueAt(listaPQR.get(i).getTipo(), i, 1);
            this.consultarPQR.tPQR.setValueAt(listaPQR.get(i).getCedula(), i, 2);
            this.consultarPQR.tPQR.setValueAt(listaPQR.get(i).getEstado(), i, 3);
        }
    }
            
    public void cerrarVentana()  
    {
        this.consultarPQR.setVisible(false);
	this.consultarPQR.fDetalles.setVisible(false);
    }    
    
    public void verPQR()
    {
        int row = consultarPQR.tPQR.getSelectedRow();
                        
        if (row != -1)
        {
            String numeroPQR = (String) consultarPQR.tPQR.getValueAt(row, 0);
            
            PQR pqr = new PQRDAO().consultarPQR(numeroPQR);
                        
            if (pqr != null)
            {
                this.consultarPQR.tfNumeroPQR.setText(pqr.getNumero());
                this.consultarPQR.tfFecha.setText(pqr.getFecha());
		this.consultarPQR.tfTipo.setText(pqr.getTipo());
		this.consultarPQR.taContenido.setText(pqr.getContenido());
		this.consultarPQR.tfEstado.setText(pqr.getEstado());
		this.consultarPQR.tfCedula.setText(pqr.getCedula());
		this.consultarPQR.tfNombre.setText(pqr.getNombre());
		this.consultarPQR.tfSede.setText(pqr.getSede());
		
		this.consultarPQR.fDetalles.setLocationRelativeTo(consultarPQR);
		this.consultarPQR.fDetalles.setVisible(true);
            }       
        }
        else
        {
            JOptionPane.showMessageDialog(consultarPQR, "No ha seleccionado ningun PQR.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void cerrarDetalles()
    {
	this.consultarPQR.fDetalles.setVisible(false);
	borrarCamposDetalles();
    }
    
    public void generarRecibo()
    {
	String numero = this.consultarPQR.tfNumeroPQR.getText();	
	ReportesPDF.generarReciboPQR(new PQRDAO().consultarPQR(numero));
    }
    
    public void borrarCamposDetalles()
    {
	this.consultarPQR.tfNumeroPQR.setText("");
	this.consultarPQR.tfFecha.setText("");
	this.consultarPQR.tfTipo.setText("");
	this.consultarPQR.taContenido.setText("");
	this.consultarPQR.tfEstado.setText("");
	this.consultarPQR.tfCedula.setText("");
	this.consultarPQR.tfNombre.setText("");
	this.consultarPQR.tfSede.setText("");
    }
}
