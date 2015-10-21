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
/**
 *
 * @author AndrésFelipe
 */
public class PQRDAO 
{
    ConexionBD conexionBD = new ConexionBD();
    
    public ArrayList<PQR> getListaUsuarios() 
    {
        conexionBD.conectar();
        
        ArrayList<PQR> listaPQR = new ArrayList();
        String query = "SELECT * FROM usuarios";
        
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
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return listaPQR;
    }    
    
    public boolean insertarPQR(PQR item)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "INSERT INTO pqr VALUES('"
                + item.getNumero() + "', '"
                + item.getCedula()+ "', '"
                + item.getNombre()+ "', '"
                + item.getSede()+ "', '"
                + item.getTipo()+ "', '"
                + item.getContenido()+ "') ";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            int tabla = st.executeUpdate(query);
            exito = true;
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return exito;
    }
    
    public boolean modificarPQR(PQR item)
    {
        conexionBD.conectar();
        boolean exito = false;
        
        String query = "UPDATE pqr SET "
                //+ "pqr_numero='" + item.getNumero() + "', "
                + "pqr_cedula='" + item.getCedula()+ "', "
                + "pqr_nombre='" + item.getNombre()+ "', "
                + "pqr_sede='" + item.getSede()+ "', "
                + "pqr_tipo='" + item.getTipo()+ "', "
                + "pqr_contenido='" + item.getContenido()+ "' "
                + "WHERE pqr_numero='" + item.getNumero() + "'";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            int tabla = st.executeUpdate(query);
            exito = true;
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return exito;
    }
    
    public PQR consultarPQR(String pqr_numero)
    {
        conexionBD.conectar();
        String query = "SELECT * "
                + "FROM pqr "
                + "WHERE pqr_numero='"+pqr_numero+"'";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            if (tabla.next())
            {
                return new PQR(tabla.getString(1), tabla.getString(2),
                        tabla.getString(3), tabla.getString(4),
                        tabla.getString(5), tabla.getString(6),
                        tabla.getString(7));
                
            }
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
