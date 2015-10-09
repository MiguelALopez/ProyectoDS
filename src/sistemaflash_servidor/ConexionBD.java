/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaflash_servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ConexionBD 
{
    private String url; // direccion de la base de datos
    private String user; // usuario de la base de datos
    private String password; // contraseña de la base de datos
    
    private Connection conexion; // coneccion a la base de datos
    
    /**
     * constructor para inicializar los valores necesarios
     */
    public ConexionBD()
    {
        url = "jdbc:postgresql://localhost:5432/Prueba";
        user = "postgres";
        password = "postgresql";
    }
    
    /**
     * metodo para realizar la coneccion con la base de datos
     * @return la coneccion con la base de datos
     */
    public Connection conectar()
    {
        try
        {
            conexion = DriverManager.getConnection(url, user, password);
            
            //System.out.println( "Conexion Abierta" );
            return conexion;
        } 
        catch( SQLException ex ) 
        {
             //System.out.println( "No se pudo abrir." );
             return null;
        }
    }
    
    /**
     * metodo para cerrar una coneccion con la base de datos
     */
    public void cerrarConexion()
    {
        try
        {
           conexion.close();
           System.out.println( "Conexión con BD cerrada!" );
        }
        catch(SQLException ex)
        {
            System.out.println( "No se pudo cerrar la conexion" );
        }
    }
    
    public String getUrl() 
    {
        return url;
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUser() 
    {
        return user;
    }

    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public Connection getConexion() 
    {
        return conexion;
    }

    public void setConexion(Connection conexion) 
    {
        this.conexion = conexion;
    }
}
