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
    private final ModificarUsuario modificarUsuario;
    
    public ModificarUsuario_Eventos(final ModificarUsuario modificarUsuario)
    {
        this.modificarUsuario = modificarUsuario;
        
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
        
        modificarUsuario.tfBuscarCedula.addActionListener(
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
        String rol = (String) this.modificarUsuario.cbCargo.getSelectedItem();
        String estado = (String) this.modificarUsuario.cbEstado.getSelectedItem();        
        String fechaNacimiento = this.modificarUsuario.ftfFechaNacimiento.getText();
        String direccion = this.modificarUsuario.tfDireccion.getText();
        String telefono = this.modificarUsuario.tfTelefono.getText();
        String celular = this.modificarUsuario.tfCelular.getText();
        String fechaIncorporacion = this.modificarUsuario.ftfFechaIncorporacion.getText();
        String salario = this.modificarUsuario.tfSalario.getText();
        String cuenta = this.modificarUsuario.tfNumeroCuenta.getText();
        String sede = (String) this.modificarUsuario.cbSedes.getSelectedItem();
        
        String rePasswd = String.valueOf(this.modificarUsuario.pfVerificarClave.getPassword());
        
        Usuario usuario = new Usuario(cedula, passwd, nombre, rol, estado, fechaNacimiento, direccion, telefono, celular, fechaIncorporacion, salario, cuenta, sede);
        
        boolean verificar = verificarCamposModificarUsuario(usuario, rePasswd);
        
        if (verificar)
        {
            int op = JOptionPane.showConfirmDialog(modificarUsuario, "Desea modificar el Usuario " + cedula + " en la Base de Datos?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION)
            {
                boolean resultado = new UsuarioDAO().modificarUsuario(usuario);
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
                
            Usuario usuario = new UsuarioDAO().consultarUsuario(cedula);
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
        
        ArrayList<Sede> sedes = new SedeDAO().consultarSedes();
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
                Long.parseLong(usuario.getTelefono());
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
                Long.parseLong(usuario.getCelular());
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
        //this.modificarUsuario.tfCedula.setEnabled(b);
        this.modificarUsuario.cbCargo.setEnabled(b);
        this.modificarUsuario.pfClave.setEditable(b);
        this.modificarUsuario.pfVerificarClave.setEditable(b);
        this.modificarUsuario.tfNombre.setEditable(b);
        this.modificarUsuario.tfDireccion.setEditable(b);
        this.modificarUsuario.ftfFechaNacimiento.setEditable(b);
        this.modificarUsuario.tfTelefono.setEditable(b);
        this.modificarUsuario.tfCelular.setEditable(b);
        this.modificarUsuario.ftfFechaIncorporacion.setEditable(b);
        this.modificarUsuario.tfSalario.setEditable(b);
        this.modificarUsuario.tfNumeroCuenta.setEditable(b);
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
        this.modificarUsuario.cbCargo.setSelectedIndex(0);
        this.modificarUsuario.cbEstado.setSelectedIndex(0);
        this.modificarUsuario.cbSedes.setSelectedIndex(0);
    }
    
    public void cerrarVentana()
    {
        this.modificarUsuario.setVisible(false);
    }
}
