/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 20-oct-2015
 * Nombre del Archivo: ConsultarSede_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Controlador;

import Modelo.Sede;
import Modelo.SedeDAO;
import Vista.ConsultarSede;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ConsultarSede_Eventos {
    private ConsultarSede consultarSede;

    public ConsultarSede_Eventos(ConsultarSede consultarSede) {
        this.consultarSede = consultarSede;

        cargarDatos(new SedeDAO().consultarSedes());

        this.consultarSede.getButtonCancel().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarVentana();
                    }
                }
        );


    }

    public void cargarDatos(ArrayList<Sede> listaSedes){

            for (int i = 0; i < listaSedes.size(); i++){
                Vector<String> v = new Vector<>();
                v.addElement(listaSedes.get(i).getNumero());
                v.addElement(listaSedes.get(i).getNombre());
                v.addElement(listaSedes.get(i).getGerente());
                v.addElement(listaSedes.get(i).getDireccion());
                consultarSede.getTableModelContent().addRow(v);
            }
    }

    private void cerrarVentana() {
        consultarSede.setVisible(false);
        limpiarCampos();
    }

    private void limpiarCampos() {

    }
}
