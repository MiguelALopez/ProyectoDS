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
import Vista.ModificarSede;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarSede_Eventos {

    private ModificarSede modificarSede;

    public ModificarSede_Eventos(final ModificarSede modificarSede) {
        this.modificarSede = modificarSede;

        this.modificarSede.getButtonCancel().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarVentana();
                    }
                }
        );

        this.modificarSede.getButtonBuscarSede().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean existe = buscarSede(modificarSede.getTextNumSede().getText());
                        modificarSede.enableText(existe);
                        if (!existe){
                            JOptionPane.showMessageDialog(null, "La sede no existe");
                        }
                    }
                }
        );

        this.modificarSede.getButtonAccept().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (verificarCampos()) {
                            modificarSede();
                        }else {
                            JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos necesarios");
                        }
                    }
                }
        );
    }

    /**
     * Metodo encargado de buscar una sede y llevar los datos a los textField
     * @param numeroSede es el numero de la sede que se desea buscar
     * @return retorna true si la sede existe o false si no existe
     */
    public boolean buscarSede(String numeroSede){
        boolean existe = false;
        SedeDAO sedeDAO = new SedeDAO();
        Sede sede = sedeDAO.consultarSede(numeroSede);
        if (sede!=null){
            modificarSede.getTextNameSede().setText(sede.getNombre());
            modificarSede.getTextAddress().setText(sede.getDireccion());
            modificarSede.getTextManager().setText(sede.getGerente());
            modificarSede.getTextBudget().setText(sede.getPresupuesto());
            modificarSede.getTextNumTruck().setText(Integer.toString(sede.getCamiones()));
            existe = true;
        }
        return existe;
    }

    public void modificarSede() {
        boolean exito = true;
        Sede sede= new Sede();

        sede.setNumero(modificarSede.getTextNumSede().getText());
        sede.setNombre(modificarSede.getTextNameSede().getText());
        sede.setDireccion(modificarSede.getTextAddress().getText());
        sede.setGerente(modificarSede.getTextManager().getText());
        sede.setPresupuesto(modificarSede.getTextBudget().getText());
        sede.setCamiones(Integer.parseInt(modificarSede.getTextNumTruck().getText()));

        exito = new SedeDAO().modificarSede(sede);
        if (exito){
            JOptionPane.showMessageDialog(null, "La sede fue modificada con exito");
            limpiarCampos();
        }else {
            JOptionPane.showMessageDialog(null, "Error al modificar la sede");
        }
    }

    // Metodo encargado de hacer la ventana invisible y llamar al metodo limpiarCampos
    public void cerrarVentana(){
        modificarSede.setVisible(false);
        limpiarCampos();
    }

    // Metodo encergado de limpiar los campos de la ventana
    public void limpiarCampos(){
        modificarSede.getTextNumSede().setText("");
        modificarSede.getTextNameSede().setText("");
        modificarSede.getTextAddress().setText("");
        modificarSede.getTextManager().setText("");
        modificarSede.getTextBudget().setText("");
        modificarSede.getTextNumTruck().setText("");
        modificarSede.enableText(false);
    }

    public boolean verificarCampos(){
        boolean exito = true;

        if (modificarSede.getTextNumSede().getText().isEmpty() ||
                modificarSede.getTextNameSede().getText().isEmpty() ||
                modificarSede.getTextAddress().getText().isEmpty() ||
                modificarSede.getTextNumTruck().getText().isEmpty()){
            exito = false;

        }
        return exito;
    }
}
