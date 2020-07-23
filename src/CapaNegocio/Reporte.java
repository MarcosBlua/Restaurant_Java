package CapaNegocio;

import CapaDatos.ReportesBD;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Locale;

public class Reporte {
    
    //Funciones
    //Pasaje de datos para devolver TableModel con la ventas de un mozo en un dia especifico
    public static void ventasPorMozo(long cuil, Calendar fecha, LinkedList<Object[]> ventasPorMozo){
        //Cambio la fecha al siguiente formato '01 Jan 2020'
        String fech = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH) + " " + String.valueOf(fecha.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH)) + " " + String.valueOf(fecha.get(Calendar.YEAR)));
        
        ReportesBD.ventasPorMozo(cuil, fech, ventasPorMozo);
    }
    
    //Pasaje de datos para devolver TableModel con las ventas del local en un dia especifico
    public static void ventasPorDia(Calendar fecha, LinkedList<Object[]> ventasPorDia){
        //Cambio la fecha al siguiente formato '01 Jan 2020'
        String fech = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH) + " " + String.valueOf(fecha.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH)) + " " + String.valueOf(fecha.get(Calendar.YEAR)));
        
        ReportesBD.ventasPorDia(fech, ventasPorDia);
    }
    
    //Pasaje de datos para devolver TableModel con los insumos utilizados en un dia especifico
    public static void insumosUtilizados(Calendar fecha, LinkedList<Object[]> insumosUtilizados){
        //Cambio la fecha al siguiente formato '01 Jan 2020'
        String fech = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH) + " " + String.valueOf(fecha.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH)) + " " + String.valueOf(fecha.get(Calendar.YEAR)));
        
        ReportesBD.insumosUtilizados(fech, insumosUtilizados);
    }
}
