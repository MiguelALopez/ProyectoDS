/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Fecha: 20-oct-2015
 * Nombre del Archivo: ModificarSede_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Controlador;

import Vista.ModificarSede;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarSede_Eventos {

    private ModificarSede modificarSede;

    public ModificarSede_Eventos(ModificarSede modificarSede) {
        this.modificarSede = modificarSede;

        this.modificarSede.getButtonCancel().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarVentana();
                    }
                }
        );

        this.modificarSede.getButtonAccept().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        modificarSede();
                    }
                }
        );
    }

    private void modificarSede() {

    }

    // Metodo encargado de hacer la ventana invisible y llamar al metodo limpiarCampos
    public void cerrarVentana(){
        modificarSede.setVisible(false);
        limpiarCampos();
    }

    // Metodo encergado de limpiar los campos de la ventana
    private void limpiarCampos(){
        modificarSede.getTextNumSede().setText("");
        modificarSede.getTextNameSede().setText("");
        modificarSede.getTextAddress().setText("");
        modificarSede.getTextManager().setText("");
        modificarSede.getTextBudget().setText("");
        modificarSede.getTextNumTruck().setText("");
    }
}
