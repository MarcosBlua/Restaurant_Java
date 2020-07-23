package CapaNegocio;

import java.sql.Date;
import CapaDatos.ComandaBD;
import java.util.LinkedList;

public class Comanda {
    //Variables de datos
    private int nroComanda;
    private Date fecha;
    private int nroMesa;
    private Boolean activa;
    private float total;
    private float descuento;
    private float precioFinal;
    private long cuilMozo;
    //Variables de control
    private Boolean error = false;
    private String mensaje;
    
    //Constructores
    public Comanda(){
        
    }
    
    public Comanda(Date c_fecha, int c_nroMesa, long c_cuilMozo){
        this.fecha = c_fecha;
        this.nroMesa = c_nroMesa;
        this.cuilMozo = c_cuilMozo;
    }
    
    public Comanda(int c_nroCom, Date c_fecha, int c_nroMesa, Boolean c_activa, float c_total, float c_descuento, float c_precioFinal, long c_cuilMozo){
        this.nroComanda = c_nroCom;
        this.fecha = c_fecha;
        this.nroMesa = c_nroMesa;
        this.activa = c_activa;
        this.total = c_total;
        this.descuento = c_descuento;
        this.precioFinal = c_precioFinal;
        this.cuilMozo = c_cuilMozo;
    }
    
    //Getters y Setters
    public int getNroComanda() {
        return nroComanda;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNroMesa() {
        return nroMesa;
    }

    public Boolean getActiva() {
        return activa;
    }

    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        //En caso de que se intente introducir un numero negativo como total
        if(total < 0){
            this.error = true;
            this.mensaje += "El total no puede ser un numero menor a cero. ";
        }else{
            this.total = total;
        }
    }

    public float getDescuento() {
        return descuento;
    }
    public void setDescuento(float descuento) {
        //En caso de que se intente introducir un numero negativo como descuento
        if(descuento < 0){
            this.error = true;
            this.mensaje += "El descuento no puede ser un numero menor a cero. ";
        }else{
            this.descuento = descuento;
        }        
    }

    public float getPrecioFinal() {
        return precioFinal;
    }
    public void setPrecioFinal(float precioFinal) {
        //En caso de que se intente introducir un numero negativo como precio final
        if(precioFinal < 0){
            this.error = true;
            this.mensaje += "El precio final no puede ser un numero menor a cero. ";
        }else{
            this.precioFinal = precioFinal;
        }
    }

    public long getCuilMozo() {
        return cuilMozo;
    }

    public Boolean getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    //Funciones
    //Pasaje de datos para guardar comanda
    public void guardarComanda(){
        ComandaBD.guardarComanda(this);
    }
    
    //Pasaje de datos para modificar comanda
    public void modificarComanda(int nroMesa, long culMozo){
        this.nroMesa = nroMesa;
        this.cuilMozo = cuilMozo;
        
        ComandaBD.modificarComanda(this);
    }
    
    //Pasaje de datos para eliminar comanda
    public static void eliminarComanda(int nroComanda){
        ComandaBD.eliminarComanda(nroComanda);
    }
    
    //Pasaje de datos para cerrar comanda
    public void cerrarComanda(){
        ComandaBD.cerrarComanda(this.nroComanda, this.total, this.descuento, this.precioFinal);
    }
    
    //Pasaje de datos para devolver una comanda
    public static Comanda traerComanda(int nroComanda){
        return ComandaBD.traerUnaComanda(nroComanda);
    }
}
