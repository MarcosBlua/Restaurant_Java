package CapaNegocio;

import CapaDatos.InsumoBD;
import java.util.LinkedList;

public class Insumo {
    //Variables de datos
    private int idInsumo;
    private String nombre;
    private int idCategoria;
    private String descripcion;
    private float costo;
    private float stock;
    private int unidad;
    //Variables de control
    private Boolean error = false;
    private String mensaje;
    
    //Constructores
    public Insumo(){
        
    }
    
    //Constructor usado al crear nuevos insumos
    public Insumo(String c_nombre, int c_idCat, String c_desc, float c_costo, float c_stock, int c_unidad){
        //Carga los datos dependiendo de la validacion
        if(!validarNuevo(c_nombre)){
            this.nombre = c_nombre;
            this.idCategoria = c_idCat;
            this.descripcion = c_desc;
            this.costo = c_costo;
            this.stock = c_stock;
            this.unidad = c_unidad;
        }
    }
    
    //Constructor usado al modificar un insumo
    public Insumo(int c_idInsumo, String c_nombre, int c_idCat, String c_desc, float c_costo, float c_stock, int c_unidad){
        //Carga los datos dependiendo de la validacion
        if(!validarMod(c_idInsumo, c_nombre)){
            this.idInsumo = c_idInsumo;
            this.nombre = c_nombre;
            this.idCategoria = c_idCat;
            this.descripcion = c_desc;
            this.costo = c_costo;
            this.stock = c_stock;
            this.unidad = c_unidad;
        }
    }
    
    //Constructor usado para cargar un insumo desde la base de datos
    public Insumo(int c_idInsumo, String c_nombre, int c_idCat, String c_desc, float c_costo, float c_stock, int c_unidad, boolean baja){
        this.idInsumo = c_idInsumo;
        this.nombre = c_nombre;
        this.idCategoria = c_idCat;
        this.descripcion = c_desc;
        this.costo = c_costo;
        this.stock = c_stock;
        this.unidad = c_unidad;
    }
    
    //Getters y setters
    public int getIdInsumo() {
        return idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public float getStock() {
        return stock;
    }
    public void setStock(float stock) {
        if(stock < 0){
            this.error = true;
            this.mensaje = "El stock no puede ser menor a 0";
        }else{
            this.stock = stock;
        }        
    }

    public int getUnidad() {
        return unidad;
    }
    
    public Boolean getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    //Funciones
    //Valida un nuevo insumo
    public boolean validarNuevo(String nombre){
        if(Validaciones.newInsumo(nombre)){
            this.error = true;
            this.mensaje = "Ya existe un insumo con este nombre. ";
        }else{
            this.error = false;
        }
        return error;
    }
    
    //Valida un insumo modificado
    public boolean validarMod(int idIns, String nombre){
        if(Validaciones.modInsumo(idIns, nombre)){
            this.error = true;
            this.mensaje = "Ya existe un insumo con este nombre. ";
        }else{
            this.error = false;
        }
        return error;
    }
    
    //Pasaje de datos para guardar insumo
    public void guardarInsumo(){
        //Envia este mismo objeto como parametro para guardar
        InsumoBD.guardarInsumo(this);
    }
    
    //Pasaje de datos para modificar insumo
    public void modificarInsumo(){
        //Envia este mismo objeto como parametro para modificar
        InsumoBD.modificarInsumo(this);
    }
    
    //Pasaje de datos para eliminar insumo
    public static void eliminarInsumo(int idInsumo){
        InsumoBD.eliminarInsumo(idInsumo);
    }
    
    //Pasaje de datos para devolver un insumo
    public static Insumo traerUnInsumo(int idInsumo){
        return InsumoBD.traerUnInsumo(idInsumo);
    }
    
    //Pasaje de datos para actualizar el stock de un insumo
    public static void actualizarStock(int idInsumo, float cantidad, Boolean suma){
        InsumoBD.actualizarStock(idInsumo, cantidad, suma);
    }
    
    //Override de funciones necesarias para el manejo del objeto en un ComboBox
    @Override
    public String toString(){
        return getNombre();
    }
}
