package CapaUsuario;

import CapaDatos.Config;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends javax.swing.JPanel {
    public Login() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        pssContra = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(1010, 580));
        setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 100)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Kost");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");

        txtUser.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N

        btnIniciarSesion.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
        });
        btnIniciarSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIniciarSesionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(pssContra))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(pssContra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)))
                        .addGap(44, 44, 44)
                        .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked
        //Llamo a la funcion para inciar sesion
        iniciarSesion();
    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    private void btnIniciarSesionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIniciarSesionKeyPressed
        //Detecta cuanto se aprieta enter en el boton de inicio de secion
        btnIniciarSesion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                //Llamo a la funcion para inciar sesion
                iniciarSesion();
            }
            }
        });
    }//GEN-LAST:event_btnIniciarSesionKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pssContra;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
    
    //Getters y setters
    public String getPssContra() {
        return pssContra.getText();
    }

    public void setPssContra(String pssContra) {
        this.pssContra.setText(pssContra);
    }

    public String getTxtUser() {
        return txtUser.getText();
    }

    public void setTxtUser(String txtUser) {
        this.txtUser.setText(txtUser);
    }
    
    //Funciones
    //Limpia los campos de la pantalla
    public void clear(){
        setTxtUser("");
        setPssContra("");
    }
    
    //Se verifica si lo campos de la pantalla fueron completados
    public boolean campoVacio(){
        return ("".equals(txtUser.getText()) || "".equals(pssContra.getText()));
    }
    
    //Realiza el incio de sesion
    private void iniciarSesion(){
        //Verifica que los campos esten completados
        if(!campoVacio()){
            //Se crea el objeto que contiene la configuracion
            Config conf = new Config();
            //Usuario y contraseña default de configuracion
            if(conf.getAdmin().equals(txtUser.getText()) && conf.getPassAdmin().equals(pssContra.getText())){
                Inicio.admin = true;
                Inicio.activarBarra();
                Inicio.limpiarTodo();
                Inicio.comAct.actualizarPantalla();
                Inicio.mostrarVentana(Inicio.comAct);
            }else{
                //Casos de incio de sesion
                switch(CapaNegocio.Usuario.incioSecion(txtUser.getText(), pssContra.getText())){
                case 0:
                    //Usuario y contraseña incorrectos o inexistentes
                    Mensajes.msjError("Usuario y/o contraseña incorrectos.");
                    break;
                case 1:
                    //Usuario
                    Inicio.admin = false;
                    Inicio.activarBarra();
                    Inicio.limpiarTodo();
                    Inicio.comAct.actualizarPantalla();
                    Inicio.mostrarVentana(Inicio.comAct);
                    break;
                case 2:
                    //Administrador
                    Inicio.admin = true;
                    Inicio.activarBarra();
                    Inicio.limpiarTodo();
                    Inicio.comAct.actualizarPantalla();
                    Inicio.mostrarVentana(Inicio.comAct);
                    break;
                }
            }
            
        }else{
            Mensajes.msjError("Complete todos los campos");
        }
    }
    
    public void actualizarPantalla(){
        clear();
    }
}
