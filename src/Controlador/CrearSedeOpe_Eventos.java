/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Andresf01<andres.felipe.martinez@correounivalle.edu.co>
 */
import Modelo.Sede;
import Modelo.SedeDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.CrearSedeOpe;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CrearSedeOpe_Eventos 
{
    private CrearSedeOpe crearSedeOpe;
    
    public CrearSedeOpe_Eventos(final CrearSedeOpe crearSedeOpe)
    {
        this.crearSedeOpe = crearSedeOpe;
        
        this.crearSedeOpe.bCancelarMain.addActionListener(
            new ActionListener() 
            {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    bCancelarMain();
                }
            }
        );
        
        this.crearSedeOpe.bSelGerente.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    ListGerentes();
                }
            }
        );
        
        this.crearSedeOpe.bSeleccionar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    SeleccionGerente();
                }
            }
        );
        
        this.crearSedeOpe.bAgregar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    bAgregarSede();
                }
            }
        );
        
        this.crearSedeOpe.bCancelar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    bCancelar();
                }
            }
        );
        
    }
    
    public void bAgregarSede(){
        if(validaCampos())
        {
            String numero, nombre, direccion;
            numero = this.crearSedeOpe.tNumero.getText();
            nombre = this.crearSedeOpe.tNombre.getText();
            direccion = this.crearSedeOpe.tDireccion.getText();
            
            SedeDAO daoSede = new SedeDAO();
            
            Sede antigua = daoSede.consultarSede(numero);
            
            if(antigua != null)
            {
                JOptionPane.showMessageDialog(crearSedeOpe, "La sede "+numero+" ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                int go = JOptionPane.showConfirmDialog(crearSedeOpe, "Seguro desea agregar la sede "+ numero, "Confirmación", JOptionPane.YES_NO_OPTION);
            
                if(go == JOptionPane.YES_OPTION)
                {
                    String presupuesto="", gerente="", ciudad="";
                    presupuesto = this.crearSedeOpe.tPresupuesto.getText();
                    ciudad = this.crearSedeOpe.cbCiudad.getSelectedItem().toString();
                    gerente = this.crearSedeOpe.tGerente.getText();

                    Sede sede = new Sede(numero, nombre, gerente, presupuesto, 0, direccion, ciudad);

                    daoSede.insertarSede(sede);

                    borrarCampos();
                }
            }
            
            
            
            
            
            
        }
        
    }
    
    public void bCancelarMain(){
        borrarCampos();
        this.crearSedeOpe.setVisible(false);
        this.crearSedeOpe.jfSelGerente.setVisible(false);
    }
    
    public void bCancelar()
    {
        this.crearSedeOpe.jfSelGerente.setVisible(false);
    }
    
    public void ListGerentes()
    {
        ArrayList<Usuario> listaGerentes = null;
        
        UsuarioDAO consulta = new UsuarioDAO();
        
        if((listaGerentes = consulta.getListarGerentes()) != null)
        {
            DefaultTableModel model = (DefaultTableModel) this.crearSedeOpe.tGerentes.getModel();
            model.setRowCount(listaGerentes.size());
            
            for (int i = 0; i < listaGerentes.size(); i++) 
            {
                this.crearSedeOpe.tGerentes.setValueAt(listaGerentes.get(i).getCedula(), i, 0);
                this.crearSedeOpe.tGerentes.setValueAt(listaGerentes.get(i).getNombre(), i, 1);
                this.crearSedeOpe.tGerentes.setValueAt(listaGerentes.get(i).getApellido(), i, 2);
            }
            
            this.crearSedeOpe.jfSelGerente.setLocationRelativeTo(crearSedeOpe);
            this.crearSedeOpe.jfSelGerente.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(crearSedeOpe, "No existen gerentes en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void SeleccionGerente()
    {
        int row = this.crearSedeOpe.tGerentes.getSelectedRow();
        
        if(row != -1)
        {
            this.crearSedeOpe.tGerente.setText((String) this.crearSedeOpe.tGerentes.getValueAt(row, 0));
            
            DefaultTableModel model = (DefaultTableModel) this.crearSedeOpe.tGerentes.getModel();
            model.setRowCount(0);
            
            this.crearSedeOpe.jfSelGerente.setVisible(false);
        }
    }
    
    public void borrarCampos()
    {
        this.crearSedeOpe.tDireccion.setText("");
        this.crearSedeOpe.tGerente.setText("");
        this.crearSedeOpe.tNombre.setText("");
        this.crearSedeOpe.tNumero.setText("");
        this.crearSedeOpe.tPresupuesto.setText("");
    }
    
    public boolean validaCampos()
    {
        String error="";
        if(this.crearSedeOpe.tNumero.getText().isEmpty())
        {
            error += "\n* Numero de Sede";
        }
        
        if(this.crearSedeOpe.tNombre.getText().isEmpty())
        {
            error += "\n* Nombre de Sede";
        }
        
        if(this.crearSedeOpe.tDireccion.getText().isEmpty())
        {
            error += "\n* Dirección de Sede";
        }
        
        if(error.length() > 1)
        {
            error = "Por favor verificar los siguientes campos" + error;
            JOptionPane.showMessageDialog(crearSedeOpe, error,"Digite los campos obligatorios",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
}
