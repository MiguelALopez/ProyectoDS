/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: ConsultarUsuarios_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.ConsultarUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * clase para manejar los eventos de consultar usuarios
 */
public class ConsultarUsuarios_Eventos {
    private final ConsultarUsuarios consultarUsuarios;

    /***
     * Constuctor encargado de inicializar los eventos de la interfaz ConsultarUsuarios
     *
     * @param consultarUsuarios Objeto que contiene la interfaz ConsultarUsuarios
     */
    public ConsultarUsuarios_Eventos(final ConsultarUsuarios consultarUsuarios) {
        this.consultarUsuarios = consultarUsuarios;

        consultarUsuarios.bCerrar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        cerrarVentana();
                    }
                }
        );

        consultarUsuarios.bActualizar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        consultarUsuarios();
                    }
                }
        );

        consultarUsuarios.bVerPerfil.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        verPerfil();
                    }
                }
        );

        consultarUsuarios.bCerrarPerfil.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        cerrarPerfil();
                    }
                }
        );

        consultarUsuarios.addWindowListener(
                new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        cerrarVentana();
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {
                    }

                    @Override
                    public void windowActivated(WindowEvent e) {
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                    }
                }
        );

        consultarUsuarios();
    }

    private void consultarUsuarios() {
        ArrayList<Usuario> usuarios = new UsuarioDAO().getListaUsuarios(); // aqui metodo DAO para obtener todos los usuarios de la BD

        if (usuarios != null) {
            DefaultTableModel model = (DefaultTableModel) this.consultarUsuarios.tUsuarios.getModel();
            model.setRowCount(usuarios.size());

            for (int i = 0; i < usuarios.size(); i++) {
                this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getCedula(), i, 0);
                this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getNombre(), i, 1);
                this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getApellido(), i, 2);
                this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getRol(), i, 3);
                this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getEstado(), i, 4);
            }
        }
    }

    public void cerrarVentana() {
        this.consultarUsuarios.setVisible(false);
        this.consultarUsuarios.fPerfil.setVisible(false);
    }

    public void verPerfil() {
        int row = consultarUsuarios.tUsuarios.getSelectedRow();

        if (row != -1) {
            String cedula = (String) consultarUsuarios.tUsuarios.getValueAt(row, 0);

            Usuario usuario = new UsuarioDAO().consultarUsuario(cedula);

            if (usuario != null) {
                this.consultarUsuarios.tfCedula.setText(usuario.getCedula());
                this.consultarUsuarios.tfRol.setText(usuario.getRol());
                this.consultarUsuarios.tfNombre.setText(usuario.getNombre());
                this.consultarUsuarios.tfApellido.setText(usuario.getApellido());
                this.consultarUsuarios.tfFechaNacimiento.setText(usuario.getFechaNacimiento());
                this.consultarUsuarios.tfFechaIncorporacion.setText(usuario.getFechaIncorporacion());
                this.consultarUsuarios.tfDireccion.setText(usuario.getDireccion());
                this.consultarUsuarios.tfSalario.setText(usuario.getSalario());
                this.consultarUsuarios.tfTelefono.setText(usuario.getTelefono());
                this.consultarUsuarios.tfNumeroCuenta.setText(usuario.getCuenta());
                this.consultarUsuarios.tfSede.setText(usuario.getNumeroSede());
                this.consultarUsuarios.tfEstado.setText(usuario.getEstado());

                this.consultarUsuarios.fPerfil.setLocationRelativeTo(consultarUsuarios);
                this.consultarUsuarios.fPerfil.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(consultarUsuarios, "No ha seleccionado ningun Usuario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void borrarCamposPerfil() {
        this.consultarUsuarios.tfCedula.setText("");
        this.consultarUsuarios.tfRol.setText("");
        this.consultarUsuarios.tfNombre.setText("");
        this.consultarUsuarios.tfApellido.setText("");
        this.consultarUsuarios.tfFechaNacimiento.setText("");
        this.consultarUsuarios.tfFechaIncorporacion.setText("");
        this.consultarUsuarios.tfDireccion.setText("");
        this.consultarUsuarios.tfSalario.setText("");
        this.consultarUsuarios.tfTelefono.setText("");
        this.consultarUsuarios.tfNumeroCuenta.setText("");
        this.consultarUsuarios.tfSede.setText("");
        this.consultarUsuarios.tfEstado.setText("");
    }

    public void cerrarPerfil() {
        this.consultarUsuarios.fPerfil.setVisible(false);
        borrarCamposPerfil();
    }
}
