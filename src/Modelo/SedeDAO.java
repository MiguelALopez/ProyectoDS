/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AndrésFelipe
 */
public class SedeDAO 
{
    ConexionBD conexionBD = new ConexionBD();
    
    public Sede consultarSede(String sede_numero)
    {
        conexionBD.conectar();
        String query = "SELECT * "
                + "FROM sede "
                + "WHERE sede_numero='"+sede_numero+"'";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
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
        conexionBD.cerrarConexion();
        return null;
    }
    
    public void insertarSede(Sede sede)
    {
        conexionBD.conectar();
        String query = "INSERT INTO sedes VALUES('"
                + sede.getNumero()+"','"
                + sede.getNombre()+"','"                
                + sede.getPresupuesto()+"','"
                + sede.getCamiones()+"','"
                + sede.getDireccion() + "')";
        
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
    
    public void modificarSede(Sede sede)
    {
        conexionBD.conectar();
        String query = "UPDATE sede SET "
                //+ "sede_numero='" + sede.getNumero()+"', "
                + "sede_nombre='" + sede.getNombre()+"', "                
                + "sede_presupuesto='" + sede.getPresupuesto()+"', "
                + "sede_cant_camiones='" + sede.getCamiones()+"', "
                + "sede_direccion='" + sede.getDireccion() + "' "
                + "WHERE sede_numero='"+sede.getNumero()+"'";
        
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
