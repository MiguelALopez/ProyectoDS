/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Fecha: 20-oct-2015
 * Nombre del Archivo: CrearSede_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Controlador;

import Modelo.Sede;
import Modelo.SedeDAO;
import Vista.CrearSede;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearSede_Eventos {
    private CrearSede crearSede;

    
    public CrearSede_Eventos(final CrearSede crearSede){
        this.crearSede = crearSede;

        // Eventos para el boton de Cancelar
        this.crearSede.getButtonCancel().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarVentana();
                    }
                }
        );
        // Eventos para el boton de Crear
        this.crearSede.getButtonCreate().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (verificarCampos()){
                            crearSede();
                            crearSede.setVisible(false);
                        }else {
                            JOptionPane.showMessageDialog(null, "Por favor llene los campos necesarios");
                        }
                    }
                }
        );
    }

    //Metodo encargado de crear una nueva sede y añadirla a la Base de Datos
    public void crearSede(){
        String numSede = crearSede.getTextNumSede().getText();
        String nameSede = crearSede.getTextNameSede().getText();
        String address = crearSede.getTextAddress().getText();

        Sede sede = new Sede(numSede, nameSede, address);
        // Se verifica si se creo la sede con exito
        if (new SedeDAO().insertarSede(sede)){
            JOptionPane.showMessageDialog(null, "La sede a sido creada exitosamente");
        }else {
            JOptionPane.showMessageDialog(null, "Error al crear la sede");
        }


    }

    // Metodo encargado de hacer la ventana invisible y llamar al metodo limpiarCampos
    public void cerrarVentana(){
        crearSede.setVisible(false);
        limpiarCampos();
    }

    // Metodo encergado de limpiar los campos de la ventana
    public void limpiarCampos(){
        crearSede.getTextNumSede().setText("");
        crearSede.getTextNameSede().setText("");
        crearSede.getTextAddress().setText("");
    }

    public boolean verificarCampos(){
        boolean exito = true;

        if (crearSede.getTextNumSede().getText().isEmpty() ||
                crearSede.getTextNameSede().getText().isEmpty() ||
                crearSede.getTextAddress().getText().isEmpty()){
            exito = false;

        }
        return exito;
    }

}
