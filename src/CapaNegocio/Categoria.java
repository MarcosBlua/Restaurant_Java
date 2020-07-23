package CapaNegocio;

import CapaDatos.CategoriaBD;

public class Categoria {
    //Variables de datos
    private String nombre;
    private int idCategoria;
    private boolean baja;
    //Variables de control
    private Boolean error = false;
    private String mensaje;
    
    //Constructores
    public Categoria(){
        
    }
    
    public Categoria(String c_nombre, boolean c_baja){
        //Valida la categoria al crearla
        ValidarCategoria(c_nombre);
        //Define el nombre dependiendo de la validacion
        if(!this.error){
            this.nombre = c_nombre;
            this.baja = c_baja;
        }
    }
    
    public Categoria(int c_id, String c_nombre){
        this.idCategoria = c_id;
        this.nombre = c_nombre;
    }
    
    public Categoria(int c_id, String c_nombre, boolean c_baja){
        this.idCategoria = c_id;
        this.nombre = c_nombre;
        this.baja = c_baja;
    }
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public Boolean getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isBaja() {
        return baja;
    }
    
    //Funciones
    //Valida la categoria con el nombre
    protected void ValidarCategoria(String v_nombre){
        //Si la validacion da positivo genera un error
        if(Validaciones.categoria(v_nombre)){
            this.error = true;
            this.mensaje = "La categoria ya existe";
        }
    }
    
    //Pasaje de datos para guardar categoria
    public void guardarCategoria(){
        //Envia este mismo objeto como parametro para guardar
        CategoriaBD.guardarCategoria(this);
    }
    
    //Pasaje de datos para modificar categoria
    public void modificarCategoria(String c_nombre, boolean c_baja){
        this.error = false;
        //Envia este mismo objeto como parametro para modificar
        if(Validaciones.categoria(c_nombre) && !c_nombre.equals(this.nombre)){
            this.error = true;
            this.mensaje = "La categoria ya existe";
        }else{
            this.nombre = c_nombre;
            this.baja = c_baja;
            
            CategoriaBD.modificarCategoria(this);
        }
    }
    
    //Pasaje de datos para devolver el nombre de una categoria
    public static String nombreCategoria(int idCat){
        return CategoriaBD.nombreCategoria(idCat);
    }
    
    //Pasaje de datos para devolver categoria
    public static Categoria traerUnaCategoria(int id){
        return CategoriaBD.traerUnaCategoria(id);
    }
    
    //Override de funciones necesarias para el manejo del objeto en un ComboBox
    @Override
    public String toString(){
        return getNombre();
    }
    
    @Override
    public boolean equals(Object otro){
        return this.idCategoria == ((Categoria)otro).idCategoria;
    }
}
