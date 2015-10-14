/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Implementacion;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ModuloUsuarios 
{
    UsuarioDAO usuarioDAO;
    
    public ModuloUsuarios()
    {
        usuarioDAO = new UsuarioDAO();
    }
    
    public String consultarUsuario(final String cedula)
    {
        //Usuario usuario = usuarioDAO.consultarUsuario(cedula);
        Usuario usuario = new Usuario();
        
        if (usuario != null)
        {
            String perfil;
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
            
            return perfil;
        }
        else
        {
            return null;
        }
    }
    
    public void consultarUsuarios(final JTable tabla)
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
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(usuarios.size());
        
        for (int i = 0; i < usuarios.size(); i++) 
        {
            tabla.setValueAt(usuarios.get(i).getCedula(), i, 0);
            tabla.setValueAt(usuarios.get(i).getNombre(), i, 1);
            tabla.setValueAt(usuarios.get(i).getRol(), i, 2);
            tabla.setValueAt(usuarios.get(i).getEstado(), i, 3);
        }
    }
}
