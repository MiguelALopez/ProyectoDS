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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AndrésFelipe
 */
public class PQRDAO 
{
    ConexionBD conexionBD = new ConexionBD();
    
    public ArrayList<PQR> getListaPQR()
    {
        conexionBD.conectar();
        
        ArrayList<PQR> listaPQR = new ArrayList();
        String query = "SELECT * FROM pqr;";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            while (tabla.next())
            {
                listaPQR.add(new PQR(tabla.getString(1), tabla.getString(2),
                        tabla.getString(3), tabla.getString(4),
                        tabla.getString(5), tabla.getString(6),
                        tabla.getString(7)));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return listaPQR;
    }    
    
    public boolean insertarPQR(PQR pqr)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "INSERT INTO pqr (pqr_numero, pqr_cedula, pqr_nombre, pqr_sede, pqr_tipo, pqr_contenido, pqr_estado)"
                + " VALUES(?,?,?,?,?,?,?);";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            st.setString(1, pqr.getNumero());
            st.setString(2, pqr.getCedula());
            st.setString(3, pqr.getNombre());
            st.setString(4, pqr.getSede());
            st.setString(5, pqr.getTipo());
            st.setString(6, pqr.getContenido());
            st.setString(7, pqr.getEstado());
            
            int resultado = st.executeUpdate();
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return exito;
    }
    
    public boolean modificarPQR(PQR pqr)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "UPDATE pqr SET "
                //+ "pqr_numero = ?,"
                + "pqr_cedula = ?,"
                + "pqr_nombre = ?,"
                + "pqr_sede = ?,"
                + "pqr_tipo = ?,"
                + "pqr_contenido = ?,"
                + "pqr_estado = ?"
                + "WHERE pqr_numero = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            st.setString(1, pqr.getCedula());
            st.setString(2, pqr.getNombre());
            st.setString(3, pqr.getSede());
            st.setString(4, pqr.getTipo());
            st.setString(5, pqr.getContenido());
            st.setString(6, pqr.getEstado());
            st.setString(7, pqr.getNumero());
                        
            int resultado = st.executeUpdate();
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return exito;
    }
    
    public PQR consultarPQR(String pqr_numero)
    {
        conexionBD.conectar();
        
        PQR pqr = null;
        
        String query = "SELECT * FROM pqr "
                + "WHERE pqr_numero='"+pqr_numero+"'";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            if (tabla.next())
            {
                pqr = new PQR(tabla.getString(1), tabla.getString(2),
                        tabla.getString(3), tabla.getString(4),
                        tabla.getString(5), tabla.getString(6),
                        tabla.getString(7));
                
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PQRDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return pqr;
    }
}
