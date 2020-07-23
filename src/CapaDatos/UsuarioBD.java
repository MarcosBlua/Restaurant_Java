package CapaDatos;

import CapaNegocio.Persona;
import CapaNegocio.Usuario;
import java.sql.SQLException;
import CapaUsuario.Mensajes;
import java.util.LinkedList;

public class UsuarioBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Verifica si existe un usuario por nombre
    public static Boolean existeNuevoUser(String user){
        //Sentencia SQL
        String sentencia= "SELECT baja FROM Usuarios WHERE usuario = '" + user + "'";
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
    
    //Verifica si existe un usuario por cuil y nombre
    public static Boolean existeModUser(long cuil, String user){
        //Sentencia SQL
        String sentencia= "SELECT baja FROM Usuarios WHERE usuario = '" + user + "' AND cuilPersona != " + cuil;
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
    
    //Verifica si existe un usuario por cuil
    public static Boolean existeCuil(long cuil){
        //Sentencia SQL
        String sentencia= "SELECT baja FROM Usuarios WHERE cuilPersona = " + cuil;
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
    
    //Guarda un usuario
    public static void guardarUsuario(Usuario user){
        //Sentencia SQL
        String sentencia="INSERT INTO Usuarios (usuario, contrasenia, nivel, cuilPersona, baja) VALUES (?, ?, ?, ?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, user.getUser());
            connBD.pps.setString(2, user.getPassword());
            connBD.pps.setInt(3, user.getNivel());
            connBD.pps.setLong(4, user.getCuil());
            
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
    
    //Modifica un usuario
    public static void modificarUsuario(Usuario user){
        //Sentencia SQL
        String sentencia="UPDATE Usuarios SET usuario = ?, contrasenia = ?, nivel = ? , baja = 0 WHERE cuilPersona = ?";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, user.getUser());
            connBD.pps.setString(2, user.getPassword());
            connBD.pps.setInt(3, user.getNivel());
            connBD.pps.setLong(4, user.getCuil());
            
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
    
    //Elimina un usuario
    public static void eliminarUsuario(long cuil){
        //Sentencia SQL
        String sentencia="UPDATE Usuarios SET baja = 1 WHERE cuilPersona = " + cuil + ";" + 
                         "UPDATE Personas SET baja = 1 WHERE cuil = " + cuil;
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
    
    //Carga una TableModel con usuarios activos
    public static void cargarTablaUsuarios(LinkedList<Object[]> users){
        //Sentencia SQL
        String sentencia= "SELECT P.nombre, P.apellido ,P.cuil FROM Personas P INNER JOIN Usuarios U ON P.cuil = U.cuilPersona WHERE P.baja = 0 AND U.baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de un usuario
                users.add(new Object[]{connBD.rs.getString("nombre") + " " + connBD.rs.getString("apellido"), connBD.rs.getLong("cuil")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Trae un usuario completo por cuil
    public static Usuario traerUnUsuario(long cuil, Persona per){
        //Sentencia SQL
        String sentencia= "SELECT * FROM Usuarios WHERE cuilPersona = " + cuil;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejcuta la lectura
            connBD.rs.next();
            
            //Carga los datos de la lectura en un detalle para devolver
            //Usuario(String c_user, String c_pass, int c_nivel, String c_nombre, String c_apellido, String c_direccion, String c_mail, long c_cuil, Date c_nacimiento, boolean baja)
            return new Usuario(connBD.rs.getString("Usuario"), connBD.rs.getString("Contrasenia"), 
                    connBD.rs.getInt("Nivel"), per.getNombre(), per.getApellido(), per.getDireccion(), per.getMail(), per.getCuil(), per.getNacimiento(), connBD.rs.getBoolean("Baja"));
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return null;
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }    
    }
    
    //Trae solo los datos de usuario por cuil
    public static Usuario traerUnUsuarioInterno(long cuil){
        //Sentencia SQL
        String sentencia= "SELECT * FROM Usuarios WHERE cuilPersona = " + cuil;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejcuta la lectura
            connBD.rs.next();
            
            //Carga los datos de la lectura en un detalle para devolver
            //Usuario(String c_user, String c_pass, int c_nivel, String c_nombre, String c_apellido, String c_direccion, String c_mail, long c_cuil, Date c_nacimiento, boolean baja)
            return new Usuario(connBD.rs.getString("Usuario"), connBD.rs.getString("Contrasenia"), connBD.rs.getInt("Nivel"));
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return null;
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }    
    }
    
    //Devuelve un numero de nivel para incio de secion dependiendo de: si no existe = 0, existe y es usuario = 1, existe y es administrador = 2
    public static int iniciaSesion(String user, String pass){
        //Sentencia SQL
        String sentencia= "SELECT nivel FROM Usuarios WHERE usuario = '" + user + "' AND contrasenia = " + pass;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejecuta la lectura
            if(!connBD.rs.next()){
                //Devuelve si la lectura no se hace
                return 0;
            }else{
                //Devuelve lo obtenido de la lectura
                return connBD.rs.getInt("nivel");
            }
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return 0;
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
}
