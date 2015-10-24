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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

public class ConsultarSede extends JFrame {

    private JButton buttonView;
    private JButton buttonEdit;
    private JButton buttonCancel;
    private JTextField textNumSede;
    private DefaultTableModel tableModelContent;


    //array bidimencional de objetos con los datos de la tabla
    Object[][] data = {
//                {"001", "Melendez", "Carrera 100", "Miguel", "100000", "150", "70"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"},
            {"001", "Melendez", "Miguel", "Activa"}

    };
    String[] columnNames = {"Numero de Sede", "Nombre", "Gerente a Cargo", "Estado"};


    public ConsultarSede() {
        super("Modificar Sede");
        setLayout(new GridBagLayout());
        initComponets();
        setSize(700, 400);
    }

    public void initComponets(){
        GridBagConstraints c = new GridBagConstraints();

        // Se inicializan los componentes
        tableModelContent = new DefaultTableModel();
        JTable tableContent = new JTable(tableModelContent);
        JScrollPane scrollPane = new JScrollPane(tableContent);
        buttonView = new JButton("Ver sede");
        buttonEdit = new JButton("Modificar sede");
        buttonCancel = new JButton("Cancelar");
        textNumSede = new JTextField();

        // Se añaden las columnas de la tabla
        tableModelContent.addColumn("Numero de Sede");
        tableModelContent.addColumn("Nombre");
        tableModelContent.addColumn("Gerente a Cargo");
        tableModelContent.addColumn("Dierccion");

        Vector<String> v  =  new Vector<String>();
        v.addElement("hola");
        v.addElement("que hace");
        v.addElement("nada");
        v.addElement("o k ace");
        tableModelContent.addRow(v);

        // Tabla con los elementos
        manageConst(c, 0, 0, 3, 1, 1, 1, 3, 3);
        c.insets = new Insets(15, 30, 15, 30);
        c.fill = GridBagConstraints.BOTH;
        add(scrollPane, c);

        // Label con el numero de la sede
        manageConst(c, 0, 1, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(0, 30, 15, 0);
        c.anchor = GridBagConstraints.WEST;
        add(new JLabel("Numero sede"), c);

        // Text para ingresar el numero de sede
        manageConst(c, 1, 1, 2, 1, 0, 0, 3, 3);
        c.insets = new Insets(0, 20, 15, 30);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textNumSede, c);

        // button cancelar
        manageConst(c, 0, 2, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(0, 30, 15, 30);
        c.anchor = GridBagConstraints.WEST;
        add(buttonCancel, c);

        //button modificar
        manageConst(c, 1, 2, 1, 1, 1, 0, 3, 3);
        c.insets = new Insets(0, 0, 15, 0);
        c.anchor = GridBagConstraints.EAST;
        add(buttonEdit, c);

        //button ver sede
        manageConst(c, 2, 2, 1, 1, 0, 0, 3, 3);
        c.insets = new Insets(0, 15, 15, 30);
        c.anchor = GridBagConstraints.EAST;
        add(buttonView, c);
    }

    public void manageConst(GridBagConstraints c, int colX, int filY, int width, int heigth, int weightx, int weighty, int ipadx, int ipady) {
        c.gridx = colX;                        // La posicion en la columna
        c.gridy = filY;                        // La posicion en la fila
        c.gridheight = heigth;                 // La ocupacion del elemento a lo ancho
        c.gridwidth = width;                   // La ocupacion del elemento a lo alto
        c.weightx = weightx;                   // Si se desea que se estire la fila
        c.weighty = weighty;                   // Si se desea que se estire la columna
        c.fill = GridBagConstraints.NONE;      // Si se desea que se estire el elemento
        c.anchor = GridBagConstraints.CENTER;  // Si se desea que se ubique en una posicion especial
        c.insets = new Insets(0, 0, 0, 0);     // Los margenes externos que se desean
        c.ipadx = ipadx;                       // Los margenes internos en X
        c.ipady = ipady;                       // Los margenes internos en Y
    }

    // Getters and Setters
    public JButton getButtonView() {
        return buttonView;
    }

    public void setButtonView(JButton buttonView) {
        this.buttonView = buttonView;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }

    public void setButtonEdit(JButton buttonEdit) {
        this.buttonEdit = buttonEdit;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JTextField getTextNumSede() {
        return textNumSede;
    }

    public void setTextNumSede(JTextField textNumSede) {
        this.textNumSede = textNumSede;
    }

    public DefaultTableModel getTableModelContent() {
        return tableModelContent;
    }

    public void setTableModelContent(DefaultTableModel tableModelContent) {
        this.tableModelContent = tableModelContent;
    }

    public static void main(String[] args) {
        ConsultarSede prueba = new ConsultarSede();
        prueba.setLocationRelativeTo(null);
        prueba.setVisible(true);
        prueba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
