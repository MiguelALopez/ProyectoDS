/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Implementacion.PQRDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristian Jurado
 */
public class CrearPqr_Eventos {

    private CrearPqr crearPqr;
    private PQRDAO pqrDAO;
    
    CrearPqr_Eventos(final CrearPqr crearPqr) {
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
    }
    
    public void cerrarVentana()
    {
        this.crearPqr.setVisible(false);
        //limpiarCampos();
    }
    
        
}
