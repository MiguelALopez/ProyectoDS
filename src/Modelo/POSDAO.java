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
 * clase encargada de la conexion a la base de datos donde se solicitara la lista
 * de POS, Modificacion de POS y Agregacion de POS
 */
public class POSDAO 
{
    ConexionBD conexionBD;
 
     /***
     * Constructor donde se creara una nueva conexion a la base de datos
     */
    public POSDAO()
    {
        this.conexionBD = new ConexionBD();
    }
  
     /***
     * Metodo donde se solicitara la Lista de POS a la base de datos 
     */
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
     /***
     * Metodo encargado de la insercion de un nuevo POS en la base de datos
     * @param  pos : Pos que se desea agregar en la base de datos
     */
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

     /***
     * Metodo encargada de la modificacion de algun POS que ya exista
     * en la base de datos 
     * @param pos : pos que se desea modificar en la base de datos
     */
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
     /***
     * Funcion encargada de la consulta de algun POS que ya exista
     * en la base de datos
     * @param pos_id : id del pos que se desea consultar
     */
    public POS consultarPOS(String pos_id)
    {
        conexionBD.conectar();
        
        POS pos = null;
        // La consulta se hace de esta forma para evitar inserciones SQL
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
