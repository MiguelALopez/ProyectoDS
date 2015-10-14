/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import Implementacion.ModuloUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ConsultarUsuarios_Eventos 
{
    private ConsultarUsuarios consultarUsuarios;
    private ModuloUsuarios moduloUsuarios;
    
    public ConsultarUsuarios_Eventos(final ConsultarUsuarios consultarUsuarios)
    {
        this.consultarUsuarios = consultarUsuarios;
        this.moduloUsuarios = new ModuloUsuarios();    
        
        consultarUsuarios.bCerrar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        consultarUsuarios.bActualizar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        consultarUsuarios();
                    }
                }
        );
        
        consultarUsuarios.bVerPerfil.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        verPerfil();
                    }
                }
        );
        
        consultarUsuarios.addWindowListener(
                new WindowListener()
                {
                    @Override
                    public void windowOpened(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowClosing(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowClosed(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowIconified(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowDeiconified(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowActivated(WindowEvent we) 
                    {
                        consultarUsuarios();
                    }

                    @Override
                    public void windowDeactivated(WindowEvent we) 
                    {
                        
                    }                    
                }
        );
    }
    
    public void consultarUsuarios()
    {
        moduloUsuarios.consultarUsuarios(consultarUsuarios.tUsuarios);
    }
    
    public void cerrarVentana()
    {
        DefaultTableModel model = (DefaultTableModel) consultarUsuarios.tUsuarios.getModel();
        model.setRowCount(0);
        this.consultarUsuarios.setVisible(false);
    }
    
    public void verPerfil()
    {
        int row = consultarUsuarios.tUsuarios.getSelectedRow();
                        
        if (row != -1)
        {
            String cedula = (String) consultarUsuarios.tUsuarios.getValueAt(row, 0);
            String perfil = moduloUsuarios.consultarUsuario(cedula);
            JTextArea area = new JTextArea(perfil);
            area.setEditable(false);
            JOptionPane.showMessageDialog(consultarUsuarios, area, "Perfil de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(consultarUsuarios, "No ha seleccionado ningun Usuario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
