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

    public ArrayList<Sede> consultarSedes()
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
                listaSedes.add(new Sede(tabla.getString(1),
                        tabla.getString(2),
                        tabla.getString(3),
                        tabla.getString(4),
                        tabla.getInt(5),
                        tabla.getString(6)));                
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
    
    public Sede consultarSedeEspecifico(String sede_numero)
    {
        conexionBD.conectar();
        Sede sede = null;
        
        String query = "SELECT * "
                + "FROM sede "
                + "WHERE sede_numero='"+sede_numero+"';";
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);

            if (tabla.next())
            {
                sede = new Sede(
                        tabla.getString(1),
                        tabla.getString(2),
                        tabla.getString(3),
                        tabla.getString(4),
                        tabla.getInt(5),
                        tabla.getString(6));
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
            // Se verifica que no exista la sede primero
            if (!existSede(sede.getNumero())) 
            {
                PreparedStatement consulta;
                // La consulta se hace de esta forma para evitar inserciones SQL
                String insertSQL = "INSERT INTO sede" +
                        "(sede_numero, sede_nombre, sede_direccion) " +
                        "VALUES (?, ?, ?);";
                try 
                {
                    consulta = conexionBD.conexion.prepareStatement(insertSQL);

                    consulta.setString(1, sede.getNumero());
                    consulta.setString(2, sede.getNombre());
                    consulta.setString(3, sede.getDireccion());

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
            else 
            {
                System.err.println("La sede numero " + sede.getNumero() + " ya existe");
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
                "sede_gerente = ?, " +
                "sede_presupuesto = ?, " +
                "sede_cant_camiones = ?, " +
                "sede_direccion = ? " +
                "WHERE sede_numero = ?;";
        
        try
        {
            PreparedStatement preparedStatement = conexionBD.conexion.prepareStatement(query);
            
            if (!sede.getNombre().isEmpty()){
                preparedStatement.setString(1, sede.getNombre());
            }else {
                preparedStatement.setNull(1, Types.VARCHAR);
            }
            if (!sede.getGerente().isEmpty()){
                preparedStatement.setString(2, sede.getGerente());
            }else {
                preparedStatement.setNull(2, Types.VARCHAR);
            }
            if (!sede.getPresupuesto().isEmpty()){
                preparedStatement.setString(3, sede.getPresupuesto());
            }else {
                preparedStatement.setNull(3, Types.VARCHAR);
            }
            preparedStatement.setInt(4, sede.getCamiones());
            if (!sede.getDireccion().isEmpty()){
                preparedStatement.setString(5, sede.getDireccion());
            }else {
                preparedStatement.setNull(3, Types.VARCHAR);
            }
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

    public boolean existSede(String numSede)
    {
        conexionBD.conectar();
        boolean existe = false;
        
        String consulta = "SELECT sede_numero "
                + "FROM sede "
                + "WHERE sede_numero='" + numSede + "';";
        
        ResultSet resultSet;

        try 
        {
            Statement statement = conexionBD.conexion.createStatement();
            resultSet = statement.executeQuery(consulta);
            
            if (resultSet.next())
            {
                existe = true;
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

        return existe;
    }
}
