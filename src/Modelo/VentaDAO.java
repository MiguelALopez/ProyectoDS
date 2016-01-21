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
import java.text.SimpleDateFormat;
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
                        tabla.getDouble(7), tabla.getDouble(8), tabla.getDouble(9), 
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
    
    public boolean insertarVenta(Venta venta)
    {
	conexionBD.conectar();
        boolean exito = false;
        
        String query = "INSERT INTO venta (venta_cedula, venta_nombre, venta_direccion, venta_fecha, venta_metodo, venta_seguro, venta_subtotal, venta_iva, venta_total, pos_id)"
                + " VALUES(?,?,?,DATE(?),?,?,?,?,?,?);";
	String query2 = "SELECT MAX(venta_id) FROM venta;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            
            st.setString(1, venta.getCedula());
            st.setString(2, venta.getNombre());
            st.setString(3, venta.getDireccion());
	    st.setString(4, venta.getFecha());
	    st.setString(5, venta.getMetodo());
	    st.setDouble(6, venta.getSeguro());
	    st.setDouble(7, venta.getSubtotal());
	    st.setDouble(8, venta.getIva());
	    st.setDouble(9, venta.getTotal());
	    st.setString(10, venta.getPos());
            
            int resultado = st.executeUpdate();
	    
	    st = conexionBD.conexion.prepareStatement(query2);
	    ResultSet tabla = st.executeQuery();
	    
	    if (tabla.next())
	    {
		String venta_id = tabla.getString(1);
		
		for (Paquete p : venta.getPaquetes())
		{
		    p.setVenta(venta_id);
		}
		
		boolean res = new PaqueteDAO().insertarPaquetes(venta.getPaquetes(), conexionBD);
	    }
	    
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
	    
	    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            
            while (tabla.next())
            {
                ArrayList<Paquete> lista = new PaqueteDAO().getListaPaquetes(tabla.getString(1), conexionBD);
                
                venta = new Venta(tabla.getString(1), tabla.getString(2), tabla.getString(3), 
                        tabla.getString(4), f.format(tabla.getDate(5)), tabla.getString(6), 
                        tabla.getDouble(7), tabla.getDouble(8), tabla.getDouble(9), 
                        tabla.getDouble(10), tabla.getString(11), lista);
		System.out.println(venta.getFecha());
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
    
    public Venta consultarUltimaVenta()
    {
        conexionBD.conectar();
        
        Venta venta = null;
        String query = "SELECT * FROM venta WHERE venta_id = (SELECT MAX(venta_id) FROM venta);";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            ResultSet tabla = st.executeQuery();
            
            while (tabla.next())
            {
                ArrayList<Paquete> lista = new PaqueteDAO().getListaPaquetes(tabla.getString(1), conexionBD);
                
                venta = new Venta(tabla.getString(1), tabla.getString(2), tabla.getString(3), 
                        tabla.getString(4), tabla.getString(5), tabla.getString(6), 
                        tabla.getDouble(7), tabla.getDouble(8), tabla.getDouble(9), 
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
