/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: CrearPOS_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.POS;
import Modelo.POSDAO;
import Vista.CrearPOS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * clase para manejar los eventos de crear pos
 */
public class CrearPOS_Eventos 
{
    private final CrearPOS crearPOS;

    /***
     * Constructor encargado de inicializar los eventos de la interfaz de CrearPOS
     * @param crearPOS Objeto que contiene la interfaz CrearPOS con todos sus componentes
     */
    public CrearPOS_Eventos(final CrearPOS crearPOS)
    {
        this.crearPOS = crearPOS;
        
        crearPOS.bCrearPOS.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    crearPOS();
                }
            }
        );
	
	crearPOS.bCancelar.addActionListener(
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
     * Metodo encargado de pasarle al modulo DAO los datos de un pos para que los ingrese a la base de datos
     */
    public void crearPOS()
    {
        if (verificarCampos())
        {
            String id = this.crearPOS.tfID.getText();
            String nombre = this.crearPOS.tfNombre.getText();
            String direccion = this.crearPOS.tfDireccion.getText();
            
            POS pos = new POS(id, nombre, direccion);
            
            int op = JOptionPane.showConfirmDialog(crearPOS, "Desea crear el POS " + id + "?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (op == JOptionPane.YES_OPTION)
            {
                boolean exito = new POSDAO().insertarPOS(pos);
                
                if (exito)
                {
                    JOptionPane.showMessageDialog(crearPOS, "POS " + id + " creado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                }
                else
                {
                    JOptionPane.showMessageDialog(crearPOS, "Error al crear el POS.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /***
     * Metodo encargado de verificar si los campos del pos se llenaron correctamente
     * @return Retorna true si los campos de llenaron correctamente y false de lo contrario
     */
    public boolean verificarCampos()
    {
        if (this.crearPOS.tfID.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPOS, "Campo ID obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (this.crearPOS.tfNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPOS, "Campo Nombre obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (this.crearPOS.tfDireccion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPOS, "Campo Direccion obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    /***
     * Metodo encargado de limpoar los campos de la intefaz de CrearPOS para volver a usarlos
     */
    public void limpiarCampos()
    {
        this.crearPOS.tfID.setText("");
        this.crearPOS.tfNombre.setText("");
        this.crearPOS.tfDireccion.setText("");
    }

    /***
     * Metodo encargado de hacer invisible la interfaz de CrearPOS al usuario
     */
    public void cerrarVentana()
    {
	    this.crearPOS.setVisible(false);
    }
}
