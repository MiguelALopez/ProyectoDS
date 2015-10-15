/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.PQR;
import Modelo.PQRDAO;
import Vista.CrearPQR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristian Jurado
 */
public class CrearPQR_Eventos 
{
    private CrearPQR crearPQR;
    private PQRDAO pqrDAO;
    
    public CrearPQR_Eventos(final CrearPQR crearPqr) 
    {
        this.crearPQR = crearPqr;
        this.pqrDAO = new PQRDAO();
        
        crearPqr.bSalir.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    cerrarVentana();
                }
            }
        );
        
        crearPqr.bEnviar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    crearPQR();
                }
            }
        );
    }
    
    public void crearPQR()
    {
        String tPQRN = this.crearPQR.TPqrn.getText();
        String tCedula = this.crearPQR.TCedula.getText();
        String tNombre = this.crearPQR.TNombre.getText();
        String tSede = this.crearPQR.TSede.getText();
        String tTipo = this.crearPQR.ComboTipo.getSelectedItem().toString();
        String tContenido = this.crearPQR.TContenido.getText();
        String tEstado = "Nueva";
        
        /*pqrDAO.insertarPQR(
                new PQR(tPQRN,tCedula,tSede,tNombre,tTipo,tContenido,tEstado)
        );*/
    }
    
    public void cerrarVentana()
    {
        this.crearPQR.setVisible(false);
        limpiarCampos();
    }
    
    public void limpiarCampos()
    {
        this.crearPQR.TPqrn.setText("");
        this.crearPQR.TCedula.setText("");
        this.crearPQR.TNombre.setText("");
        this.crearPQR.TSede.setText("");
        this.crearPQR.TContenido.setText("");
    }        
}
