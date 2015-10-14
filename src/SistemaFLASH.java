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

import Interfaz.MenuPrincipal;
import Interfaz.MenuPrincipal_Eventos;


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
        MenuPrincipal cliente = new MenuPrincipal();
        MenuPrincipal_Eventos eventos = new MenuPrincipal_Eventos(cliente);
    }
}
