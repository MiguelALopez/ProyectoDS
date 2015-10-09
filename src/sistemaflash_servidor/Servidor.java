/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaflash_servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class Servidor extends javax.swing.JFrame implements Runnable
{
    private ServerSocket server;
    private MulticastSocket multiSocket;
    private InetAddress grupo;
    private Thread thread;
    private ServidorHilo client;
    
    private final int MAX_CONEXIONES = 5;
    public int numConexiones;
    
    private ConsultasBD bd;
    
    /**
     * Creates new form Servidor
     */
    public Servidor(int port) 
    {
        initComponents();
        
        try
        {
            taNotificaciones.append(" Uniendose al puerto " + port + ", por favor espere...");
            server = new ServerSocket(port);
            taNotificaciones.append("\n Servidor iniciado: " + server);
            
            grupo = InetAddress.getByName("225.0.0.0");
            multiSocket = new MulticastSocket();
            
            bd = new ConsultasBD();
            int state = bd.conectar();
            
            if (state >= 0)
            {
               taNotificaciones.append("\n Conexion exitosa con la Base de Datos.");
            }
            else
            {
               taNotificaciones.append("\n Fallo la conexion con la Base de Datos.");
            }
            
            start();
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
    }
    
    @Override
    public void run() 
    {
        while (thread != null)
        {  
            try
            {
                taNotificaciones.append("\n Esperando por un cliente...");
                
                Socket incoming = server.accept();
                DataOutputStream out = new DataOutputStream(incoming.getOutputStream());
                
                if (numConexiones >= MAX_CONEXIONES)
                {
                    out.writeBoolean(false);
                    taNotificaciones.append("\n Conexion " + incoming.getPort() + " rechazada (servidor lleno).");
                }
                else
                {
                    addThread(incoming);
                    numConexiones++;
                    out.writeBoolean(true);
                }
            }
            catch(IOException ie)
            {
                System.out.println("Acceptance Error: " + ie); 
            }
        }
    }
    
    private void start()
    { 
        if (thread == null)
        {  
            thread = new Thread(this); 
            thread.start();
        }
    }
    
    public void addThread(Socket socket)
    { 
        taNotificaciones.append("\n Cliente aceptado: " + socket);
        client = new ServidorHilo(this, socket);
        
        try
        {
            client.open();
            client.start();
        }   
        catch(IOException ioe)
        {  
           System.out.println("Error opening thread: " + ioe);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taNotificaciones = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema FLASH - Servidor");

        taNotificaciones.setColumns(20);
        taNotificaciones.setRows(5);
        jScrollPane1.setViewportView(taNotificaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea taNotificaciones;
    // End of variables declaration//GEN-END:variables

}
