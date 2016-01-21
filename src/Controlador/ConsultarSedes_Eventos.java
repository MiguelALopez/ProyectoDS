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

import Modelo.Sede;
import Modelo.SedeDAO;
import Vista.ConsultarSedes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ConsultarSedes_Eventos 
{
    private final ConsultarSedes consultarSedes;

    public ConsultarSedes_Eventos(final ConsultarSedes consultarSede) 
    {
        this.consultarSedes = consultarSede;

        cargarDatos();

        this.consultarSedes.bCerrar.addActionListener(
                new ActionListener() 
		{
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        cerrarVentana();
                    }
                }
        );
	
	this.consultarSedes.bActualizar.addActionListener(
                new ActionListener() 
		{
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        cargarDatos();
                    }
                }
        );
	
	this.consultarSedes.bVerDetalles.addActionListener(
                new ActionListener() 
		{
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        verDetalles();
                    }
                }
        );
    }

    public void cerrarVentana() 
    {
        this.consultarSedes.setVisible(false);
    }

    private void cargarDatos()
    {       
        ArrayList<Sede> listaSedes = new SedeDAO().getListaSedes();
        
        if (listaSedes != null)
        {
            DefaultTableModel model = (DefaultTableModel) this.consultarSedes.tSedes.getModel();
            model.setRowCount(listaSedes.size());
        
            for (int i = 0; i < listaSedes.size(); i++) 
            {
                this.consultarSedes.tSedes.setValueAt(listaSedes.get(i).getNumero(), i, 0);
                this.consultarSedes.tSedes.setValueAt(listaSedes.get(i).getNombre(), i, 1);
		this.consultarSedes.tSedes.setValueAt(listaSedes.get(i).getDireccion(), i, 2);
                this.consultarSedes.tSedes.setValueAt(listaSedes.get(i).getCiudad(), i, 3);
            }
        }
    }
    
    public void verDetalles()
    {
	
    }
}
