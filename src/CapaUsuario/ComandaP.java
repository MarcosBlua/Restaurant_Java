package CapaUsuario;

import CapaNegocio.Comanda;
import javax.swing.table.DefaultTableModel;
import CapaNegocio.Detalle;
import CapaNegocio.Detalles;
import CapaNegocio.Mozo;
import CapaNegocio.Producto;
import CapaNegocio.Productos;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ComandaP extends javax.swing.JPanel {
    //Variables usadas para guardar datos a mostrar en pantalla
    LinkedList<Object[]> datosTabla = new LinkedList<Object[]>();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Comanda comanda = new Comanda();
    boolean bandModificar = false;
    int row;
    Detalle detal = new Detalle();
    
    public ComandaP() {
        initComponents();
        
        //Crea las columnas del JTable
        modeloTabla.addColumn("NroDetalle");
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNroComanda = new javax.swing.JLabel();
        lblNroMesa = new javax.swing.JLabel();
        lblMozo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetalles = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnlDetalle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPrecioUnitario = new javax.swing.JLabel();
        cbxProductos = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrarComanda = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblPrecioFinal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(800, 580));
        setMinimumSize(new java.awt.Dimension(800, 580));
        setPreferredSize(new java.awt.Dimension(800, 580));

        lblNroComanda.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblNroComanda.setText("N°Comanda:");

        lblNroMesa.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblNroMesa.setText("N°Mesa:");

        lblMozo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblMozo.setText("Mozo:");

        jtDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°Detalle", "Cód.Producto", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDetalles.setColumnSelectionAllowed(true);
        jtDetalles.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtDetalles);
        jtDetalles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        pnlDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Detalle");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Producto");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Precio unit.");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Cantidad");

        lblPrecioUnitario.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblPrecioUnitario.setText("$");

        cbxProductos.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        cbxProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProductosItemStateChanged(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        txtCantidad.setText("1");
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxProductos, 0, 214, Short.MAX_VALUE)
                                            .addComponent(txtCantidad))))))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxProductos)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblPrecioUnitario))
                .addGap(13, 13, 13)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCerrarComanda.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnCerrarComanda.setText("Cerrar Comanda");
        btnCerrarComanda.setToolTipText("");
        btnCerrarComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarComandaMouseClicked(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.setToolTipText("");
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblTotal.setText("$");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setText("Total:");

        lblPrecioFinal.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblPrecioFinal.setText("$");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Precio Final:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("Descuento");

        txtDescuento.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        txtDescuento.setText("0");
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNroComanda)
                                .addGap(89, 89, 89)
                                .addComponent(lblNroMesa)
                                .addGap(107, 107, 107)
                                .addComponent(lblMozo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCerrarComanda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNroComanda)
                    .addComponent(lblNroMesa)
                    .addComponent(lblMozo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(lblTotal))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblPrecioFinal))))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        clear();
        
        Producto prod = (Producto)cbxProductos.getSelectedItem();
        lblPrecioUnitario.setText("$" + prod.getPrecioVenta());
        
        activarCarga();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        clear();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        bandModificar = true;
        
        activarCarga();
        
        //Utiliza el numero de row para verificar que haya un elemento seleccionado
        row = jtDetalles.getSelectedRow();
        if(row == -1){
            Mensajes.msjError("No hay detalles en la comanda");
        }else{
            Producto pro = new Producto();
            detal = Detalle.traerUnDetalle((Integer)jtDetalles.getValueAt(row, 0));
            pro = Producto.traerUnProducto(detal.getIdProducto());
            
            txtCantidad.setText(String.valueOf(detal.getCantidad())); 
            cbxProductos.setSelectedItem(pro);
        }        
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        //Utiliza el numero de row para verificar que haya un elemento seleccionado
        row = jtDetalles.getSelectedRow();
        if(row == -1){
            Mensajes.msjError("No hay detalles en la comanda o no selecciono uno.");
        }else{
            if(Mensajes.msjConfim("¿Esta seguro que desea eliminar el detalle?") == JOptionPane.YES_OPTION){
                Detalle.eliminarDetalle((Integer)jtDetalles.getValueAt(row, 0));
        
                cargarJTB();
        
                calcularTotal();
            }            
        }        
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnCerrarComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarComandaMouseClicked
        if(Mensajes.msjConfim("¿Esta seguro que desea cerrar la comanda?") == JOptionPane.YES_OPTION){
            comanda.cerrarComanda();
        
            clear();
        
            Inicio.limpiarTodo();
            Inicio.comAct.actualizarPantalla();
            Inicio.mostrarVentana(Inicio.comAct);
        }        
    }//GEN-LAST:event_btnCerrarComandaMouseClicked

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        clear();
        
        Inicio.limpiarTodo();
        Inicio.comAct.actualizarPantalla();
        Inicio.mostrarVentana(Inicio.comAct);
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if((Integer)cbxProductos.getSelectedIndex() == -1){
            Mensajes.msjError("No hay productos cargados en el sistema.");
        }else{
            if(txtCantidad.getText().equals("")){
                Mensajes.msjError("Debe indicar la catidad.");
            }else{
                Producto p = (Producto)cbxProductos.getSelectedItem();
                //Hace una verificacion de stock antes de proceder al guardado
                if(Producto.hayStock(p.getIdProd(), Integer.parseInt(txtCantidad.getText()))){
                    if(!bandModificar){  
                        detal = new Detalle(comanda.getNroComanda(), p.getIdProd(), p.getNombre(), (Integer.parseInt(txtCantidad.getText())), (p.getPrecioVenta() * detal.getCantidad()));
                        
                        detal.guardarDetalle();
                    }else{
                        detal = new Detalle(detal.getNroDetalle(), comanda.getNroComanda(), p.getIdProd(), p.getNombre(), (Integer.parseInt(txtCantidad.getText())), (p.getPrecioVenta() * detal.getCantidad()));
                        
                        detal.modificarDetalle();
                    }
                }else{
                    Mensajes.msjError("No hay suficiente stock para cargar este producto.");
                }
            }
                
            clear();
        
            cargarJTB();
        
            calcularTotal();
            
            calcularPrecioFinal();
        }
        
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed
        //Solo permite el ingreso de numeros en el campo descuento
        //Calcula el descuento a medida que se ingresa el monto de descuento
        txtDescuento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!((c >= '0') && (c <= '9') || !(c != '.') ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }else{
                calcularPrecioFinal();
            }
            }
        });
    }//GEN-LAST:event_txtDescuentoKeyPressed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        //Solo permite el ingreso de numeros enteros en el campo cantidad
        txtCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!((c >= '0') && (c <= '9') ||
                (c == KeyEvent.VK_BACK_SPACE) ||
                (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
            }
        });
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void cbxProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProductosItemStateChanged
        //Carga el label con los datos necesarios del item seleccionado
        cbxProductos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e){
                Producto prod = (Producto)cbxProductos.getSelectedItem();
                lblPrecioUnitario.setText("$" + prod.getPrecioVenta());
            }
        });
    }//GEN-LAST:event_cbxProductosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarComanda;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<Producto> cbxProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtDetalles;
    private javax.swing.JLabel lblMozo;
    private javax.swing.JLabel lblNroComanda;
    private javax.swing.JLabel lblNroMesa;
    private javax.swing.JLabel lblPrecioFinal;
    private javax.swing.JLabel lblPrecioUnitario;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    // End of variables declaration//GEN-END:variables
    //Carga JTable con datos
    public void cargarJTB(){
        vaciarTabla();
        
        Detalles.cargarTablaDetalles(comanda.getNroComanda(), datosTabla);
        
        ManejoTablas.cargarTabla(datosTabla, modeloTabla);
        
        jtDetalles.setModel(modeloTabla);
    }
    
    //Carga JComboBox con datos
    public void cargarCBX(){
        cbxProductos.removeAll();
        
        LinkedList<Producto> listaProductos = new LinkedList();
        
        Productos.cargarCBXProductos(listaProductos);
        
        DefaultComboBoxModel<Producto> comboModel = new DefaultComboBoxModel(listaProductos.toArray());
        
        cbxProductos.setModel(comboModel);
    }
    
    //Limpia campos de ingreso de datos, desactiva botones y resetea banderas
    public void clear(){
        detal = new Detalle();
        bandModificar = false;
        cbxProductos.setEnabled(false);
        txtCantidad.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        txtCantidad.setText("1");
        lblPrecioUnitario.setText("$");
    }
    
    //Limpia toda la pantalla
    public void clear_T(){
        clear();
        
        vaciarTabla();
    }
    
    //Vacia el JTable
    public void vaciarTabla(){
        DefaultTableModel dtm = (DefaultTableModel) jtDetalles.getModel();
        dtm.setRowCount(0);
        jtDetalles.setModel(dtm);
        
        datosTabla.clear();
    }
    
    //Calcula el total de la comanda
    public void calcularTotal(){
        //Recorre la JTable tomando el total de cada detalle y lo agrega a un acumulador
        float acum = 0;
        
        for(int cont = 0; cont < jtDetalles.getRowCount(); cont++){
            acum += (Float)jtDetalles.getValueAt(cont, 3);
        }
        //Guarda el total en la variable comanda y lo muestra en pantalla
        comanda.setTotal(acum);
        
        lblTotal.setText("$" + comanda.getTotal());
    }
    
    //Calcula el precio final de la comanda
    public void calcularPrecioFinal(){
        //Si no se ingresa tomara que no hay descuento
        if(txtDescuento.getText().equals("")){
            comanda.setDescuento(0);
        }else{
            comanda.setDescuento(Float.parseFloat(txtDescuento.getText()));
        }        
        //Guarda en la variable comanda el precio final y lo muestra en pantalla
        //El precio final se compone del total y el decuento en la variable comanda
        comanda.setPrecioFinal(comanda.getTotal() - comanda.getDescuento());
        
        lblPrecioFinal.setText("$" + comanda.getPrecioFinal());
    }
    
    //Activa los campos de carga de datos y botones correspondientes
    public void activarCarga(){
        cbxProductos.setEnabled(true);
        txtCantidad.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }
    
    //Actualiza la pantalla, recube una comanda necesaria para cargar los datos en pantalla
    public void actualizarPantalla(Comanda com){
        comanda = com;
        
        cargarCBX();
        
        cargarJTB();
        
        lblNroComanda.setText("N°Comanda: " + com.getNroComanda());
        lblNroMesa.setText("N°Mesa: " + com.getNroMesa());
        lblMozo.setText("Mozo: " + Mozo.nombreMozo(com.getCuilMozo()));
        calcularTotal();
    }
}