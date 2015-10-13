/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Fecha: 09-oct-2015
 * Nombre del Archivo: .java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Interfaz;

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
                    
                }                
            }
        );
        
        this.menuPrincipal.bConsultarUsuarios.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae) 
                {
                    
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
    }
}
