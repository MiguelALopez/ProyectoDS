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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class VentaDAO 
{
    ConexionBD conexionBD;
    
    public VentaDAO()
    {
        this.conexionBD = new ConexionBD();
    }
    
    public ArrayList<Venta> getListaVentas()
    {
        conexionBD.conectar();
        
        ArrayList<Venta> listaVentas = null;
        String query = "SELECT * FROM venta;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            ResultSet tabla = st.executeQuery();
            
            listaVentas = new ArrayList();
            
            while (tabla.next())
            {
                ArrayList<Paquete> lista = new PaqueteDAO().getListaPaquetes(tabla.getString(1), conexionBD);
                
                listaVentas.add(new Venta(tabla.getString(1), tabla.getString(2), tabla.getString(3), 
                        tabla.getString(4), tabla.getString(5), tabla.getString(6), 
                        tabla.getBoolean(7), tabla.getDouble(8), tabla.getDouble(9), 
                        tabla.getDouble(10), tabla.getString(11), lista));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return listaVentas;
    }
    
    public Venta consultarVenta(String id)
    {
        conexionBD.conectar();
        
        Venta venta = null;
        String query = "SELECT * FROM venta WHERE venta_id = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            st.setString(1, id);
            ResultSet tabla = st.executeQuery();
            
            while (tabla.next())
            {
                ArrayList<Paquete> lista = new PaqueteDAO().getListaPaquetes(tabla.getString(1), conexionBD);
                
                venta = new Venta(tabla.getString(1), tabla.getString(2), tabla.getString(3), 
                        tabla.getString(4), tabla.getString(5), tabla.getString(6), 
                        tabla.getBoolean(7), tabla.getDouble(8), tabla.getDouble(9), 
                        tabla.getDouble(10), tabla.getString(11), lista);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (conexionBD != null)
            {
                conexionBD.cerrarConexion();
            }
        }
        
        return venta;
    }
}
