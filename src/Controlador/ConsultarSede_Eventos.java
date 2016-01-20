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
import Vista.ConsultarSede;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class ConsultarSede_Eventos 
{
    private final ConsultarSede consultarSede;

    public ConsultarSede_Eventos(ConsultarSede consultarSede) 
    {
        this.consultarSede = consultarSede;

        cargarDatos();

        this.consultarSede.getButtonCancel().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarVentana();
                    }
                }
        );
    }

    private void cargarDatos()
    {       
        ArrayList<Sede> listaSedes = new SedeDAO().getListaSedes();
        
        if (listaSedes != null)
        {
            for (int i = 0; i < listaSedes.size(); i++)
            {
                Vector<String> v = new Vector<>();
                v.addElement(listaSedes.get(i).getNumero());
                v.addElement(listaSedes.get(i).getNombre());
                v.addElement(listaSedes.get(i).getGerente());
                v.addElement(listaSedes.get(i).getDireccion());
                v.addElement(listaSedes.get(i).getPresupuesto());
                v.addElement(Integer.toString(listaSedes.get(i).getCamiones()));
                consultarSede.getTableModelContent().addRow(v);
            }
        }
    }

    public void cerrarVentana() 
    {
        consultarSede.setVisible(false);
    }
}
