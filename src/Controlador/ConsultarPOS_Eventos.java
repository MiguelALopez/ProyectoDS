/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Vista.ConsultarPOS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ConsultarPOS_Eventos 
{
    private final ConsultarPOS consultarPOS;
    
    public ConsultarPOS_Eventos(final ConsultarPOS consultarPOS)
    {
        this.consultarPOS = consultarPOS;
        
        consultarPOS.bCerrar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        consultarPOS.bActualizar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        consultarPOS();
                    }
                }
        );
        
        consultarPOS();
    }
    
    public void cerrarVentana()
    {
        this.consultarPOS.setVisible(false);
    }
    
    private void consultarPOS()  
    {
        ArrayList<POS> listaPOS = new POSDAO().getListaPOS(); // aqui metodo DAO para obtener todos los POS de la BD
        //ArrayList<POS> listaPOS = new ArrayList();
        
        DefaultTableModel model = (DefaultTableModel) this.consultarPOS.tPOS.getModel();
        model.setRowCount(listaPOS.size());
        
        for (int i = 0; i < listaPOS.size(); i++) 
        {
            this.consultarPOS.tPOS.setValueAt(listaPOS.get(i).getId(), i, 0);
            this.consultarPOS.tPOS.setValueAt(listaPOS.get(i).getNombre(), i, 1);
            this.consultarPOS.tPOS.setValueAt(listaPOS.get(i).getDireccion(), i, 2);
        }
    }
}
