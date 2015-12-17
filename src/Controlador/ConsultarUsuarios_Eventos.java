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

package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.ConsultarUsuarios;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Ruiz Casanova
 */
public class ConsultarUsuarios_Eventos 
{
    private ConsultarUsuarios consultarUsuarios;
    private UsuarioDAO usuarioDAO;
    
    public ConsultarUsuarios_Eventos(final ConsultarUsuarios consultarUsuarios)
    {
        this.consultarUsuarios = consultarUsuarios;
        this.usuarioDAO = new UsuarioDAO();
        
        consultarUsuarios.bCerrar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        cerrarVentana();
                    }
                }
        );
        
        consultarUsuarios.bActualizar.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        consultarUsuarios();
                    }
                }
        );
        
        consultarUsuarios.bVerPerfil.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae) 
                    {
                        verPerfil();
                    }
                }
        );
        
        consultarUsuarios();
    }
    
    private void consultarUsuarios()
    {
        ArrayList<Usuario> usuarios = usuarioDAO.getListaUsuarios(); // aqui metodo DAO para obtener todos los usuarios de la BD
        //ArrayList<Usuario> usuarios = new ArrayList();
        
        // prueba
//        Usuario u1 = new Usuario();
//        u1.setCedula("1144082592");
//        u1.setNombre("Camilo Ruiz Casanova");
//        u1.setRol("Gerente");
//        u1.setEstado("Activo");
//        usuarios.add(u1);
        // fin prueba
        
        DefaultTableModel model = (DefaultTableModel) this.consultarUsuarios.tUsuarios.getModel();
        model.setRowCount(usuarios.size());
        
        for (int i = 0; i < usuarios.size(); i++) 
        {
            this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getCedula(), i, 0);
            this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getNombre(), i, 1);
            this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getRol(), i, 2);
            this.consultarUsuarios.tUsuarios.setValueAt(usuarios.get(i).getEstado(), i, 3);
        }
    }
    
    public void cerrarVentana()
    {
        DefaultTableModel model = (DefaultTableModel) consultarUsuarios.tUsuarios.getModel();
        model.setRowCount(0);
        this.consultarUsuarios.setVisible(false);
    }
    
    public void verPerfil()
    {
        int row = consultarUsuarios.tUsuarios.getSelectedRow();
                        
        if (row != -1)
        {
            String cedula = (String) consultarUsuarios.tUsuarios.getValueAt(row, 0);
            
            Usuario usuario = usuarioDAO.consultarUsuario(cedula);
            //Usuario usuario = new Usuario();    

            if (usuario != null)
            {
                JFrame fPerfil = new JFrame();
                JPanel pPerfil = new JPanel(new GridLayout(6, 4, 5, 10));

                pPerfil.add(new JLabel("Cedula: "));
                pPerfil.add(new JLabel(usuario.getCedula()));

                pPerfil.add(new JLabel("Nombre: "));
                pPerfil.add(new JLabel(usuario.getNombre()));

                pPerfil.add(new JLabel("Estado: "));
                pPerfil.add(new JLabel(usuario.getEstado()));

                pPerfil.add(new JLabel("Rol: "));
                pPerfil.add(new JLabel(usuario.getRol()));

                pPerfil.add(new JLabel("Fecha de Nacimiento: "));
                pPerfil.add(new JLabel(usuario.getFechaNacimiento()));

                pPerfil.add(new JLabel("Direccion: "));
                pPerfil.add(new JLabel(usuario.getDireccion()));

                pPerfil.add(new JLabel("Telefono: "));
                pPerfil.add(new JLabel(usuario.getTelefono()));

                pPerfil.add(new JLabel("Celular: "));
                pPerfil.add(new JLabel(usuario.getCelular()));

                pPerfil.add(new JLabel("Fecha de Incorporacion: "));
                pPerfil.add(new JLabel(usuario.getFechaIncorporacion()));

                pPerfil.add(new JLabel("Salario: "));
                pPerfil.add(new JLabel(usuario.getSalario()));

                pPerfil.add(new JLabel("Cuenta: "));
                pPerfil.add(new JLabel(usuario.getCuenta()));

                pPerfil.add(new JLabel("Sede: "));
                pPerfil.add(new JLabel(usuario.getNumeroSede()));

                fPerfil.add(pPerfil);
                fPerfil.pack();
                fPerfil.setLocationRelativeTo(null);
                fPerfil.setVisible(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(consultarUsuarios, "No ha seleccionado ningun Usuario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
