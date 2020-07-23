package CapaUsuario;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mensajes {
    
    private void msj_OK(String m){
        JOptionPane.showConfirmDialog(null, m, "OK!", JOptionPane.DEFAULT_OPTION);
    }
    
    private void msj_Error(String m){
        JOptionPane.showMessageDialog(null, m, "Error!", 0);
    }
    
    private int msj_Confirm(String m){
        return JOptionPane.showConfirmDialog(null, m, "Error!", JOptionPane.YES_NO_OPTION);
    }
    
    public static void msjOk(String m){
        Mensajes msj = new Mensajes();
        msj.msj_OK(m);
    }
    
    public static void msjError(String m){
        Mensajes msj = new Mensajes();
        msj.msj_Error(m);
    }
    
    public static int msjConfim(String m){
        Mensajes msj = new Mensajes();
        return msj.msj_Confirm(m);
    }
}
