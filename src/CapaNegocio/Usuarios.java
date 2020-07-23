package CapaNegocio;

import CapaDatos.UsuarioBD;
import java.util.LinkedList;

public class Usuarios {
    //Pasaje de datos para cargar TableModel con usuarios
    public static void cargarTablaUsuarios(LinkedList<Object[]> users){
        UsuarioBD.cargarTablaUsuarios(users);
    }
}
