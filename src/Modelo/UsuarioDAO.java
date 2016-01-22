/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: .java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AndresFelipe
 */
public class UsuarioDAO 
{
    ConexionBD conexionBD;
    
    public UsuarioDAO()
    {
        this.conexionBD = new ConexionBD();
    }
        
    public ArrayList<Usuario> getListaUsuarios() 
    {
        conexionBD.conectar();
        
        ArrayList<Usuario> listaUsuarios = null;
        String query = "SELECT * FROM usuario;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            ResultSet tabla = st.executeQuery();
            
            listaUsuarios = new ArrayList();
            
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return listaUsuarios;
    }
    
    public ArrayList<Usuario> getListarGerentes(){
        this.conexionBD.conectar();
        
        ArrayList<Usuario> listaGerentes = null;
        
        String query = "SELECT * FROM usuario WHERE usuario_rol='Gerente'";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            ResultSet tabla = st.executeQuery();
            
            listaGerentes = new ArrayList();
            
            while (tabla.next())
            {
                listaGerentes.add(new Usuario(tabla.getString(1), 
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return listaGerentes;
    }
    
    public Usuario consultarUsuario(String user)
    {
        conexionBD.conectar();
        
        Usuario usuario = null;
        
        String query = "SELECT * "
                + "FROM usuario WHERE usuario_cedula = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
	    st.setString(1, user);
            ResultSet tabla = st.executeQuery();
            
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return usuario;
    }
    
    public boolean insetarUsuario(Usuario usuario)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, usuario_rol, usuario_estado, "
                + "usuario_fecha_nacimiento, usuario_direccion, usuario_telefono, usuario_fecha_incorporacion, "
                + "usuario_salario, usuario_cuenta, usuario_sede_numero) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            st.setString(1, usuario.getCedula());
            st.setString(2, usuario.getPasswd());
            st.setString(3, usuario.getNombre());
	    st.setString(4, usuario.getApellido());
            st.setString(5, usuario.getRol());
            st.setString(6, usuario.getEstado());
            
            if (usuario.getFechaNacimiento().isEmpty())
            {
                st.setNull(7, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(7, usuario.getFechaNacimiento());
            }
            
            if (usuario.getDireccion().isEmpty())
            {
                st.setNull(8, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(8, usuario.getDireccion());
            }
            
            if (usuario.getTelefono().isEmpty())
            {
                st.setNull(9, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(9, usuario.getTelefono());
            }
            
            if (usuario.getFechaIncorporacion().isEmpty())
            {
                st.setNull(10, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(10, usuario.getFechaIncorporacion());
            }
            
            if (usuario.getSalario().isEmpty())
            {
                st.setNull(11, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(11, usuario.getSalario());
            }
            
            if (usuario.getCuenta().isEmpty())
            {
                st.setNull(12, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(12, usuario.getCuenta());
            }
            
            if (usuario.getNumeroSede().isEmpty())
            {
                st.setNull(13, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(13, usuario.getNumeroSede());
            }
            
            int resultado = st.executeUpdate();
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return exito;
    }
    
    public boolean modificarUsuario(Usuario usuario) 
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "UPDATE usuario SET "
                //+ "usuario_cedula = ?,"
                + "usuario_passwd = ?,"
                + "usuario_nombre = ?,"
		+ "usuario_apellido = ?,"
                + "usuario_rol = ?,"
                + "usuario_estado = ?,"
                + "usuario_fecha_nacimiento = ?,"
                + "usuario_direccion = ?,"
                + "usuario_telefono = ?,"
                + "usuario_fecha_incorporacion = ?,"
                + "usuario_salario = ?,"
                + "usuario_cuenta = ?,"
                + "usuario_sede_numero = ?"
                + "WHERE usuario_cedula = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            //st.setString(1, usuario.getCedula());
            st.setString(1, usuario.getPasswd());
            st.setString(2, usuario.getNombre());
	    st.setString(3, usuario.getApellido());
            st.setString(4, usuario.getRol());
            st.setString(5, usuario.getEstado());
            
            if (usuario.getFechaNacimiento().isEmpty())
            {
                st.setNull(6, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(6, usuario.getFechaNacimiento());
            }
            
            if (usuario.getDireccion().isEmpty())
            {
                st.setNull(7, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(7, usuario.getDireccion());
            }
            
            if (usuario.getTelefono().isEmpty())
            {
                st.setNull(8, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(8, usuario.getTelefono());
            }
            
            if (usuario.getFechaIncorporacion().isEmpty())
            {
                st.setNull(9, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(9, usuario.getFechaIncorporacion());
            }
            
            if (usuario.getSalario().isEmpty())
            {
                st.setNull(10, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(10, usuario.getSalario());
            }
            
            if (usuario.getCuenta().isEmpty())
            {
                st.setNull(11, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(11, usuario.getCuenta());
            }
            
            if (usuario.getNumeroSede().isEmpty())
            {
                st.setNull(12, java.sql.Types.VARCHAR);
            }
            else
            {
                st.setString(12, usuario.getNumeroSede());
            }
            
            st.setString(13, usuario.getCedula());
            
            int resultado = st.executeUpdate();
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return exito;
    }
}
