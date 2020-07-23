package CapaDatos;

import CapaNegocio.Detalle;
import java.sql.SQLException;
import CapaUsuario.Mensajes;
import java.util.LinkedList;

public class DetalleBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Guarda un detalle
    public static void guardarDetalle(Detalle det){
        //Sentencia SQL
        String sentencia="INSERT INTO Detalles (nroComanda, idProducto, nombreProducto, cantidad, precioUnitario, baja) values (?, ?, ?, ?, ?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setInt(1, det.getNroComanda());
            connBD.pps.setInt(2, det.getIdProducto());
            connBD.pps.setString(3, det.getNombreProducto());
            connBD.pps.setInt(4, det.getCantidad());
            connBD.pps.setFloat(5, det.getPrecioUnitario());
            
            //Se ejecuta la escritura
            connBD.pps.executeUpdate();
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        } finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Modifica un detalle
    public static void modificarDetalle(Detalle det){
        //Sentencia SQL
        String sentencia="UPDATE Detalles SET idProducto = ?, nombreProducto = ?, cantidad = ?, precioUnitario = ?, baja = 0 WHERE nroDetalle = ?";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setInt(1, det.getIdProducto());
            connBD.pps.setString(2, det.getNombreProducto());
            connBD.pps.setInt(3, det.getCantidad());
            connBD.pps.setFloat(4, det.getPrecioUnitario());
            connBD.pps.setInt(5, det.getNroDetalle());
            
            //Se ejecuta la escritura
            connBD.pps.executeUpdate();
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        } finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Elimina un detalle por su numero identifiador
    public static void eliminarDetalle(int nroDetalle){
        //Sentencia SQL
        String sentencia="DELETE FROM Detalles WHERE nroDetalle = " + nroDetalle;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se ejecuta la escritura
            connBD.pps.executeUpdate();
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        } finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Elimina un detalle por el numero de la comanda a la que pertenece
    public static void eliminarDetallesDeComanda(int nroComanda){
        //Sentencia SQL
        String sentencia="DELETE FROM Detalles WHERE nroComanda = " + nroComanda;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se ejecuta la escritura
            connBD.pps.executeUpdate();
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        } finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga una TableModel con los detalles de una comanda
    public static void cargarTablaDetalles(int nroComanda, LinkedList<Object[]> detalles){
        //Sentencia SQL
        String sentencia= "SELECT nroDetalle, nombreProducto, cantidad, precioUnitario FROM Detalles WHERE nroComanda = " + nroComanda + " AND baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){   
                //Agrega a la tabla una fila con la informacion de un detalle
                detalles.add(new Object[]{connBD.rs.getInt("nroDetalle"), connBD.rs.getString("nombreProducto"), connBD.rs.getInt("cantidad"), connBD.rs.getFloat("precioUnitario")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Trae un detalle por su numero identificador
    public static Detalle traerUnDetalle(int nroDetalle){
        //Sentencia SQL
        String sentencia= "SELECT * FROM Detalles WHERE nroDetalle = " + nroDetalle;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejcuta la lectura
            connBD.rs.next();
            
            //Carga los datos de la lectura en un detalle para devolver
            return new Detalle(connBD.rs.getInt("nroDetalle"), connBD.rs.getInt("nroComanda"), connBD.rs.getInt("idProducto"), connBD.rs.getString("nombreProducto"), connBD.rs.getInt("cantidad"), connBD.rs.getFloat("precioUnitario"));
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return null;
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }        
    }
}
