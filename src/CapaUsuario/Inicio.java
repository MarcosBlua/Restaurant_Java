package CapaUsuario;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class Inicio extends javax.swing.JFrame {
    //Clase que se encarga del manejo de pantallas
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraIzq = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        btnComandas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnMozos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btinProductos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxReportes = new javax.swing.JComboBox<>();
        btnVerReporte = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraIzq.setBackground(new java.awt.Color(102, 102, 102));
        barraIzq.setForeground(new java.awt.Color(204, 204, 204));
        barraIzq.setName("barraIzq"); // NOI18N

        logo.setFont(new java.awt.Font("Century Gothic", 0, 60)); // NOI18N
        logo.setForeground(new java.awt.Color(0, 204, 204));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setText("Kost");

        btnComandas.setBackground(new java.awt.Color(102, 102, 102));
        btnComandas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComandasMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(btnComandas);
        jLabel1.setText("Comandas");

        javax.swing.GroupLayout btnComandasLayout = new javax.swing.GroupLayout(btnComandas);
        btnComandas.setLayout(btnComandasLayout);
        btnComandasLayout.setHorizontalGroup(
            btnComandasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnComandasLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnComandasLayout.setVerticalGroup(
            btnComandasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnComandasLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnUsuarios.setBackground(new java.awt.Color(102, 102, 102));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuarios");

        javax.swing.GroupLayout btnUsuariosLayout = new javax.swing.GroupLayout(btnUsuarios);
        btnUsuarios.setLayout(btnUsuariosLayout);
        btnUsuariosLayout.setHorizontalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUsuariosLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnUsuariosLayout.setVerticalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        btnMozos.setBackground(new java.awt.Color(102, 102, 102));
        btnMozos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMozosMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mozos");

        javax.swing.GroupLayout btnMozosLayout = new javax.swing.GroupLayout(btnMozos);
        btnMozos.setLayout(btnMozosLayout);
        btnMozosLayout.setHorizontalGroup(
            btnMozosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMozosLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btnMozosLayout.setVerticalGroup(
            btnMozosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnMozosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btinProductos.setBackground(new java.awt.Color(102, 102, 102));
        btinProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btinProductosMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Productos");

        javax.swing.GroupLayout btinProductosLayout = new javax.swing.GroupLayout(btinProductos);
        btinProductos.setLayout(btinProductosLayout);
        btinProductosLayout.setHorizontalGroup(
            btinProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(btinProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btinProductosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btinProductosLayout.setVerticalGroup(
            btinProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(btinProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btinProductosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        btnCerrarSesion.setBackground(new java.awt.Color(102, 102, 102));
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cerrar sesión");

        javax.swing.GroupLayout btnCerrarSesionLayout = new javax.swing.GroupLayout(btnCerrarSesion);
        btnCerrarSesion.setLayout(btnCerrarSesionLayout);
        btnCerrarSesionLayout.setHorizontalGroup(
            btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCerrarSesionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnCerrarSesionLayout.setVerticalGroup(
            btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCerrarSesionLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reportes");

        cbxReportes.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        btnVerReporte.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnVerReporte.setText("Ver Reporte");
        btnVerReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerReporteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout barraIzqLayout = new javax.swing.GroupLayout(barraIzq);
        barraIzq.setLayout(barraIzqLayout);
        barraIzqLayout.setHorizontalGroup(
            barraIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnComandas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btinProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMozos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(barraIzqLayout.createSequentialGroup()
                .addGroup(barraIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barraIzqLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6))
                    .addGroup(barraIzqLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(cbxReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(barraIzqLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnVerReporte)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        barraIzqLayout.setVerticalGroup(
            barraIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraIzqLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnComandas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMozos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btinProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(barraIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 580));
        barraIzq.getAccessibleContext().setAccessibleName("barraizq");

        panelPrincipal.setBackground(new java.awt.Color(255, 253, 255));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 800, 580));
        panelPrincipal.getAccessibleContext().setAccessibleName("panelinicio");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComandasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComandasMouseClicked
        limpiarTodo();
        comAct.actualizarPantalla();
        mostrarVentana(comAct);        
    }//GEN-LAST:event_btnComandasMouseClicked

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        //Solo usuarios administradores pueden ver esta pantalla
        if(admin){
            limpiarTodo();
            user.actualizarPantalla();
            mostrarVentana(user);
        }else{
            Mensajes.msjError("Necesita ser administrador para entrar a esta sección.");
        }        
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnMozosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMozosMouseClicked
        limpiarTodo();
        moz.actualizarPantalla();
        mostrarVentana(moz);
    }//GEN-LAST:event_btnMozosMouseClicked

    private void btinProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btinProductosMouseClicked
        limpiarTodo();
        listProd.actualizarPantalla();
        mostrarVentana(listProd);
    }//GEN-LAST:event_btinProductosMouseClicked

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        limpiarTodo();
        barraIzq.setVisible(false);
        log.actualizarPantalla();
        mostrarVentana(log);
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnVerReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerReporteMouseClicked
        switch(cbxReportes.getSelectedIndex()){
            case 0:
                limpiarTodo();
                ventPM.actualizarPantalla();
                mostrarVentana(ventPM);
                break;
            case 1:
                limpiarTodo();
                ventPD.actualizarPantalla();
                mostrarVentana(ventPD);
                break;
            case 2:
                limpiarTodo();
                insUti.actualizarPantalla();
                mostrarVentana(insUti);
                break;
        }
    }//GEN-LAST:event_btnVerReporteMouseClicked

    //Crea variables de cada pantalla y un layout para el manejo de las mismas
    GridBagLayout layout = new GridBagLayout();
    protected static CategoriaP cat;
    protected static ComandaP com;
    protected static ComandasActivas comAct;
    protected static InsumoP ins;
    protected static ListaInsumos listIns;
    protected static InsumosUtilizados insUti;
    protected static ListaProductos listProd;
    protected static Login log;
    protected static MozoP moz;
    protected static ProductoP prod;
    protected static Stock sto;
    protected static UsuarioP user;
    protected static VentasPorDia ventPD;
    protected static VentasPorMozo ventPM;
    protected static boolean admin;

    public static boolean isAdmin() {
        return admin;
    }

    public static void setAdmin(boolean admin) {
        Inicio.admin = admin;
    }
    
    public Inicio(){
        initComponents();
        //Inicializa las variables de pantalla 
        admin = false;
        cbxReportes.addItem("Ventas por mozo");
        cbxReportes.addItem("Ventas por día");
        cbxReportes.addItem("Insumos utilizados");
        cat = new CategoriaP();
        com = new ComandaP();
        comAct = new ComandasActivas();
        ins = new InsumoP();
        listIns = new ListaInsumos();
        insUti = new InsumosUtilizados();
        listProd = new ListaProductos();
        moz = new MozoP();
        prod = new ProductoP();
        sto = new Stock();
        user = new UsuarioP();
        ventPD = new VentasPorDia();
        ventPM = new VentasPorMozo();        
        log = new Login();
        
        //Ajusta el layout y las restricciones de donde se mostraran las pantallas
        panelPrincipal.setLayout(layout);
        GridBagConstraints c= new GridBagConstraints ();
        c.gridx = 0;
        c.gridy = 0;
        
        panelPrincipal.add(cat, c);
        panelPrincipal.add(com, c);
        panelPrincipal.add(comAct, c);
        panelPrincipal.add(ins, c);
        panelPrincipal.add(listIns, c);
        panelPrincipal.add(insUti, c);
        panelPrincipal.add(listProd, c);
        panelPrincipal.add(moz, c);
        panelPrincipal.add(prod, c);
        panelPrincipal.add(sto, c);
        panelPrincipal.add(user, c);
        panelPrincipal.add(ventPD, c);
        panelPrincipal.add(ventPM, c);
        
        this.setLayout(layout);
        this.add(log, c);
        
        //Settea todas las pantallas como invicibles
        cat.setVisible(false);
        com.setVisible(false);
        comAct.setVisible(false);
        ins.setVisible(false);
        listIns.setVisible(false);
        insUti.setVisible(false);
        listProd.setVisible(false);
        moz.setVisible(false);
        prod.setVisible(false);
        sto.setVisible(false);
        user.setVisible(false);
        ventPD.setVisible(false);
        ventPM.setVisible(false);
        log.setVisible(false);
        barraIzq.setVisible(false);
        //Muestra pantalla de inicio de sesion
        mostrarVentana(log);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel barraIzq;
    private javax.swing.JPanel btinProductos;
    private javax.swing.JPanel btnCerrarSesion;
    private javax.swing.JPanel btnComandas;
    private javax.swing.JPanel btnMozos;
    private javax.swing.JPanel btnUsuarios;
    private javax.swing.JButton btnVerReporte;
    private javax.swing.JComboBox<String> cbxReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel logo;
    private static javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
    //Envia una pantalla seleccionada al frente para ser la visible y pone al resto como invisibles
    public static void mostrarVentana(JPanel panel){
        cat.setVisible(false);
        com.setVisible(false);
        comAct.setVisible(false);
        ins.setVisible(false);
        listIns.setVisible(false);
        insUti.setVisible(false);
        listProd.setVisible(false);
        moz.setVisible(false);
        prod.setVisible(false);
        sto.setVisible(false);
        user.setVisible(false);
        ventPD.setVisible(false);
        ventPM.setVisible(false);
        log.setVisible(false);
        
        panel.setVisible(true);
    }
    
    //Muestra la barra izquierda de botones
    public static void activarBarra(){
        barraIzq.setVisible(true);
    }
    
    //Hace una limpieza de datos de todas las pantallas
    public static void limpiarTodo(){
        log.clear();
        comAct.clear_T();
        com.clear_T();
        ins.clear();
        listIns.clear_T();
        listProd.clear_T();
        prod.clear_T();
        moz.clear_T();
        user.clear_T();
        cat.clear_T();
        insUti.clear_T();
        ventPD.clear_T();
        ventPM.clear_T();
        sto.clear_T();
    }
}
