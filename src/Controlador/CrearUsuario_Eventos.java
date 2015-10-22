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
import javax.swing.JOptionPane;

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
        
        String rePasswd = String.valueOf(this.crearUsuario.pfVerificarClave.getPassword());
        
        Usuario nuevoUsuario = new Usuario(cedula, passwd, nombre, estado, rol, fechaNacimiento, direccion, telefono, celular, fechaIncorporacion, salario, cuenta, sede);
        
        boolean verificar = verificarCamposCrearUsuario(nuevoUsuario, rePasswd);
        
        if (verificar)
        {
            int op = JOptionPane.showConfirmDialog(crearUsuario, "Desea agregar el Usuario " + cedula + " a la Base de Datos?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION)
            {
                //boolean resultado = usuarioDAO.insetarUsuario(nuevoUsuario);
                boolean resultado = false;

                if (resultado)
                {
                    JOptionPane.showMessageDialog(crearUsuario, "Usuario " + cedula + " creado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(crearUsuario, "Error al crear el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
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
    
    public boolean verificarCamposCrearUsuario(Usuario usuario, String rePasswd)
    {
        if (usuario.getCedula().isEmpty())
        {
            JOptionPane.showMessageDialog(crearUsuario, "El campo Cedula es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (usuario.getPasswd().isEmpty())
        {
            JOptionPane.showMessageDialog(crearUsuario, "El campo Contraseña es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (rePasswd.isEmpty())
        {
            JOptionPane.showMessageDialog(crearUsuario, "Debe de confirmar la clave.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!usuario.getPasswd().equals(rePasswd))
        {
            JOptionPane.showMessageDialog(crearUsuario, "Las claves deben de coincidir.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (usuario.getNombre().isEmpty())
        {
            JOptionPane.showMessageDialog(crearUsuario, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!usuario.getTelefono().isEmpty())
        {
            try
            {
                Integer.parseInt(usuario.getTelefono());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(crearUsuario, "El campo Telefono es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if (!usuario.getCelular().isEmpty())
        {
            try
            {
                Integer.parseInt(usuario.getCelular());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(crearUsuario, "El campo Celular es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if (!usuario.getSalario().isEmpty())
        {
            try
            {
                Double.parseDouble(usuario.getSalario());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(crearUsuario, "El campo Salario es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if (!usuario.getCuenta().isEmpty())
        {
            try
            {
                Long.parseLong(usuario.getCuenta());
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(crearUsuario, "El campo Cuenta es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        return true;
    }
}
