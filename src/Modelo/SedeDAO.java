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

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SedeDAO
{
    ConexionBD conexionBD;
    
    public SedeDAO()
    {
        this.conexionBD = new ConexionBD();
    }

    public ArrayList<Sede> getListaSedes()
    {
        conexionBD.conectar();        
        ArrayList<Sede> listaSedes = null;
        
        String query = "SELECT * FROM sede;";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            listaSedes = new ArrayList();
            
            while (tabla.next())
            {
                listaSedes.add(new Sede(tabla.getString(1), tabla.getString(2), tabla.getString(3),
                        tabla.getString(4), tabla.getString(5), tabla.getInt(6)));  
            }        
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return listaSedes;
    }
    
    public Sede consultarSede(String sede_numero)
    {
        conexionBD.conectar();
        Sede sede = null;
        
        String query = "SELECT * "
                + "FROM sede "
                + "WHERE sede_numero = ?;";
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
	    st.setString(1, sede_numero);
            ResultSet tabla = st.executeQuery();

            if (tabla.next())
            {
                sede = new Sede(tabla.getString(1), tabla.getString(2), tabla.getString(3), 
			tabla.getString(4), tabla.getString(5), tabla.getInt(6));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return sede;
    }

    /* Metodo encargado de insertar una sede en la base de datos retorna un true si la
    * operacion es exitosa y un false de lo contrario*/
    public boolean insertarSede(Sede sede)
    {        
        conexionBD.conectar();
        boolean exitoso = false;
        
        if (conexionBD.conexion != null) 
        {
	    PreparedStatement consulta;
	    // La consulta se hace de esta forma para evitar inserciones SQL
	    String insertSQL = "INSERT INTO sede " +
		    "(sede_numero, sede_nombre, sede_direccion, sede_ciudad, sede_gerente, sede_cant_camiones) " +
		    "VALUES (?, ?, ?, ?, ?, ?);";
	    try 
	    {
		consulta = conexionBD.conexion.prepareStatement(insertSQL);

		consulta.setString(1, sede.getNumero());
		consulta.setString(2, sede.getNombre());
		consulta.setString(3, sede.getDireccion());
		consulta.setString(4, sede.getCiudad());
		
		if (!sede.getGerente().isEmpty())
		{
		    consulta.setString(5, sede.getGerente());
		}
		else 
		{
		    consulta.setNull(5, Types.VARCHAR);
		}		
		
		consulta.setInt(6, sede.getCamiones());

		consulta.executeUpdate();
		exitoso = true;
	    } 
	    catch (SQLException ex) 
	    {
		Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    finally
	    {
		if (conexionBD != null)
		{
		    conexionBD.cerrarConexion();
		}
	    }
        }
        
        return exitoso;
    }
    
    public boolean modificarSede(Sede sede)
    {        
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "UPDATE sede SET " +
                "sede_nombre = ?, " +
		"sede_direccion = ?, " +
		"sede_ciudad = ?, " +
                "sede_gerente = ?, " +
                "sede_cant_camiones = ? " +                
                "WHERE sede_numero = ?;";
        
        try
        {
            PreparedStatement preparedStatement = conexionBD.conexion.prepareStatement(query);
            
            
	    preparedStatement.setString(1, sede.getNombre());
	    preparedStatement.setString(2, sede.getDireccion());
	    preparedStatement.setString(3, sede.getCiudad());
            
            if (!sede.getGerente().isEmpty())
	    {
                preparedStatement.setString(4, sede.getGerente());
            }
	    else 
	    {
                preparedStatement.setNull(4, Types.VARCHAR);
            }
            
            preparedStatement.setInt(5, sede.getCamiones());
            preparedStatement.setString(6, sede.getNumero());
            
            preparedStatement.executeUpdate();
            exito = true;
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(SedeDAO.class.getName()).log(Level.SEVERE, null, ex);
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
