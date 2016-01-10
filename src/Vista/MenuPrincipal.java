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

import Controlador.*;
import javax.swing.JFrame;


/**
 *
 * @author Camilo Ruiz Casanova
 */
public class MenuPrincipal extends JFrame
{
    public CrearUsuario crearUsuario;
	public CrearUsuario_Eventos crearUsuario_Eventos;

	public ModificarUsuario modificarUsuario;
	public ModificarUsuario_Eventos modificarUsuario_Eventos;

	public ConsultarUsuarios consultarUsuarios;
	public ConsultarUsuarios_Eventos consultarUsuarios_Eventos;

	public CrearSede crearSede;
	public CrearSede_Eventos crearSede_Eventos;

	public ModificarSede modificarSede;
	public ModificarSede_Eventos modificarSede_Eventos;

	public ConsultarSede consultarSede;
	public ConsultarSede_Eventos consultarSede_Eventos;

	public CrearPQR crearPQR;
	public CrearPQR_Eventos crearPQR_Eventos;

	public ConsultarPQR consultarPQR;
	public ConsultarPQR_Eventos consultarPQR_Eventos;

	public ResponderPQR responderPQR;
	public ResponderPQR_Eventos responderPQR_Eventos;

	public RegistrarVenta registrarVenta;
	public RegistrarVenta_Eventos registrarVenta_Eventos;
    
    /**
     * constructor de la clase, construye la interfaz
     */
    public MenuPrincipal() 
    {
        initComponents();       
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pIniciarSesion = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        bIniciarSesion = new javax.swing.JButton();
        pfClave = new javax.swing.JPasswordField();
        pIdentidad = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tfIdentidad = new javax.swing.JTextField();
        bCerrarSesion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pGestionUsuarios = new javax.swing.JPanel();
        bCrearUsuario = new javax.swing.JButton();
        bModificarUsuario = new javax.swing.JButton();
        bConsultarUsuarios = new javax.swing.JButton();
        pGestionSedes = new javax.swing.JPanel();
        bCrearSede = new javax.swing.JButton();
        bModificarSede = new javax.swing.JButton();
        bConsultarSedes = new javax.swing.JButton();
        pPQR = new javax.swing.JPanel();
        bCrearPQR = new javax.swing.JButton();
        bConsultarPQR = new javax.swing.JButton();
        bResponderPQR = new javax.swing.JButton();
        pGestionUsuarios2 = new javax.swing.JPanel();
        bRegistrarVenta = new javax.swing.JButton();
        bModificarVenta = new javax.swing.JButton();
        bConsultarVentas = new javax.swing.JButton();
        pGestionUsuarios1 = new javax.swing.JPanel();
        bReportes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema FLASH");
        setMinimumSize(new java.awt.Dimension(800, 625));

        pIniciarSesion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Iniciar Sesion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Cedula:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Contraseña:");

        tfUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bIniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bIniciarSesion.setText("Iniciar Sesion");

        pfClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pIniciarSesionLayout = new javax.swing.GroupLayout(pIniciarSesion);
        pIniciarSesion.setLayout(pIniciarSesionLayout);
        pIniciarSesionLayout.setHorizontalGroup(
            pIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pIniciarSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addGroup(pIniciarSesionLayout.createSequentialGroup()
                        .addGroup(pIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(pIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pfClave, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(tfUsuario))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pIniciarSesionLayout.setVerticalGroup(
            pIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pIniciarSesionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(pfClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pIdentidad.setLayout(new java.awt.GridLayout(1, 3, 20, 0));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Usted se ha identificado como:");
        pIdentidad.add(jLabel14);

        tfIdentidad.setEditable(false);
        tfIdentidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pIdentidad.add(tfIdentidad);

        bCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCerrarSesion.setText("Cerrar Sesion");
        bCerrarSesion.setEnabled(false);
        pIdentidad.add(bCerrarSesion);

        jPanel1.setLayout(new java.awt.GridLayout(2, 3, 10, 10));

        pGestionUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Usuarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        bCrearUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCrearUsuario.setText("Crear Usuario");
        bCrearUsuario.setEnabled(false);

        bModificarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bModificarUsuario.setText("Modificar Usuario");
        bModificarUsuario.setEnabled(false);

        bConsultarUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bConsultarUsuarios.setText("Consultar Usuarios");
        bConsultarUsuarios.setEnabled(false);

        javax.swing.GroupLayout pGestionUsuariosLayout = new javax.swing.GroupLayout(pGestionUsuarios);
        pGestionUsuarios.setLayout(pGestionUsuariosLayout);
        pGestionUsuariosLayout.setHorizontalGroup(
            pGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGestionUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bConsultarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(bModificarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pGestionUsuariosLayout.setVerticalGroup(
            pGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGestionUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCrearUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bModificarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bConsultarUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pGestionUsuarios);

        pGestionSedes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Sedes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        pGestionSedes.setPreferredSize(new java.awt.Dimension(155, 126));

        bCrearSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCrearSede.setText("Crear Sede");
        bCrearSede.setEnabled(false);

        bModificarSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bModificarSede.setText("Modificar Sede");
        bModificarSede.setEnabled(false);

        bConsultarSedes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bConsultarSedes.setText("Consultar Sedes");
        bConsultarSedes.setEnabled(false);

        javax.swing.GroupLayout pGestionSedesLayout = new javax.swing.GroupLayout(pGestionSedes);
        pGestionSedes.setLayout(pGestionSedesLayout);
        pGestionSedesLayout.setHorizontalGroup(
            pGestionSedesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGestionSedesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGestionSedesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCrearSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bModificarSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bConsultarSedes, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap())
        );
        pGestionSedesLayout.setVerticalGroup(
            pGestionSedesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGestionSedesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCrearSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bModificarSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bConsultarSedes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pGestionSedes);

        pPQR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PQR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        bCrearPQR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCrearPQR.setText("Realizar PQR");
        bCrearPQR.setEnabled(false);

        bConsultarPQR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bConsultarPQR.setText("Consultar PQR");
        bConsultarPQR.setEnabled(false);

        bResponderPQR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bResponderPQR.setText("Responder PQR");
        bResponderPQR.setEnabled(false);

        javax.swing.GroupLayout pPQRLayout = new javax.swing.GroupLayout(pPQR);
        pPQR.setLayout(pPQRLayout);
        pPQRLayout.setHorizontalGroup(
            pPQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPQRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCrearPQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bConsultarPQR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bResponderPQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pPQRLayout.setVerticalGroup(
            pPQRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPQRLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCrearPQR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bConsultarPQR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bResponderPQR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pPQR);

        pGestionUsuarios2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Ventas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        bRegistrarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bRegistrarVenta.setText("Registrar Venta");
        bRegistrarVenta.setEnabled(false);

        bModificarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bModificarVenta.setText("Modificar Venta");
        bModificarVenta.setEnabled(false);

        bConsultarVentas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bConsultarVentas.setText("Consultar Ventas");
        bConsultarVentas.setEnabled(false);

        javax.swing.GroupLayout pGestionUsuarios2Layout = new javax.swing.GroupLayout(pGestionUsuarios2);
        pGestionUsuarios2.setLayout(pGestionUsuarios2Layout);
        pGestionUsuarios2Layout.setHorizontalGroup(
            pGestionUsuarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGestionUsuarios2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGestionUsuarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bRegistrarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bConsultarVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(bModificarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pGestionUsuarios2Layout.setVerticalGroup(
            pGestionUsuarios2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGestionUsuarios2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bRegistrarVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bModificarVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bConsultarVentas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pGestionUsuarios2);

        pGestionUsuarios1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reportes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        bReportes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bReportes.setText("Reportes");
        bReportes.setEnabled(false);

        javax.swing.GroupLayout pGestionUsuarios1Layout = new javax.swing.GroupLayout(pGestionUsuarios1);
        pGestionUsuarios1.setLayout(pGestionUsuarios1Layout);
        pGestionUsuarios1Layout.setHorizontalGroup(
            pGestionUsuarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGestionUsuarios1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );
        pGestionUsuarios1Layout.setVerticalGroup(
            pGestionUsuarios1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGestionUsuarios1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bReportes)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel1.add(pGestionUsuarios1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOMBRE Y LOGO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(pIdentidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bCerrarSesion;
    public javax.swing.JButton bConsultarPQR;
    public javax.swing.JButton bConsultarSedes;
    public javax.swing.JButton bConsultarUsuarios;
    public javax.swing.JButton bConsultarVentas;
    public javax.swing.JButton bCrearPQR;
    public javax.swing.JButton bCrearSede;
    public javax.swing.JButton bCrearUsuario;
    public javax.swing.JButton bIniciarSesion;
    public javax.swing.JButton bModificarSede;
    public javax.swing.JButton bModificarUsuario;
    public javax.swing.JButton bModificarVenta;
    public javax.swing.JButton bRegistrarVenta;
    public javax.swing.JButton bReportes;
    public javax.swing.JButton bResponderPQR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pGestionSedes;
    private javax.swing.JPanel pGestionUsuarios;
    private javax.swing.JPanel pGestionUsuarios1;
    private javax.swing.JPanel pGestionUsuarios2;
    private javax.swing.JPanel pIdentidad;
    private javax.swing.JPanel pIniciarSesion;
    private javax.swing.JPanel pPQR;
    public javax.swing.JPasswordField pfClave;
    public javax.swing.JTextField tfIdentidad;
    public javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
