/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: MenuPrincipal_Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * clase para manejar los eventos de login y roles
 */
public class MenuPrincipal_Eventos {
    private final MenuPrincipal menuPrincipal;
    private final ImageIcon logo;

    /***
     * Constructor encargado de inicializar los eventos de la interfaz de MenuPrincipal
     * @param menuPrincipal Objeto que contiene la interfaz de MenuPrincipal
     */
    public MenuPrincipal_Eventos(final MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        logo = new ImageIcon("img/logo.png");

        this.menuPrincipal.lTitle.addComponentListener(
                new ComponentListener() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        resizeLogo();
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                    }

                    @Override
                    public void componentShown(ComponentEvent e) {
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                    }
                }
        );

        this.menuPrincipal.bIniciarSesion.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        iniciarSesion();
                    }
                }
        );

        this.menuPrincipal.pfClave.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        iniciarSesion();
                    }
                }
        );

        this.menuPrincipal.bCerrarSesion.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        cerrarSesion();
                    }
                }
        );

        this.menuPrincipal.bCrearUsuario.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        CrearUsuario cu = new CrearUsuario();
                        CrearUsuario_Eventos cue = new CrearUsuario_Eventos(cu);
                        cu.setLocationRelativeTo(null);
                        cu.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bModificarUsuario.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ModificarUsuario mu = new ModificarUsuario();
                        ModificarUsuario_Eventos mue = new ModificarUsuario_Eventos(mu);
                        mu.setLocationRelativeTo(null);
                        mu.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bConsultarUsuarios.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
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
                        ConsultarSedes cs = new ConsultarSedes();
                        ConsultarSedes_Eventos cse = new ConsultarSedes_Eventos(cs);
                        cs.setLocationRelativeTo(null);
                        cs.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bCrearPQR.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        CrearPQR cp = new CrearPQR();
                        CrearPQR_Eventos cpe = new CrearPQR_Eventos(cp);
                        cp.setLocationRelativeTo(null);
                        cp.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bConsultarPQR.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ConsultarPQR cp = new ConsultarPQR();
                        ConsultarPQR_Eventos cpe = new ConsultarPQR_Eventos(cp);
                        cp.setLocationRelativeTo(null);
                        cp.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bResponderPQR.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ResponderPQR rp = new ResponderPQR();
                        ResponderPQR_Eventos rpe = new ResponderPQR_Eventos(rp);
                        rp.setLocationRelativeTo(null);
                        rp.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bCrearPOS.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        CrearPOS cp = new CrearPOS();
                        CrearPOS_Eventos cpe = new CrearPOS_Eventos(cp);
                        cp.setLocationRelativeTo(null);
                        cp.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bModificarPOS.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ModificarPOS mp = new ModificarPOS();
                        ModificarPOS_Eventos mpe = new ModificarPOS_Eventos(mp);
                        mp.setLocationRelativeTo(null);
                        mp.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bConsultarPOS.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        ConsultarPOS cp = new ConsultarPOS();
                        ConsultarPOS_Eventos cpe = new ConsultarPOS_Eventos(cp);
                        cp.setLocationRelativeTo(null);
                        cp.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bRegistrarVenta.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RegistrarVenta rv = new RegistrarVenta();
                        RegistrarVenta_Eventos rve = new RegistrarVenta_Eventos(rv);
                        rv.setLocationRelativeTo(null);
                        rv.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bConsultarVentas.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ConsultarVentas cv = new ConsultarVentas();
                        ConsultarVentas_Eventos cve = new ConsultarVentas_Eventos(cv);
                        cv.setLocationRelativeTo(null);
                        cv.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bReportes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Reportes r = new Reportes();
                        Reportes_Eventos re = new Reportes_Eventos(r);
                        r.setLocationRelativeTo(null);
                        r.setVisible(true);
                    }
                }
        );

        resizeLogo();
    }

    /***
     * Metodo encargado de modificar el tamaño del logo con forme varia el tamaño de la ventana
     */
    private void resizeLogo() {
        int h = this.menuPrincipal.lTitle.getSize().height;
        int w = (479 / 224) * h;

        ImageIcon imageIcon = new ImageIcon(this.logo.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        this.menuPrincipal.lTitle.setIcon(imageIcon);
    }

    /***
     * Metodo encargado de conectarse con el modulo DAO y verificar los datos del usuario
     * para iniciar seccion segun su rol en la empresa
     */
    public void iniciarSesion() {
        String cedula = this.menuPrincipal.tfUsuario.getText();
        String passwd = String.valueOf(this.menuPrincipal.pfClave.getPassword());

        Usuario usuario = new UsuarioDAO().consultarUsuario(cedula);

        if (usuario != null) {
            if (usuario.getPasswd().equals(passwd)) {
                if (usuario.getEstado().equals("Activo")) {
                    this.menuPrincipal.tfUsuario.setText("");
                    this.menuPrincipal.tfUsuario.setEnabled(false);
                    this.menuPrincipal.pfClave.setText("");
                    this.menuPrincipal.pfClave.setEnabled(false);
                    this.menuPrincipal.bIniciarSesion.setEnabled(false);

                    this.menuPrincipal.tfIdentidad.setText(usuario.getCedula());
                    this.menuPrincipal.bCerrarSesion.setEnabled(true);

                    String rol = usuario.getRol();

                    switch (rol) {
                        case "Gerente": {
                            this.menuPrincipal.bConsultarPQR.setEnabled(true);
                            this.menuPrincipal.bResponderPQR.setEnabled(true);
                            this.menuPrincipal.bReportes.setEnabled(true);
                            break;
                        }
                        case "Contador": {
                            break;
                        }
                        case "Operador de Oficina": {
                            this.menuPrincipal.bRegistrarVenta.setEnabled(true);
                            this.menuPrincipal.bConsultarVentas.setEnabled(true);
                            break;
                        }
                        case "Auxiliar de Operacion": {
                            break;
                        }
                        case "Secretaria": {
                            this.menuPrincipal.bConsultarUsuarios.setEnabled(true);
                            this.menuPrincipal.bConsultarSedes.setEnabled(true);
                            this.menuPrincipal.bCrearPQR.setEnabled(true);
                            this.menuPrincipal.bConsultarPQR.setEnabled(true);
                            this.menuPrincipal.bResponderPQR.setEnabled(true);
                            this.menuPrincipal.bConsultarPOS.setEnabled(true);
                            this.menuPrincipal.bConsultarVentas.setEnabled(true);
                            break;
                        }
                        case "Administrador": {
                            this.menuPrincipal.bCrearUsuario.setEnabled(true);
                            this.menuPrincipal.bModificarUsuario.setEnabled(true);
                            this.menuPrincipal.bConsultarUsuarios.setEnabled(true);
                            this.menuPrincipal.bCrearSede.setEnabled(true);
                            this.menuPrincipal.bModificarSede.setEnabled(true);
                            this.menuPrincipal.bConsultarSedes.setEnabled(true);
                            this.menuPrincipal.bCrearPQR.setEnabled(true);
                            this.menuPrincipal.bConsultarPQR.setEnabled(true);
                            this.menuPrincipal.bResponderPQR.setEnabled(true);
                            this.menuPrincipal.bCrearPOS.setEnabled(true);
                            this.menuPrincipal.bModificarPOS.setEnabled(true);
                            this.menuPrincipal.bConsultarPOS.setEnabled(true);
                            this.menuPrincipal.bRegistrarVenta.setEnabled(true);
                            this.menuPrincipal.bConsultarVentas.setEnabled(true);
                            this.menuPrincipal.bReportes.setEnabled(true);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(menuPrincipal, "Usuario inactivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(menuPrincipal, "Usuario o Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(menuPrincipal, "Usuario o Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /***
     * Metodo encargado de desactivar todos los campos activados en la seccion anterior
     */
    public void cerrarSesion() {
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
        this.menuPrincipal.bCrearPOS.setEnabled(false);
        this.menuPrincipal.bModificarPOS.setEnabled(false);
        this.menuPrincipal.bConsultarPOS.setEnabled(false);
        this.menuPrincipal.bRegistrarVenta.setEnabled(false);
        this.menuPrincipal.bConsultarVentas.setEnabled(false);
        this.menuPrincipal.bReportes.setEnabled(false);
    }
}
