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

/**
 *
 * @author Cristian Jurado
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

        jPanel1 = new javax.swing.JPanel();
        bCerrar = new javax.swing.JButton();
        bActualizarPQR = new javax.swing.JButton();
        bVerPQR = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPQR = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));

        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        bCerrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCerrar.setText("Cerrar");
        jPanel1.add(bCerrar);

        bActualizarPQR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bActualizarPQR.setText("Actualizar Lista");
        jPanel1.add(bActualizarPQR);

        bVerPQR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bVerPQR.setText("Ver PQR Completo");
        jPanel1.add(bVerPQR);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bActualizarPQR;
    public javax.swing.JButton bCerrar;
    public javax.swing.JButton bVerPQR;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tPQR;
    // End of variables declaration//GEN-END:variables
}
