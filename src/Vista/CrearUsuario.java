/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: CrearUsuario.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Vista;

/**
 * interfaz de crear usuario
 */
public class CrearUsuario extends javax.swing.JFrame 
{
    /**
     * Creates new form CrearUsuario
     */
    public CrearUsuario() 
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfCedula = new javax.swing.JTextField();
        cbCargo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pfClave = new javax.swing.JPasswordField();
        pfVerificarClave = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ftfFechaNacimiento = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        cbSedes = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ftfFechaIncorporacion = new javax.swing.JFormattedTextField();
        tfApellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfSalario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfNumeroCuenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        bCancelar = new javax.swing.JButton();
        bCrearUsuario = new javax.swing.JButton();

        setTitle("Crear Usuario");
        setMinimumSize(new java.awt.Dimension(700, 430));
        setPreferredSize(new java.awt.Dimension(700, 430));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Ingreso al Sistema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 0);
        jPanel1.add(jLabel19, gridBagConstraints);

        tfCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel1.add(tfCedula, gridBagConstraints);

        cbCargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Gerente", "Contador", "Operador de Oficina", "Auxiliar de Operacion", "Secretaria" }));
        cbCargo.setMinimumSize(new java.awt.Dimension(10, 23));
        cbCargo.setPreferredSize(new java.awt.Dimension(10, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel1.add(cbCargo, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 0);
        jPanel1.add(jLabel15, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Rol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
        jPanel1.add(jLabel18, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        pfClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel1.add(pfClave, gridBagConstraints);

        pfVerificarClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel1.add(pfVerificarClave, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 0);
        jPanel1.add(jLabel17, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Repetir Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 0);
        jPanel2.add(jLabel5, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
        jPanel2.add(jLabel20, gridBagConstraints);

        tfNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel2.add(tfNombre, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(jLabel8, gridBagConstraints);

        tfDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfDireccion, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de Nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(jLabel7, gridBagConstraints);

        ftfFechaNacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        ftfFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(ftfFechaNacimiento, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Sede");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 0);
        jPanel2.add(jLabel14, gridBagConstraints);

        cbSedes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbSedes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel2.add(cbSedes, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de Incorporacion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(jLabel6, gridBagConstraints);

        tfTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfTelefono, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 0);
        jPanel2.add(jLabel10, gridBagConstraints);

        ftfFechaIncorporacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        ftfFechaIncorporacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(ftfFechaIncorporacion, gridBagConstraints);

        tfApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel2.add(tfApellido, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(jLabel9, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Salario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(jLabel11, gridBagConstraints);

        tfSalario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfSalario, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Numero de Cuenta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(jLabel12, gridBagConstraints);

        tfNumeroCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfNumeroCuenta, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 0);
        jPanel2.add(jLabel13, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 0);
        jPanel2.add(jLabel16, gridBagConstraints);

        cbEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        cbEstado.setMinimumSize(new java.awt.Dimension(32, 23));
        cbEstado.setPreferredSize(new java.awt.Dimension(32, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel2.add(cbEstado, gridBagConstraints);

        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
        jPanel2.add(jLabel24, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(jPanel2, gridBagConstraints);

        jLabel21.setText("Los campos marcados con");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        getContentPane().add(jLabel21, gridBagConstraints);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel22, gridBagConstraints);

        jLabel23.setText("son obligatorios.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel23, gridBagConstraints);

        jPanel10.setLayout(new java.awt.GridBagLayout());

        bCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCancelar.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel10.add(bCancelar, gridBagConstraints);

        bCrearUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCrearUsuario.setText("Crear Usuario");
        bCrearUsuario.setMinimumSize(new java.awt.Dimension(99, 31));
        bCrearUsuario.setPreferredSize(new java.awt.Dimension(99, 31));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel10.add(bCrearUsuario, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jPanel10, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bCancelar;
    public javax.swing.JButton bCrearUsuario;
    public javax.swing.JComboBox cbCargo;
    public javax.swing.JComboBox cbEstado;
    public javax.swing.JComboBox cbSedes;
    public javax.swing.JFormattedTextField ftfFechaIncorporacion;
    public javax.swing.JFormattedTextField ftfFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPasswordField pfClave;
    public javax.swing.JPasswordField pfVerificarClave;
    public javax.swing.JTextField tfApellido;
    public javax.swing.JTextField tfCedula;
    public javax.swing.JTextField tfDireccion;
    public javax.swing.JTextField tfNombre;
    public javax.swing.JTextField tfNumeroCuenta;
    public javax.swing.JTextField tfSalario;
    public javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
