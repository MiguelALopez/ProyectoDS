/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaflash_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo Ruiz Casanova, Andrés Felipe Martínez, Miguel Ángel López
 * 
 */
public class Cliente extends javax.swing.JFrame 
{
    private Socket socket;
    private MulticastSocket multiSocket;
    private InetAddress grupo;
    private DataOutputStream streamOut;
    private DataInputStream streamIn;
    
    /**
     * constructor de la clase, construye la interfaz y realiza las conexiones
     * @param serverName direccion ip del servidor
     * @param serverPort puerto del servidor
     */
    public Cliente(String serverName, int serverPort) 
    {
        initComponents();
        
        this.conectar(serverName, serverPort);
    }
    
    private void conectar(String direccionServidor, int puertoServidor)
    {
        try
        {
            grupo = InetAddress.getByName("225.0.0.0");
            multiSocket = new MulticastSocket(3456);
            multiSocket.joinGroup(grupo);
            
            taNotificaciones.append("Conectando con el Servidor, por favor espere...\n");
            socket = new Socket(direccionServidor, puertoServidor);
            
            start();
            
            if (streamIn.readBoolean())
            {
                taNotificaciones.append("Conectado: " + socket + "\n");
                leer();
            }
            else
            {
                taNotificaciones.append("Conexion rechazada (Servidor lleno).\n");
                
                multiSocket.leaveGroup(grupo);
                multiSocket.close();
                if (socket != null)  socket.close();             
            }
        }
        catch(UnknownHostException uhe)
        {
            taNotificaciones.append("Conexion fallida, por favor intentelo de nuevo.\n");
        }
        catch(IOException ioe)
        {
            taNotificaciones.append("Conexion fallida, por favor intentelo de nuevo.\n");
        }
    }
    
    /**
     * metodo para iniciar los flujos de comunicacion del socket
     * @throws IOException 
     */
    private void start() throws IOException
    {  
       streamOut = new DataOutputStream(socket.getOutputStream());
       streamIn = new DataInputStream(socket.getInputStream());
    }
    
    /**
     * metodo para cerrar las conexiones del cliente y cerrar la aplicacion
     */
    public void cerrar()
    {  
        try
        {
            multiSocket.leaveGroup(grupo);
            if (streamIn != null)  streamIn.close();
            if (streamOut != null)  streamOut.close();
            if (socket    != null)  socket.close();
            
            System.exit(0);
        }
        catch(IOException ioe)
        {  
            System.out.println("Error closing ...");
        }
    }
    
    public final void leer()
    {
        Thread lecturaSocket = new Thread()
        {
            @Override
            public void run()
            {
                while(!socket.isClosed())
                {
                    try
                    {
                        String input = streamIn.readUTF();
                        taNotificaciones.append(input);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
        Thread lecturaMultiSocket = new Thread()
        {
            @Override
            public void run()
            {
                while(!multiSocket.isClosed())
                {
                    byte[] buffer = new byte[1000];
                    
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    
                    try
                    {
                        multiSocket.receive(packet);
                        
                        byte[] buffer2 = new byte[packet.getLength()];

                        // Copy the sent data to the second byte array.
                        System.arraycopy(packet.getData(), 0, buffer2, 0, packet.getLength());
                        
                        String mensaje = new String(buffer2);
                    }
                    catch (IOException ex) 
                    {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
        lecturaSocket.start();
        lecturaMultiSocket.start();
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
        jLabel14 = new javax.swing.JLabel();
        tfIdentidad = new javax.swing.JTextField();
        bCerrarSesion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        bIniciarSesion = new javax.swing.JButton();
        tfClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema FLASH - Cliente");

        taNotificaciones.setColumns(20);
        taNotificaciones.setRows(5);
        jScrollPane1.setViewportView(taNotificaciones);

        jLabel14.setText("Usted se ha identificado como:");

        bCerrarSesion.setText("Cerrar Sesion");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Iniciar Sesion"));

        jLabel11.setText("Usuario:");

        jLabel13.setText("Contraseña:");

        bIniciarSesion.setText("Iniciar Sesion");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(tfClave)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(bIniciarSesion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bIniciarSesion)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCerrarSesion))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(bCerrarSesion)
                    .addComponent(tfIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrarSesion;
    private javax.swing.JButton bIniciarSesion;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taNotificaciones;
    private javax.swing.JPasswordField tfClave;
    private javax.swing.JTextField tfIdentidad;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
