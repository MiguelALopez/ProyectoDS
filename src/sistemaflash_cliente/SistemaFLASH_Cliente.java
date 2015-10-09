/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Fecha: 09-oct-2015
 * Nombre del Archivo: .java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package sistemaflash_cliente;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class SistemaFLASH_Cliente 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Cliente cliente = new Cliente("localhost", 3344);
        cliente.setLocationRelativeTo(null);
        cliente.setVisible(true);
    }
}
