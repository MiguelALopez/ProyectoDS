/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AndrésFelipe
 */
public class UsuarioDAO {
    private Usuario[]  listaUsuarios;
    ConexionBD fachada;
    Connection conexion;
    
    
    public Usuario[] getListaUsuarios() {
        
        return listaUsuarios;
    }
    
    public Usuario consultarUsuario(String user)
    {
        String query = "SELECT user_passwd, user_estado, user_name, user_rol "
                + "FROM usuarios WHERE user_cedula='"+user+"' AND "
                + "user_estado='Activo';";
        
        
        
        try
        {
            Statement st = conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            if (tabla.next())
            {
                return new Usuario(tabla.getString(0), tabla.getString(1), 
                        tabla.getString(2), tabla.getString(3), 
                        tabla.getString(4), tabla.getString(5), 
                        tabla.getString(6), tabla.getString(7), 
                        tabla.getString(8), tabla.getString(9), 
                        tabla.getString(10), tabla.getString(11));
                
            }
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return new Usuario();
        
        
    }
    
}
