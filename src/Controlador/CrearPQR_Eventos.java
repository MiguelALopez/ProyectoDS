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
import Modelo.ReportesPDF;
import Modelo.Sede;
import Modelo.SedeDAO;
import Vista.CrearPQR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Jurado
 * clase para manejar los eventos de crear pqr
 */
public class CrearPQR_Eventos 
{
    private final CrearPQR crearPQR;
    
    public CrearPQR_Eventos(final CrearPQR crearPQR) 
    {
        this.crearPQR = crearPQR;
        
        crearPQR.bCancelar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    cerrarVentana();
                }
            }
        );
        
        crearPQR.bEnviar.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    crearPQR();
                }
            }
        );
        
        actualizarSedes();
    }
    
    private void actualizarSedes()
    {
        crearPQR.cbSedes.removeAllItems();
        
        ArrayList<Sede> sedes = new SedeDAO().getListaSedes();
        
        for (int i = 0; i < sedes.size(); i++) 
        {
            crearPQR.cbSedes.addItem(sedes.get(i).getNumero());            
        }
    }
    
    public void crearPQR()
    {
	if (verificarCamposCrearPQR())
        {
	    String fecha = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	    String tipo = this.crearPQR.cbTipo.getSelectedItem().toString();
	    String contenido = this.crearPQR.taContenido.getText();
	    String estado = this.crearPQR.tfEstado.getText();
	    String cedula = this.crearPQR.tfCedula.getText();
	    String nombre = this.crearPQR.tfNombre.getText();
	    String sede = (String) this.crearPQR.cbSedes.getSelectedItem();
	    
	    contenido = "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()) + "]:\n" 
		    + contenido;

	    PQR nuevoPQR = new PQR(fecha, tipo, contenido, estado, cedula, nombre, sede);
	
            int op = JOptionPane.showConfirmDialog(crearPQR, "Desea realizar el PQR?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (op == JOptionPane.YES_OPTION)
            {
                boolean resultado = new PQRDAO().insertarPQR(nuevoPQR);
        
                if (resultado)
                {
                    JOptionPane.showMessageDialog(crearPQR, "PQR creado exitosamente.", "", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
		    generarReciboPQR(cedula);
                }
                else
                {
                    JOptionPane.showMessageDialog(crearPQR, "Error al crear el PQR.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    public void generarReciboPQR(String cedula)
    {
	ReportesPDF.generarReciboPQR(new PQRDAO().ultimoPQR(cedula));
    }
    
    public boolean verificarCamposCrearPQR()
    {
	if (this.crearPQR.taContenido.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPQR, "El campo Contenido es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
	
	if (this.crearPQR.tfEstado.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPQR, "El campo Contenido es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
	
        if (this.crearPQR.tfCedula.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPQR, "El campo Cedula es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }	
        
        if (this.crearPQR.tfNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(crearPQR, "El campo Nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }  
        
        return true;
    }
    
    public void cerrarVentana()
    {
        this.crearPQR.setVisible(false);
    }
    
    public void limpiarCampos()
    {
        this.crearPQR.tfCedula.setText("");
        this.crearPQR.tfNombre.setText("");
        this.crearPQR.cbSedes.setSelectedIndex(0);
        this.crearPQR.cbTipo.setSelectedIndex(0);
        this.crearPQR.taContenido.setText("");
    }
}
