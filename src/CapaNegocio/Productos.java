package CapaNegocio;

import CapaDatos.ProductoBD;
import java.util.LinkedList;

public class Productos {
    //Pasaje de datos para cargar ComboBoxModel con productos
    public static void cargarCBXProductos(LinkedList<Producto> productos){
        ProductoBD.cargarCBXProductos(productos);
    }
    
    //Pasaje de datos para cargar TableModel con productos
    public static void cargarTablaProductos(LinkedList<Object[]> productos){
        ProductoBD.cargarTablaProductos(productos);
    }
    
    //Pasaje de datos para cargar TableModel con composiciones
    public static void cargarTablaComposiciones(int idProducto, LinkedList<Object[]> composiciones){
        ProductoBD.cargarTablaComposiciones(idProducto, composiciones);
    }
    
    //Pasaje de datos para devolver una composicion
    public static void traerComposiciones(int idProductos, LinkedList<Composicion> composiciones){
        ProductoBD.traerComposiciones(idProductos, composiciones);
    }
}
