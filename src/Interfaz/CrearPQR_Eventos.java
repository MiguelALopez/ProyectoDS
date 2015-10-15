/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Implementacion.PQR;
import Implementacion.PQRDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristian Jurado
 */
public class CrearPQR_Eventos {

    private CrearPQR crearPqr;
    private PQRDAO pqrDAO;
    
    CrearPQR_Eventos(final CrearPQR crearPqr) {
        this.crearPqr = crearPqr;
        this.pqrDAO = new PQRDAO();
        
        crearPqr.bSalir.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    cerrarVentana();
                }
            }
        );
        
        crearPqr.bEnviar.addActionListener(
            new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    crearPQR();
                }
            }
        );
    }
    
    public void crearPQR(){
        String tPQRN = this.crearPqr.TPqrn.getText();
        String tCedula = this.crearPqr.TCedula.getText();
        String tNombre = this.crearPqr.TNombre.getText();
        String tSede = this.crearPqr.TSede.getText();
        String tTipo = this.crearPqr.ComboTipo.getSelectedItem().toString();
        String tContenido = this.crearPqr.TContenido.getText();
        String tEstado = "Nueva";

        
        /*pqrDAO.insertarPQR(
                new PQR(tPQRN,tCedula,tSede,tNombre,tTipo,tContenido,tEstado)
        );*/
    }
    
    public void cerrarVentana()
    {
        this.crearPqr.setVisible(false);
        limpiarCampos();
    }
    
    public void limpiarCampos(){
        this.crearPqr.TPqrn.setText("");
        this.crearPqr.TCedula.setText("");
        this.crearPqr.TNombre.setText("");
        this.crearPqr.TSede.setText("");
        this.crearPqr.TContenido.setText("");
    }
        
}
