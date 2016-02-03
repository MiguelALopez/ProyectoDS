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
        
        if (listaPOS != null)
        {
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
}
