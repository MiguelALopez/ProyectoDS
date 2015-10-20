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

    private JTextField textNumSede;
    private JTextField textNameSede;
    private JTextField textAddress;
    private JButton buttonCreate;
    private JButton buttonCancel;

    public CrearSede() {
        super("Crear Sede");
        setLayout(new GridBagLayout());
        initComponents();
        setSize(400, 200);
    }

    /* Clase encargada de inicializar y posicionar los elementos en los diferentes posiciones en el frame*/
    public void initComponents(){

        // Se inicializan los componentes
        textNumSede = new JTextField();
        textNameSede = new JTextField();
        textAddress = new JTextField();
        buttonCreate = new JButton("Crear");
        buttonCancel = new JButton("Cancelar");

        GridBagConstraints c = new GridBagConstraints();

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

        // Button Cancelar
        manageConst(c, 0, 3, 1, 1, 0, 0, 0, 0);
        c.insets = new Insets(10, 15, 0, 30);
        c.anchor = GridBagConstraints.WEST;
        add(buttonCancel, c);

        // Button Crear
        manageConst(c, 1, 3, 1, 1, 0, 0, 0, 0);
        c.insets = new Insets(10, 20, 0, 30);
        c.anchor = GridBagConstraints.EAST;
        add(buttonCreate, c);
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

    //Getters and Setters
    public JTextField getTextNumSede() {
        return textNumSede;
    }

    public void setTextNumSede(JTextField textNumSede) {
        this.textNumSede = textNumSede;
    }

    public JTextField getTextNameSede() {
        return textNameSede;
    }

    public void setTextNameSede(JTextField textNameSede) {
        this.textNameSede = textNameSede;
    }

    public JTextField getTextAddress() {
        return textAddress;
    }

    public void setTextAddress(JTextField textAddress) {
        this.textAddress = textAddress;
    }

    public JButton getButtonCreate() {
        return buttonCreate;
    }

    public void setButtonCreate(JButton buttonCreate) {
        this.buttonCreate = buttonCreate;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public static void main(String[] args) {
        CrearSede prueba = new CrearSede();
        prueba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        prueba.setLocationRelativeTo(null);
        prueba.setVisible(true);

    }
}
