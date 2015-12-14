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

import Modelo.PQR;
import Modelo.PQRDAO;
import Vista.ResponderPQR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ResponderPQR_Eventos 
{
    private ResponderPQR responderPQR;
    private PQRDAO pqrDAO;
    
    public ResponderPQR_Eventos(final ResponderPQR responderPQR)
    {
        this.responderPQR = responderPQR;
        this.pqrDAO = new PQRDAO();
        
        responderPQR.bBuscarPQR.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        buscarPQR();
                    }
                }
        );
        
        responderPQR.bSalir.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        responderPQR.bEnviar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        responderPQR();
                    }
                }
        );
    }
    
    public void responderPQR()
    {
        String numeroPQR = this.responderPQR.tfNumeroPQR.getText();
        String cedula = this.responderPQR.tfCedula.getText();
        String nombre = this.responderPQR.tfNombre.getText();
        String sede = this.responderPQR.tfSede.getText();
        String tipo = this.responderPQR.tfTipo.getText();        
        String contenido = this.responderPQR.taContenido.getText();
        String estado = "Respondido";
        String respuesta = this.responderPQR.taRespuesta.getText();
        
        String nuevoContenido = contenido + "\n\n\n" + respuesta;
        
        PQR pqr = new PQR(numeroPQR, cedula, nombre, sede, tipo, nuevoContenido, estado);
        
        if (!respuesta.isEmpty())
        {
            int op = JOptionPane.showConfirmDialog(responderPQR, "Desea responder el PQR N° " + numeroPQR + "?", "Confirmacion", JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION)
            {
                boolean resultado = pqrDAO.modificarPQR(pqr);
                //boolean resultado = false;

                if (resultado)
                {
                    JOptionPane.showMessageDialog(responderPQR, "Se ha adicionado una respuesta al PQR N° " + numeroPQR + " exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    habilitarCampos(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(responderPQR, "Error al adicionar una respuesta al PQR.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(responderPQR, "Debe adicionar una respuesta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buscarPQR()
    {
        boolean verificar = verificarCamposBuscarPQR();
        
        if (verificar)
        {
            String numeroPQR = this.responderPQR.tfBuscarPQR.getText();
                
            PQR pqr = this.pqrDAO.consultarPQR(numeroPQR);
            //Usuario pqr = new Usuario();

            if (pqr != null)
            {
                this.responderPQR.tfNumeroPQR.setText(pqr.getNumero());
                this.responderPQR.tfCedula.setText(pqr.getCedula());
                this.responderPQR.tfNombre.setText(pqr.getNombre());
                this.responderPQR.tfTipo.setText(pqr.getTipo());
                this.responderPQR.tfSede.setText(pqr.getSede());
                this.responderPQR.taContenido.setText(pqr.getContenido());
                this.responderPQR.tfEstado.setText(pqr.getEstado());

                habilitarCampos(true);
            }
            else
            {
                JOptionPane.showMessageDialog(responderPQR, "Error al consultar en la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean verificarCamposBuscarPQR()
    {
        if (this.responderPQR.tfBuscarPQR.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(responderPQR, "Debe de introducir el numero de PQR para buscar el PQR.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public void habilitarCampos(boolean b)
    {
        this.responderPQR.tfBuscarPQR.setEnabled(!b);
        this.responderPQR.bBuscarPQR.setEnabled(!b);
        
        this.responderPQR.taRespuesta.setEditable(b);
    }
    
    public void limpiarCampos()
    {
        this.responderPQR.tfBuscarPQR.setText("");
        this.responderPQR.tfNumeroPQR.setText("");
        this.responderPQR.tfCedula.setText("");
        this.responderPQR.tfNombre.setText("");
        this.responderPQR.tfTipo.setText("");
        this.responderPQR.tfSede.setText("");
        this.responderPQR.taContenido.setText("");
        this.responderPQR.tfEstado.setText("");
        this.responderPQR.taRespuesta.setText("");
    }
    
    public void cerrarVentana()
    {
        this.responderPQR.setVisible(false);
        limpiarCampos();
        habilitarCampos(false);
    }
}
