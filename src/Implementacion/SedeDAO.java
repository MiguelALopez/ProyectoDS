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
public class SedeDAO 
{
    ConexionBD fachada;
    Connection conexion;
    
    public Sede consultarSede(String sede_numero)
    {
        String query = "SELECT * "
                + "FROM sede "
                + "WHERE sede_numero='"+sede_numero+"'";
        
        try
        {
            Statement st = conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            if (tabla.next())
            {
                return new Sede(
                        tabla.getString(0), tabla.getString(1),
                        tabla.getString(2), tabla.getString(3),
                        tabla.getString(4));
                
            }
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void insertarSede(Sede sede)
    {
        String query = "INSERT INTO sedes VALUES('"
                + sede.getNumero()+"','"
                + sede.getNombre()+"','"                
                + sede.getPresupuesto()+"','"
                + sede.getCamiones()+"','"
                + sede.getDireccion() + "')";
        
        try
        {
            Statement st = conexion.createStatement();
            int tabla = st.executeUpdate(query);            
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarSede(Sede sede)
    {
        String query = "UPDATE sede SET "
                + "sede_numero='" + sede.getNumero()+"', "
                + "sede_nombre='" + sede.getNombre()+"', "                
                + "sede_presupuesto='" + sede.getPresupuesto()+"', "
                + "sede_cant_camiones='" + sede.getCamiones()+"', "
                + "sede_direccion='" + sede.getDireccion() + "' "
                + "WHERE sede_numero='"+sede.getNumero()+"'";
        
        try
        {
            Statement st = conexion.createStatement();
            int tabla = st.executeUpdate(query);
            
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
