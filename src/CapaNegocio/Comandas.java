package CapaNegocio;

import CapaDatos.ComandaBD;
import java.util.LinkedList;

public class Comandas {
    //Pasaje de datos para cargar TableModel con comandas activas
    public static void cargarTablaComandasActivas(LinkedList comandasActivas){
        ComandaBD.cargarTablaComandasActivas(comandasActivas);
    }
}
