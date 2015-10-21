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

import Vista.ConsultarSede;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarSede_Eventos {
    private ConsultarSede consultarSede;

    public ConsultarSede_Eventos(ConsultarSede consultarSede) {
        this.consultarSede = consultarSede;

        this.consultarSede.getButtonCancel().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarVentana();
                    }
                }
        );
    }

    private void cerrarVentana() {
        consultarSede.setVisible(false);
        limpiarCampos();
    }

    private void limpiarCampos() {

    }
}
