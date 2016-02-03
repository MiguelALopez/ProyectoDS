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
 * @author AndrésFelipe
 */
public class PQRDAO 
{
    ConexionBD conexionBD;
    
    public PQRDAO()
    {
        this.conexionBD = new ConexionBD();
    }
    
    public ArrayList<PQR> getListaPQR()
    {
        conexionBD.conectar();
        
        ArrayList<PQR> listaPQR = new ArrayList();
        String query = "SELECT * FROM pqr;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            ResultSet tabla = st.executeQuery();
            
            while (tabla.next())
            {
                listaPQR.add(new PQR(tabla.getString(1), tabla.getString(2),
                        tabla.getString(3), tabla.getString(4),
                        tabla.getString(5), tabla.getString(6),
                        tabla.getString(7), tabla.getString(8)));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return listaPQR;
    }    
    
    public boolean insertarPQR(PQR pqr)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "INSERT INTO pqr (pqr_fecha, pqr_tipo, pqr_contenido, pqr_estado, pqr_cedula, pqr_nombre, pqr_sede)"
                + " VALUES(DATE(?),?,?,?,?,?,?);";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            st.setString(1, pqr.getFecha());
            st.setString(2, pqr.getTipo());
            st.setString(3, pqr.getContenido());
            st.setString(4, pqr.getEstado());
            st.setString(5, pqr.getCedula());
            st.setString(6, pqr.getNombre());
            st.setString(7, pqr.getSede());
            
            int resultado = st.executeUpdate();
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public boolean modificarPQR(PQR pqr)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "UPDATE pqr SET "
                //+ "pqr_numero = ?,"
                + "pqr_fecha = DATE(?),"
                + "pqr_tipo = ?,"
                + "pqr_contenido = ?,"
                + "pqr_estado = ?,"
                + "pqr_cedula = ?,"
                + "pqr_nombre = ?,"
		+ "pqr_sede = ? "
                + "WHERE pqr_numero = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            st.setString(1, pqr.getFecha());
            st.setString(2, pqr.getTipo());
            st.setString(3, pqr.getContenido());
            st.setString(4, pqr.getEstado());
            st.setString(5, pqr.getCedula());
            st.setString(6, pqr.getNombre());
            st.setString(7, pqr.getSede());
	    st.setString(8, pqr.getNumero());
                        
            int resultado = st.executeUpdate();
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public PQR consultarPQR(String pqr_numero)
    {
        conexionBD.conectar();
        
        PQR pqr = null;
        
        String query = "SELECT * FROM pqr "
                + "WHERE pqr_numero = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
	    st.setString(1, pqr_numero);
            ResultSet tabla = st.executeQuery();
            
            if (tabla.next())
            {
                pqr = new PQR(tabla.getString(1), tabla.getString(2),
                        tabla.getString(3), tabla.getString(4),
                        tabla.getString(5), tabla.getString(6),
                        tabla.getString(7), tabla.getString(8));                
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return pqr;
    }
    
    public PQR ultimoPQR(String cedula)
    {
	conexionBD.conectar();
        
        PQR pqr = null;
        
        String query = "SELECT * FROM pqr "
                + "WHERE pqr_numero = (SELECT MAX(pqr_numero) FROM pqr WHERE pqr_cedula = ?);";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
	    st.setString(1, cedula);
            ResultSet tabla = st.executeQuery();
            
            if (tabla.next())
            {
                pqr = new PQR(tabla.getString(1), tabla.getString(2),
                        tabla.getString(3), tabla.getString(4),
                        tabla.getString(5), tabla.getString(6),
                        tabla.getString(7), tabla.getString(8));                
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return pqr;
    }
}
