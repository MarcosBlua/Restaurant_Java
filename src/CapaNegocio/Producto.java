package CapaNegocio;

import CapaDatos.InsumoBD;
import CapaDatos.ProductoBD;
import java.util.LinkedList;

public class Producto {
    //Variables de datos
    private int idProd;
    private String nombre;
    private float precioVenta;
    private int idCategoria;
    private String descProd;
    //Variables de control
    private Boolean error = false;
    private String mensaje;
    
    //Constructores
    public Producto(){
        
    }
    
    public Producto(String c_nombre, String c_desc, int c_idCat, float c_precioVenta){
        this.nombre = c_nombre;
        this.descProd = c_desc;
        this.idCategoria = c_idCat;
        this.precioVenta = c_precioVenta;
    }
    
    public Producto(int c_idProd, String c_nombre, String c_desc, int c_idCat, float c_precioVenta){
        this.idProd = c_idProd;
        this.nombre = c_nombre;
        this.descProd = c_desc;
        this.idCategoria = c_idCat;
        this.precioVenta = c_precioVenta;
    }
    
    //Getters y setters
    public int getIdProd() {
        return idProd;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getDescProd() {
        return descProd;
    }

    public Boolean getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    //Funciones
    //Pasaje de datos para guardar producto, 'componentes' posee todas las composiciones que forman al producto
    public void guardarProducto(LinkedList<Composicion> componentes){
        //Envia este mismo objeto como parametro para guardar
        ProductoBD.guardarProducto(this);
        //Envia uno a uno los componentes del producto para ser guardados
        for(Composicion composicion : componentes){
            ProductoBD.guardarComposicion(composicion.getIdInsumo(), composicion.getCantidad());
        }
    }
    
    //Pasaje de datos para modificar producto
    public void modificarProducto(){
        //Envia este mismo objeto como parametro para guardar
        ProductoBD.modificarProducto(this);
    }
    
    //Pasaje de datos para guardar composicion
    public static void guardarComposicion(Composicion comp){
        ProductoBD.guardarComposicionMod(comp);
    }
    
    //Pasaje de datos para eliminar producto
    public static void eliminarProducto(int idProducto){
        ProductoBD.eliminarProducto(idProducto);
    }
    
    //Pasaje de datos para eliminar composicion
    public static void eliminarComposicion(int idProducto, int idInsumo){
        ProductoBD.eliminarComposicion(idProducto, idInsumo);
    }
    
    //Pasaje de datos para devolver un producto
    public static Producto traerUnProducto(int idProducto){
        return ProductoBD.traerUnProducto(idProducto);
    }
    
    //Verifica si hay suficiente stock de los insumos que conforman un producto, como para vender la cantidad especificada del mismo
    public static boolean hayStock(int idProducto, int cantidad){
        //Variable que devolvera el resultado
        boolean resultado = true;
        //Trae las composiciones del producto necesario
        LinkedList<Composicion> composicion = new LinkedList();
        Productos.traerComposiciones(idProducto, composicion);
        Insumo ins = new Insumo();
        
        //Recorre las composiciones
        for(Composicion comp : composicion){
            //Trae el insumo de la composicion en la que se encuentra
            ins = Insumo.traerUnInsumo(comp.getIdInsumo());
            //Elije un camindo dependiendo del tipo de unidad que utiliza el insumo
            if(ins.getUnidad() == 2){
                //Pregunta si tiene suficiente stock
                if(ins.getStock() < (cantidad * comp.getCantidad())){
                    resultado = false;
                    break;
                }
            }else{
                //Pregunta si tiene suficiente stock
                if(ins.getStock() < (cantidad * comp.getCantidad() / 1000)){
                    resultado = false;
                    break;
                }
            }
        }
        
        //Si hay sufuciente stock devolvera true
        return resultado;
    }
    
    //Disminuye el stock de los insumos usados al vender una cantidad de productos
    public static void usarStock(int idProducto, int cantidad){
        //Trae las composiciones del producto necesario
        LinkedList<Composicion> composicion = new LinkedList();
        Productos.traerComposiciones(idProducto, composicion);
        Insumo ins = new Insumo();     
        
        //Recorre las composiciones
        for(Composicion comp : composicion){   
            //Trae el insumo de la composicion en la que se encuentra
            ins = Insumo.traerUnInsumo(comp.getIdInsumo());
            //Disminuye el stock del insumo por la cantidad requerida
            InsumoBD.actualizarStock(ins.getIdInsumo(), (comp.getCantidad()*cantidad), false);
        }
    }
    
    //Aumenta el stock de los insumos de un producto que sacan de un detalle
    public static void devolverStock(int idProducto, int cantidad){
        //Trae las composiciones del producto necesario
        LinkedList<Composicion> composicion = new LinkedList();
        Productos.traerComposiciones(idProducto, composicion);
        Insumo ins = new Insumo();
        
        //Recorre las composiciones
        for(Composicion comp : composicion){
            //Trae el insumo de la composicion en la que se encuentra
            ins = Insumo.traerUnInsumo(comp.getIdInsumo());
            //Aumenta el stock del insumo por la cantidad requerida
            InsumoBD.actualizarStock(ins.getIdInsumo(), (comp.getCantidad()*cantidad), true);
        }
    }
    
    //Override de funciones necesarias para el manejo del objeto en un ComboBox
    @Override
    public String toString(){
        return getNombre();
    }
    
    @Override
    public boolean equals(Object otro){
        return this.idProd == ((Producto)otro).idProd;
    }
}
