/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaz;

import Implementacion.ModuloUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class CrearUsuario_Eventos 
{
    private CrearUsuario crearUsuario;
    private ModuloUsuarios moduloUsuarios;
    
    public CrearUsuario_Eventos(final CrearUsuario crearUsuario)
    {
        this.crearUsuario = crearUsuario;
        this.moduloUsuarios = new ModuloUsuarios();
        
        crearUsuario.bCancelar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        crearUsuario.bCrearUsuario.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        crearUsuario();
                    }
                }
        );
        
        crearUsuario.addWindowListener(
                new WindowListener()
                {
                    @Override
                    public void windowOpened(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowClosing(WindowEvent we) 
                    {
                        cerrarVentana();
                    }

                    @Override
                    public void windowClosed(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowIconified(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowDeiconified(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowActivated(WindowEvent we) 
                    {
                        actualizarSedes();
                    }

                    @Override
                    public void windowDeactivated(WindowEvent we) 
                    {
                        
                    }                    
                }
        );
    }
    
    public void limpiarCampos()
    {
        this.crearUsuario.ftfFechaIncorporacion.setText("");
        this.crearUsuario.ftfFechaNacimiento.setText("");
        this.crearUsuario.pfClave.setText("");
        this.crearUsuario.pfVerificarClave.setText("");
        this.crearUsuario.tfCedula.setText("");
        this.crearUsuario.tfCelular.setText("");
        this.crearUsuario.tfDireccion.setText("");
        this.crearUsuario.tfNombre.setText("");
        this.crearUsuario.tfNumeroCuenta.setText("");
        this.crearUsuario.tfSalario.setText("");
        this.crearUsuario.tfTelefono.setText("");
    }
    
    public void cerrarVentana()
    {
        this.crearUsuario.setVisible(false);
        limpiarCampos();
    }
    
    public void crearUsuario()
    {
        
    }
    
    public void actualizarSedes()
    {
        
    }
}
