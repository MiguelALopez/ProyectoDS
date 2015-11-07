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
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Jurado
 */
public class CrearPQR_Eventos 
{
    private CrearPQR crearPQR;
    private PQRDAO pqrDAO;
    
    public CrearPQR_Eventos(final CrearPQR crearPQR) 
    {
        this.crearPQR = crearPQR;
        this.pqrDAO = new PQRDAO();
        
        crearPQR.bSalir.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    cerrarVentana();
                }
            }
        );
        
        crearPQR.bEnviar.addActionListener(
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
        String numeroPQR = this.crearPQR.TPqrn.getText();
        String cedula = this.crearPQR.TCedula.getText();
        String nombre = this.crearPQR.TNombre.getText();
        String sede = this.crearPQR.TSede.getText();
        String tipo = this.crearPQR.ComboTipo.getSelectedItem().toString();
        String contenido = this.crearPQR.TContenido.getText();
        String estado = "Nueva";
        
        PQR nuevoPQR = new PQR(numeroPQR, cedula, nombre, sede, tipo, contenido, estado);
        //PQR nuevoPQR = new PQR();
        
        boolean resultado = pqrDAO.insertarPQR(nuevoPQR);
        
        if (resultado)
        {
            JOptionPane.showMessageDialog(crearPQR, "PQR " + numeroPQR + " creado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
        else
        {
            JOptionPane.showMessageDialog(crearPQR, "Error al crear el PQR.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
