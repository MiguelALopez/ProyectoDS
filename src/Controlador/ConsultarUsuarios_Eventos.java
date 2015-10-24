/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.ConsultarUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ConsultarUsuarios_Eventos 
{
    private ConsultarUsuarios consultarUsuarios;
    private UsuarioDAO usuarioDAO;
    
    public ConsultarUsuarios_Eventos(final ConsultarUsuarios consultarUsuarios)
    {
        this.consultarUsuarios = consultarUsuarios;
        this.usuarioDAO = new UsuarioDAO();
        
        consultarUsuarios.bCerrar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        consultarUsuarios.bActualizar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        consultarUsuarios();
                    }
                }
        );
        
        consultarUsuarios.bVerPerfil.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        verPerfil();
                    }
                }
        );
        
        consultarUsuarios();
    }
    
    public void consultarUsuarios()
    {
        //ArrayList<Usuario> usuarios = usuarioDAO.getListaUsuarios(); // aqui metodo DAO para obtener todos los usuarios de la BD
        ArrayList<Usuario> usuarios = new ArrayList();
        
        // prueba
        Usuario u1 = new Usuario();
        u1.setCedula("1144082592");
        u1.setNombre("Camilo Ruiz Casanova");
        u1.setRol("Gerente");
        u1.setEstado("Activo");
        usuarios.add(u1);
        // fin prueba
        
        DefaultTableModel model = (DefaultTableModel) this.consultarUsuarios.tUsuarios.getModel();
        model.setRowCount(usuarios.size());
        
        for (int i = 0; i < usuarios.size(); i++) 
        {
            this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getCedula(), i, 0);
            this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getNombre(), i, 1);
            this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getRol(), i, 2);
            this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getEstado(), i, 3);
        }
    }
    
    public void cerrarVentana()
    {
        DefaultTableModel model = (DefaultTableModel) consultarUsuarios.tUsuarios.getModel();
        model.setRowCount(0);
        this.consultarUsuarios.setVisible(false);
    }
    
    public void verPerfil()
    {
        int row = consultarUsuarios.tUsuarios.getSelectedRow();
                        
        if (row != -1)
        {
            String cedula = (String) consultarUsuarios.tUsuarios.getValueAt(row, 0);
            String perfil = "";
            
            //Usuario usuario = usuarioDAO.consultarUsuario(cedula);
            Usuario usuario = new Usuario();

            if (usuario != null)
            {
                perfil = "\t\tInformacion del Usuario\t\t\t" + 
                        "\n\nCedula:\t\t" + usuario.getCedula() + "\t\t" +
                        "Nombre:\t" + usuario.getNombre() +
                        "\n\nEstado:\t\t" + usuario.getEstado()+ "\t\t" +
                        "Rol:\t" + usuario.getRol() +
                        "\n\nFecha de Nacimiento:\t" + usuario.getFechaNacimiento() + "\t\t" +
                        "Direccion:\t" + usuario.getDireccion() +
                        "\n\nTelefono:\t\t" + usuario.getTelefono() + "\t\t" +
                        "Celular:\t" + usuario.getCelular() +
                        "\n\nFecha de Incorporacion:\t" + usuario.getFechaIncorporacion() + "\t\t" +
                        "Salario:\t" + usuario.getSalario() +
                        "\n\nCuenta:\t\t" + usuario.getCuenta() + "\t\t" +
                        "Sede:\t" + usuario.getNumeroSede() +
                        "\n";
                
                //System.out.println(perfil);
            }
                        
            JTextArea area = new JTextArea(perfil);
            area.setEditable(false);
            JOptionPane.showMessageDialog(consultarUsuarios, area, "Perfil de Usuario", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(consultarUsuarios, "No ha seleccionado ningun Usuario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
