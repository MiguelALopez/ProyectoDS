/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: UsuarioDAO.java
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
 * clase encargada de la conexion a la base de datos donde se solicitara la lista
 * de Usuarios , Modificacion de Usuarios y Agregacion de Usuarios
 */
public class UsuarioDAO 
{
    ConexionBD conexionBD;
     /***
     * Constructor donde se creara una nueva conexion a la base de datos
     */
    public UsuarioDAO()
    {
        this.conexionBD = new ConexionBD();
    }
    /***
     * Metodo donde se solicitara la Lista de Usuarios a la base de datos 
     */   
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
    /***
     * Metodo donde se solicitara la Lista de Usuarios a la base de datos
     * posteriormente se realizara una consulta y se generara la lista 
     * exclusiva de Gerentes y se retornara
     */
    public ArrayList<Usuario> getListaGerentes(){
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
    /***
     * Metodo donde se consultara un usuario ya creado en la base de datos y
     * se retornara
     * @param user : cedula del usuario que se desea consultar en 
     * la base de datos
     */
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
    /***
     * Metodo donde se insertara un usuario nuevo en la base de datos 
     * retornando el exito o fracaso de la funcion
     * @param usuario : usuario el cual se desea insertar en la base de datos
     */
    public boolean insetarUsuario(Usuario usuario)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "INSERT INTO usuario (usuario_cedula, usuario_passwd, usuario_nombre, usuario_apellido, "
		+ "usuario_rol, usuario_estado, usuario_fecha_nacimiento, usuario_direccion, usuario_telefono, "
		+ "usuario_fecha_incorporacion, usuario_salario, usuario_cuenta, usuario_sede_numero) "
		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
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
    /***
     * Metodo donde se modificara un usuario ya creado en la base de datos 
     * @param usuario : usuario el cual se desea modificar
     */
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
