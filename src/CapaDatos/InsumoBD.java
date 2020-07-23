package CapaDatos;

import CapaNegocio.Categoria;
import CapaNegocio.Insumo;
import java.sql.SQLException;
import CapaUsuario.Mensajes;
import java.util.LinkedList;

public class InsumoBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Verifica si existe un insumo por nombre, funcion para nuevos insumos
    public static Boolean existeNombre(String nombre){
        //Sentencia SQL
        String sentencia= "SELECT Baja FROM Insumos WHERE Nombre = '" + nombre + "'";
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
    
    //Verifica si existe un insumo por nombre, funcion para insumos modificados
    public static Boolean existeNombreMod(int idIns, String nombre){
        //Sentencia SQL
        String sentencia= "SELECT Baja FROM Insumos WHERE Nombre = '" + nombre + "' AND IdInsumo != " + idIns;
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
    
    //Guarda un insumo
    public static void guardarInsumo(Insumo insum){
        //Sentencia SQL
        String sentencia="INSERT INTO Insumos (nombre, idcategoria, descripcion, costo, stock, unidad, baja) values (?, ?, ?, ?, ?, ?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, insum.getNombre());
            connBD.pps.setInt(2, insum.getIdCategoria());
            connBD.pps.setString(3, insum.getDescripcion());
            connBD.pps.setFloat(4, insum.getCosto());
            connBD.pps.setFloat(5, insum.getStock());
            connBD.pps.setInt(6, insum.getUnidad());
            
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
    
    //Verifica el estado de un insumo
    public static Boolean insumoActivo(int idInsumo){
        //Sentencia SQL
        String sentencia= "SELECT Baja FROM Insumos WHERE idinsumo = " + idInsumo;
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
    
    //Modifica un insumo
    public static void modificarInsumo(Insumo insum){
        //Sentencia SQL
        String sentencia="UPDATE Insumos SET nombre = ?, idcategoria = ?, descripcion = ?, costo = ?, stock = ?, unidad = ?, baja = 0 WHERE idinsumo = ?";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, insum.getNombre());
            connBD.pps.setInt(2, insum.getIdCategoria());
            connBD.pps.setString(3, insum.getDescripcion());
            connBD.pps.setFloat(4, insum.getCosto());
            connBD.pps.setFloat(5, insum.getStock());
            connBD.pps.setInt(6, insum.getUnidad());
            connBD.pps.setInt(7, insum.getIdInsumo());
            
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
    
    //Elimina un insumo
    public static void eliminarInsumo(int idInsumo){
        //Sentencia SQL
        String sentencia="DELETE FROM Insumos WHERE idinsumo = " + idInsumo;
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
    
    //Carga un ComboBoxModel con insumos activos
    public static void cargarCBXInsumos(LinkedList<Insumo> insumos){
        //Sentencia SQL
        String sentencia= "SELECT * FROM Insumos WHERE baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
                     
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){  
                //Crea y carga un objeto
                Insumo ins = new Insumo(connBD.rs.getInt("IdInsumo"), connBD.rs.getString("Nombre"), connBD.rs.getInt("IdCategoria"), connBD.rs.getString("Descripcion"), connBD.rs.getFloat("Costo"), connBD.rs.getFloat("Stock"), connBD.rs.getInt("Unidad"), connBD.rs.getBoolean("Baja"));
                
                //Carga el objeto al ComboBoxModel
                insumos.add(ins);
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga una TableModel con insumos activos
    public static void cargarTablaInsumos(LinkedList<Object[]> insumos){
        //Sentencia SQL
        String sentencia= "SELECT * FROM Insumos WHERE baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de un insumo
                insumos.add(new Object[]{connBD.rs.getInt("idInsumo"), connBD.rs.getString("nombre"), connBD.rs.getString("descripcion"), Categoria.nombreCategoria(connBD.rs.getInt("idcategoria")), connBD.rs.getFloat("costo")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga uns TableModel con insumos y su stock
    public static void cargarTablaStocks(LinkedList<Object[]> insumos){
        //Sentencia SQL
        String sentencia= "SELECT idInsumo, nombre, stock FROM Insumos WHERE baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de un insumo
                insumos.add(new Object[]{connBD.rs.getInt("idInsumo"), connBD.rs.getString("nombre"), connBD.rs.getFloat("stock")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Trae un insumo por id
    public static Insumo traerUnInsumo(int idInsumo){
        //Sentencia SQL
        String sentencia= "SELECT * FROM Insumos WHERE idinsumo = " + idInsumo;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejcuta la lectura
            connBD.rs.next();
            
            //Carga los datos de la lectura en un detalle para devolver
            return new Insumo(connBD.rs.getInt("IdInsumo"), connBD.rs.getString("Nombre"), connBD.rs.getInt("IdCategoria"), connBD.rs.getString("Descripcion"), connBD.rs.getFloat("Costo"), connBD.rs.getFloat("Stock"), connBD.rs.getInt("Unidad"), connBD.rs.getBoolean("Baja"));
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return null;
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Funcion para actualizar el stock de un insumo, agregar o quitar dependiendo de la variable 'suma'
    public static void actualizarStock(int idInsumo, float cant, Boolean suma){
        //Se usa una de las sentencias segun lo requerido
        String sentencia;
        if(suma){
            //Sentencia para agregar stock
            sentencia = "UPDATE Insumos SET stock = stock + ? WHERE idinsumo = ?";
        }else{
            //Sentencia para quitar stock
            sentencia = "UPDATE Insumos SET stock = stock - ? WHERE idinsumo = ?";
        }        
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setFloat(1, cant);
            connBD.pps.setInt(2, idInsumo);
            
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
    
    //Devuelve el nombre de un insumo por su id
    public static String nombreInsumo(int idIns){
        //Sentencia SQL
        String sentencia= "SELECT Nombre FROM Insumos WHERE IdInsumo = " + idIns;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejecuta la lectura
            connBD.rs.next();
            
            //Devuelve lo obtenido de la lectura
            return connBD.rs.getString("Nombre");
                        
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return "";
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
}
