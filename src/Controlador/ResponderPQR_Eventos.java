/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: ResponderPQR_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.PQR;
import Modelo.PQRDAO;
import Vista.ResponderPQR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * clase para manejar los eventos de responder pqr
 */
public class ResponderPQR_Eventos {
    private final ResponderPQR responderPQR;

    /***
     * Constructor encargado de inicializar la interfaz con sus respectivos eventos
     *
     * @param responderPQR
     */
    public ResponderPQR_Eventos(final ResponderPQR responderPQR) {
        this.responderPQR = responderPQR;

        responderPQR.bBuscarPQR.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        buscarPQR();
                    }
                }
        );

        responderPQR.bCancelar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        cerrarVentana();
                    }
                }
        );

        responderPQR.bEnviar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        responderPQR();
                    }
                }
        );
    }

    /***
     * Metodo encargado de conectarse con el modulo de DAO para enviarle la respuesta de un PQR
     * y registarla en la base de datos
     */
    public void responderPQR() {
        String numero = this.responderPQR.tfNumeroPQR.getText();
        String fecha = this.responderPQR.tfFecha.getText();
        String tipo = this.responderPQR.tfTipo.getText();
        String contenido = this.responderPQR.taContenido.getText();
        String estado = (String) this.responderPQR.cbEstado.getSelectedItem();
        String cedula = this.responderPQR.tfCedula.getText();
        String nombre = this.responderPQR.tfNombre.getText();
        String sede = this.responderPQR.tfSede.getText();
        String respuesta = this.responderPQR.taRespuesta.getText();

        String fechaR = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        String nuevoContenido = contenido + "\n\n\n[" + fechaR + "]:\n" + respuesta;

        PQR pqr = new PQR(numero, fecha, tipo, nuevoContenido, estado, cedula, nombre, sede);

        if (!respuesta.isEmpty()) {
            int op = JOptionPane.showConfirmDialog(responderPQR, "Desea responder el PQR N° " + numero + "?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                boolean resultado = new PQRDAO().modificarPQR(pqr);

                if (resultado) {
                    JOptionPane.showMessageDialog(responderPQR, "Se ha adicionado una respuesta al PQR N° " + numero + " exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    habilitarCampos(false);
                } else {
                    JOptionPane.showMessageDialog(responderPQR, "Error al adicionar una respuesta al PQR.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(responderPQR, "Debe adicionar una respuesta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /***
     * Metodo encargado de buscar una PQR, y llenar los campos con sus respectivos campos
     */
    public void buscarPQR() {
        boolean verificar = verificarCamposBuscarPQR();

        if (verificar) {
            String numeroPQR = this.responderPQR.tfBuscarPQR.getText();

            PQR pqr = new PQRDAO().consultarPQR(numeroPQR);

            if (pqr != null) {
                this.responderPQR.tfNumeroPQR.setText(pqr.getNumero());
                this.responderPQR.tfFecha.setText(pqr.getFecha());
                this.responderPQR.tfTipo.setText(pqr.getTipo());
                this.responderPQR.taContenido.setText(pqr.getContenido());
                this.responderPQR.tfEstado.setText(pqr.getEstado());
                this.responderPQR.tfCedula.setText(pqr.getCedula());
                this.responderPQR.tfNombre.setText(pqr.getNombre());
                this.responderPQR.tfSede.setText(pqr.getSede());

                habilitarCampos(true);
            } else {
                JOptionPane.showMessageDialog(responderPQR, "Error al consultar en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /***
     * Metodo encargado de verificar que los campos de busqueda de PQR se encuentren bien
     * @return Retorna true si los valores fueron llenados correctamente y false de lo contrario
     */
    public boolean verificarCamposBuscarPQR() {
        if (this.responderPQR.tfBuscarPQR.getText().isEmpty()) {
            JOptionPane.showMessageDialog(responderPQR, "Debe de introducir el numero de PQR para buscar el PQR.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /***
     * Metodo encargado de habilitar o desabilitar los campos para responder una PQR
     * @param b booleano encargado de determinar si se activan las casillas o se desactivan
     */
    public void habilitarCampos(boolean b) {
        this.responderPQR.taRespuesta.setEditable(b);
        this.responderPQR.cbEstado.setEnabled(b);
    }

    /***
     * Metodo encargado de limpiar los campos de la respuesta del PQR para usarlo luego
     */
    public void limpiarCampos() {
        this.responderPQR.tfBuscarPQR.setText("");
        this.responderPQR.tfNumeroPQR.setText("");
        this.responderPQR.tfFecha.setText("");
        this.responderPQR.tfTipo.setText("");
        this.responderPQR.taContenido.setText("");
        this.responderPQR.tfEstado.setText("");
        this.responderPQR.tfCedula.setText("");
        this.responderPQR.tfNombre.setText("");
        this.responderPQR.tfSede.setText("");
        this.responderPQR.cbEstado.setSelectedIndex(0);
        this.responderPQR.taRespuesta.setText("");
    }

    /***
     * Metodo encargado de hacer invisible la ventana de respuesta de PQR al usuario
     */
    public void cerrarVentana() {
        this.responderPQR.setVisible(false);
    }
}
