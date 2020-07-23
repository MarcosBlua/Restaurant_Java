package CapaNegocio;

import java.sql.Date;
import CapaDatos.PersonaBD;

public class Persona {
    //Variables de datos
    private String nombre;
    private String apellido;
    private long cuil;
    private String direccion;
    private String mail;
    private Date nacimiento;
    //Variables de control
    private Boolean error = false;
    private String mensaje;
    
    //Constructores
    public Persona(){
        
    }
    
    public Persona(String c_nombre, String c_apellido, long c_cuil){
        this.nombre = c_nombre;
        this.apellido = c_apellido;
        this.cuil = c_cuil;
    }
    
    public Persona(String c_nombre, String c_apellido, long c_cuil, String c_direccion, String c_mail, Date c_nacimiento){
        validar(c_nombre, c_apellido, c_cuil, c_direccion, c_mail);
        if(!this.error){
            this.nombre = c_nombre;
            this.apellido = c_apellido;
            this.cuil = c_cuil;
            this.direccion = c_direccion;
            this.mail = c_mail;
            this.nacimiento = c_nacimiento;
        }
    }
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getCuil() {
        return cuil;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMail() {
        return mail;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public Boolean getError() {
        return error;
    }
    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //Funciones
    //Valida los datos almacenados en persona
    public void validar(String nombre, String apellido, long cuil, String direccion, String mail){
        if(!Validaciones.nombre(nombre)){
            this.error = true;
            this.mensaje += "el nombre contiene caracteres raros. ";
        }if(!Validaciones.apellido(apellido)){
            this.error = true;
            this.mensaje += "el apellido contiene caracteres raros. ";
        }if(!Validaciones.cuil(cuil)){
            this.error = true;
            this.mensaje += "el cuil contiene caracteres raros. ";
        }if(!Validaciones.direccion(direccion)){
            this.error = true;
            this.mensaje += "la dirección contiene caracteres raros. ";
        }if(!Validaciones.mail(mail)){
            this.error = true;
            this.mensaje += "el mail contiene caracteres raros. ";
        }
    }
    
    //Verifica si ya existe una persona guardada con un cuil especifico
    public void existePersonaCargada(long pcuil){
        if(PersonaBD.existe(pcuil)){
            this.error = true;
            //Si existe una pesona con el cuil, pregunta si la persona esta activa o no
            if(!PersonaBD.personaActiva(pcuil)){
                this.mensaje = "Persona no activa";
            }else{
                this.mensaje = "Ya existe una persona cargada en el sistema con ese nro de Cuil.";
            }
        }
    }
    
    //Pasaje de datos para devolver una persona
    public static Persona traerUnaPersona(long cuil){
        return PersonaBD.traerUnaPersona(cuil);
    }
    
    //Carga los datos de una persona de BD en este mismo objeto
    protected void cargarPersonaInterno(long cuil){
        Persona p = PersonaBD.traerUnaPersona(cuil);
        
        this.nombre = p.getNombre();
        this.apellido = p.getApellido();
        this.cuil = p.getCuil();
        this.direccion = p.getDireccion();
        this.mail = p.getMail();
        this.nacimiento = p.getNacimiento();
    }
}
