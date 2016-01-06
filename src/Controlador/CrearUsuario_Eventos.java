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
import Vista.CrearUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class CrearUsuario_Eventos 
{
    private final CrearUsuario crearUsuario;
    
    public CrearUsuario_Eventos(final CrearUsuario crearUsuario)
    {
        this.crearUsuario = crearUsuario;
        
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
        
        actualizarSedes();
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
        String rol = (String) this.crearUsuario.cbCargo.getSelectedItem();
        String estado = (String) this.crearUsuario.cbEstado.getSelectedItem();        
        String fechaNacimiento = this.crearUsuario.ftfFechaNacimiento.getText();
        String direccion = this.crearUsuario.tfDireccion.getText();
        String telefono = this.crearUsuario.tfTelefono.getText();
        String celular = this.crearUsuario.tfCelular.getText();
        String fechaIncorporacion = this.crearUsuario.ftfFechaIncorporacion.getText();
        String salario = this.crearUsuario.tfSalario.getText();
        String cuenta = this.crearUsuario.tfNumeroCuenta.getText();
        String sede = (String) this.crearUsuario.cbSedes.getSelectedItem();
        
        String rePasswd = String.valueOf(this.crearUsuario.pfVerificarClave.getPassword());
        
        Usuario nuevoUsuario = new Usuario(cedula, passwd, nombre, rol, estado, fechaNacimiento, direccion, telefono, celular, fechaIncorporacion, salario, cuenta, sede);
        
        boolean verificar = verificarCamposCrearUsuario(nuevoUsuario, rePasswd);
        
        if (verificar)
        {
            int op = JOptionPane.showConfirmDialog(crearUsuario, "Desea agregar el Usuario " + cedula + " a la Base de Datos?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION)
            {
                boolean resultado = new UsuarioDAO().insetarUsuario(nuevoUsuario);
                //boolean resultado = false;

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
    
    private void actualizarSedes()
    {
        crearUsuario.cbSedes.removeAllItems();
        
        ArrayList<Sede> sedes = new SedeDAO().consultarSedes();
        //ArrayList<Sede> sedes = new ArrayList();
        
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
                Long.parseLong(usuario.getTelefono());
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
                Long.parseLong(usuario.getCelular());
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
