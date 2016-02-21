/***********************************************
 * Autor: Camilo Ruiz Casanova - 1324486
 * Autor: Miguel Angel Lopez - 1326691
 * Autor: Andres Felipe Polanco - 1324539
 * Autor: Cristian Camilo Jurado - 1324366
 * Fecha: 09-oct-2015
 * Nombre del Archivo: ConsultarPQR.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle
 **********************************************/

package Vista;

/**
 * interfaz de consultar pqr
 */
public class ConsultarPQR extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarPQR
     */
    public ConsultarPQR() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fDetalles = new javax.swing.JFrame();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        Lpqrn = new javax.swing.JLabel();
        tfNumeroPQR = new javax.swing.JTextField();
        LTipo = new javax.swing.JLabel();
        LSede = new javax.swing.JLabel();
        LCedula = new javax.swing.JLabel();
        tfCedula = new javax.swing.JTextField();
        LNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfTipo = new javax.swing.JTextField();
        tfSede = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfFecha = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        LContenido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taContenido = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        bCerrarDetalles = new javax.swing.JButton();
        bGenerarRecibo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bCerrar = new javax.swing.JButton();
        bActualizarPQR = new javax.swing.JButton();
        bVerPQR = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPQR = new javax.swing.JTable();

        fDetalles.setTitle("Detalles del PQR");
        fDetalles.setMinimumSize(new java.awt.Dimension(600, 530));
        fDetalles.setPreferredSize(new java.awt.Dimension(600, 530));
        fDetalles.getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        Lpqrn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Lpqrn.setText("PQR N°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
        jPanel2.add(Lpqrn, gridBagConstraints);

        tfNumeroPQR.setEditable(false);
        tfNumeroPQR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPanel2.add(tfNumeroPQR, gridBagConstraints);

        LTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LTipo.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(LTipo, gridBagConstraints);

        LSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LSede.setText("Sede");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 0);
        jPanel2.add(LSede, gridBagConstraints);

        LCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LCedula.setText("Cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(LCedula, gridBagConstraints);

        tfCedula.setEditable(false);
        tfCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCedulaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfCedula, gridBagConstraints);

        LNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(LNombre, gridBagConstraints);

        tfNombre.setEditable(false);
        tfNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfNombre, gridBagConstraints);

        tfTipo.setEditable(false);
        tfTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfTipo, gridBagConstraints);

        tfSede.setEditable(false);
        tfSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel2.add(tfSede, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        tfEstado.setEditable(false);
        tfEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfEstado, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Fecha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        tfFecha.setEditable(false);
        tfFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        jPanel2.add(tfFecha, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        fDetalles.getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        LContenido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LContenido.setText("Contenido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
        jPanel3.add(LContenido, gridBagConstraints);

        taContenido.setEditable(false);
        taContenido.setColumns(20);
        taContenido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        taContenido.setRows(7);
        jScrollPane1.setViewportView(taContenido);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        jPanel3.add(jScrollPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        fDetalles.getContentPane().add(jPanel3, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        bCerrarDetalles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCerrarDetalles.setText("Cerrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel5.add(bCerrarDetalles, gridBagConstraints);

        bGenerarRecibo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bGenerarRecibo.setText("Generar Recibo");
        bGenerarRecibo.setMaximumSize(new java.awt.Dimension(79, 31));
        bGenerarRecibo.setMinimumSize(new java.awt.Dimension(79, 31));
        bGenerarRecibo.setPreferredSize(new java.awt.Dimension(79, 31));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel5.add(bGenerarRecibo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        fDetalles.getContentPane().add(jPanel5, gridBagConstraints);

        setMinimumSize(new java.awt.Dimension(700, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        bCerrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCerrar.setText("Cerrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel1.add(bCerrar, gridBagConstraints);

        bActualizarPQR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bActualizarPQR.setText("Actualizar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(bActualizarPQR, gridBagConstraints);

        bVerPQR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bVerPQR.setText("Ver PQR Completo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel1.add(bVerPQR, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        tPQR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tPQR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tPQR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°PQR", "TIPO", "CEDULA", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPQR.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tPQR);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCedulaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LCedula;
    private javax.swing.JLabel LContenido;
    private javax.swing.JLabel LNombre;
    private javax.swing.JLabel LSede;
    private javax.swing.JLabel LTipo;
    private javax.swing.JLabel Lpqrn;
    public javax.swing.JButton bActualizarPQR;
    public javax.swing.JButton bCerrar;
    public javax.swing.JButton bCerrarDetalles;
    public javax.swing.JButton bGenerarRecibo;
    public javax.swing.JButton bVerPQR;
    public javax.swing.JFrame fDetalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tPQR;
    public javax.swing.JTextArea taContenido;
    public javax.swing.JTextField tfCedula;
    public javax.swing.JTextField tfEstado;
    public javax.swing.JTextField tfFecha;
    public javax.swing.JTextField tfNombre;
    public javax.swing.JTextField tfNumeroPQR;
    public javax.swing.JTextField tfSede;
    public javax.swing.JTextField tfTipo;
    // End of variables declaration//GEN-END:variables
}
