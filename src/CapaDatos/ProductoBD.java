package CapaDatos;

import CapaNegocio.Categoria;
import CapaNegocio.Composicion;
import CapaNegocio.Producto;
import java.sql.SQLException;
import CapaUsuario.Mensajes;
import java.util.LinkedList;

public class ProductoBD {
    //Variables usadas para la conexion a SQL
    static Conexion connBD;
    
    //Verifica si existe un producto por id
    public static Boolean existeProducto(int idProducto){
        //Sentencia SQL
        String sentencia= "SELECT Baja FROM Productos WHERE isproducto = " + idProducto;
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
    
    //Guarda un producto
    public static void guardarProducto(Producto prod){
        //Sentencia SQL
        String sentencia="INSERT INTO Productos (nombre, precioventa, idcategoria, descripcion, baja) values (?, ?, ?, ?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, prod.getNombre());
            connBD.pps.setFloat(2, prod.getPrecioVenta());
            connBD.pps.setInt(3, prod.getIdCategoria());
            connBD.pps.setString(4, prod.getDescProd());
            
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
    
    //Modifica un producto
    public static void modificarProducto(Producto prod){
        //Sentencia SQL
        String sentencia="UPDATE Productos SET nombre = ?, precioVenta = ?, idCategoria = ?, descripcion = ?,  baja = 0 WHERE idproducto = '" + prod.getIdProd() + "'";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setString(1, prod.getNombre());
            connBD.pps.setFloat(2, prod.getPrecioVenta());
            connBD.pps.setInt(3, prod.getIdCategoria());
            connBD.pps.setString(4, prod.getDescProd());
            
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
    
    //Guarda una composicion de producto
    public static void guardarComposicion(int idInsumo, int cantidad){
        //Sentencia SQL
        String sentencia="INSERT INTO Composicion (idproducto, idinsumo, cantidad, baja) values ((SELECT TOP 1 idproducto FROM Productos WHERE baja = 0 ORDER BY idproducto DESC), ?, ?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setInt(1, idInsumo);
            connBD.pps.setInt(2, cantidad);
            
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
    
    //Modifica una composicion de producto
    public static void guardarComposicionMod(Composicion comp){
        //Sentencia SQL
        String sentencia="INSERT INTO Composicion (idproducto, idinsumo, cantidad, baja) values (?, ?, ?, 0)";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setInt(1, comp.getIdProducto());
            connBD.pps.setInt(2, comp.getIdInsumo());
            connBD.pps.setInt(3, comp.getCantidad());
            
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
    
    //Elimina un producto
    public static void eliminarProducto(int idProducto){
        //Sentencia SQL
        String sentencia="DELETE FROM Productos WHERE idproducto = " + idProducto + "; DELETE FROM Composicion WHERE idproducto = " + idProducto;
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
    
    //Elimina una composicion de producto
    public static void eliminarComposicion(int idProducto, int idInsumo){
        //Sentencia SQL
        String sentencia="DELETE FROM Composicion WHERE idproducto = ? AND idinsumo = ?";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirEscritura(sentencia);
            
            //Se cargan los datos de las variables a la sentencia
            connBD.pps.setInt(1, idProducto);
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
    
    //Trae un producto por id
    public static Producto traerUnProducto(int idProducto){
        //Sentencia SQL
        String sentencia="SELECT idproducto, nombre, precioventa, idcategoria, descripcion FROM Productos WHERE idproducto = " + idProducto;
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Se ejcuta la lectura
            connBD.rs.next();
            
            //Carga los datos de la lectura en un detalle para devolver
            return new Producto(connBD.rs.getInt("idproducto"), connBD.rs.getString("nombre"), connBD.rs.getString("descripcion"), connBD.rs.getInt("idcategoria"), connBD.rs.getFloat("precioventa"));
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
            return null;
        } finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga un ComboBoxModel con productos activos
    public static void cargarCBXProductos(LinkedList<Producto> productos){
        //Sentencia SQL
        String sentencia= "SELECT IdProducto, Nombre, Descripcion, PrecioVenta, IdCategoria FROM Productos WHERE Baja=0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){  
                //Crea y carga un objeto
                Producto producto = new Producto(connBD.rs.getInt("IdProducto"), connBD.rs.getString("Nombre"), connBD.rs.getString("Descripcion"), connBD.rs.getInt("IdCategoria"), connBD.rs.getFloat("PrecioVenta"));
                
                //Carga el objeto al ComboBoxModel
                productos.add(producto);
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga una TableModel con productos activos
    public static void cargarTablaProductos(LinkedList<Object[]> productos){
        //Sentencia SQL
        String sentencia= "SELECT IdProducto, Nombre, Descripcion, PrecioVenta, IdCategoria FROM Productos WHERE Baja=0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de un producto
                productos.add(new Object[]{connBD.rs.getInt("IdProducto"), connBD.rs.getString("Nombre"), connBD.rs.getString("Descripcion"), Categoria.nombreCategoria(connBD.rs.getInt("IdCategoria")), connBD.rs.getFloat("PrecioVenta")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga una TableModel con composiciones de un producto
    public static void cargarTablaComposiciones(int idProducto, LinkedList<Object[]> composiciones){
        //Sentencia SQL
        String sentencia= "SELECT C.idInsumo, I.nombre, C.cantidad FROM Insumos I INNER JOIN Composicion C ON I.idInsumo = C.idInsumo WHERE C.idProducto = " + idProducto + " and C.baja = 0 and I.baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Agrega a la tabla una fila con la informacion de una composicion
                composiciones.add(new Object[]{connBD.rs.getInt("idInsumo"), connBD.rs.getString("Nombre"), connBD.rs.getInt("Cantidad")});
            }
            
        } catch (SQLException ex) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError(ex.getMessage());
        }finally{
            //Finaliza cerrando la conexion
            connBD.desconectar();
        }
    }
    
    //Carga un LinkedList con composiciones de un producto
    public static void traerComposiciones(int idProducto, LinkedList<Composicion> composiciones){
        //Sentencia SQL
        String sentencia= "SELECT C.idInsumo, I.nombre, C.cantidad FROM Insumos I INNER JOIN Composicion C ON I.idInsumo = C.idInsumo WHERE C.idProducto = " + idProducto + " and C.baja = 0 and I.baja = 0";
        try {
            //Comienza la conexion y settea la sentencia a usar
            connBD= new Conexion();
            connBD.abrirLectura(sentencia);
            
            //Mientras lee y encuentra coincidencias sigue iterando
            while(connBD.rs.next()){
                //Crea y carga un objeto
                Composicion composicion = new Composicion(idProducto, connBD.rs.getInt("IdInsumo"), connBD.rs.getString("Nombre"), connBD.rs.getInt("Cantidad"));
                
                //Carga el objeto al LinkedList
                composiciones.add(composicion);
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
