/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: CrearUsuario_Eventos.java
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
 * clase para manejar los eventos de crear usuario
 */
public class CrearUsuario_Eventos {
    private final CrearUsuario crearUsuario;

    /***
     * Constructor encargado de inicializar un constructor con los eventos de la interfaz CrearUsuario
     *
     * @param crearUsuario Objeto que contiene la interfaz CrearUsuario con todos sus elementos
     */
    public CrearUsuario_Eventos(final CrearUsuario crearUsuario) {
        this.crearUsuario = crearUsuario;

        crearUsuario.bCancelar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        cerrarVentana();
                    }
                }
        );

        crearUsuario.bCrearUsuario.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        crearUsuario();
                    }
                }
        );

        actualizarSedes();
    }

    /***
     * Metodo encargado de mostrar todas las sedes disponebles
     */
    private void actualizarSedes() {
        crearUsuario.cbSedes.removeAllItems();

        ArrayList<Sede> sedes = new SedeDAO().getListaSedes();

        if (sedes != null) {
            for (int i = 0; i < sedes.size(); i++) {
                crearUsuario.cbSedes.addItem(sedes.get(i).getNumero());
            }
        }
    }

    /***
     * Metodo encargado de limpiar los campos de la interfaz CrearUsuario para volver a usarlos depues
     */
    public void limpiarCampos() {
        this.crearUsuario.ftfFechaIncorporacion.setText("");
        this.crearUsuario.ftfFechaNacimiento.setText("");
        this.crearUsuario.pfClave.setText("");
        this.crearUsuario.pfVerificarClave.setText("");
        this.crearUsuario.tfCedula.setText("");
        this.crearUsuario.tfDireccion.setText("");
        this.crearUsuario.tfNombre.setText("");
        this.crearUsuario.tfApellido.setText("");
        this.crearUsuario.tfNumeroCuenta.setText("");
        this.crearUsuario.tfSalario.setText("");
        this.crearUsuario.tfTelefono.setText("");
    }

    /***
     * Metodo encargado de hacer invisible la ventana CrearUsuario
     */
    public void cerrarVentana() {
        this.crearUsuario.setVisible(false);
        limpiarCampos();
    }

    /***
     * Metodo encargado de llamar al modulo DAO y pasarle un usuario para que lo ingrese en la base de datos
     */
    public void crearUsuario() {
        String cedula = this.crearUsuario.tfCedula.getText();
        String passwd = String.valueOf(this.crearUsuario.pfClave.getPassword());
        String nombre = this.crearUsuario.tfNombre.getText();
        String apellido = this.crearUsuario.tfApellido.getText();
        String rol = (String) this.crearUsuario.cbCargo.getSelectedItem();
        String estado = (String) this.crearUsuario.cbEstado.getSelectedItem();
        String fechaNacimiento = this.crearUsuario.ftfFechaNacimiento.getText();
        String direccion = this.crearUsuario.tfDireccion.getText();
        String telefono = this.crearUsuario.tfTelefono.getText();
        String fechaIncorporacion = this.crearUsuario.ftfFechaIncorporacion.getText();
        String salario = this.crearUsuario.tfSalario.getText();
        String cuenta = this.crearUsuario.tfNumeroCuenta.getText();
        String sede = (String) this.crearUsuario.cbSedes.getSelectedItem();

        String rePasswd = String.valueOf(this.crearUsuario.pfVerificarClave.getPassword());

        Usuario nuevoUsuario = new Usuario(cedula, passwd, nombre, apellido, rol, estado, fechaNacimiento, direccion, telefono, fechaIncorporacion, salario, cuenta, sede);

        boolean verificar = verificarCamposCrearUsuario(nuevoUsuario, rePasswd);

        if (verificar) {
            int op = JOptionPane.showConfirmDialog(crearUsuario, "Desea agregar el Usuario " + cedula + " a la Base de Datos?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                boolean resultado = new UsuarioDAO().insetarUsuario(nuevoUsuario);

                if (resultado) {
                    JOptionPane.showMessageDialog(crearUsuario, "Usuario " + cedula + " creado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(crearUsuario, "Error al crear el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /***
     * Metodo encargado de verificar los campos de crear usuario
     * @param usuario Usado para verificar los campos de el usuario
     * @param rePasswd Usado para verificar el password
     * @return Retorna true en caso de que todos los campos esten bien y false de lo contrario
     */
    public boolean verificarCamposCrearUsuario(Usuario usuario, String rePasswd) {
        if (usuario.getCedula().isEmpty()) {
            JOptionPane.showMessageDialog(crearUsuario, "El campo Cedula es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (usuario.getPasswd().isEmpty()) {
            JOptionPane.showMessageDialog(crearUsuario, "El campo Contraseña es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (rePasswd.isEmpty()) {
            JOptionPane.showMessageDialog(crearUsuario, "Debe de confirmar la clave.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!usuario.getPasswd().equals(rePasswd)) {
            JOptionPane.showMessageDialog(crearUsuario, "Las claves deben de coincidir.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (usuario.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(crearUsuario, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (usuario.getApellido().isEmpty()) {
            JOptionPane.showMessageDialog(crearUsuario, "El campo Apellido es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!usuario.getTelefono().isEmpty()) {
            try {
                Long.parseLong(usuario.getTelefono());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(crearUsuario, "El campo Telefono es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (!usuario.getSalario().isEmpty()) {
            try {
                Double.parseDouble(usuario.getSalario());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(crearUsuario, "El campo Salario es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (!usuario.getCuenta().isEmpty()) {
            try {
                Long.parseLong(usuario.getCuenta());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(crearUsuario, "El campo Cuenta es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }
}
