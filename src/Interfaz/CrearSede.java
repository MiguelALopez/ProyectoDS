/***********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Código: 1326691
 * Fecha: 13-oct-2015
 * Nombre del Archivo: CrearSede.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/
package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CrearSede extends JFrame{

    JTextField textNumSede;
    JTextField textNameSede;
    JTextField textAddress;

    public CrearSede(){
        /*super("Crear Sede");
        setLayout(new GridLayout(3, 2, 5, 5));

        // Se inicializan los componentes
        textNumSede = new JTextField();
        textNameSede = new JTextField();
        textAddress = new JTextField();

        add(new JLabel("Numero Sede"));
        add(textNumSede);
        add(new JLabel("Nombre de la Sede"));
        add(textNameSede);
        add(new JLabel("Direccion"));
        add(textAddress);


        setVisible(true);
        setSize(400, 200);*/

        super("Crear Sede");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Se inicializan los componentes
        textNumSede = new JTextField();
        textNameSede = new JTextField();
        textAddress = new JTextField();

        manageConst(c,0,0,1,1,0,0);
        add(new JLabel("Numero Sede"),c);

        manageConst(c,1,0,1,1,1,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNumSede,c);

        manageConst(c,0,1,1,1,0,0);
        add(new JLabel("Nombre de la Sede"),c);

        manageConst(c,1,1,1,1,1,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNameSede,c);

        manageConst(c,0,2,1,1,0,0);
        add(new JLabel("Direccion"),c);

        manageConst(c,1,2,1,1,1,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textAddress,c);


        setVisible(true);
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void manageConst(GridBagConstraints c, int colX, int filY, int width, int heigth, int weightx, int weighty){
        c.gridx = colX;
        c.gridy = filY;
        c.gridheight = heigth;
        c.gridwidth = width;
        c.weightx = weightx;
        c.weighty = weighty;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10,10,10,10);
//        c.ipadx = 50;
//        c.ipady = 50;
    }



    public static void main(String[] args) {
        CrearSede prueba = new CrearSede();

    }
}
