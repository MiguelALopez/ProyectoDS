/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaflash_servidor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ConsultasBD 
{
    ConexionBD fachada;
    Connection conexion;
    
    /**
     * constructor para inicializar atributos
     */
    public ConsultasBD()
    {
        
    }
    
    public int conectar()
    {
        fachada = new ConexionBD();
        conexion = fachada.conectar();
        
        if (conexion != null)
        {
            return 0; // sin fallas
        }
        else
        {
            return -1; // con fallas
        }
    }
    
    public int insertarCuenta(String user, String pass, int type)
    {
        String query = "INSERT INTO cuentas (usuario, clave, tipo) VALUES ('" + user + "', '" + pass + "', " + type + ")";
        
        try
        {
            Statement st = conexion.createStatement();
            int tabla = st.executeUpdate(query);
            
            return 0;
        }
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public int consultarCuenta(String user, String pass)
    {
        String query = "SELECT * FROM cuentas WHERE usuario = '" + user + 
                "' AND clave = '" + pass + "'";
        
        try
        {
            Statement st = conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
            if (tabla.next())
            {
                return tabla.getInt(3);
            }
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
        return -1;
    }
    
    public ResultSet consultarCuentas()
    {
        String query = "SELECT * FROM cuentas";
        
        try
        {
            Statement st = conexion.createStatement();
            ResultSet table = st.executeQuery(query);
            return table;
        }
        catch (SQLException ex)
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public int modificarCuenta(String currentUser, String user, String password, int type)
    {
        String query = "UPDATE cuentas SET usuario = '" + user + "'" + ", clave = '" + password + "', tipo =" + type
                + " WHERE usuario = '" + currentUser + "'";
        
        try
        {
            Statement st = conexion.createStatement();
            st.executeUpdate(query);
            return 0;
        }
        catch (SQLException ex)
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public int eliminarCuenta(String user)
    {
        String query = "DELETE FROM cuentas WHERE usuario = '" + user + "'";
        
        try
        {
            Statement st = conexion.createStatement();
            st.executeUpdate(query);
            return 0;
        }
        catch (SQLException ex)
        {
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
