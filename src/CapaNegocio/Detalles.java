package CapaNegocio;

import CapaDatos.DetalleBD;
import java.util.LinkedList;

public class Detalles {
    //Pasaje de datos para cargar TableModel con detalles de una comanda
    public static void cargarTablaDetalles(int nroComanda, LinkedList<Object[]> detalles){
        DetalleBD.cargarTablaDetalles(nroComanda, detalles);
    }
}
