/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
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
    private MenuPrincipal menuPrincipal;
    private UsuarioDAO usuarioDAO;
    
    public MenuPrincipal_Eventos(final MenuPrincipal menuPrincipal)
    {
        this.menuPrincipal = menuPrincipal;
        this.usuarioDAO = new UsuarioDAO();
        
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
                    menuPrincipal.crearUsuario = new CrearUsuario();
                    menuPrincipal.crearUsuario_Eventos = new CrearUsuario_Eventos(menuPrincipal.crearUsuario);
                    menuPrincipal.crearUsuario.setLocationRelativeTo(null);
                    menuPrincipal.crearUsuario.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bModificarUsuario.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    menuPrincipal.modificarUsuario = new ModificarUsuario();
                    menuPrincipal.modificarUsuario_Eventos = new ModificarUsuario_Eventos(menuPrincipal.modificarUsuario);
                    menuPrincipal.modificarUsuario.setLocationRelativeTo(null);
                    menuPrincipal.modificarUsuario.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bConsultarUsuarios.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    menuPrincipal.consultarUsuarios = new ConsultarUsuarios();
                    menuPrincipal.consultarUsuarios_Eventos = new ConsultarUsuarios_Eventos(menuPrincipal.consultarUsuarios);
                    menuPrincipal.consultarUsuarios.setLocationRelativeTo(null);
                    menuPrincipal.consultarUsuarios.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bCrearSede.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuPrincipal.crearSede = new CrearSede();
                        menuPrincipal.crearSede_Eventos = new CrearSede_Eventos(menuPrincipal.crearSede);
                        menuPrincipal.crearSede.setLocationRelativeTo(null);
                        menuPrincipal.crearSede.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bModificarSede.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuPrincipal.modificarSede = new ModificarSede();
                        menuPrincipal.modificarSede_Eventos = new ModificarSede_Eventos(menuPrincipal.modificarSede);
                        menuPrincipal.modificarSede.setLocationRelativeTo(null);
                        menuPrincipal.modificarSede.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bConsultarSedes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuPrincipal.consultarSede = new ConsultarSede();
                        menuPrincipal.consultarSede_Eventos = new ConsultarSede_Eventos(menuPrincipal.consultarSede);
                        menuPrincipal.consultarSede.setLocationRelativeTo(null);
                        menuPrincipal.consultarSede.setVisible(true);
                    }
                }
        );
        
        this.menuPrincipal.bCrearPQR.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    menuPrincipal.crearPQR = new CrearPQR();
                    menuPrincipal.crearPQR_Eventos = new CrearPQR_Eventos(menuPrincipal.crearPQR);
                    menuPrincipal.crearPQR.setLocationRelativeTo(null);
                    menuPrincipal.crearPQR.setVisible(true);                    
                }                
            }
        ); 
 
        this.menuPrincipal.bConsultarPQR.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    menuPrincipal.consultarPQR = new ConsultarPQR();
                    menuPrincipal.consultarPQR_Eventos = new ConsultarPQR_Eventos(menuPrincipal.consultarPQR);
                    menuPrincipal.consultarPQR.setLocationRelativeTo(null);
                    menuPrincipal.consultarPQR.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bResponderPQR.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    menuPrincipal.responderPQR = new ResponderPQR();
                    menuPrincipal.responderPQR_Eventos = new ResponderPQR_Eventos(menuPrincipal.responderPQR);
                    menuPrincipal.responderPQR.setLocationRelativeTo(null);
                    menuPrincipal.responderPQR.setVisible(true);
                }                
            }
        ); 
    }
    
    public void iniciarSesion()
    {
        String cedula = this.menuPrincipal.tfUsuario.getText();
        String passwd = String.valueOf(this.menuPrincipal.pfClave.getPassword());
        
        Usuario usuario = usuarioDAO.consultarUsuario(cedula);
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
                            break;
                        }

                        case "Administrador":
                        {
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
    }
}
