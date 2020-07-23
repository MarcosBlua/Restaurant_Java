package CapaUsuario;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;

public class ManejoTablas {
    public static void cargarTabla(LinkedList<Object[]> listaTabla, DefaultTableModel modeloTabla){
        modeloTabla.setRowCount(0);
        
        for(Object[] listaRow : listaTabla){
            modeloTabla.addRow(listaRow);
        }
    }
}
