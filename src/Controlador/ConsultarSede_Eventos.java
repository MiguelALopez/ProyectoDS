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

import Modelo.SedeDAO;
import Vista.ConsultarSede;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void cargarDatos(ResultSet tabla){

        try {
            while (tabla != null && tabla.next()){
                Vector<String> v = new Vector<>();
                v.addElement(tabla.getString(1));
                v.addElement(tabla.getString(2));
                v.addElement(tabla.getString(3));
                v.addElement(tabla.getString(4));
                consultarSede.getTableModelContent().addRow(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void cerrarVentana() {
        consultarSede.setVisible(false);
        limpiarCampos();
    }

    private void limpiarCampos() {

    }
}
