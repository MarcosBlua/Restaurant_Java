package restaurantproj;

import CapaDatos.Conexion;
import CapaUsuario.Inicio;

public class RestaurantProj {
    public static Inicio inicio;
    public static Conexion conn;
    public static void main(String[] args) {
        inicio = new Inicio();
        inicio.setVisible(true);
    }
    
}
