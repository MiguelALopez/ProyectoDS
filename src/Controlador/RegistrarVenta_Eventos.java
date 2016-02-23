/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: RegistrarVenta_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Modelo.Paquete;
import Modelo.ReportesPDF;
import Modelo.Venta;
import Modelo.VentaDAO;
import Vista.RegistrarVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * clase para manejar los eventos de registrar venta
 */
public class RegistrarVenta_Eventos {
    private final RegistrarVenta registrarVenta;
    private ArrayList<Paquete> paquetes;
    private Paquete selected;

    /***
     * Constructor encargado de inicializar los eventos de la interfaz RegistrarVenta
     *
     * @param registrarVenta Objeto que contiene la interfaz RegistrarVenta con todos sus componetes
     */
    public RegistrarVenta_Eventos(final RegistrarVenta registrarVenta) {
        this.registrarVenta = registrarVenta;
        this.paquetes = new ArrayList();
        this.selected = null;

        this.registrarVenta.bCancelar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cerrarFormulario();
                    }
                }
        );

        this.registrarVenta.cbPaquetes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        seleccion();
                    }
                }
        );

        this.registrarVenta.bEliminarPaquete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eliminaPaquete();
                    }
                }
        );

        this.registrarVenta.bAgregarPaquete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        agregaPaquete();
                    }
                }
        );

        this.registrarVenta.cbSeguro.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        agregaSeguro();
                    }
                }
        );

        this.registrarVenta.bRegistrarVenta.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        agregaVenta();
                    }
                }
        );

        actualizaPOS();
        habilitarVenta();
    }

    /***
     * Metodo encargado de conectarse con el modulo DAO y visualizar los POS registrados
     */
    private void actualizaPOS() {
        ArrayList<POS> pos = new POSDAO().getListaPOS();

        if (pos != null) {
            this.registrarVenta.cbPOS.removeAllItems();

            for (POS p : pos) {
                this.registrarVenta.cbPOS.addItem(p.getId());
            }
        }
    }

    /***
     * Metodo encargado de habilitar los componentes para su edicion
     */
    private void habilitarVenta() {
        boolean b;
        b = this.registrarVenta.cbPOS.getItemCount() > 0;

        this.registrarVenta.tfCedula.setEditable(b);
        this.registrarVenta.tfNombre.setEditable(b);
        this.registrarVenta.tfDireccion.setEditable(b);
        this.registrarVenta.tfAgregarVolumen.setEditable(b);
        this.registrarVenta.tfAgregarPeso.setEditable(b);
        this.registrarVenta.taAgregarDescripcion.setEditable(b);
        this.registrarVenta.tfCosto.setEditable(b);
        this.registrarVenta.cbPaquetes.setEnabled(b);
        this.registrarVenta.bAgregarPaquete.setEnabled(b);
        this.registrarVenta.bEliminarPaquete.setEnabled(b);
        this.registrarVenta.rbEfectivo.setEnabled(b);
        this.registrarVenta.rbCredito.setEnabled(b);
        this.registrarVenta.rbDebito.setEnabled(b);
        this.registrarVenta.cbSeguro.setEnabled(b);
        this.registrarVenta.bRegistrarVenta.setEnabled(b);
    }

    /***
     * Metodo encargado de hacer invisible la ventana para el usuario
     */
    public void cerrarFormulario() {
        this.registrarVenta.setVisible(false);
    }

    /***
     * Metodo encargado de capturar la seleccion de un paquete para mostrar los detalles de este
     */
    public void seleccion() {
        int index = this.registrarVenta.cbPaquetes.getSelectedIndex();

        if (index != -1) {
            this.selected = this.paquetes.get(index);

            if (selected != null) {
                this.registrarVenta.tfVerVolumen.setText(selected.getVolumen() + "");
                this.registrarVenta.tfVerPeso.setText(selected.getPeso() + "");
                this.registrarVenta.taVerDescripcion.setText(selected.getDescripcion());
                this.registrarVenta.tfVerCosto.setText(selected.getCosto() + "");
            }
        } else {
            this.selected = null;
        }
    }

    /***
     * Metodo encargado de eliminar la lista temporal de paquetes que se va a registrar
     */
    public void eliminaPaquete() {
        if (this.selected != null) {
            int index = this.registrarVenta.cbPaquetes.getSelectedIndex();
            this.paquetes.remove(index);

            for (int i = index; i < this.paquetes.size(); i++) {
                this.paquetes.get(i).setNumero(this.paquetes.get(i).getNumero() - 1);
            }

            borrarCamposPaquete();
            actualizaLista();

            calcular();
        }
    }

    /***
     * Metodo encargado de verificar si los campos del paquete se llenaron correctamente
     * @return Retorna true si se lleno el formulario correctamente y false de lo contrario
     */
    public boolean verificaCamposPaquete() {
        if (!this.registrarVenta.tfAgregarVolumen.getText().isEmpty()) {
            try {
                Double.parseDouble(this.registrarVenta.tfAgregarVolumen.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(registrarVenta, "El campo Volumen es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(registrarVenta, "El campo Volumen es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!this.registrarVenta.tfAgregarPeso.getText().isEmpty()) {
            try {
                Double.parseDouble(this.registrarVenta.tfAgregarPeso.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(registrarVenta, "El campo Peso es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(registrarVenta, "El campo Peso es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.registrarVenta.taAgregarDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registrarVenta, "El campo Descripcion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!this.registrarVenta.tfCosto.getText().isEmpty()) {
            try {
                Double.parseDouble(this.registrarVenta.tfCosto.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(registrarVenta, "El campo Costo es numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(registrarVenta, "El campo Costo es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /***
     * Metodo encargado de agregar un paquete a una lista temporal de paquetes
     */
    public void agregaPaquete() {
        if (verificaCamposPaquete()) {
            int numero = this.paquetes.size() + 1;
            double volumen = Double.parseDouble(this.registrarVenta.tfAgregarVolumen.getText());
            double peso = Double.parseDouble(this.registrarVenta.tfAgregarPeso.getText());
            String descripcion = this.registrarVenta.taAgregarDescripcion.getText();
            double costo = Double.parseDouble(this.registrarVenta.tfCosto.getText());

            Paquete insert = new Paquete("", numero, volumen, peso, descripcion, costo);
            this.paquetes.add(insert);

            borrarCamposPaquete();
            actualizaLista();

            // Autoseleccionar ultimo item agregado
            this.registrarVenta.cbPaquetes.setSelectedIndex(numero - 1);

            calcular();
        }
    }

    /***
     * Metodo encargado de verificar si los campos de venta se llenaron correctamente
     * @return Retorna true si el formulario se lleno correctamente y false de lo contrario
     */
    public boolean verificaCamposVenta() {
        if (this.registrarVenta.tfCedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registrarVenta, "El campo Cedula es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.registrarVenta.tfNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registrarVenta, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.registrarVenta.tfDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registrarVenta, "El campo Direccion es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (this.paquetes.size() <= 0) {
            JOptionPane.showMessageDialog(registrarVenta, "Debe agregar al menos 1 paquete.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!this.registrarVenta.rbEfectivo.isSelected() && !this.registrarVenta.rbCredito.isSelected() && !this.registrarVenta.rbDebito.isSelected()) {
            JOptionPane.showMessageDialog(registrarVenta, "Debe seleccionar un metodo de pago.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /***
     * Metodo encargado de conectarse con el modulo DAO y enviar una venta para registrarla en la base de datos
     */
    public void agregaVenta() {
        if (verificaCamposVenta()) {
            String pos = (String) this.registrarVenta.cbPOS.getSelectedItem();
            String cedula = this.registrarVenta.tfCedula.getText();
            String nombre = this.registrarVenta.tfNombre.getText();
            String direccion = this.registrarVenta.tfDireccion.getText();

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = df.format(Calendar.getInstance().getTime());

            String metodo = "";

            if (this.registrarVenta.rbEfectivo.isSelected()) {
                metodo = this.registrarVenta.rbEfectivo.getText();
            } else if (this.registrarVenta.rbCredito.isSelected()) {
                metodo = this.registrarVenta.rbCredito.getText();
            } else if (this.registrarVenta.rbDebito.isSelected()) {
                metodo = this.registrarVenta.rbDebito.getText();
            }

            double seguro = Double.parseDouble(this.registrarVenta.tfSeguro.getText());
            double subtotal = Double.parseDouble(this.registrarVenta.tfSubtotal.getText());
            double iva = Double.parseDouble(this.registrarVenta.tfIVA.getText());
            double total = Double.parseDouble(this.registrarVenta.tfTotal.getText());

            Venta venta = new Venta(cedula, nombre, direccion, fecha, metodo, seguro, subtotal, iva, total, pos, this.paquetes);

            int op = JOptionPane.showConfirmDialog(registrarVenta, "Desea registrar la Venta?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                boolean exito = new VentaDAO().insertarVenta(venta);

                if (exito) {
                    JOptionPane.showMessageDialog(registrarVenta, "Venta registrada correctamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    borrarCamposVenta();

                    generaRecibo(new VentaDAO().consultarUltimaVenta(cedula));
                } else {
                    JOptionPane.showMessageDialog(registrarVenta, "Error al registrar la Venta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /***
     * Metodo encargado de comunicarse con el modulo de reportes para generar el recibo
     * @param venta
     */
    public void generaRecibo(Venta venta) {
        ReportesPDF.generarRecibo(venta);
    }

    /***
     * Metodo encargado de actualizar la lista de paquetes
     */
    public void actualizaLista() {
        this.registrarVenta.cbPaquetes.removeAllItems();

        for (Paquete i : this.paquetes) {
            this.registrarVenta.cbPaquetes.addItem(i.getNumero() + "");
        }
    }

    /***
     * Metodo encargado de adicionarl el valor del seguro al valor total
     */
    public void agregaSeguro() {
        if (this.registrarVenta.cbSeguro.isSelected()) {
            double total = Double.parseDouble(this.registrarVenta.tfTotal.getText());
            double seguro = total * 0.02;

            this.registrarVenta.tfSeguro.setText(seguro + "");
        } else {
            this.registrarVenta.tfSeguro.setText("0.0");
        }

        calcular();
    }

    /***
     * Metodo encargado de calcular el precio de la venta
     */
    public void calcular() {
        double iva;
        double subtotal = 0;

        for (Paquete p : this.paquetes) {
            subtotal += p.getCosto();
        }

        iva = subtotal * 0.16;
        double total = subtotal + iva;

        if (this.registrarVenta.cbSeguro.isSelected()) {
            double seguro = Double.parseDouble(this.registrarVenta.tfSeguro.getText());
            total += seguro;
        }

        this.registrarVenta.tfSubtotal.setText("" + subtotal);
        this.registrarVenta.tfIVA.setText("" + iva);
        this.registrarVenta.tfTotal.setText(total + "");
    }

    /***
     * Metodo encargado de limpiar los campos de venta para volver a usarlos despues
     */
    public void borrarCamposVenta() {
        this.registrarVenta.cbPOS.setSelectedIndex(0);
        this.registrarVenta.tfCedula.setText("");
        this.registrarVenta.tfNombre.setText("");
        this.registrarVenta.tfDireccion.setText("");
        this.paquetes = new ArrayList();
        actualizaLista();
        borrarCamposPaquete();
        this.registrarVenta.buttonGroup1.clearSelection();
        this.registrarVenta.cbSeguro.setSelected(false);
        this.registrarVenta.tfSeguro.setText("0.0");
        this.registrarVenta.tfSubtotal.setText("0.0");
        this.registrarVenta.tfIVA.setText("0.0");
        this.registrarVenta.tfTotal.setText("0.0");
    }

    /***
     * Metodo encargado de limpiar los campos de paquete para volver a usarlos despues
     */
    public void borrarCamposPaquete() {
        this.registrarVenta.taAgregarDescripcion.setText("");
        this.registrarVenta.taVerDescripcion.setText("");
        this.registrarVenta.tfAgregarPeso.setText("");
        this.registrarVenta.tfAgregarVolumen.setText("");
        this.registrarVenta.tfCosto.setText("");
        this.registrarVenta.tfVerPeso.setText("");
        this.registrarVenta.tfVerVolumen.setText("");
        this.registrarVenta.tfVerCosto.setText("");
    }
}
