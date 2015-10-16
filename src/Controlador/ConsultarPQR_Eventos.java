/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioDAO;
import Vista.ConsultarPQR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import Modelo.PQR;
import Modelo.PQRDAO;

/**
 *
 * @author Cristian Jurado
 */
public class ConsultarPQR_Eventos {
        private ConsultarPQR consultarPQR;
        private PQRDAO PqrDAO;
        
    public ConsultarPQR_Eventos(final ConsultarPQR consultarPQR)
    {
        this.consultarPQR = consultarPQR;
        this.PqrDAO = new PQRDAO();
        
        consultarPQR.bCerrar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        consultarPQR.bActualizarPQR.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        consultarPQR();
                    }
                }
        );
        
        consultarPQR.bVerPQR.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        verPQR();
                    }
                }
        );
        
        consultarPQR.addWindowListener(
                new WindowListener()
                {
                    @Override
                    public void windowOpened(WindowEvent we) 
                    {
                        
                    }

                    @Override
                    public void windowClosing(WindowEvent we) 
                    {
                        
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
                        consultarPQR();
                    }

                    @Override
                    public void windowDeactivated(WindowEvent we) 
                    {
                        
                    }                    
                }
        );
    }    
    
        
        
    public void consultarPQR()  {
        //ArrayList<PQR> PQRs = usuarioDAO.getListaUsuarios(); // aqui metodo DAO para obtener todos los PQR de la BD
        ArrayList<PQR> PQRs = new ArrayList();
        
        // prueba
        PQR u1 = new PQR();
        u1.setCedula("1000000");
        u1.setNumero("1");
        u1.setTipo("Jodido eso");
        u1.setEstado("SinResponder");
        PQRs.add(u1);
        // fin prueba
        
        DefaultTableModel model = (DefaultTableModel) this.consultarPQR.tPQR.getModel();
        model.setRowCount(PQRs.size());
        
        for (int i = 0; i < PQRs.size(); i++) 
        {
            this.consultarPQR.tPQR.setValueAt(PQRs.get(i).getNumero(), i, 0);
            this.consultarPQR.tPQR.setValueAt(PQRs.get(i).getTipo(), i, 1);
            this.consultarPQR.tPQR.setValueAt(PQRs.get(i).getCedula(), i, 2);
            this.consultarPQR.tPQR.setValueAt(PQRs.get(i).getEstado(), i, 3);
        }
    }
            
    public void cerrarVentana()  {
        DefaultTableModel model = (DefaultTableModel) consultarPQR.tPQR.getModel();
        model.setRowCount(0);
        this.consultarPQR.setVisible(false);
    }
    
    
        public void verPQR()
    {
        int row = consultarPQR.tPQR.getSelectedRow();
                        
        if (row != -1)
        {
            String cedula = (String) consultarPQR.tPQR.getValueAt(row, 0);
            String perfil = "";
            
            //PQR pqr = pqrDAO.consultarPQR(cedula);
            PQR pqr = new PQR();

            if (pqr != null)
            {
                perfil = "\t\tInformacion del Usuario\t\t\t" + 
                        "\n\nN°PQR:\t\t" + pqr.getNumero() + "\t\t" +
                        "Cedula:\t" + pqr.getCedula() +
                        "\n\nNombre:\t\t" + pqr.getNombre()+ "\t\t" +
                        "Sede:\t" + pqr.getSede() +
                        "\n\nTipo:\t" + pqr.getTipo() + "\t\t" +
                        "Contenido:\t" + pqr.getContenido() +
                        "\n\nEstado:\t\t" + pqr.getEstado() +
                        "\n";
                
                //System.out.println(perfil);
            }
                        
            JTextArea area = new JTextArea(perfil);
            area.setEditable(false);
            JOptionPane.showMessageDialog(consultarPQR, area, "PQR Detallada", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(consultarPQR, "No ha seleccionado ningun PQR.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
            
        
    
}
