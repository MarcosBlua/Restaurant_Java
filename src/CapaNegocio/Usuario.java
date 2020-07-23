package CapaNegocio;

import CapaDatos.PersonaBD;
import CapaDatos.UsuarioBD;
import CapaUsuario.Mensajes;
import java.sql.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Usuario extends Persona{
    //Variables de datos
    private String user;
    private String password;
    private int nivel;
    boolean eraMozo = false;
    
    //Constructores
    public Usuario(){
        
    }
    
    public Usuario(String c_user, String c_pass, int c_nivel){
        this.user = c_user;
        this.password = c_pass;
        this.nivel = c_nivel;
    }
    
    public Usuario(String c_user, String c_pass, int c_nivel, String c_nombre, String c_apellido, String c_direccion, String c_mail, long c_cuil, Date c_nacimiento){
        //Valida si ya existe un usuario con el mismo username
        super(c_nombre, c_apellido, c_cuil, c_direccion, c_mail, c_nacimiento);
        
        if(!getError()){
            if(Validaciones.newUsuario(c_user)){
                setError(true);
                setMensaje("El usuario ya existe. ");
            }else{
                this.user = c_user;
                this.password = c_pass;
                this.nivel = c_nivel;
            
                //Valida si existe una persona guardad con el mismo cuil
                this.existePersonaCargada(c_cuil);
            
                if(this.getError()){
                    //Si existe lo identifica como usuario o mozo
                    if(getMensaje().equals("Persona no activa")){
                        if(UsuarioBD.existeCuil(c_cuil)){
                            setError(true);
                            setMensaje("Usuario no activo");
                        }else{
                            setError(true);
                            setMensaje("Mozo no activo");
                        }
                    }            
                }
            }
        }
    }
    
    public Usuario(String c_user, String c_pass, int c_nivel, String c_nombre, String c_apellido, String c_direccion, String c_mail, long c_cuil, Date c_nacimiento, boolean baja){
        super(c_nombre, c_apellido, c_cuil, c_direccion, c_mail, c_nacimiento);
        
        this.user = c_user;
        this.password = c_pass;
        this.nivel = c_nivel;
    }

    //Getters y setters
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getNivel() {
        return nivel;
    }
    
    //Funciones
    //Proceso de guardado de un usuario. Devuelve true si el usuario es guardado o hay error, y devuelve false si hay un usuario/mozo que mostrar en la pantalla.
    public boolean guardar(){
        //Si no hay error significa que es una persona nueva a guardar
        if(!getError()){
            //Procede a guardar la persona como usuario
            PersonaBD.guardarPersona(this);
            UsuarioBD.guardarUsuario(this);
            return true;
        }else{
            //Si hubo error significa que ya existe la persona en el sistema, dependiendo del tipo tomara una ruta
            switch (getMensaje()) {
                case "Usuario no activo":
                    //Marca variable bandera y trae el usuario
                    eraMozo = false;
                    cargarUsuarioInterno(getCuil());
                    //Pregunta con una ventana de seleccion como se quiere proceder y toma un camino
                    if(Mensajes.msjConfim("Existe un usuario no activo con este cuil. ¿Desea ver esos datos para soobreescribirlos? De ser la respuesta no, se creará un nuevo usuario con los datos ingresados.") == JOptionPane.YES_OPTION){
                        return false;
                    }else{
                        guardarModificacion();
                        return true;
                    }
                case "Mozo no activo":
                    //Marca variable bandera y trae la persona que compone el mozo
                    eraMozo = true;
                    cargarPersonaInterno(getCuil());
                    //Pregunta con una ventana de seleccion como se quiere proceder y toma un camino
                    if(Mensajes.msjConfim("Existe un mozo no activo con este cuil. ¿Desea ver los datos que habia guardados en el sistema? De ser la respuesta no, se creará un nuevo mozo con los datos ingresados.") == JOptionPane.YES_OPTION){
                        return false;
                    }else{
                        guardarModificacion();
                        return true;
                    }
                default:
                    //Si el error es otro solo lo muestra
                    Mensajes.msjError(getMensaje());
                    return true;
            }
        }
    }
    
    //Pasaje de datos para modificacion del usuario
    public void guardarModificacion(){
        //Valida el nombre de usuario
        validarModificacion(eraMozo);
        
        if(!getError()){
            if(eraMozo){
                //Si era mozo, crea un nuevo usuario y modifica los datos de la persona.
                UsuarioBD.guardarUsuario(this);
                PersonaBD.modificarPersona(this);
                UsuarioBD.modificarUsuario(this);

                eraMozo = false;
            }else{
                //Si era un usuario modifica los datos
                PersonaBD.modificarPersona(this);
                UsuarioBD.modificarUsuario(this);
                
                eraMozo = false;
            }
        }else{
            Mensajes.msjError(getMensaje());
        }
    }
    
    //Pasaje de datos para eliminar usuario
    public static void eliminarUsuario(long cuil){
        UsuarioBD.eliminarUsuario(cuil);
        PersonaBD.eliminarPersona(cuil);
    }
    
    //Valida si ya existe un usuario con el mismo username durante una modificacion
    public void validarModificacion(boolean bandMod){
        //'bandMod' determina si es una modificacion o un usuario nuevo
        setError(false);
        if(bandMod){
            //Validacion de nuevo usuario
            if(Validaciones.newUsuario(user)){
                setError(true);
                setMensaje("El usuario ya existe. ");
            }
        }else{
            //Validacion de modificacion de usuario
            if(Validaciones.modUsuario(getCuil(), getUser())){
                setError(true);
                setMensaje("El usuario ya existe. ");
            }
        }
        
    }
    
    //Pasaje de datos para devolver un usuario
    public static Usuario traerUnUsuario(long cuil){
        Persona per = PersonaBD.traerUnaPersona(cuil);
        
        return UsuarioBD.traerUnUsuario(cuil, per);
    }
    
    //Carga los datos de un usuario de BD en este mismo objeto
    private void cargarUsuarioInterno(long cuil){
        Usuario user =  UsuarioBD.traerUnUsuarioInterno(cuil);
        traerUnaPersona(cuil);
        
        this.user = user.getUser();
        this.password = user.getPassword();
        this.nivel = user.getNivel();
    }
    
    //Pasaje de datos para el incio de secion
    public static int incioSecion(String user, String pass){
        return UsuarioBD.iniciaSesion(user, pass);
    }
}
