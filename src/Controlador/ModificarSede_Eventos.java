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
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.ModificarSede;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ModificarSede_Eventos {

    private final ModificarSede modificarSede;

    public ModificarSede_Eventos(final ModificarSede modificarSede) {
        this.modificarSede = modificarSede;

        this.modificarSede.bCancelar.addActionListener(
                new ActionListener() 
		{
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        cerrarVentana();
                    }
                }
        );

        this.modificarSede.bBuscarSede.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        buscarSede();
                    }
                }
        );

        this.modificarSede.bModificar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        modificarSede();
                    }
                }
        );
	
	this.modificarSede.bBuscar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        consultarGerentes();
                    }
                }
        );
	
	this.modificarSede.bSeleccionar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        seleccionarGerente();
                    }
                }
        );
	
	this.modificarSede.bCerrar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) 
		    {
                        cerrarSeleccion();
                    }
                }
        );
    }

    /**
     * Metodo encargado de buscar una sede y llevar los datos a los textField
     */
    public void buscarSede()
    {
	String numero = this.modificarSede.tfBuscar.getText();
	
        Sede sede = new SedeDAO().consultarSede(numero);
	
        if (sede != null)
	{
	    this.modificarSede.tfNumero.setText(sede.getNumero());
            this.modificarSede.tfNombre.setText(sede.getNombre());
            this.modificarSede.tfDireccion.setText(sede.getDireccion());
	    this.modificarSede.cbCiudad.setSelectedItem(sede.getCiudad());
            this.modificarSede.tfGerente.setText(sede.getGerente());
            this.modificarSede.tfCamiones.setText(Integer.toString(sede.getCamiones()));
	    
	    habilitarCampos(true);
        }
	else
	{
	    JOptionPane.showMessageDialog(modificarSede, "Error al consultar.", "Error", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    public void habilitarCampos(boolean b)
    {
	this.modificarSede.tfNombre.setEditable(b);
	this.modificarSede.tfDireccion.setEditable(b);
	this.modificarSede.cbCiudad.setEnabled(b);
	this.modificarSede.tfGerente.setEditable(b);
	this.modificarSede.bBuscar.setEnabled(b);
	this.modificarSede.tfCamiones.setEditable(b);
    }

    public void modificarSede() 
    {
	if (verificarCampos())
	{
	    String numero = this.modificarSede.tfNumero.getText();
	    String nombre = this.modificarSede.tfNombre.getText();
	    String direccion = this.modificarSede.tfDireccion.getText();
	    String ciudad = (String) this.modificarSede.cbCiudad.getSelectedItem();
	    String gerente = this.modificarSede.tfGerente.getText();
	    int camiones = Integer.parseInt(this.modificarSede.tfCamiones.getText());
	    
	    Sede sede = new Sede(numero, nombre, direccion, ciudad, gerente, camiones);
	    
	    int op = JOptionPane.showConfirmDialog(modificarSede, "Desea modificar la sede"+numero+"?", "", JOptionPane.YES_NO_OPTION);
	    
	    if (op == JOptionPane.YES_OPTION)
	    {
		boolean exito = new SedeDAO().modificarSede(sede);
	    
		if (exito)
		{
		    JOptionPane.showMessageDialog(null, "Sede modificada exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
		    limpiarCampos();
		    habilitarCampos(false);
		}
		else 
		{
		    JOptionPane.showMessageDialog(null, "Error al modificar.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	    }
	}
    }
    
    public void consultarGerentes()
    {
        ArrayList<Usuario> listaGerentes = new UsuarioDAO().getListaGerentes();
        
        if(listaGerentes != null)
        {
            DefaultTableModel model = (DefaultTableModel) this.modificarSede.tGerentes.getModel();
            model.setRowCount(listaGerentes.size());
            
            for (int i = 0; i < listaGerentes.size(); i++) 
            {
                this.modificarSede.tGerentes.setValueAt(listaGerentes.get(i).getCedula(), i, 0);
                this.modificarSede.tGerentes.setValueAt(listaGerentes.get(i).getNombre(), i, 1);
                this.modificarSede.tGerentes.setValueAt(listaGerentes.get(i).getApellido(), i, 2);
            }
            
            this.modificarSede.fSelGerente.setLocationRelativeTo(modificarSede);
            this.modificarSede.fSelGerente.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(modificarSede, "Error al consultar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void seleccionarGerente()
    {
        int row = this.modificarSede.tGerentes.getSelectedRow();
        
        if(row != -1)
        {
            this.modificarSede.tfGerente.setText((String) this.modificarSede.tGerentes.getValueAt(row, 0));
            
            DefaultTableModel model = (DefaultTableModel) this.modificarSede.tGerentes.getModel();
            model.setRowCount(0);
            
            this.modificarSede.fSelGerente.setVisible(false);
        }
	else
	{
	    JOptionPane.showMessageDialog(this.modificarSede.fSelGerente, "Seleccione un gerente.", "", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    public void cerrarSeleccion()
    {
	this.modificarSede.fSelGerente.setVisible(false);
    }

    // Metodo encargado de hacer la ventana invisible y llamar al metodo limpiarCampos
    public void cerrarVentana()
    {
        this.modificarSede.setVisible(false);
	this.modificarSede.fSelGerente.setVisible(false);
    }

    // Metodo encergado de limpiar los campos de la ventana
    public void limpiarCampos()
    {
	this.modificarSede.tfBuscar.setText("");
        this.modificarSede.tfNumero.setText("");
	this.modificarSede.tfNombre.setText("");
	this.modificarSede.tfDireccion.setText("");
	this.modificarSede.cbCiudad.setSelectedIndex(0);
	this.modificarSede.tfGerente.setText("");
	this.modificarSede.tfCamiones.setText("");
    }

    public boolean verificarCampos()
    {
        if (this.modificarSede.tfNumero.getText().isEmpty())
	{
	    JOptionPane.showMessageDialog(modificarSede, "El campo Numero es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
        }
	
	if (this.modificarSede.tfNombre.getText().isEmpty())
	{
	    JOptionPane.showMessageDialog(modificarSede, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
        }
	
	if (this.modificarSede.tfDireccion.getText().isEmpty())
	{
	    JOptionPane.showMessageDialog(modificarSede, "El campo Direccion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
	    return false;
        }
	
	if (!this.modificarSede.tfCamiones.getText().isEmpty())
	{
	    try
	    {
		Long c = Long.parseLong(this.modificarSede.tfCamiones.getText());
		
		if (c < 0)
		{
		    JOptionPane.showMessageDialog(modificarSede, "La cantidad en el campo Camiones debe ser mayor o igual a cero.", "Error", JOptionPane.ERROR_MESSAGE);
		    return false;
		}
	    }
	    catch (NumberFormatException ex)
	    {
		JOptionPane.showMessageDialog(modificarSede, "El campo Camiones es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
		return false;
	    }
        }
	
        return true;
    }
}
