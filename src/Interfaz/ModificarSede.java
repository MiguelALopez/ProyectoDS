/***********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Código: 1326691
 * Fecha: 14-oct-2030
 * Nombre del Archivo: ModificarSede.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/
package Interfaz;

import javax.swing.*;
import java.awt.*;

public class ModificarSede extends JFrame{

    JTextField textNumSede;
    JTextField textNameSede;
    JTextField textAddress;
    JTextField textManager;
    JTextField textBudget;
    JTextField textNumTruck;
    JButton buttonAccept;
    JButton buttonCancel;

    public ModificarSede(){
        super("Modificar Sede");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Se inicializan los componentes
        textNumSede = new JTextField();
        textNameSede = new JTextField();
        textAddress = new JTextField();
        textManager = new JTextField();
        textBudget = new JTextField();
        textNumTruck = new JTextField();
        buttonAccept = new JButton("Aceptar");
        buttonCancel = new JButton("Cancelar");

        // Label titulo
        manageConst(c,0,0,2,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.CENTER;
        add(new JLabel("Panel de Modificacion de Sedes"),c);

        // Linea separadora
        manageConst(c,0,1,2,1,0,0,3,3);
        c.insets = new Insets(0,30,30,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new JSeparator(SwingConstants.HORIZONTAL),c);


        // Label Numero Sede
        manageConst(c,0,2,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Numero Sede"),c);

        manageConst(c,1,2,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNumSede,c);

        // Label Nombre Sede
        manageConst(c,0,3,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nombre de la Sede"),c);

        manageConst(c,1,3,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNameSede,c);

        // Label Direccion
        manageConst(c,0,4,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Direccion"),c);

        manageConst(c,1,4,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textAddress,c);

        // Label Gerente
        manageConst(c,0,5,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Gerente a Cargo"),c);

        manageConst(c,1,5,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textManager,c);

        // Label Presupuesto
        manageConst(c,0,6,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Presupuesto Asignado"),c);

        manageConst(c,1,6,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textBudget,c);

        // Label Camiones
        manageConst(c,0,7,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Numero de Camiones"),c);

        manageConst(c,1,7,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNumTruck,c);

        // Button Cancelar
        manageConst(c,0,8,1,1,0,0,0,0);
        c.insets = new Insets(15,20,0,30);
        c.anchor = GridBagConstraints.CENTER;
        add(buttonCancel,c);

        // Button Aceptar
        manageConst(c,1,8,1,1,0,0,0,0);
        c.insets = new Insets(15,20,0,30);
        c.anchor = GridBagConstraints.CENTER;
        add(buttonAccept,c);


        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void manageConst(GridBagConstraints c, int colX, int filY, int width, int heigth, int weightx, int weighty, int ipadx, int ipady){
        c.gridx = colX;
        c.gridy = filY;
        c.gridheight = heigth;
        c.gridwidth = width;
        c.weightx = weightx;
        c.weighty = weighty;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0,0,0,0);
        c.ipadx = ipadx;
        c.ipady = ipady;
    }

    public static void main(String[] args) {
        ModificarSede prueba = new ModificarSede();

    }
}
