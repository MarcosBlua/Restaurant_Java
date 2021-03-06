package CapaUsuario;

import CapaNegocio.Mozo;
import CapaNegocio.Mozos;
import CapaNegocio.Reporte;
import java.util.Calendar;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class VentasPorMozo extends javax.swing.JPanel {
    //Variables usadas para guardar datos a mostrar en pantalla
    LinkedList<Object[]> datosTabla = new LinkedList<Object[]>();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Calendar fechaAct = Calendar.getInstance();

    public VentasPorMozo() {
        initComponents();
        
        jdcVentasPorMozo.setDate(new java.sql.Date(fechaAct.getTimeInMillis()));
        
        //Crea las columnas del JTable
        modeloTabla.addColumn("NroComanda");
        modeloTabla.addColumn("Total");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jdcVentasPorMozo = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxMozos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentasPorMozo = new javax.swing.JTable();
        lblTotalVendido = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 580));
        setMinimumSize(new java.awt.Dimension(800, 580));
        setPreferredSize(new java.awt.Dimension(800, 580));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("Ventas por mozo");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Mozo");

        cbxMozos.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        jtVentasPorMozo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NroComanda", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtVentasPorMozo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtVentasPorMozo);

        lblTotalVendido.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblTotalVendido.setText("Total que vendió: $");

        btnVer.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVer.setText("Ver");
        btnVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jdcVentasPorMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(cbxMozos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalVendido)
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdcVentasPorMozo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbxMozos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnVer))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblTotalVendido)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerMouseClicked
        cargarJTB();
    }//GEN-LAST:event_btnVerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox<Mozo> cbxMozos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcVentasPorMozo;
    private javax.swing.JTable jtVentasPorMozo;
    private javax.swing.JLabel lblTotalVendido;
    // End of variables declaration//GEN-END:variables
    //Limpia toda la pantalla
    public void clear_T(){
        vaciarTabla();
        
        lblTotalVendido.setText("Total que vendió: $");
        
        cbxMozos.removeAllItems();
    }
    
    //Carga JComboBox con datos
    public void cargarCBX(){
        LinkedList<Mozo> listaMozos = new LinkedList();
        
        Mozos.cargarCBXMozos(listaMozos);
        
        DefaultComboBoxModel<Mozo> comboMozo = new DefaultComboBoxModel(listaMozos.toArray());
        
        cbxMozos.setModel(comboMozo);
    }
    
    //Vacia el JTable
    public void vaciarTabla(){
        DefaultTableModel dtm = (DefaultTableModel) jtVentasPorMozo.getModel();
        dtm.setRowCount(0);
        jtVentasPorMozo.setModel(dtm);
        
        datosTabla.clear();
    }
    
    //Carga JTable con datos
    public void cargarJTB(){
        vaciarTabla();
        
        if((Integer)cbxMozos.getSelectedIndex() == -1){
            Mensajes.msjError("No hay mozos de los cuales mostrar ventas.");
        }else{
            Mozo moz = (Mozo)cbxMozos.getSelectedItem();
            float total = 0;
            long cuil = moz.getCuil();
            
            Reporte.ventasPorMozo(cuil, jdcVentasPorMozo.getCalendar(), datosTabla);
            
            ManejoTablas.cargarTabla(datosTabla, modeloTabla);
            //Calcula el total de todas las ventas de la tabla
            for(int cont = 0; cont < jtVentasPorMozo.getRowCount(); cont++){
                total += (Float)jtVentasPorMozo.getValueAt(cont, 1);
            }
                                
            lblTotalVendido.setText("Total que vendió: $" + total);
            jtVentasPorMozo.setModel(modeloTabla);
        }        
    }
    
    //Actualiza la pantalla
    public void actualizarPantalla(){
        cargarCBX();
        
        cargarJTB();
        
        jdcVentasPorMozo.setDate(new java.sql.Date(fechaAct.getTimeInMillis()));
    }
}
