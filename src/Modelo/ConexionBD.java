package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
    
    public Connection conexion; // coneccion a la base de datos
    
    /**
     * constructor para inicializar los valores necesarios
     */
    public ConexionBD()
    {
        url = "jdbc:postgresql://localhost:5432/proyectods";
        user = "prueba";
        password = "123456";
    }
    
    /**
     * metodo para realizar la coneccion con la base de datos
     * @return la coneccion con la base de datos
     */
    public void conectar()
    {
        try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            System.out.println( "Driver Cargado" );
        } catch(ClassNotFoundException  e ) {
            System.err.println( "No se pudo cargar el driver." );
        }

        try{
            //Crear el objeto de conexion a la base de datos
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println( "Conexion Abierta" );

            //Crear objeto Statement para realizar queries a la base de datos
        } catch(SQLException e) {
            conexion = null;
            System.err.println( "No se pudo abrir la bd." );
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
            System.err.println( "No se pudo cerrar la conexion" );
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

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        conexionBD.conectar();
        conexionBD.cerrarConexion();
    }
}
