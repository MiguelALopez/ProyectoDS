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

import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Camilo Ruiz Casanova
 */
public class MenuPrincipal_Eventos 
{
    private MenuPrincipal menuPrincipal;
    
    public MenuPrincipal_Eventos(final MenuPrincipal menuPrincipal)
    {
        this.menuPrincipal = menuPrincipal;
        
        this.menuPrincipal.bIniciarSesion.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    
                }                
            }
        );
        
        this.menuPrincipal.bCerrarSesion.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    
                }                
            }
        );
        
        this.menuPrincipal.bCrearUsuario.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
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
                    menuPrincipal.consultarUsuarios.setLocationRelativeTo(null);
                    menuPrincipal.consultarUsuarios.setVisible(true);
                }                
            }
        );
        
        this.menuPrincipal.bCrearSede.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    
                }                
            }
        );
        
        this.menuPrincipal.bModificarSede.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    
                }                
            }
        );
        
        this.menuPrincipal.bConsultarSedes.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    
                }                
            }
        );
        this.menuPrincipal.bPqr.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
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
                    menuPrincipal.consultarPQR.setLocationRelativeTo(null);
                    menuPrincipal.consultarPQR.setVisible(true);
                }                
            }
        );

        this.menuPrincipal.bCrearSede.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuPrincipal.crearSede.setLocationRelativeTo(null);
                        menuPrincipal.crearSede.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bModificarSede.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuPrincipal.modificarSede.setLocationRelativeTo(null);
                        menuPrincipal.modificarSede.setVisible(true);
                    }
                }
        );

        this.menuPrincipal.bConsultarSedes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuPrincipal.consultarSede.setLocationRelativeTo(null);
                        menuPrincipal.consultarSede.setVisible(true);
                    }
                }
        );
  
    }
}
