/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: Reportes_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Modelo.PQRDAO;
import Modelo.ReportesPDF;
import Modelo.SedeDAO;
import Modelo.UsuarioDAO;
import Modelo.VentaDAO;
import Vista.Reportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * clase para manejar los eventos de reportes
 */
public class Reportes_Eventos 
{
    private final Reportes reportes;
    
    public Reportes_Eventos(final Reportes reportes)
    {
	this.reportes = reportes;
	
	this.reportes.bGenerarReporte.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    generarReporte();
                }
            }
        );
	
	this.reportes.bCerrar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    cerrarVentana();
                }
            }
        );
	
	this.reportes.rbListadoUsuarios.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    reportes.tfPOS.setEditable(false);
                    reportes.tfYear.setEditable(false);
                    reportes.tfMes.setEditable(false);
		    reportes.bPOS.setEnabled(false);
                }
            }
        );
	
	this.reportes.rbListadoSedes.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    reportes.tfPOS.setEditable(false);
                    reportes.tfYear.setEditable(false);
                    reportes.tfMes.setEditable(false);
		    reportes.bPOS.setEnabled(false);
                }
            }
        );
	
	this.reportes.rbListadoPQR.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    reportes.tfPOS.setEditable(false);
                    reportes.tfYear.setEditable(false);
                    reportes.tfMes.setEditable(false);
		    reportes.bPOS.setEnabled(false);
                }
            }
        );
	
	this.reportes.rbListadoPOS.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    reportes.tfPOS.setEditable(false);
                    reportes.tfYear.setEditable(false);
                    reportes.tfMes.setEditable(false);
		    reportes.bPOS.setEnabled(false);
                }
            }
        );
	
	this.reportes.rbListadoVentas.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    reportes.tfPOS.setEditable(false);
                    reportes.tfYear.setEditable(false);
                    reportes.tfMes.setEditable(false);
		    reportes.bPOS.setEnabled(false);
                }
            }
        );
	
	this.reportes.rbListadoVentasPOSyFecha.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    reportes.tfPOS.setEditable(true);
                    reportes.tfYear.setEditable(true);
                    reportes.tfMes.setEditable(true);
                    reportes.bPOS.setEnabled(true);
                }
            }
        );
	
	this.reportes.bPOS.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
		    consultarPOS();
                }
            }
        );
	
	this.reportes.bSeleccionar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
		    seleccionarPOS();
                }
            }
        );
	
	this.reportes.bCancelar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
		    cerrarSeleccion();
                }
            }
        );
	
	reportes.addWindowListener(
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
    }
    
    public void consultarPOS()
    {
	ArrayList<POS> listaPOS = new POSDAO().getListaPOS(); // aqui metodo DAO para obtener todos los POS de la BD
        
        if (listaPOS != null)
        {
            DefaultTableModel model = (DefaultTableModel) this.reportes.tPOS.getModel();
            model.setRowCount(listaPOS.size());

            for (int i = 0; i < listaPOS.size(); i++) 
            {
                this.reportes.tPOS.setValueAt(listaPOS.get(i).getId(), i, 0);
                this.reportes.tPOS.setValueAt(listaPOS.get(i).getNombre(), i, 1);
                this.reportes.tPOS.setValueAt(listaPOS.get(i).getDireccion(), i, 2);
            }
	    
	    this.reportes.fPOS.setLocationRelativeTo(reportes);
	    this.reportes.fPOS.setVisible(true);
        }
    }
    
    public void seleccionarPOS()
    {
	int row = this.reportes.tPOS.getSelectedRow();
        
        if(row != -1)
        {
            this.reportes.tfPOS.setText((String) this.reportes.tPOS.getValueAt(row, 0));
            
            DefaultTableModel model = (DefaultTableModel) this.reportes.tPOS.getModel();
            model.setRowCount(0);
            
            this.reportes.fPOS.setVisible(false);
        }
	else
	{
	    JOptionPane.showMessageDialog(this.reportes.fPOS, "Seleccione un POS.", "", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    public void cerrarSeleccion()
    {
	this.reportes.fPOS.setVisible(false);
    }
    
    public void generarReporte()
    {
	if (this.reportes.rbListadoUsuarios.isSelected())
	{
	    generarListadoUsuarios();
	}
	else if (this.reportes.rbListadoSedes.isSelected())
	{
	    generarListadoSedes();
	}
	else if (this.reportes.rbListadoPQR.isSelected())
	{
	    generarListadoPQR();
	}
	else if (this.reportes.rbListadoPOS.isSelected())
	{
	    generarListadoPOS();
	}
	else if (this.reportes.rbListadoVentas.isSelected())
	{
	    generarListadoVentas();
	}
	else if (this.reportes.rbListadoVentasPOSyFecha.isSelected())
	{
	    generarListadoVentasPOSyFecha();
	}
    }

    private void generarListadoUsuarios() 
    {
	ReportesPDF.generarListadoUsuarios(new UsuarioDAO().getListaUsuarios());
    }

    private void generarListadoSedes() 
    {
	ReportesPDF.generarListadoSedes(new SedeDAO().getListaSedes());
    }

    private void generarListadoPQR() 
    {
	ReportesPDF.generarListadoPQR(new PQRDAO().getListaPQR());
    }

    private void generarListadoPOS() 
    {
	ReportesPDF.generarListadoPOS(new POSDAO().getListaPOS());
    }

    private void generarListadoVentas() 
    {
	ReportesPDF.generarListadoVentas(new VentaDAO().getListaVentas());
    }

    private void generarListadoVentasPOSyFecha() 
    {
	String pos = this.reportes.tfPOS.getText();
	String year = this.reportes.tfYear.getText();
	String mes = this.reportes.tfMes.getText();
	
	if (!year.isEmpty())
	{
	    try
	    {
		Integer.parseInt(year);
	    }
	    catch (NumberFormatException ex)
	    {
		JOptionPane.showMessageDialog(reportes, "El campo Año es numerico.", "", JOptionPane.ERROR_MESSAGE);
		return;
	    }
	}
	
	if (!mes.isEmpty())
	{
	    try
	    {
		Integer.parseInt(mes);
	    }
	    catch (NumberFormatException ex)
	    {
		JOptionPane.showMessageDialog(reportes, "El campo Mes es numerico.", "", JOptionPane.ERROR_MESSAGE);
		return;
	    }
	}
	
	if (!pos.isEmpty() && !year.isEmpty() && !mes.isEmpty())
	{
	    ReportesPDF.generarListadoVentas(new VentaDAO().getListaVentas(pos, Integer.parseInt(year), Integer.parseInt(mes)));
	}
	else if (!pos.isEmpty() && !year.isEmpty() && mes.isEmpty())
	{
	    ReportesPDF.generarListadoVentas(new VentaDAO().getListaVentas(pos, Integer.parseInt(year)));
	}
	else if (!pos.isEmpty() && year.isEmpty() && mes.isEmpty())
	{
	    ReportesPDF.generarListadoVentas(new VentaDAO().getListaVentas(pos));
	}
	else if (pos.isEmpty() && !year.isEmpty() && !mes.isEmpty())
	{
	    ReportesPDF.generarListadoVentas(new VentaDAO().getListaVentasFecha(Integer.parseInt(year), Integer.parseInt(mes)));
	}
	else if (pos.isEmpty() && !year.isEmpty() && mes.isEmpty())
	{
	    ReportesPDF.generarListadoVentas(new VentaDAO().getListaVentasFecha(Integer.parseInt(year)));
	}
	else if (pos.isEmpty() && year.isEmpty() && !mes.isEmpty())
	{
	    JOptionPane.showMessageDialog(reportes, "Si digita un mes debe de digitar un año.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	else if (pos.isEmpty() && year.isEmpty() && mes.isEmpty())
	{
	    JOptionPane.showMessageDialog(reportes, "Debe ingresar algun dato.", "Error", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    public void cerrarVentana()
    {
	this.reportes.setVisible(false);
	this.reportes.fPOS.setVisible(false);
    }
}
