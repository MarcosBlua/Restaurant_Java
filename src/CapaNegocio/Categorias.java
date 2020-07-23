package CapaNegocio;

import CapaDatos.CategoriaBD;
import java.util.LinkedList;

public class Categorias {
    //Pasaje de datos para cargar ComboBoxModel con categorias
    public static void cargarCBXCategoria(LinkedList<Categoria> categorias){
        CategoriaBD.cargarCBXCategoria(categorias);
    }
    
    //Pasaje de datos para cargar TableModel con categorias
    public static void cargarTablaCategoria(LinkedList<Object[]> categorias){
        CategoriaBD.cargarTablaCategoria(categorias);
    }
}
