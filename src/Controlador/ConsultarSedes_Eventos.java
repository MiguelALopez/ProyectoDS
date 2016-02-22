/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: ConsultarSedes_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.Sede;
import Modelo.SedeDAO;
import Vista.ConsultarSedes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * clase para manejar los eventos de consultar sedes
 */
public class ConsultarSedes_Eventos {
    private final ConsultarSedes consultarSedes;

    /***
     * Constuctor encargado de inicializar los enventos de la interfaz ConsultarSedes
     *
     * @param consultarSede Objeto el cual contiene la interfaz ConsultarSedes
     */
    public ConsultarSedes_Eventos(final ConsultarSedes consultarSede) {
        this.consultarSedes = consultarSede;

        cargarDatos();

        this.consultarSedes.bCerrar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarVentana();
                    }
                }
        );

        this.consultarSedes.bActualizar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cargarDatos();
                    }
                }
        );

        this.consultarSedes.bVerDetalles.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        verDetalles();
                    }
                }
        );

        this.consultarSedes.bCerrarDetalles.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarDetalles();
                    }
                }
        );
    }

    /***
     * Metodo encargado de hacer invisible al usario a ventana de CosultarSedes
     */
    public void cerrarVentana() {
        this.consultarSedes.setVisible(false);
        this.consultarSedes.fDetalles.setVisible(false);
    }

    /**
     * Metod encargado de conectarse con el modulo de DAO y llenar los datos de la tabla con
     * los datos mas relevantes acerca de una sede
     */
    private void cargarDatos() {
        ArrayList<Sede> listaSedes = new SedeDAO().getListaSedes();

        if (listaSedes != null) {
            DefaultTableModel model = (DefaultTableModel) this.consultarSedes.tSedes.getModel();
            model.setRowCount(listaSedes.size());

            for (int i = 0; i < listaSedes.size(); i++) {
                this.consultarSedes.tSedes.setValueAt(listaSedes.get(i).getNumero(), i, 0);
                this.consultarSedes.tSedes.setValueAt(listaSedes.get(i).getNombre(), i, 1);
                this.consultarSedes.tSedes.setValueAt(listaSedes.get(i).getDireccion(), i, 2);
                this.consultarSedes.tSedes.setValueAt(listaSedes.get(i).getCiudad(), i, 3);
            }
        }
    }

    /***
     * Metodo encargado de conectarse con el modulo DAO y mostar los detalles de una sede
     */
    public void verDetalles() {
        int row = consultarSedes.tSedes.getSelectedRow();

        if (row != -1) {
            String numeroSedes = (String) consultarSedes.tSedes.getValueAt(row, 0);

            Sede pqr = new SedeDAO().consultarSede(numeroSedes);

            if (pqr != null) {
                this.consultarSedes.tfNumero.setText(pqr.getNumero());
                this.consultarSedes.tfNombre.setText(pqr.getNombre());
                this.consultarSedes.tfDireccion.setText(pqr.getDireccion());
                this.consultarSedes.tfCiudad.setText(pqr.getCiudad());
                this.consultarSedes.tfGerente.setText(pqr.getGerente());
                this.consultarSedes.tfCamiones.setText(String.valueOf(pqr.getCamiones()));

                this.consultarSedes.fDetalles.setLocationRelativeTo(consultarSedes);
                this.consultarSedes.fDetalles.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(consultarSedes, "No ha seleccionado ninguna Sede.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    /***
     * Metod encargado de hacer invisible al usuario el subFrame de detalles
     */
    public void cerrarDetalles() {
        this.consultarSedes.fDetalles.setVisible(false);
        borrarCamposDetalles();
    }

    /***
     * Metodo encargado de limpiar la tabla encargada de mostrar los detalles de una sede
     */
    public void borrarCamposDetalles() {
        this.consultarSedes.tfNumero.setText("");
        this.consultarSedes.tfNombre.setText("");
        this.consultarSedes.tfDireccion.setText("");
        this.consultarSedes.tfCiudad.setText("");
        this.consultarSedes.tfGerente.setText("");
        this.consultarSedes.tfCamiones.setText("");
    }
}
