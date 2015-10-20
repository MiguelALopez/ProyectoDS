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
import Vista.ModificarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ModificarUsuario_Eventos 
{
    private ModificarUsuario modificarUsuario;
    private UsuarioDAO usuarioDAO;
    private SedeDAO sedeDAO;
    
    public ModificarUsuario_Eventos(final ModificarUsuario modificarUsuario)
    {
        this.modificarUsuario = modificarUsuario;
        this.usuarioDAO = new UsuarioDAO();
        this.sedeDAO = new SedeDAO();
        
        modificarUsuario.bBuscarCedula.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        buscarUsuario();
                    }
                }
        );
        
        modificarUsuario.bCancelar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        modificarUsuario.bModificarUsuario.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        modificarUsuario();
                        limpiarCampos();
                        habilitarCampos(false);
                    }
                }
        );
        
        modificarUsuario.addWindowListener(
                new WindowListener()
                {
                    @Override
                    public void windowOpened(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowClosing(WindowEvent we) 
                    {
                        
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
                        limpiarCampos();
                        habilitarCampos(false);
                    }

                    @Override
                    public void windowDeactivated(WindowEvent we) 
                    {
                        
                    }                    
                }
        );
    }
    
    public void modificarUsuario()
    {
        String cedula = this.modificarUsuario.tfCedula.getText();
        String passwd = String.valueOf(this.modificarUsuario.pfClave.getPassword());
        String nombre = this.modificarUsuario.tfNombre.getText();
        String estado = (String) this.modificarUsuario.cbEstado.getSelectedItem();
        String rol = (String) this.modificarUsuario.cbCargo.getSelectedItem();
        String fechaNacimiento = this.modificarUsuario.ftfFechaNacimiento.getText();
        String direccion = this.modificarUsuario.tfDireccion.getText();
        String telefono = this.modificarUsuario.tfTelefono.getText();
        String celular = this.modificarUsuario.tfCelular.getText();
        String fechaIncorporacion = this.modificarUsuario.ftfFechaIncorporacion.getText();
        String salario = this.modificarUsuario.tfSalario.getText();
        String cuenta = this.modificarUsuario.tfNumeroCuenta.getText();
        String sede = (String) this.modificarUsuario.cbSedes.getSelectedItem();
        
        Usuario nuevoUsuario = new Usuario(cedula, passwd, nombre, estado, rol, fechaNacimiento, direccion, telefono, celular, fechaIncorporacion, salario, cuenta, sede);
        
        //usuarioDAO.modificarUsuario(nuevoUsuario);
    }
    
    public void buscarUsuario()
    {
        String cedula = this.modificarUsuario.tfBuscarCedula.getText();
        
        //Usuario usuario = this.usuarioDAO.consultarUsuario(cedula);
        Usuario usuario = new Usuario();
        
        if (usuario != null)
        {
            actualizarSedes();
            
            this.modificarUsuario.tfCedula.setText(usuario.getCedula());
            this.modificarUsuario.cbCargo.setSelectedItem(usuario.getRol());
            this.modificarUsuario.pfClave.setText(usuario.getPasswd());
            this.modificarUsuario.pfVerificarClave.setText(usuario.getPasswd());
            this.modificarUsuario.tfNombre.setText(usuario.getNombre());
            this.modificarUsuario.tfDireccion.setText(usuario.getDireccion());
            this.modificarUsuario.ftfFechaNacimiento.setText(usuario.getFechaNacimiento());
            this.modificarUsuario.cbSedes.setSelectedItem(usuario.getNumeroSede());
            this.modificarUsuario.tfTelefono.setText(usuario.getTelefono());
            this.modificarUsuario.tfCelular.setText(usuario.getCelular());
            this.modificarUsuario.ftfFechaIncorporacion.setText(usuario.getFechaIncorporacion());
            this.modificarUsuario.tfSalario.setText(usuario.getSalario());
            this.modificarUsuario.tfNumeroCuenta.setText(usuario.getCuenta());
            this.modificarUsuario.cbEstado.setSelectedItem(usuario.getEstado());
            
            habilitarCampos(true);
        }
        else
        {
            JOptionPane.showMessageDialog(modificarUsuario, "Error al consultar en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarSedes()
    {
        modificarUsuario.cbSedes.removeAllItems();
        
        //ArrayList<Sede> sedes = sedeDAO.consultarSedes();
        ArrayList<Sede> sedes = new ArrayList();
        
        for (int i = 0; i < sedes.size(); i++) 
        {
            modificarUsuario.cbSedes.addItem(sedes.get(i).getNumero());            
        }
    }
    
    public boolean verificarCampos()
    {
        return true;
    }
    
    public void habilitarCampos(boolean b)
    {
        this.modificarUsuario.tfBuscarCedula.setEnabled(!b);
        this.modificarUsuario.bBuscarCedula.setEnabled(!b);
        
        //this.modificarUsuario.tfCedula.setEnabled(b);
        this.modificarUsuario.cbCargo.setEnabled(b);
        this.modificarUsuario.pfClave.setEnabled(b);
        this.modificarUsuario.pfVerificarClave.setEnabled(b);
        this.modificarUsuario.tfNombre.setEnabled(b);
        this.modificarUsuario.tfDireccion.setEnabled(b);
        this.modificarUsuario.ftfFechaNacimiento.setEnabled(b);
        this.modificarUsuario.tfTelefono.setEnabled(b);
        this.modificarUsuario.tfCelular.setEnabled(b);
        this.modificarUsuario.ftfFechaIncorporacion.setEnabled(b);
        this.modificarUsuario.tfSalario.setEnabled(b);
        this.modificarUsuario.tfNumeroCuenta.setEnabled(b);
        this.modificarUsuario.cbEstado.setEnabled(b);
        this.modificarUsuario.cbSedes.setEnabled(b);
        this.modificarUsuario.bModificarUsuario.setEnabled(b);
    }
    
    public void limpiarCampos()
    {
        this.modificarUsuario.tfBuscarCedula.setText("");
        this.modificarUsuario.ftfFechaIncorporacion.setText("");
        this.modificarUsuario.ftfFechaNacimiento.setText("");
        this.modificarUsuario.pfClave.setText("");
        this.modificarUsuario.pfVerificarClave.setText("");
        this.modificarUsuario.tfCedula.setText("");
        this.modificarUsuario.tfCelular.setText("");
        this.modificarUsuario.tfDireccion.setText("");
        this.modificarUsuario.tfNombre.setText("");
        this.modificarUsuario.tfNumeroCuenta.setText("");
        this.modificarUsuario.tfSalario.setText("");
        this.modificarUsuario.tfTelefono.setText("");
    }
    
    public void cerrarVentana()
    {
        this.modificarUsuario.setVisible(false);
        limpiarCampos();
        habilitarCampos(false);
    }
}
