/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AndrésFelipe
 */
public class UsuarioDAO 
{
    ConexionBD conexionBD = new ConexionBD();
        
    public ArrayList<Usuario> getListaUsuarios() 
    {
        conexionBD.conectar();
        
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        String query = "SELECT * FROM usuario;";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            while (tabla.next())
            {
                listaUsuarios.add(new Usuario(tabla.getString(1), 
                        tabla.getString(2), tabla.getString(3), 
                        tabla.getString(4), tabla.getString(5), 
                        tabla.getString(6), tabla.getString(7), 
                        tabla.getString(8), tabla.getString(9), 
                        tabla.getString(10), tabla.getString(11), 
                        tabla.getString(12), tabla.getString(13)));                
            }        
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return listaUsuarios;
    }
    
    public Usuario consultarUsuario(String user)
    {
        conexionBD.conectar();
        
        Usuario usuario = null;
        
        String query = "SELECT * "
                + "FROM usuario WHERE usuario_cedula='"+user+"';";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            if (tabla.next())
            {
                usuario = new Usuario(tabla.getString(1), 
                        tabla.getString(2), tabla.getString(3), 
                        tabla.getString(4), tabla.getString(5), 
                        tabla.getString(6),tabla.getString(7), 
                        tabla.getString(8), tabla.getString(9), 
                        tabla.getString(10), tabla.getString(11), 
                        tabla.getString(12), tabla.getString(13));                
            }
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return usuario;
    }
    
    public boolean insetarUsuario(Usuario usr)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "INSERT INTO usuario VALUES ('"
                + usr.getCedula()+ "','"
                + usr.getPasswd() + "','"
                + usr.getNombre()+ "','"
                + usr.getRol()+ "','"
                + usr.getEstado()+ "','"
                + usr.getFechaNacimiento()+ "','"
                + usr.getDireccion()+ "','"
                + usr.getTelefono()+ "','"
                + usr.getCelular()+ "','"
                + usr.getFechaIncorporacion()+ "','"
                + usr.getSalario()+ "','"
                + usr.getCuenta()+ "','"
                + usr.getNumeroSede()+ "');";        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            int tabla = st.executeUpdate(query);
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return exito;
    }
    
    public boolean modificarUsuario(Usuario usr) 
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "UPDATE usuario SET "
                //+ "usuario_cedula='" + usr.getCedula() + "', "
                + "usuario_passwd='" + usr.getPasswd()+ "', "
                + "usuario_nombre='" + usr.getNombre()+ "', "
                + "usuario_rol='" + usr.getRol()+ "', "
                + "usuario_estado='" + usr.getEstado()+ "', "
                + "usuario_fecha_nacimiento='" + usr.getFechaNacimiento()+ "', "
                + "usuario_direccion='" + usr.getDireccion()+ "', "
                + "usuario_telefono='" + usr.getTelefono()+ "', "
                + "usuario_celular='" + usr.getCelular()+ "', "
                + "usuario_fecha_incorporacion='" + usr.getFechaIncorporacion()+ "', "
                + "usuario_salario='" + usr.getSalario()+ "', "
                + "usuario_sede_numero='" + usr.getNumeroSede()+ "', "
                + "usuario_cuenta='" + usr.getCuenta()+ "' "
                + "WHERE usuario_cedula='" + usr.getCedula() +"';";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            int tabla = st.executeUpdate(query);
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return exito;
    }    
}
