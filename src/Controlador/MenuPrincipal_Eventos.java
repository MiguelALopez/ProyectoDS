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

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Camilo Ruiz Casanova
 */
public class MenuPrincipal_Eventos 
{
    private final MenuPrincipal menuPrincipal;
    
    public MenuPrincipal_Eventos(final MenuPrincipal menuPrincipal)
    {
        this.menuPrincipal = menuPrincipal;
        
        this.menuPrincipal.bIniciarSesion.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    iniciarSesion();
                }                
            }
        );
        
        this.menuPrincipal.bCerrarSesion.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    cerrarSesion();
                }                
            }
        );
        
        this.menuPrincipal.bCrearUsuario.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    CrearUsuario cu = new CrearUsuario();
                    CrearUsuario_Eventos cue = new CrearUsuario_Eventos(cu);
                    cu.setLocationRelativeTo(null);
                    cu.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bModificarUsuario.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    ModificarUsuario mu = new ModificarUsuario();
                    ModificarUsuario_Eventos mue = new ModificarUsuario_Eventos(mu);
                    mu.setLocationRelativeTo(null);
                    mu.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bConsultarUsuarios.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    ConsultarUsuarios cu = new ConsultarUsuarios();
                    ConsultarUsuarios_Eventos cue = new ConsultarUsuarios_Eventos(cu);
                    cu.setLocationRelativeTo(null);
                    cu.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bCrearSede.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CrearSede cs = new CrearSede();
                        CrearSede_Eventos cse = new CrearSede_Eventos(cs);
                        cs.setLocationRelativeTo(null);
                        cs.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bModificarSede.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ModificarSede ms = new ModificarSede();
                        ModificarSede_Eventos mse = new ModificarSede_Eventos(ms);
                        ms.setLocationRelativeTo(null);
                        ms.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bConsultarSedes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ConsultarSede cs = new ConsultarSede();
                        ConsultarSede_Eventos cse = new ConsultarSede_Eventos(cs);
                        cs.setLocationRelativeTo(null);
                        cs.setVisible(true);
                    }
                }
        );
        
        this.menuPrincipal.bCrearPQR.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    CrearPQR cp = new CrearPQR();
                    CrearPQR_Eventos cpe = new CrearPQR_Eventos(cp);
                    cp.setLocationRelativeTo(null);
                    cp.setVisible(true);
                }                
            }
        ); 
 
        this.menuPrincipal.bConsultarPQR.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    ConsultarPQR cp = new ConsultarPQR();
                    ConsultarPQR_Eventos cpe = new ConsultarPQR_Eventos(cp);
                    cp.setLocationRelativeTo(null);
                    cp.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bResponderPQR.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    ResponderPQR rp = new ResponderPQR();
                    ResponderPQR_Eventos rpe = new ResponderPQR_Eventos(rp);
                    rp.setLocationRelativeTo(null);
                    rp.setVisible(true);
                }                
            }
        ); 
    }
    
    public void iniciarSesion()
    {
        String cedula = this.menuPrincipal.tfUsuario.getText();
        String passwd = String.valueOf(this.menuPrincipal.pfClave.getPassword());
        
        Usuario usuario = new UsuarioDAO().consultarUsuario(cedula);
        //prueba
//        Usuario usuario = new Usuario();
//        usuario.setCedula("123");
//        usuario.setPasswd("123");
//        usuario.setRol("Administrador");
        
        if (usuario != null)
        {            
            if (usuario.getPasswd().equals(passwd))
            {
                if (usuario.getEstado().equals("Activo"))
                {
                    this.menuPrincipal.tfUsuario.setText("");
                    this.menuPrincipal.tfUsuario.setEnabled(false);
                    this.menuPrincipal.pfClave.setText("");
                    this.menuPrincipal.pfClave.setEnabled(false);
                    this.menuPrincipal.bIniciarSesion.setEnabled(false);

                    this.menuPrincipal.tfIdentidad.setText(usuario.getCedula());
                    this.menuPrincipal.bCerrarSesion.setEnabled(true);

                    String rol = usuario.getRol();

                    switch (rol)
                    {
                        case "Gerente":
                        {
                            this.menuPrincipal.bConsultarPQR.setEnabled(true);
                            
                            break;
                        }

                        case "Contador":
                        {
                            break;
                        }

                        case "Auxiliar de Operacion":
                        {
                            break;
                        }

                        case "Auxiliar de Oficina":
                        {
                            break;
                        }

                        case "Secretaria":
                        {
                            this.menuPrincipal.bModificarUsuario.setEnabled(true);
                            this.menuPrincipal.bConsultarUsuarios.setEnabled(true);
                            this.menuPrincipal.bModificarSede.setEnabled(true);
                            this.menuPrincipal.bConsultarSedes.setEnabled(true);
                            this.menuPrincipal.bCrearPQR.setEnabled(true);
                            this.menuPrincipal.bConsultarPQR.setEnabled(true);
                            this.menuPrincipal.bResponderPQR.setEnabled(true);
                            
                            break;
                        }

                        case "Administrador":
                        {
                            this.menuPrincipal.bCrearUsuario.setEnabled(true);
                            this.menuPrincipal.bModificarUsuario.setEnabled(true);
                            this.menuPrincipal.bConsultarUsuarios.setEnabled(true);
                            this.menuPrincipal.bCrearSede.setEnabled(true);
                            this.menuPrincipal.bModificarSede.setEnabled(true);
                            this.menuPrincipal.bConsultarSedes.setEnabled(true);
                            
                            break;
                        }

                        default:
                        {
                            break;
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(menuPrincipal, "Usuario inactivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(menuPrincipal, "Usuario o Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(menuPrincipal, "Usuario o Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cerrarSesion()
    {
        this.menuPrincipal.tfIdentidad.setText("");
        this.menuPrincipal.bCerrarSesion.setEnabled(false);
        
        this.menuPrincipal.tfUsuario.setEnabled(true);
        this.menuPrincipal.pfClave.setEnabled(true);
        this.menuPrincipal.bIniciarSesion.setEnabled(true);
        
        this.menuPrincipal.bCrearUsuario.setEnabled(false);
        this.menuPrincipal.bModificarUsuario.setEnabled(false);
        this.menuPrincipal.bConsultarUsuarios.setEnabled(false);
        this.menuPrincipal.bCrearSede.setEnabled(false);
        this.menuPrincipal.bModificarSede.setEnabled(false);
        this.menuPrincipal.bConsultarSedes.setEnabled(false);
        this.menuPrincipal.bCrearPQR.setEnabled(false);
        this.menuPrincipal.bConsultarPQR.setEnabled(false);
        this.menuPrincipal.bResponderPQR.setEnabled(false);
    }
}
