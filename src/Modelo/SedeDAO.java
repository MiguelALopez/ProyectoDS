/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;


public class SedeDAO
{
    ConexionBD conexionBD = new ConexionBD();

    public ArrayList<Sede> consultarSedes(){
        conexionBD.conectar();
        
        ArrayList<Sede> listaSedes = new ArrayList();
        String query = "SELECT * FROM sede";
        
        try
        {
            Statement st = conexionBD.conexion.createStatement();
            ResultSet tabla = st.executeQuery(query);
            
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
            //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexionBD.cerrarConexion();
        
        return listaSedes;
    }
    
    public Sede consultarSedeEspecifico(String sede_numero)
    {
        Sede sede = null;
        conexionBD.conectar();
        if (conexionBD.conexion != null){
            String query = "SELECT * "
                    + "FROM sede "
                    + "WHERE sede_numero='"+sede_numero+"'";
            try{
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
            }catch (SQLException e){
                e.printStackTrace();
                //Logger.getLogger(ConsultasBD.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public boolean modificarSede(Sede sede)
    {
        boolean exito = true;
        conexionBD.conectar();
        String query = "UPDATE sede SET " +
                "sede_nombre = ?," +
                "sede_gerente = ?," +
                "sede_presupuesto = ?," +
                "sede_cant_camiones = ?," +
                "sede_direccion = ?" +
                "WHERE sede_numero = ?";
        
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

        }
        catch (SQLException ex) 
        {
            exito = false;
        }
        conexionBD.cerrarConexion();
        return exito;
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
