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
                    bSelGerente();
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
    
    public void bCancelarMain(){
        borrarCampos();
        this.crearSedeOpe.setVisible(false);
        this.crearSedeOpe.jfSelGerente.setVisible(false);
    }
    
    public void bCancelar()
    {
        this.crearSedeOpe.jfSelGerente.setVisible(false);
    }
    
    public void bListGerentes()
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
            
            this.crearSedeOpe.jfSelGerente.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(crearSedeOpe, "No existen gerentes en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void bSelGerente()
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
        
    }
    
}
