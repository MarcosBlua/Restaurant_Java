package CapaDatos;

import java.sql.SQLException;
import CapaUsuario.Mensajes;
import java.util.LinkedList;

public class ReportesBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Carga una TableModel con las ventas hechas en un dia por un mozo
    public static void ventasPorMozo(long cuil, String fecha, LinkedList<Object[]> ventasPorMozo){
        //Sentencia SQL
        String sentencia= "SELECT C.nroComanda, C.precioFinal " +
                        "FROM (Personas P INNER JOIN Mozos M ON P.cuil = M.cuilMozo) INNER JOIN Comandas C " +
                                                            "ON C.cuilMozo = M.cuilMozo " +
                         "WHERE convert(varchar, C.fecha, 106) = '" + fecha + "' AND M.cuilMozo = " + cuil + " AND C.activa = 0;";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de una venta
                ventasPorMozo.add(new Object[]{connBD.rs.getInt("nroComanda"), connBD.rs.getFloat("precioFinal")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga una TableModel con las ventas hechas en un dia
    public static void ventasPorDia(String fecha, LinkedList<Object[]> ventasPorDia){
        //Sentencia SQL
        String sentencia= "SELECT CONCAT(P.nombre,' ',P.apellido) AS mozo, C.nroComanda, C.precioFinal " +
                "FROM(Personas P INNER JOIN Mozos M ON P.cuil = M.cuilMozo) INNER JOIN Comandas " +
                "C ON C.cuilMozo = M.cuilMozo WHERE convert(varchar, C.fecha, 106) = '" + fecha + "' AND C.activa = 0;";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de una venta
                ventasPorDia.add(new Object[]{connBD.rs.getString("mozo"), connBD.rs.getInt("nroComanda"), connBD.rs.getFloat("precioFinal")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga una TableModel con los insumos utilizados en un dia
    public static void insumosUtilizados(String fecha, LinkedList<Object[]> insumosUtilizados){
        //Sentencia SQL
        String sentencia= "SELECT I.nombre, I.unidad, SUM(D.cantidad * Comp.cantidad) AS cantidad FROM Productos P INNER JOIN Composicion Comp " +
                          "ON P.idProducto = Comp.idProducto INNER JOIN Insumos I " +
                          "ON Comp.idInsumo = I.idInsumo INNER JOIN Detalles D " +
                          "ON D.idProducto = P.idProducto INNER JOIN Comandas C " +
                          "ON C.nroComanda = D.nroComanda WHERE C.baja = 0 AND C.Activa = 0 AND convert(varchar, C.fecha, 106) = '" + fecha + "' GROUP BY I.Nombre, I.Unidad;";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            String unidad = "Unidad no reconocida";
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                switch(connBD.rs.getInt("unidad")){
                case 0:
                    unidad = "Gramos";
                    break;
                case 1:
                    unidad = "Mililitros";
                    break;
                case 2:
                    unidad = "Unidades";
                    break;
                }
                
                //Agrega a la tabla una fila con la informacion de un insumo
                insumosUtilizados.add(new Object[]{connBD.rs.getString("nombre"), unidad, connBD.rs.getFloat("cantidad")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
}
