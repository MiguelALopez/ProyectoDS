/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.ConsultarPQR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import Modelo.PQR;
import Modelo.PQRDAO;
import java.awt.Color;

/**
 *
 * @author Cristian Jurado
 */
public class ConsultarPQR_Eventos 
{
        private ConsultarPQR consultarPQR;
        private PQRDAO pqrDAO;
        
    public ConsultarPQR_Eventos(final ConsultarPQR consultarPQR)
    {
        this.consultarPQR = consultarPQR;
        this.pqrDAO = new PQRDAO();
        
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
        
        consultarPQR();
    }  
        
    public void consultarPQR()  
    {
        ArrayList<PQR> listaPQR = pqrDAO.getListaPQR(); // aqui metodo DAO para obtener todos los PQR de la BD
        //ArrayList<PQR> listaPQR = new ArrayList();
        
        // prueba
//        PQR u1 = new PQR();
//        u1.setCedula("1000000");
//        u1.setNumero("1");
//        u1.setTipo("Jodido eso");
//        u1.setEstado("SinResponder");
//        listaPQR.add(u1);
        // fin prueba
        
        DefaultTableModel model = (DefaultTableModel) this.consultarPQR.tPQR.getModel();
        model.setRowCount(listaPQR.size());
        
        for (int i = 0; i < listaPQR.size(); i++) 
        {
            this.consultarPQR.tPQR.setValueAt(listaPQR.get(i).getNumero(), i, 0);
            this.consultarPQR.tPQR.setValueAt(listaPQR.get(i).getTipo(), i, 1);
            this.consultarPQR.tPQR.setValueAt(listaPQR.get(i).getCedula(), i, 2);
            this.consultarPQR.tPQR.setValueAt(listaPQR.get(i).getEstado(), i, 3);
        }
    }
            
    public void cerrarVentana()  
    {
        DefaultTableModel model = (DefaultTableModel) consultarPQR.tPQR.getModel();
        model.setRowCount(0);
        this.consultarPQR.setVisible(false);
    }
    
    
    public void verPQR()
    {
        int row = consultarPQR.tPQR.getSelectedRow();
                        
        if (row != -1)
        {
            String numeroPQR = (String) consultarPQR.tPQR.getValueAt(row, 0);
            String perfil = "";
            
            PQR pqr = pqrDAO.consultarPQR(numeroPQR);
            //PQR pqr = new PQR();

            if (pqr != null)
            {
                perfil = "\tInformacion del PQR\t\t\t" + 
                        "\n\nPQR N°:\t" + pqr.getNumero() + "\t\t" +
                        "Cedula:\t" + pqr.getCedula() +
                        "\n\nNombre:\t" + pqr.getNombre()+ "\t\t" +
                        "Sede:\t" + pqr.getSede() +
                        "\n\nTipo:\t" + pqr.getTipo() + "\t\t" +
                        "Contenido:\t" + pqr.getContenido() +
                        "\n\nEstado:\t" + pqr.getEstado() +
                        "\n";
                
                //System.out.println(perfil);
            }
                        
            JTextArea area = new JTextArea(perfil);
            area.setEditable(false);
            area.setOpaque(false);
            area.setBackground(new Color(0,0,0,0));
            JOptionPane.showMessageDialog(consultarPQR, area, "PQR Detallado", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(consultarPQR, "No ha seleccionado ningun PQR.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }   
}
