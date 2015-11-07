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
                    }
                }
        );
        
        actualizarSedes();
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
        
        String rePasswd = String.valueOf(this.modificarUsuario.pfVerificarClave.getPassword());
        
        Usuario usuario = new Usuario(cedula, passwd, nombre, estado, rol, fechaNacimiento, direccion, telefono, celular, fechaIncorporacion, salario, cuenta, sede);
        
        boolean verificar = verificarCamposModificarUsuario(usuario, rePasswd);
        
        if (verificar)
        {
            int op = JOptionPane.showConfirmDialog(modificarUsuario, "Desea modificar el Usuario " + cedula + " en la Base de Datos?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION)
            {
                boolean resultado = usuarioDAO.modificarUsuario(usuario);
                //boolean resultado = false;

                if (resultado)
                {
                    JOptionPane.showMessageDialog(modificarUsuario, "Usuario " + cedula + " modificado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    habilitarCampos(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(modificarUsuario, "Error al modificar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public void buscarUsuario()
    {
        boolean verificar = verificarCamposBuscarUsuario();
        
        if (verificar)
        {
            String cedula = this.modificarUsuario.tfBuscarCedula.getText();
                
            Usuario usuario = this.usuarioDAO.consultarUsuario(cedula);
            //Usuario usuario = new Usuario();

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
    }
    
    public void actualizarSedes()
    {
        modificarUsuario.cbSedes.removeAllItems();
        
        ArrayList<Sede> sedes = sedeDAO.consultarSedes();
        //ArrayList<Sede> sedes = new ArrayList();
        
        for (int i = 0; i < sedes.size(); i++) 
        {
            modificarUsuario.cbSedes.addItem(sedes.get(i).getNumero());            
        }
    }
    
    public boolean verificarCamposBuscarUsuario()
    {
        if (this.modificarUsuario.tfBuscarCedula.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarUsuario, "Debe de introducir la Cedula para buscar el Usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public boolean verificarCamposModificarUsuario(Usuario usuario, String rePasswd)
    {        
        if (usuario.getPasswd().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarUsuario, "El campo Contraseña es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (rePasswd.isEmpty())
        {
            JOptionPane.showMessageDialog(modificarUsuario, "Debe de confirmar la clave.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!usuario.getPasswd().equals(rePasswd))
        {
            JOptionPane.showMessageDialog(modificarUsuario, "Las claves deben de coincidir.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (usuario.getNombre().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarUsuario, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(modificarUsuario, "El campo Telefono es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(modificarUsuario, "El campo Celular es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(modificarUsuario, "El campo Salario es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(modificarUsuario, "El campo Cuenta es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
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
