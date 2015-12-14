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

package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
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
    JButton buttonBuscarSede;

    public ModificarSede(){
        super("Modificar Sede");
        setLayout(new GridBagLayout());
        initComponents();
        setSize(500, 400);
    }

    /* Clase encargada de inicializar y posicionar los elementos en los diferentes posiciones en el frame*/
    public void initComponents(){
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
        buttonBuscarSede = new JButton("Buscar");
        // Se desactivan las casillas
        enableText(false);

        // Panel buscarSede
        JPanel panelBusqueda = new JPanel(new GridBagLayout());
        manageConst(c,0,0,2,1,1,0,0,10);
        c.insets = new Insets(0,60,20,60);
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        TitledBorder borderPanelBusqueda = new TitledBorder("Sede a buscar");
        borderPanelBusqueda.setTitleJustification(TitledBorder.CENTER);
        panelBusqueda.setBorder(borderPanelBusqueda);
        add(panelBusqueda, c);

        // Label numero sede
        manageConst(c,0,0,1,1,0,0,3,3);
        c.insets = new Insets(0,5,0,0);
        c.anchor = GridBagConstraints.WEST;
        panelBusqueda.add(new JLabel("No. Sede"),c);

        manageConst(c,1,0,1,1,1,0,3,3);
        c.insets = new Insets(0,10,0,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        panelBusqueda.add(textNumSede,c);

        manageConst(c,2,0,1,1,0,0,3,3);
        c.insets = new Insets(0,0,0,5);
        c.anchor = GridBagConstraints.EAST;
        panelBusqueda.add(buttonBuscarSede, c);

        // Panel datosSede
        JPanel panelDatosSede = new JPanel(new GridBagLayout());
        manageConst(c,0,1,2,1,1,0,0,10);
        c.insets = new Insets(0,15,0,15);
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        TitledBorder borderPanelSede = new TitledBorder("Datos de la sede");
        borderPanelSede.setTitleJustification(TitledBorder.CENTER);
        panelDatosSede.setBorder(borderPanelSede);
        add(panelDatosSede,c);

        // Label Nombre Sede
        manageConst(c,0,0,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        panelDatosSede.add(new JLabel("Nombre de la Sede"), c);

        manageConst(c,1,0,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        panelDatosSede.add(textNameSede, c);

        // Label Direccion
        manageConst(c,0,1,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        panelDatosSede.add(new JLabel("Direccion"), c);

        manageConst(c,1,1,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        panelDatosSede.add(textAddress, c);

        // Label Gerente
        manageConst(c,0,2,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        panelDatosSede.add(new JLabel("Gerente a Cargo"), c);

        manageConst(c,1,2,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        panelDatosSede.add(textManager, c);

        // Label Presupuesto
        manageConst(c,0,3,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        panelDatosSede.add(new JLabel("Presupuesto Asignado"), c);

        manageConst(c,1,3,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        panelDatosSede.add(textBudget, c);

        // Label Camiones
        manageConst(c,0,4,1,1,0,0,3,3);
        c.insets = new Insets(10,30,10,0);
        c.anchor = GridBagConstraints.WEST;
        panelDatosSede.add(new JLabel("Numero de Camiones"), c);

        manageConst(c,1,4,1,1,1,0,3,3);
        c.insets = new Insets(0,20,0,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        panelDatosSede.add(textNumTruck,c);

        // Button Cancelar
        manageConst(c,0,2,1,1,0,0,0,0);
        c.insets = new Insets(15,20,0,30);
        c.anchor = GridBagConstraints.SOUTHWEST;
        add(buttonCancel,c);

        // Button Aceptar
        manageConst(c,1,2,1,1,0,0,0,0);
        c.insets = new Insets(15,20,0,15);
        c.anchor = GridBagConstraints.SOUTHEAST;
        add(buttonAccept,c);
    }

    /**
     * Este Metodo esta encarado de manejar las medidas del Layout pasandole una variable Constraint
     * @param c Constraints encargado de organizar
     * @param colX Posicion en X en la cuadricula
     * @param filY Posicion en Y en la cuadricula
     * @param width Numero de Filas que ocupa
     * @param heigth Numero de Columnas que ocupa
     * @param weightx Estiramiento horizontal puede ser 1 ó 0
     * @param weighty Estiramiento vertical puede ser 1 ó 0
     * @param ipadx Espaciado interno en X
     * @param ipady Espaciado interno en Y
     */
    public void manageConst(GridBagConstraints c, int colX, int filY, int width, int heigth, int weightx, int weighty, int ipadx, int ipady){
        c.gridx = colX; // Posicion en X en la cuadricula
        c.gridy = filY; // Posicion en Y en la cuadricula
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

    // Metodo encargado de activar o desactivar los JText
    public void enableText(boolean enable){
        textAddress.setEnabled(enable);
        textBudget.setEnabled(enable);
        textManager.setEnabled(enable);
        textNameSede.setEnabled(enable);
        textNumSede.setEnabled(!enable);
        textNumTruck.setEnabled(enable);
    }

    // Getters and Setters
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

    public JTextField getTextManager() {
        return textManager;
    }

    public void setTextManager(JTextField textManager) {
        this.textManager = textManager;
    }

    public JTextField getTextBudget() {
        return textBudget;
    }

    public void setTextBudget(JTextField textBudget) {
        this.textBudget = textBudget;
    }

    public JTextField getTextNumTruck() {
        return textNumTruck;
    }

    public void setTextNumTruck(JTextField textNumTruck) {
        this.textNumTruck = textNumTruck;
    }

    public JButton getButtonAccept() {
        return buttonAccept;
    }

    public void setButtonAccept(JButton buttonAccept) {
        this.buttonAccept = buttonAccept;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JButton getButtonBuscarSede() {
        return buttonBuscarSede;
    }

    public void setButtonBuscarSede(JButton buttonBuscarSede) {
        this.buttonBuscarSede = buttonBuscarSede;
    }

    public static void main(String[] args) {
        ModificarSede prueba = new ModificarSede();
        prueba.setLocationRelativeTo(null);
        prueba.setVisible(true);
        prueba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
