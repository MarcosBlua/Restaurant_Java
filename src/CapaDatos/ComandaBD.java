package CapaDatos;

import CapaNegocio.Comanda;
import java.sql.SQLException;
import CapaUsuario.Mensajes;
import java.util.LinkedList;

public class ComandaBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Guarda una comanda
    public static void guardarComanda(Comanda com){
        //Sentencia SQL
        String sentencia="INSERT INTO Comandas (fecha, nroMesa, activa, total, descuento, precioFinal, cuilMozo, baja) values (?, ?, 1, 0, 0, 0, ?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setDate(1, com.getFecha());
            connBD.pps.setInt(2, com.getNroMesa());
            connBD.pps.setLong(3, com.getCuilMozo());
            
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
    
    //Modifica una comanda
    public static void modificarComanda(Comanda com){
        //Sentencia SQL
        String sentencia="UPDATE Comandas SET NroMesa = ?, CuilMozo = ? WHERE NroComanda = ? and Activa = 1 and Baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setInt(1, com.getNroMesa());
            connBD.pps.setLong(2, com.getCuilMozo());
            connBD.pps.setInt(3, com.getNroComanda());
            
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
    
    //Elimina una comanda
    public static void eliminarComanda(int nroComanda){
        //Sentencia SQL
        String sentencia="DELETE FROM Comandas WHERE NroComanda = " + nroComanda;
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
    
    //Carga una TableModel con las comandas activas
    public static void cargarTablaComandasActivas(LinkedList<Object[]> comandasActivas){
        //Sentencia SQL
        String sentencia= "SELECT CONCAT(P.nombre,' ', P.apellido)as nya, C.* FROM Personas P INNER JOIN Comandas C ON P.cuil = C.cuilMozo WHERE P.baja = 0 AND C.baja = 0 AND C.activa = 1";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de una comanda
                comandasActivas.add(new Object[]{connBD.rs.getInt("NroComanda"), connBD.rs.getInt("NroMesa"), connBD.rs.getString("nya")});
            }
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Cierra una comanda guardando los datos necesarios para ello
    public static void cerrarComanda(int nroComanda, float total, float descuento, float precioFinal){
        //Sentencia SQL
        String sentencia="UPDATE Comandas SET total = ?, descuento = ?, precioFinal = ?, activa = 0 WHERE nroComanda = ?;";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setFloat(1, total);
            connBD.pps.setFloat(2, descuento);
            connBD.pps.setFloat(3, precioFinal);
            connBD.pps.setInt(4, nroComanda);
            
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
    
    //Trae una comanda por el numero identificador
    public static Comanda traerUnaComanda(int nroComanda){
        //Sentencia SQL
        String sentencia="SELECT nroComanda, fecha, nroMesa, activa, total, descuento, precioFinal, cuilMozo FROM Comandas WHERE nroComanda = " + nroComanda;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejcuta la lectura
            connBD.rs.next();
            
            //Carga los datos de la lectura en una comanda para devolver
            return new Comanda(connBD.rs.getInt("nroComanda"), connBD.rs.getDate("fecha"), connBD.rs.getInt("nroMesa"), connBD.rs.getBoolean("activa"), connBD.rs.getFloat("total"), connBD.rs.getFloat("descuento"), connBD.rs.getFloat("precioFinal"), connBD.rs.getLong("cuilMozo"));
        
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return null;
        } finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Verifica si existe una comanda activa para una mesa especifica
    public static Boolean comandaDeMesaActiva(int nroMesa){
        //Sentencia SQL
        String sentencia="SELECT baja FROM Comandas WHERE nroMesa = " + nroMesa + " AND activa = 1";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Devuelve si lo encuentra o no
            return connBD.rs.next();
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return false;
        } finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
}
