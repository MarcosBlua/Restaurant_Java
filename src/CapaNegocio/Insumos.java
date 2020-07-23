package CapaNegocio;

import CapaDatos.InsumoBD;
import java.util.LinkedList;

public class Insumos {
    //Pasaje de datos para cargar ComboBoxModel con insumos
    public static void cargarCBXInsumos(LinkedList<Insumo> insumos){
        InsumoBD.cargarCBXInsumos(insumos);
    }
    
    //Pasaje de datos para cargar TableModel con insumos
    public static void cargarTablaInsumos(LinkedList<Object[]> insumos){
        InsumoBD.cargarTablaInsumos(insumos);
    }
    
    //Pasaje de datos para cargar TableModel con el stock de los insumos
    public static void cargarTablaStocks(LinkedList<Object[]> insumos){
        InsumoBD.cargarTablaStocks(insumos);
    }
}
