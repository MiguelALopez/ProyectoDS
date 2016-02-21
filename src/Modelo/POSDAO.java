/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: POSDAO.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class POSDAO 
{
    ConexionBD conexionBD;
    
    public POSDAO()
    {
        this.conexionBD = new ConexionBD();
    }
    
    public ArrayList<POS> getListaPOS()
    {
        conexionBD.conectar();
        
        ArrayList<POS> listaPOS = null;
        String query = "SELECT * FROM pos;";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            listaPOS = new ArrayList();
            
            while (tabla.next())
            {
                listaPOS.add(new POS(tabla.getString(1), tabla.getString(2),
                        tabla.getString(3)));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return listaPOS;
    }    
    
    public boolean insertarPOS(POS pos)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "INSERT INTO pos (pos_id, pos_nombre, pos_direccion)"
                + " VALUES(?,?,?);";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            st.setString(1, pos.getId());
            st.setString(2, pos.getNombre());
            st.setString(3, pos.getDireccion());
            
            int resultado = st.executeUpdate();
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public boolean modificarPOS(POS pos)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "UPDATE pos SET "
                //+ "pos_id = ?,"
                + "pos_nombre = ?,"
                + "pos_direccion = ?"
                + "WHERE pos_id = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            st.setString(3, pos.getId());
            st.setString(1, pos.getNombre());
            st.setString(2, pos.getDireccion());
                        
            int resultado = st.executeUpdate();
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public POS consultarPOS(String pos_id)
    {
        conexionBD.conectar();
        
        POS pos = null;
        
        String query = "SELECT * FROM pos "
                + "WHERE pos_id = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            st.setString(1, pos_id);
            ResultSet tabla = st.executeQuery();
            
            if (tabla.next())
            {
                pos = new POS(tabla.getString(1), tabla.getString(2),
                        tabla.getString(3));                
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return pos;
    }
}
