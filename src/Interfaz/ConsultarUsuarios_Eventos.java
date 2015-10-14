/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ConsultarUsuarios_Eventos 
{
    private ConsultarUsuarios consultarUsuarios;
    
    public ConsultarUsuarios_Eventos(final ConsultarUsuarios consultarUsuarios)
    {
        this.consultarUsuarios = consultarUsuarios;
        
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
        
        consultarUsuarios.bVerPerfil.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        
                    }
                }
        );
    }
    
    public void cerrarVentana()
    {
        DefaultTableModel model = (DefaultTableModel) consultarUsuarios.tUsuarios.getModel();
        model.setRowCount(0);
        this.consultarUsuarios.setVisible(false);
    }
}
