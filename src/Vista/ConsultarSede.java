/***********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Código: 1326691
 * Fecha: 14-oct-2015
 * Nombre del Archivo: ConsultarSede.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/
package Vista;

import javax.swing.*;
import java.awt.*;

public class ConsultarSede extends JFrame {

    /*private JTextField textNumSede;
    private JTextField textNameSede;
    private JTextField textAddress;
    private JTextField textManager;
    private JTextField textBudget;
    private JTextField textNumEmployee;
    private JTextField textNumTruck;*/
    private JButton buttonView;
    private JButton buttonEdit;
    private JButton buttonCancel;

    private JTable tableContent;

    //array bidimencional de objetos con los datos de la tabla
    /*Object[][] data = {
//                {"001", "Melendez", "Carrera 100", "Miguel", "100000", "150", "70"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"}

    };*/

    public ConsultarSede() {
        super("Modificar Sede");
        setLayout(new GridLayout(1,1,5,5));
//        setLayout(new GridBagLayout());
//        initComponets();
        initComponets2();

        setSize(660, 286);
//        setSize(400, 450);
    }

    public void initComponets2(){
        GridBagConstraints c = new GridBagConstraints();

        // Se inicializan los componentes
        tableContent = new JTable();
        JScrollPane scrollPane = new JScrollPane(tableContent);
        buttonView = new JButton("Ver sede");
        buttonEdit = new JButton("Modificar sede");
        buttonCancel = new JButton("Cancelar");




        /*//array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Numero de Sede", "Nombre", "Gerente a Cargo", "Estado"};
        //se crea la Tabla
        JTable table = new JTable(data, columnNames);
        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(table);
        //Agregamos el JScrollPane al contenedor
        add(scrollPane);
        //manejamos la salida*/
    }

    // Metodo encargado de
    public Object[][] getData(){
        Object data[][] = null;

        return data;
    }

    /*public void initComponets(){
        GridBagConstraints c = new GridBagConstraints();

        // Se inicializan los componentes
        textNumSede = new JTextField();
        textNameSede = new JTextField();
        textAddress = new JTextField();
        textManager = new JTextField();
        textBudget = new JTextField();
        textNumEmployee = new JTextField();
        textNumTruck = new JTextField();
        buttonView = new JButton("Aceptar");
        buttonCancel = new JButton("Cancelar");

        // Label titulo
        manageConst(c, 0, 0, 2, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 30, 10, 0);
        c.anchor = GridBagConstraints.CENTER;
        add(new JLabel("Panel de Modificacion de Sedes"), c);

        // Linea separadora
        manageConst(c, 0, 1, 2, 1, 0, 0, 3, 3);
        c.insets = new Insets(0, 30, 30, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(new JSeparator(SwingConstants.HORIZONTAL), c);


        // Label Numero Sede
        manageConst(c, 0, 2, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 30, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Numero Sede"), c);

        manageConst(c, 1, 2, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNumSede, c);

        // Label Nombre Sede
        manageConst(c, 0, 3, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 30, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nombre de la Sede"), c);

        manageConst(c, 1, 3, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNameSede, c);

        // Label Direccion
        manageConst(c, 0, 4, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 30, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Direccion"), c);

        manageConst(c, 1, 4, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textAddress, c);

        // Label Gerente
        manageConst(c, 0, 5, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 30, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Gerente a Cargo"), c);

        manageConst(c, 1, 5, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textManager, c);

        // Label Presupuesto
        manageConst(c, 0, 6, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 30, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Presupuesto Asignado"), c);

        manageConst(c, 1, 6, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textBudget, c);

        // Label Presupuesto
        manageConst(c, 0, 7, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 30, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Presupuesto Asignado"), c);

        manageConst(c, 1, 7, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNumEmployee, c);

        // Label Camiones
        manageConst(c, 0, 8, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(10, 30, 10, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Numero de Camiones"), c);

        manageConst(c, 1, 8, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 20, 0, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNumTruck, c);

        // Button Cancelar
        manageConst(c, 0, 9, 1, 1, 0, 0, 0, 0);
        c.insets = new Insets(15, 20, 0, 30);
        c.anchor = GridBagConstraints.CENTER;
        add(buttonCancel, c);

        // Button Aceptar
        manageConst(c, 1, 9, 1, 1, 0, 0, 0, 0);
        c.insets = new Insets(15, 20, 0, 30);
        c.anchor = GridBagConstraints.CENTER;
        add(buttonView, c);
    }*/

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

    // Getters and Setters
    public JButton getButtonView() {
        return buttonView;
    }

    public void setButtonView(JButton buttonView) {
        this.buttonView = buttonView;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public static void main(String[] args) {
        ConsultarSede prueba = new ConsultarSede();
        prueba.setLocationRelativeTo(null);
        prueba.setVisible(true);
        prueba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
