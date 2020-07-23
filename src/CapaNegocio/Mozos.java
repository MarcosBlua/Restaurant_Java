package CapaNegocio;

import CapaDatos.MozoBD;
import java.util.LinkedList;

public class Mozos {
    //Pasaje de datos para cargar ComboBoxModel con mozos
    public static void cargarCBXMozos(LinkedList<Mozo> mozos){
        MozoBD.cargarCBXMozos(mozos);
    }
    
    //Pasaje de datos para cargar TableModel con mozos
    public static void cargarTablaMozos(LinkedList<Object[]> mozos){
        MozoBD.cargarTablaMozos(mozos);
    }
}
