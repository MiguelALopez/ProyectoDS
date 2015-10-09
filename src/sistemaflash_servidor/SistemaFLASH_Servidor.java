/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Fecha: 09-oct-2015
 * Nombre del Archivo: .java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package sistemaflash_servidor;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class SistemaFLASH_Servidor 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Servidor servidor = new Servidor(3344);
        servidor.setLocationRelativeTo(null);
        servidor.setVisible(true);
    }    
}
