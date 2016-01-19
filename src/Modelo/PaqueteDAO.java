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
public class PaqueteDAO 
{
    ConexionBD conexionBD;
    
    public PaqueteDAO()
    {
        this.conexionBD = new ConexionBD();
    }
    
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
                        tabla.getDouble(4), tabla.getString(5)));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaPaquetes;
    }
}
