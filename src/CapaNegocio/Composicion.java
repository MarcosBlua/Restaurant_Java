package CapaNegocio;

public class Composicion {
    //Variables de datos
    private int idProducto;
    private int idInsumo;
    private int cantidad;
    private String nombreIns;
    
    //Constructor
    public Composicion(){
        
    }
    
    public Composicion(int c_idIns, String c_nombreIns, int c_cantidad){
        this.idInsumo = c_idIns;
        this.nombreIns = c_nombreIns;
        this.cantidad = c_cantidad;
    }
    
    public Composicion(int c_idProd, int c_idIns, String c_nombreIns, int c_cantidad){
        this.idProducto = c_idProd;
        this.idInsumo = c_idIns;
        this.nombreIns = c_nombreIns;
        this.cantidad = c_cantidad;
    }

    //Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombreIns() {
        return nombreIns;
    }
    
    
}
