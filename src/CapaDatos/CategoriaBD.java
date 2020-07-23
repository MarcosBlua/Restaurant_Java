package CapaDatos;

import CapaNegocio.Categoria;
import java.sql.SQLException;
import CapaUsuario.Mensajes;
import java.util.LinkedList;

public class CategoriaBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Verifica si una categoria ya existe con el nombre dado
    public static Boolean existe(String nombre){
        //Sentencia SQL
        String sentencia= "SELECT Baja FROM Categorias WHERE Nombre = '" + nombre + "'";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD = new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Si lee es porque existe por lo que devuelve true
            if(connBD.rs.next()){
                return true;
            }
            return false;
                        
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return false;
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Guarda una categoria
    public static void guardarCategoria(Categoria cat){
        //Sentencia SQL
        String sentencia="INSERT INTO Categorias (Nombre, Baja) values (?, ?)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, cat.getNombre());
            connBD.pps.setBoolean(2, cat.isBaja());
            
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
    
    //Modifica una categoria
    public static void modificarCategoria(Categoria cat){
        //Sentencia SQL
        String sentencia="UPDATE Categorias SET Nombre = ?, Baja = ? WHERE IdCategoria = ?";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, cat.getNombre());
            connBD.pps.setBoolean(2, cat.isBaja());
            connBD.pps.setInt(3, cat.getIdCategoria());
            
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
    
    //Trae una categoria por el id
    public static Categoria traerUnaCategoria(int idCat){
        //Sentencia SQL
        String sentencia= "SELECT * FROM Categorias WHERE IdCategoria = " + idCat;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Ejecuta la lectura
            connBD.rs.next();
            //Carga lo leido en un obejto para devolver
            return new Categoria(connBD.rs.getInt("IdCategoria"), connBD.rs.getString("Nombre"), connBD.rs.getBoolean("Baja"));
                        
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return null;
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Trae el nombre de una categoria por el id
    public static String nombreCategoria(int idCat){
        //Sentencia SQL
        String sentencia= "SELECT nombre FROM Categorias WHERE IdCategoria = " + idCat;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Ejecuta la lectura
            connBD.rs.next();
            //Devuelve el nombre
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
    
    //Carga un ComboBoxModel con categorias activas
    public static void cargarCBXCategoria(LinkedList<Categoria> listaDeCategorias){
        //Sentencia SQL
        String sentencia= "SELECT idCategoria, nombre FROM Categorias WHERE baja = 1";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
                        
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){  
                //Crea y carga un objeto
                Categoria cat = new Categoria(connBD.rs.getInt("IdCategoria"), connBD.rs.getString("Nombre"));
                
                //Carga el objeto al ComboBoxModel
                listaDeCategorias.add(cat);
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga una TableModel con todas las categorias
    public static void cargarTablaCategoria(LinkedList<Object[]> todasCategorias){
        //Sentencia SQL
        String sentencia= "SELECT idCategoria, nombre, baja FROM Categorias";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            String activa;
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Pasa un dato bool a texto para poder mostrar
                if(connBD.rs.getBoolean("Baja")){
                    activa = "Si";
                }else{
                    activa = "No";
                }
                //Agrega a la tabla una fila con la informacion de una categoria
                todasCategorias.add(new Object[]{connBD.rs.getInt("IdCategoria"), connBD.rs.getString("Nombre"), activa});
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
