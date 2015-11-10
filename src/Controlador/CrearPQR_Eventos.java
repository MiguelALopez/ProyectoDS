/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.PQR;
import Modelo.PQRDAO;
import Modelo.Sede;
import Modelo.SedeDAO;
import Vista.CrearPQR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Jurado
 */
public class CrearPQR_Eventos 
{
    private CrearPQR crearPQR;
    private PQRDAO pqrDAO;
    private SedeDAO sedeDAO;
    
    public CrearPQR_Eventos(final CrearPQR crearPQR) 
    {
        this.crearPQR = crearPQR;
        this.pqrDAO = new PQRDAO();
        this.sedeDAO = new SedeDAO();
        
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
        
        actualizarSedes();
    }
    
    public void crearPQR()
    {
        String numeroPQR = this.crearPQR.TPqrn.getText();
        String cedula = this.crearPQR.TCedula.getText();
        String nombre = this.crearPQR.TNombre.getText();
        String sede = (String) this.crearPQR.cbSedes.getSelectedItem();
        String tipo = this.crearPQR.ComboTipo.getSelectedItem().toString();
        String contenido = this.crearPQR.TContenido.getText();

        PQR nuevoPQR = new PQR(numeroPQR, cedula, nombre, sede, tipo, contenido);
        
        boolean verificar = verificarCamposCrearPQR(nuevoPQR);
        
        if (verificar)
        {
            int op = JOptionPane.showConfirmDialog(crearPQR, "Desea realizar el PQR N° " + numeroPQR + "?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (op == JOptionPane.YES_OPTION)
            {
                boolean resultado = pqrDAO.insertarPQR(nuevoPQR);
        
                if (resultado)
                {
                    JOptionPane.showMessageDialog(crearPQR, "PQR N°" + numeroPQR + " creado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(crearPQR, "Error al crear el PQR.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public boolean verificarCamposCrearPQR(PQR pqr)
    {
        if (pqr.getNumero().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPQR, "El campo PQR N° es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (pqr.getCedula().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPQR, "El campo Cedula es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (pqr.getNombre().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPQR, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (pqr.getContenido().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPQR, "El campo Contenido es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
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
        this.crearPQR.cbSedes.setSelectedIndex(0);
        this.crearPQR.ComboTipo.setSelectedIndex(0);
        this.crearPQR.TContenido.setText("");
    }
    
    public void actualizarSedes()
    {
        crearPQR.cbSedes.removeAllItems();
        
        ArrayList<Sede> sedes = sedeDAO.consultarSedes();
        //ArrayList<Sede> sedes = new ArrayList();
        
        for (int i = 0; i < sedes.size(); i++) 
        {
            crearPQR.cbSedes.addItem(sedes.get(i).getNumero());            
        }
    }
}
