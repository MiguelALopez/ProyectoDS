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

import Vista.MenuPrincipal;
import Controlador.MenuPrincipal_Eventos;


/**
 *
 * @author Camilo Ruiz Casanova
 */
public class SistemaFLASH
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        setLookAndFeel();
        MenuPrincipal cliente = new MenuPrincipal();
        MenuPrincipal_Eventos eventos = new MenuPrincipal_Eventos(cliente);
    }
    
    public static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                // System.out.println(info.getClassName());
                if ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel".equals(info.getClassName()) || "com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {   
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
                }
            }
        } catch(Exception e) {
          System.out.println("Error setting native LAF: " + e);
        }
    }
}
