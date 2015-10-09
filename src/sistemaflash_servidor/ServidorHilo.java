/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemaflash_servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ServidorHilo extends Thread
{
    private Socket socket = null;
    private Servidor server = null;
    private int ID = -1;
    private DataInputStream streamIn = null;
    private DataOutputStream streamOut = null;
    
    /**
     * constructor con el servidor y el socket del cliente
     * @param server servidor
     * @param socket socket del cliente
     */
    public ServidorHilo(Servidor server, Socket socket)
    {  
        this.server = server;  
        this.socket = socket;  
        ID = socket.getPort();
    }
    
    /**
     * se inician los flujos de comunacion del socket
     * @throws IOException 
     */
    public void open() throws IOException
    {  
        streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        streamOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    /**
     * metodo para cerrar la conexion con el cliente
     */
    public void close()
    {  
        try
        {
            if (socket != null)   
            {
                socket.close();
            }

            if (streamIn != null)  
            {
                streamIn.close();
            }

            if (streamOut != null)  
            {
                streamOut.close();
            }
        }
        catch (IOException io)
        {
            
        }
    }
    
    @Override
    public void run()
    {
        server.taNotificaciones.append("\n Cliente " + ID + " en ejecucion.");
        String input = "";
            
        while (true)
        {           
            try
            {
                input = streamIn.readUTF();
                
                if (input.equals("Salir"))
                {
                    server.taNotificaciones.append("\n Cliente "+ ID + " desconectado");
                    server.numConexiones--;
                    break;
                }
            }
            catch (SocketException ex)
            {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
            catch (IOException ex) 
            {
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
}
