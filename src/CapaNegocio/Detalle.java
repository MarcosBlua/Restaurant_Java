package CapaNegocio;

import CapaDatos.DetalleBD;
import java.util.LinkedList;

public class Detalle {
    //Variables de datos
    private int nroComanda;
    private int nroDetalle;
    private int idProducto;
    private String nombreProducto;
    private int cantidad;
    private float precioUnitario;
    //Variables de control
    private Boolean error = false;
    private String mensaje;
    
    //Constructores
    public Detalle(){
        
    }
    
    public Detalle(int c_nroCom, int c_idProd, String c_nombProd, int c_cant, float c_precioUni){
        this.nroComanda = c_nroCom;
        this.idProducto = c_idProd;
        this.nombreProducto = c_nombProd;
        this.cantidad = c_cant;
        this.precioUnitario = c_precioUni;
    }
    
    public Detalle(int c_nroDetal, int c_nroCom, int c_idProd, String c_nombProd, int c_cant, float c_precioUni){
        this.nroDetalle = c_nroDetal;
        this.nroComanda = c_nroCom;
        this.idProducto = c_idProd;
        this.nombreProducto = c_nombProd;
        this.cantidad = c_cant;
        this.precioUnitario = c_precioUni;
    }
    
    //Getters y setters
    public int getNroComanda() {
        return nroComanda;
    }

    public int getNroDetalle() {
        return nroDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public Boolean getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    //Funciones
    //Pasaje de datos para guardar detalle
    public void guardarDetalle(){
        //Envia este mismo objeto como parametro para guardar
        DetalleBD.guardarDetalle(this);
        //Reduce el stock del producto usado en el detalle
        Producto.usarStock(getIdProducto(), getCantidad());
    }
    
    //Pasaje de datos para modificar detalle
    public void modificarDetalle(){
        //Crea y cargar un objeto detalle
        Detalle detal = new Detalle();
        detal = traerUnDetalle(getNroDetalle());
        
        //Agrega o disminuye stock del producto que caso de que la cantidad del producto en el detalle cambie
        if(detal.getCantidad() > this.getCantidad()){
            Producto.devolverStock(detal.getIdProducto(), (detal.getCantidad() - this.getCantidad()));
        }else if(detal.getCantidad() < this.getCantidad()){
            Producto.usarStock(detal.getIdProducto(), (this.getCantidad() - detal.getCantidad()));
        }      
        
        //Envia este mismo objeto como parametro para modificar
        DetalleBD.modificarDetalle(this);
    }
    
    //Pasaje de datos para eliminar detalle
    public static void eliminarDetalle(int nroDetalle){
        DetalleBD.eliminarDetalle(nroDetalle);
        
        //Devuelve el stock que era usado por el detalle
        Detalle detal = new Detalle();
        detal = traerUnDetalle(nroDetalle);
        
        Producto.devolverStock(detal.getNroDetalle(), detal.getCantidad());
    }
    
    //Pasaje de datos para devolver un detalle
    public static Detalle traerUnDetalle(int nroDetalle){
        return DetalleBD.traerUnDetalle(nroDetalle);
    }
}
