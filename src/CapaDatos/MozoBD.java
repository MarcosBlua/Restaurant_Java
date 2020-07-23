package CapaDatos;

import CapaNegocio.Mozo;
import java.sql.SQLException;
import CapaUsuario.Mensajes;
import java.util.LinkedList;

public class MozoBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Verifica si existe un mozo por cuil
    public static Boolean existe(long cuil){
        //Sentencia SQL
        String sentencia= "SELECT baja FROM Mozos WHERE cuilMozo =  " + cuil;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Devuelve el resultado de leer
            return connBD.rs.next();          
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return false;
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Guarda un mozo
    public static void guardarMozo(long cuilMozo){
        //Sentencia SQL
        String sentencia="INSERT INTO Mozos (cuilMozo, baja) values (?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setLong(1, cuilMozo);
            
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
    
    //Modifica un mozo
    public static void modificarMozo(long cuilMozo){
        //Sentencia SQL
        String sentencia="UPDATE Mozos SET baja = 0 WHERE cuilMozo = ?";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setLong(1, cuilMozo);
            
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
    
    //Elimina un mozo
    public static void eliminarMozo(long cuilMozo){
        //Sentencia SQL
        String sentencia="UPDATE Mozos SET baja = 1 WHERE cuilMozo = " + cuilMozo + ";" + 
                        "UPDATE Personas SET baja = 1 WHERE cuil = " + cuilMozo;
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
    
    //Carga un ComboBoxModel con mozos activos
    public static void cargarCBXMozos(LinkedList<Mozo> mozos){
        //Sentencia SQL
        String sentencia= "SELECT P.nombre, P.apellido, P.cuil FROM Personas P INNER JOIN Mozos M ON  P.cuil=M.cuilMozo WHERE P.baja = 0 and M.baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando            
            while(connBD.rs.next()){
                //Crea y carga un objeto
                Mozo moz = new Mozo(connBD.rs.getString("nombre"), connBD.rs.getString("apellido"), connBD.rs.getLong("cuil"));
                
                //Carga el objeto al ComboBoxModel
                mozos.add(moz);
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga una TableModel con mozos activos
    public static void cargarTablaMozos(LinkedList<Object[]> mozos){
        //Sentencia SQL
        String sentencia= "SELECT P.nombre, P.apellido, P.cuil FROM Personas P INNER JOIN Mozos M ON  P.cuil=M.cuilMozo WHERE P.baja = 0 and M.baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de un mozo
                mozos.add(new Object[]{connBD.rs.getString("nombre") + " " + connBD.rs.getString("apellido"), connBD.rs.getLong("cuil")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Devuelve el nombre de un mozo por su cuil
    public static String nombreMozo(long cuil){
        //Sentencia SQL
        String sentencia= "SELECT CONCAT(nombre,' ', apellido) as nya FROM Personas WHERE cuil = " + cuil;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejecuta la lectura
            connBD.rs.next();
            
            //Devuelve lo obtenido de la lectura
            return connBD.rs.getString("nya");
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return "";
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Trae un mozo por cuil
    public static Mozo traerUnMozo(long cuil){
        //Sentencia SQL
        String sentencia= "SELECT * FROM personas WHERE cuil = " + cuil;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejcuta la lectura
            connBD.rs.next();
            
            //Carga los datos de la lectura en un detalle para devolver
            return new Mozo(connBD.rs.getString("Nombre"), connBD.rs.getString("Apellido"), connBD.rs.getString("Direccion"), connBD.rs.getString("Mail"), connBD.rs.getLong("Cuil"), connBD.rs.getDate("FechaNacimiento"), connBD.rs.getBoolean("Baja"));
                        
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
