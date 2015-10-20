/***********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Código: 1326691
 * Fecha: 13-oct-2015
 * Nombre del Archivo: CrearSede.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/
package Vista;

import javax.swing.*;
import java.awt.*;

public class CrearSede extends JFrame {

    JTextField textNumSede;
    JTextField textNameSede;
    JTextField textAddress;
    JButton buttonCrear;

    public CrearSede() {
        super("Crear Sede");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Se inicializan los componentes
        textNumSede = new JTextField();
        textNameSede = new JTextField();
        textAddress = new JTextField();
        buttonCrear = new JButton("Crear");

        // Label Numero Sede
        manageConst(c, 0, 0, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 15, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Numero Sede"), c);

        manageConst(c, 1, 0, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNumSede, c);

        // Label Nombre Sede
        manageConst(c, 0, 1, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 15, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nombre de la Sede"), c);

        manageConst(c, 1, 1, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNameSede, c);

        // Label Direccion
        manageConst(c, 0, 2, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 15, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Direccion"), c);

        manageConst(c, 1, 2, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textAddress, c);

        // Button Crear
        manageConst(c, 1, 3, 1, 1, 0, 0, 0, 0);
        c.insets = new Insets(10, 20, 0, 30);
        c.anchor = GridBagConstraints.EAST;
        add(buttonCrear, c);


//        setVisible(true);
        setSize(400, 200);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void manageConst(GridBagConstraints c, int colX, int filY, int width, int heigth, int weightx, int weighty, int ipadx, int ipady) {
        c.gridx = colX;
        c.gridy = filY;
        c.gridheight = heigth;
        c.gridwidth = width;
        c.weightx = weightx;
        c.weighty = weighty;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = ipadx;
        c.ipady = ipady;
    }


    public static void main(String[] args) {
        CrearSede prueba = new CrearSede();

    }
}
