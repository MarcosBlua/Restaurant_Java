package CapaDatos;

import CapaNegocio.Persona;
import java.sql.SQLException;
import CapaUsuario.Mensajes;

public class PersonaBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Verifica si una persona existe segun su cuil
    public static Boolean existe(long cuil){
        //Sentencia SQL
        String sentencia= "SELECT Baja FROM Personas WHERE Cuil = " + cuil;
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
    
    //Verifica si una persona esta activa segun su cuil
    public static Boolean personaActiva(long cuil){
        //Sentencia SQL
        String sentencia= "SELECT Cuil FROM Personas WHERE Cuil = " + cuil + " AND Baja = 0;";
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
    
    //Guarda una persona
    public static void guardarPersona(Persona pers){
        //Sentencia SQL
        String sentencia="INSERT INTO Personas (Cuil, Nombre, Apellido, Mail, FechaNacimiento, Direccion, Baja) values (?, ?, ?, ?, ?, ?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setLong(1, pers.getCuil());
            connBD.pps.setString(2, pers.getNombre());
            connBD.pps.setString(3, pers.getApellido());
            connBD.pps.setString(4, pers.getMail());
            connBD.pps.setDate(5, pers.getNacimiento());
            connBD.pps.setString(6, pers.getDireccion());
            
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
    
    //Modifica una persona
    public static void modificarPersona(Persona pers){
        //Sentencia SQL
        String sentencia="UPDATE Personas SET Nombre = ?, Apellido = ?, Mail = ?, FechaNacimiento = ?, Direccion = ?, Baja = 0 WHERE Cuil = ?;";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, pers.getNombre());
            connBD.pps.setString(2, pers.getApellido());
            connBD.pps.setString(3, pers.getMail());
            connBD.pps.setDate(4, pers.getNacimiento());
            connBD.pps.setString(5, pers.getDireccion());
            connBD.pps.setLong(6, pers.getCuil());
            
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
    
    //Elimina una persona
    public static void eliminarPersona(long cuil){
        //Sentencia SQL
        String sentencia="UPDATE Personas SET Baja = 1 WHERE Cuil = " + cuil;
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
    
    //Trae una persona por cuil
    public static Persona traerUnaPersona(long cuil){
        //Sentencia SQL
        String sentencia= "SELECT * FROM personas WHERE cuil = " + cuil;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejcuta la lectura
            connBD.rs.next();
            
            //Carga los datos de la lectura en un detalle para devolver
            return new Persona(connBD.rs.getString("Nombre"), connBD.rs.getString("Apellido"), connBD.rs.getLong("Cuil"), connBD.rs.getString("Direccion"), connBD.rs.getString("Mail"), connBD.rs.getDate("FechaNacimiento"));
                        
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
