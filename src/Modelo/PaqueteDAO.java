/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: PaqueteDAO.java
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
 * clase encargada de la conexion a la base de datos donde se solicitara la lista
 * de Paquetes , Modificacion de Paquete y Agregacion de Paquete
 */
public class PaqueteDAO 
{
    ConexionBD conexionBD;
     /***
     * Constructor donde se creara una nueva conexion a la base de datos
     */
    public PaqueteDAO()
    {
        this.conexionBD = new ConexionBD();
    }
    /***
     * Metodo donde se solicitara la Lista de Paquetes a la base de datos 
     * pertenecientes a una venta especifica
     * @param venta : venta a la que pertenecen los paquetes
     * @param conexionBD: conexion a la base de datos que tiene la venta
     */
    public ArrayList<Paquete> getListaPaquetes(String venta, ConexionBD conexionBD)
    {        
        ArrayList<Paquete> listaPaquetes = new ArrayList();
        String query = "SELECT * FROM paquete WHERE venta_id = ?;";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);
            st.setString(1, venta);
            ResultSet tabla = st.executeQuery();
            
            while (tabla.next())
            {
                listaPaquetes.add(new Paquete(tabla.getString(1), tabla.getInt(2), tabla.getDouble(3), 
                        tabla.getDouble(4), tabla.getString(5), tabla.getDouble(6)));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaPaquetes;
    }
     /***
     * Metodo encargado de la insercion de un nuevo listado de
     * paquetes en la base de datos
     * @param paquetes : listado de paquetes que se añadiran a la base de datos
     * @param conexionBD: conexion a la base de datos que tiene la venta a la que 
     * pertenecen los paquetes
     */
    public boolean insertarPaquetes(ArrayList<Paquete> paquetes, ConexionBD conexionBD)
    {
        boolean exito = false;
        
        String query = "INSERT INTO paquete (venta_id, paquete_numero, paquete_volumen, paquete_peso, paquete_descripcion, paquete_costo)"
                + " VALUES(?,?,?,?,?,?);";
        
        try
        {
            PreparedStatement st = conexionBD.conexion.prepareStatement(query);            
	    int resultado;
	    
	    for (Paquete p : paquetes)
	    {
		st.setString(1, p.getVenta());
		st.setInt(2, p.getNumero());
		st.setDouble(3, p.getVolumen());
		st.setDouble(4, p.getPeso());
		st.setString(5, p.getDescripcion());
		st.setDouble(6, p.getCosto());
		
		resultado = st.executeUpdate();
	    }
	    
            exito = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return exito;
    }
}
