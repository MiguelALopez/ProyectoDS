/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AndrésFelipe
 */
public class UsuarioDAO 
{
    private ArrayList<Usuario> listaUsuarios;
    ConexionBD conexionBD = new ConexionBD();
    //Connection conexion;
        
    public ArrayList<Usuario> getListaUsuarios() 
    {
        conexionBD.conectar();
        listaUsuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            if (tabla.next())
            {
                listaUsuarios.add(new Usuario(tabla.getString(0), 
                        tabla.getString(1), tabla.getString(2), 
                        tabla.getString(3), tabla.getString(4), 
                        tabla.getString(5),tabla.getString(6), 
                        tabla.getString(7), tabla.getString(8), 
                        tabla.getString(9), tabla.getString(10), 
                        tabla.getString(11), tabla.getString(12)));                
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
        String query = "SELECT * "
                + "FROM usuarios WHERE user_cedula='"+user+"';";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            if (tabla.next())
            {
                return new Usuario(tabla.getString(0), tabla.getString(1), 
                        tabla.getString(2), tabla.getString(3), 
                        tabla.getString(4), tabla.getString(5), 
                        tabla.getString(6), tabla.getString(7), 
                        tabla.getString(8), tabla.getString(9), 
                        tabla.getString(10), tabla.getString(11),
                        tabla.getString(12));                
            }
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexionBD.cerrarConexion();
        return null;
    }
    
    public void insetarUsuario(Usuario usr)
    {
        conexionBD.conectar();
        String query = "INSERT INTO usuarios VALUES ('"
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
                + usr.getNumeroSede()+ "','"
                + usr.getCuenta()+ "');";        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            int tabla = st.executeUpdate(query);            
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexionBD.cerrarConexion();
    }
    public void modificarUsuario(Usuario usr) {
        conexionBD.conectar();
        String query = "UPDATE usuarios SET "
                //+ "user_cedula='" + usr.getCedula() + "', "
                + "user_passwd='" + usr.getPasswd()+ "', "
                + "user_nombre='" + usr.getNombre()+ "', "
                + "user_rol='" + usr.getRol()+ "', "
                + "user_estado='" + usr.getEstado()+ "', "
                + "user_fecha_nacimiento='" + usr.getFechaNacimiento()+ "', "
                + "user_direccion='" + usr.getDireccion()+ "', "
                + "user_telefono='" + usr.getTelefono()+ "', "
                + "user_celular='" + usr.getCelular()+ "', "
                + "user_fecha_incorporacion='" + usr.getFechaIncorporacion()+ "', "
                + "user_salario='" + usr.getSalario()+ "', "
                + "user_sede_id='" + usr.getNumeroSede()+ "', "
                + "user_cuenta='" + usr.getCuenta()+ "' "
                + "WHERE user_cedula='" + usr.getCedula() +"'";
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            int tabla = st.executeUpdate(query);            
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexionBD.cerrarConexion();
    }
    
}
