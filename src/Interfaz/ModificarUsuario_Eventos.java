/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ModificarUsuario_Eventos 
{
    private ModificarUsuario modificarUsuario;
    
    public ModificarUsuario_Eventos(final ModificarUsuario modificarUsuario)
    {
        this.modificarUsuario = modificarUsuario;
        
        modificarUsuario.bBuscarCedula.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        habilitarCampos(true);
                    }
                }
        );
        
        modificarUsuario.bCancelar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        modificarUsuario.bModificarUsuario.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        limpiarCampos();
                        habilitarCampos(false);
                    }
                }
        );
    }
    
    public void habilitarCampos(boolean b)
    {
        this.modificarUsuario.tfCedula.setEnabled(b);
        this.modificarUsuario.cbCargo.setEnabled(b);
        this.modificarUsuario.pfClave.setEnabled(b);
        this.modificarUsuario.pfVerificarClave.setEnabled(b);
        this.modificarUsuario.tfNombre.setEnabled(b);
        this.modificarUsuario.tfDireccion.setEnabled(b);
        this.modificarUsuario.ftfFechaNacimiento.setEnabled(b);
        this.modificarUsuario.tfTelefono.setEnabled(b);
        this.modificarUsuario.tfCelular.setEnabled(b);
        this.modificarUsuario.ftfFechaIncorporacion.setEnabled(b);
        this.modificarUsuario.tfSalario.setEnabled(b);
        this.modificarUsuario.tfNumeroCuenta.setEnabled(b);
        this.modificarUsuario.cbEstado.setEnabled(b);
    }
    
    public void limpiarCampos()
    {
        this.modificarUsuario.tfBuscarCedula.setText("");
        this.modificarUsuario.ftfFechaIncorporacion.setText("");
        this.modificarUsuario.ftfFechaNacimiento.setText("");
        this.modificarUsuario.pfClave.setText("");
        this.modificarUsuario.pfVerificarClave.setText("");
        this.modificarUsuario.tfCedula.setText("");
        this.modificarUsuario.tfCelular.setText("");
        this.modificarUsuario.tfDireccion.setText("");
        this.modificarUsuario.tfNombre.setText("");
        this.modificarUsuario.tfNumeroCuenta.setText("");
        this.modificarUsuario.tfSalario.setText("");
        this.modificarUsuario.tfTelefono.setText("");
    }
    
    public void cerrarVentana()
    {
        this.modificarUsuario.setVisible(false);
        limpiarCampos();
        habilitarCampos(false);
    }
}
