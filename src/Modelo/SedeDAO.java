/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
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

    public ResultSet consultarSedes(){
        ResultSet tabla = null;
        conexionBD.conectar();
        if (conexionBD.conexion != null){
            String query = "SELECT sede_numero, sede_nombre, sede_gerente, sede_direccion FROM sede;";
            try{
                Statement st = conexionBD.conexion.createStatement();
                tabla = st.executeQuery(query);
            }catch (SQLException e){
                e.printStackTrace();
            }
            conexionBD.cerrarConexion();
        }


        return tabla;
    }
    
    public Sede consultarSedeEspecifico(String sede_numero)
    {
        Sede sede = null;
        conexionBD.conectar();
        if (conexionBD.conexion != null){
            if (!existSede(sede_numero)){
                String query = "SELECT * "
                        + "FROM sede "
                        + "WHERE sede_numero='"+sede_numero+"'";
                try{
                    Statement st = conexionBD.conexion.createStatement();
                    ResultSet tabla = st.executeQuery(query);

                    if (tabla.next())
                    {
                        sede = new Sede(
                                tabla.getString(0), tabla.getString(1),
                                tabla.getString(2), tabla.getString(3),
                                tabla.getString(4));

                    }
                }catch (SQLException e){
                    e.printStackTrace();
                    //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conexionBD.cerrarConexion();
        }
        return sede;
    }

    /* Metodo encargado de insertar una sede en la base de datos retorna un true si la
    * operacion es exitosa y un false de lo contrario*/
    public boolean insertarSede(Sede sede)
    {
        boolean exitoso = false;
        conexionBD.conectar();
        if (conexionBD.conexion != null) {
            // Se verifica que no exista la sede primero
            if (!existSede(sede.getNumero())) {
                PreparedStatement consulta = null;
                // La consulta se hace de esta forma para evitar inserciones SQL
                String insertSQL = "INSERT INTO sede" +
                        "(sede_numero, sede_nombre, sede_direccion)" +
                        "VALUES (?, ?, ?);";
                try {
                    consulta = conexionBD.conexion.prepareStatement(insertSQL);

                    consulta.setString(1, sede.getNumero());
                    consulta.setString(2, sede.getNombre());
                    consulta.setString(3, sede.getDireccion());

                    consulta.executeUpdate();
                    exitoso = true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("La sede numero " + sede.getNumero() + " ya existe");
            }
            conexionBD.cerrarConexion(); // Se cierra la conexion
        }
        return exitoso;
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

    public boolean existSede(String numSede){
        Boolean existe = false;
        String consulta = "SELECT sede_numero FROM sede WHERE sede_numero='" + numSede + "';";
        ResultSet resultSet = null;

        try {
            Statement statement = conexionBD.conexion.createStatement();
            resultSet = statement.executeQuery(consulta);
            if (resultSet.next()){
                existe = true;
            }
        }catch (SQLException e){
            System.err.println("Error en la consulta en + " + e.getLocalizedMessage());
        }

        return existe;
    }
}
