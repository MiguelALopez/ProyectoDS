/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: CrearSede_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.Sede;
import Modelo.SedeDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.CrearSede;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * clase para manejar los eventos de crear sede
 */
public class CrearSede_Eventos {
    private final CrearSede crearSede;

    /***
     * Constructor encargado de inicializar los eventos de la intefaz CrearSede
     *
     * @param crearSede Objeto que contiene la interfaz CrearSede con todos sus componentes
     */
    public CrearSede_Eventos(final CrearSede crearSede) {
        this.crearSede = crearSede;

        this.crearSede.bCancelarMain.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarVentana();
                    }
                }
        );

        this.crearSede.bSelGerente.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        consultaGerentes();
                    }
                }
        );

        this.crearSede.bSeleccionar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        seleccionaGerente();
                    }
                }
        );

        this.crearSede.bCrear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        agregaSede();
                    }
                }
        );

        this.crearSede.bCancelar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarSeleccion();
                    }
                }
        );

        crearSede.addWindowListener(
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
    }

    /***
     * Metodo encargado de conectarse con el modulo DAO para enviarle una
     * sede para que la agrege a la base de datos
     */
    public void agregaSede() {
        if (validaCampos()) {
            String numero = this.crearSede.tfNumero.getText();
            String nombre = this.crearSede.tfNombre.getText();
            String direccion = this.crearSede.tfDireccion.getText();
            String ciudad = this.crearSede.cbCiudad.getSelectedItem().toString();
            String gerente = this.crearSede.tfGerente.getText();

            int op = JOptionPane.showConfirmDialog(crearSede, "Desea crear la sede " + numero + "?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                Sede sede = new Sede(numero, nombre, direccion, ciudad, gerente, 0);

                boolean exito = new SedeDAO().insertarSede(sede);

                if (exito) {
                    JOptionPane.showMessageDialog(crearSede, "Sede creada exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    borraCampos();
                } else {
                    JOptionPane.showMessageDialog(crearSede, "Error al crear.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /***
     * Metodo encargado de hacer invisible la interfaz de CrearSede para los usuarios
     */
    public void cerrarVentana() {
        this.crearSede.setVisible(false);
        this.crearSede.fSelGerente.setVisible(false);
    }

    /***
     * Metodo encargado de cerrar e subFrame que se encarga de seleccionar el gerente
     */
    public void cerrarSeleccion() {
        this.crearSede.fSelGerente.setVisible(false);
    }

    /***
     * Metodo encargado de conectarse con el modulo DAO y mostar la lista de gerentes disponibles para
     * ponerlo a cargo de una sede
     */
    public void consultaGerentes() {
        ArrayList<Usuario> listaGerentes = new UsuarioDAO().getListaGerentes();

        if (listaGerentes != null) {
            DefaultTableModel model = (DefaultTableModel) this.crearSede.tGerentes.getModel();
            model.setRowCount(listaGerentes.size());

            for (int i = 0; i < listaGerentes.size(); i++) {
                this.crearSede.tGerentes.setValueAt(listaGerentes.get(i).getCedula(), i, 0);
                this.crearSede.tGerentes.setValueAt(listaGerentes.get(i).getNombre(), i, 1);
                this.crearSede.tGerentes.setValueAt(listaGerentes.get(i).getApellido(), i, 2);
            }

            this.crearSede.fSelGerente.setLocationRelativeTo(crearSede);
            this.crearSede.fSelGerente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(crearSede, "Error al consultar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /***
     * Metodo encargado de llevar el gerente seleccionado al frame de CrearSede
     */
    public void seleccionaGerente() {
        int row = this.crearSede.tGerentes.getSelectedRow();

        if (row != -1) {
            this.crearSede.tfGerente.setText((String) this.crearSede.tGerentes.getValueAt(row, 0));

            DefaultTableModel model = (DefaultTableModel) this.crearSede.tGerentes.getModel();
            model.setRowCount(0);

            this.crearSede.fSelGerente.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this.crearSede.fSelGerente, "Seleccione un gerente.", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    /***
     * Metodo encargado de limpiar los campos para poder usarlos de nuevo despues
     */
    public void borraCampos() {
        this.crearSede.tfDireccion.setText("");
        this.crearSede.tfGerente.setText("");
        this.crearSede.tfNombre.setText("");
        this.crearSede.tfNumero.setText("");
        this.crearSede.cbCiudad.setSelectedIndex(0);
    }

    /***
     * Metodo encargado de validar si se han llenado los campos correctamente
     * @return Retorna true si los campos se llenaron correctamente y false de lo contrario
     */
    public boolean validaCampos() {
        if (this.crearSede.tfNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(crearSede, "El campo Numero es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (new SedeDAO().consultarSede(this.crearSede.tfNumero.getText()) == null) {
            JOptionPane.showMessageDialog(crearSede, "La sede " + this.crearSede.tfNumero.getText() + " ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.crearSede.tfNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(crearSede, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.crearSede.tfDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(crearSede, "El campo Direccion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
