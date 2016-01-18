/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Vista.ModificarPOS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ModificarPOS_Eventos 
{
    private final ModificarPOS modificarPOS;
    
    public ModificarPOS_Eventos(final ModificarPOS modificarPOS)
    {
        this.modificarPOS = modificarPOS;
        
        modificarPOS.bBuscar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    buscarPOS();
                }
            }
        );
        
        modificarPOS.bModificar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    modificarPOS();
                }
            }
        );
    }
    
    public void buscarPOS()
    {
        String id = this.modificarPOS.tfBuscar.getText();
        
        POS pos = new POSDAO().consultarPOS(id);
        
        if (pos != null)
        {
            this.modificarPOS.tfID.setText(pos.getId());
            this.modificarPOS.tfNombre.setText(pos.getNombre());
            this.modificarPOS.tfDireccion.setText(pos.getDireccion());
            habilitarCampos(true);
        }
        else
        {
            JOptionPane.showMessageDialog(modificarPOS, "Error al buscar el POS.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void habilitarCampos(boolean b)
    {
        this.modificarPOS.tfNombre.setEditable(b);
        this.modificarPOS.tfDireccion.setEditable(b);
    }
    
    public void modificarPOS()
    {
        if (verificarCampos())
        {
            String id = this.modificarPOS.tfID.getText();
            String nombre = this.modificarPOS.tfNombre.getText();
            String direccion = this.modificarPOS.tfDireccion.getText();
            
            POS pos = new POS(id, nombre, direccion);
            
            int op = JOptionPane.showConfirmDialog(modificarPOS, "Desea modificar el POS " + id + "?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (op == JOptionPane.YES_OPTION)
            {
                boolean exito = new POSDAO().modificarPOS(pos);
                
                if (exito)
                {
                    JOptionPane.showMessageDialog(modificarPOS, "POS " + id + " modificado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(modificarPOS, "Error al modificar el POS.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public boolean verificarCampos()
    {
        if (this.modificarPOS.tfID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarPOS, "Campo ID obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (this.modificarPOS.tfNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarPOS, "Campo Nombre obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (this.modificarPOS.tfDireccion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarPOS, "Campo Direccion obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public void limpiarCampos()
    {
        this.modificarPOS.tfBuscar.setText("");
        this.modificarPOS.tfID.setText("");
        this.modificarPOS.tfNombre.setText("");
        this.modificarPOS.tfDireccion.setText("");
    }
}
