/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: ModificarPOS_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Vista.ModificarPOS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * clase para manejar los eventos de modificar pos
 */
public class ModificarPOS_Eventos 
{
    private final ModificarPOS modificarPOS;
    
    public ModificarPOS_Eventos(final ModificarPOS modificarPOS)
    {
        this.modificarPOS = modificarPOS;
        
        modificarPOS.bBuscar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    buscarPOS();
                }
            }
        );
        
        modificarPOS.bModificar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    modificarPOS();
                }
            }
        );
	
	modificarPOS.bCancelar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    cerrarVentana();
                }
            }
        );
    }

    /***
     * Metodo encargado de conectarse con el modulo DAO y buscar si un pos existe,
     * de ser asi carga los datos el pos en los campos de la interfaz
     */
    public void buscarPOS()
    {
        String id = this.modificarPOS.tfBuscar.getText();
        
        POS pos = new POSDAO().consultarPOS(id);
        
        if (pos != null)
        {
            this.modificarPOS.tfID.setText(pos.getId());
            this.modificarPOS.tfNombre.setText(pos.getNombre());
            this.modificarPOS.tfDireccion.setText(pos.getDireccion());
            habilitarCampos(true);
        }
        else
        {
            JOptionPane.showMessageDialog(modificarPOS, "Error al buscar el POS.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /***
     * Metodo encargado de habilitar los campos para la edicion
     * @param b booleano encargado de determinar si se habilitan o se desabilitan los campos
     */
    public void habilitarCampos(boolean b)
    {
        this.modificarPOS.tfNombre.setEditable(b);
        this.modificarPOS.tfDireccion.setEditable(b);
    }

    /***
     * Metodo encargado de conectarse con el modulo DAO y enviarle las modificaciones de un POS
     */
    public void modificarPOS()
    {
        if (verificarCampos())
        {
            String id = this.modificarPOS.tfID.getText();
            String nombre = this.modificarPOS.tfNombre.getText();
            String direccion = this.modificarPOS.tfDireccion.getText();
            
            POS pos = new POS(id, nombre, direccion);
            
            int op = JOptionPane.showConfirmDialog(modificarPOS, "Desea modificar el POS " + id + "?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (op == JOptionPane.YES_OPTION)
            {
                boolean exito = new POSDAO().modificarPOS(pos);
                
                if (exito)
                {
                    JOptionPane.showMessageDialog(modificarPOS, "POS " + id + " modificado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(modificarPOS, "Error al modificar el POS.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /***
     * Metodo encargado de verificar si los campos del pos se llenaron de forma correcta
     * @return Retorna true si los campos se llenaron correctamente y false de lo contrario
     */
    public boolean verificarCampos()
    {
        if (this.modificarPOS.tfID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarPOS, "Campo ID obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (this.modificarPOS.tfNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarPOS, "Campo Nombre obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (this.modificarPOS.tfDireccion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(modificarPOS, "Campo Direccion obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    /***
     * Metodo encargado de limpiar los campos de los datos de pos para volver a usarlos despues
     */
    public void limpiarCampos()
    {
        this.modificarPOS.tfBuscar.setText("");
        this.modificarPOS.tfID.setText("");
        this.modificarPOS.tfNombre.setText("");
        this.modificarPOS.tfDireccion.setText("");
    }

    /***
     * Metodo encargado de hacer invisible la ventana al usuario
     */
    public void cerrarVentana()
    {
	    this.modificarPOS.setVisible(false);
    }
}
