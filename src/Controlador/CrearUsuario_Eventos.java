/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Sede;
import Modelo.SedeDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.CrearUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class CrearUsuario_Eventos 
{
    private CrearUsuario crearUsuario;
    private UsuarioDAO usuarioDAO;
    private SedeDAO sedeDAO;
    
    public CrearUsuario_Eventos(final CrearUsuario crearUsuario)
    {
        this.crearUsuario = crearUsuario;
        this.usuarioDAO = new UsuarioDAO();
        this.sedeDAO = new SedeDAO();
        
        crearUsuario.bCancelar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        crearUsuario.bCrearUsuario.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        crearUsuario();
                    }
                }
        );
        
        crearUsuario.addWindowListener(
                new WindowListener()
                {
                    @Override
                    public void windowOpened(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowClosing(WindowEvent we) 
                    {
                        cerrarVentana();
                    }

                    @Override
                    public void windowClosed(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowIconified(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowDeiconified(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowActivated(WindowEvent we) 
                    {
                        actualizarSedes();
                    }

                    @Override
                    public void windowDeactivated(WindowEvent we) 
                    {
                        
                    }                    
                }
        );
    }
    
    public void limpiarCampos()
    {
        this.crearUsuario.ftfFechaIncorporacion.setText("");
        this.crearUsuario.ftfFechaNacimiento.setText("");
        this.crearUsuario.pfClave.setText("");
        this.crearUsuario.pfVerificarClave.setText("");
        this.crearUsuario.tfCedula.setText("");
        this.crearUsuario.tfCelular.setText("");
        this.crearUsuario.tfDireccion.setText("");
        this.crearUsuario.tfNombre.setText("");
        this.crearUsuario.tfNumeroCuenta.setText("");
        this.crearUsuario.tfSalario.setText("");
        this.crearUsuario.tfTelefono.setText("");
    }
    
    public void cerrarVentana()
    {
        this.crearUsuario.setVisible(false);
        limpiarCampos();
    }
    
    public void crearUsuario()
    {
        String cedula = this.crearUsuario.tfCedula.getText();
        String passwd = String.valueOf(this.crearUsuario.pfClave.getPassword());
        String nombre = this.crearUsuario.tfNombre.getText();
        String estado = (String) this.crearUsuario.cbEstado.getSelectedItem();
        String rol = (String) this.crearUsuario.cbCargo.getSelectedItem();
        String fechaNacimiento = this.crearUsuario.ftfFechaNacimiento.getText();
        String direccion = this.crearUsuario.tfDireccion.getText();
        String telefono = this.crearUsuario.tfTelefono.getText();
        String celular = this.crearUsuario.tfCelular.getText();
        String fechaIncorporacion = this.crearUsuario.ftfFechaIncorporacion.getText();
        String salario = this.crearUsuario.tfSalario.getText();
        String cuenta = this.crearUsuario.tfNumeroCuenta.getText();
        String sede = (String) this.crearUsuario.cbSedes.getSelectedItem();
        
        Usuario nuevoUsuario = new Usuario(cedula, passwd, nombre, estado, rol, fechaNacimiento, direccion, telefono, celular, fechaIncorporacion, salario, cuenta, sede);
        
        //usuarioDAO.insetarUsuario(nuevoUsuario);
    }
    
    public void actualizarSedes()
    {
        crearUsuario.cbSedes.removeAllItems();
        
        //ArrayList<Sede> sedes = sedeDAO.consultarSedes();
        ArrayList<Sede> sedes = new ArrayList();
        
        for (int i = 0; i < sedes.size(); i++) 
        {
            crearUsuario.cbSedes.addItem(sedes.get(i).getNumero());            
        }
    }
}
