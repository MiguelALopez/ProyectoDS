/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Vista.CrearPOS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class CrearPOS_Eventos 
{
    private final CrearPOS crearPOS;
    
    public CrearPOS_Eventos(final CrearPOS crearPOS)
    {
        this.crearPOS = crearPOS;
        
        crearPOS.bCrearPOS.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    crearPOS();
                }
            }
        );
    }
    
    public void crearPOS()
    {
        if (verificarCampos())
        {
            String id = this.crearPOS.tfID.getText();
            String nombre = this.crearPOS.tfNombre.getText();
            String direccion = this.crearPOS.tfDireccion.getText();
            
            POS pos = new POS(id, nombre, direccion);
            
            int op = JOptionPane.showConfirmDialog(crearPOS, "Desea crear el POS " + id + "?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (op == JOptionPane.YES_OPTION)
            {
                boolean exito = new POSDAO().insertarPOS(pos);
                
                if (exito)
                {
                    JOptionPane.showMessageDialog(crearPOS, "POS " + id + " creado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(crearPOS, "Error al crear el POS.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public boolean verificarCampos()
    {
        if (this.crearPOS.tfID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPOS, "Campo ID obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (this.crearPOS.tfNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPOS, "Campo Nombre obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (this.crearPOS.tfDireccion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPOS, "Campo Direccion obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public void limpiarCampos()
    {
        this.crearPOS.tfID.setText("");
        this.crearPOS.tfNombre.setText("");
        this.crearPOS.tfDireccion.setText("");
    }
}