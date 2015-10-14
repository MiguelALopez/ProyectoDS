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
    public void consultarUsuario(String cedula)
    {
        
    }
    
    public void consultarUsuarios(final JTable tabla)
    {
        ArrayList<Usuario> usuarios = new ArrayList<>(); // aqui metodo DAO para obtener todos los usuarios de la BD
        
        // prueba
//        Usuario u1 = new Usuario();
//        u1.setCedula("1144082592");
//        u1.setNombre("Camilo Ruiz Casanova");
//        u1.setSede("Sede Melendez");
//        u1.setEstado("Activo");
//        usuarios.add(u1);
        // fin prueba
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(usuarios.size());
        
        for (int i = 0; i < usuarios.size(); i++) 
        {
            tabla.setValueAt(usuarios.get(i).getCedula(), i, 0);
            tabla.setValueAt(usuarios.get(i).getNombre(), i, 1);
            tabla.setValueAt(usuarios.get(i).getNumeroSede(), i, 2);
            tabla.setValueAt(usuarios.get(i).getEstado(), i, 3);
        }
    }
}
