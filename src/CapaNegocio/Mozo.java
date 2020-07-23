package CapaNegocio;

import CapaDatos.MozoBD;
import CapaDatos.PersonaBD;
import CapaUsuario.Mensajes;
import java.sql.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Mozo extends Persona{
    //Variable
    boolean eraUsuario = false;
    
    //Constructores
    public Mozo(){
        
    }
    
    public Mozo(String c_nombre, String c_apellido, long c_cuil){
        super(c_nombre, c_apellido, c_cuil);
    }
    
    public Mozo(String c_nombre, String c_apellido, String c_direccion, String c_mail, long c_cuil, Date c_nacimiento){
        super(c_nombre, c_apellido, c_cuil, c_direccion, c_mail, c_nacimiento);
            
        if(!this.getError()){
            
            this.existePersonaCargada(c_cuil);
            
            if(this.getError()){
                if(getMensaje().equals("Persona no activa")){
                    if(MozoBD.existe(c_cuil)){
                        setError(true);
                        setMensaje("Mozo no activo");
                    }else{
                        setError(true);
                        setMensaje("Usuario no activo");
                    }
                }                
            }
        }
    }
    
    public Mozo(String c_nombre, String c_apellido, String c_direccion, String c_mail, long c_cuil, Date c_nacimiento, boolean baja){
        super(c_nombre, c_apellido, c_cuil, c_direccion, c_mail, c_nacimiento);
    }
    
    //Funciones
    //Proceso de guardado de un mozo. Devuelve true si el mozo es guardado o hay error, y devuelve false si hay un mozo/usuario que mostrar en la pantalla.
    public boolean guardar(){
        //Si no hay error significa que es una persona nueva a guardar
        if(!getError()){
            //Procede a guardar la persona como mozo
            PersonaBD.guardarPersona(this);
            MozoBD.guardarMozo(this.getCuil());
            return true;
        }else{
            //Si hubo error significa que ya existe la persona en el sistema, dependiendo del tipo tomara una ruta
            switch (getMensaje()) {
                case "Mozo no activo":
                    //Marca variable bandera y trae el mozo
                    eraUsuario = false;
                    cargarPersonaInterno(getCuil());
                    //Pregunta con una ventana de seleccion como se quiere proceder y toma un camino
                    if(Mensajes.msjConfim("Existe un mozo no activo con este cuil. ¿Desea ver esos datos para soobreescribirlos? De ser la respuesta no, se creará un nuevo mozo con los datos ingresados.") == JOptionPane.YES_OPTION){
                        return false;
                    }else{
                        guardarModificacion();
                        return true;
                    }
                case "Usuario no activo":
                    //Marca variable bandera y trae la persona que compone al usuario
                    eraUsuario = true;
                    cargarPersonaInterno(getCuil());
                    //Pregunta con una ventana de seleccion como se quiere proceder y toma un camino
                    if(Mensajes.msjConfim("Existe un usuario no activo con este cuil, ¿Desea ver los datos que habia guardados en el sistema? De ser la respuesta no, se creara un nuevo mozo con los datos ingresados.") == JOptionPane.YES_OPTION){
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
    
    //Pasaje de datos para modificacion del mozo
    public void guardarModificacion(){
        if(!getError()){
            if(eraUsuario){
                //Si era usuario, crea un nuevo mozo y modifica los datos de la persona.
                MozoBD.guardarMozo(this.getCuil());
                PersonaBD.modificarPersona(this);
                
                eraUsuario = false;
            }else{
                //Si era un mozo modifica los datos
                PersonaBD.modificarPersona(this);
                MozoBD.modificarMozo(this.getCuil());
                
                eraUsuario = false;
            }
        }else{
            Mensajes.msjError(getMensaje());
        }
    }
    
    //Pasaje de datos para eliminar mozo
    public static void eliminarMozo(long cuil){
        MozoBD.eliminarMozo(cuil);
        PersonaBD.eliminarPersona(cuil);
    }
    
    //Pasaje de datos para devolver un mozo
    public static Mozo traerUnMozo(long cuil){
        return MozoBD.traerUnMozo(cuil);
    }
    
    //Pasaje de datos para devolver el nombre de un mozo
    public static String nombreMozo(long cuil){
        return MozoBD.nombreMozo(cuil);
    }
    
    //Override de funciones necesarias para el manejo del objeto en un ComboBox
    @Override
    public String toString(){
        return (getNombre() + " " + getApellido());
    }
    
    @Override
    public boolean equals(Object otro){
        return getCuil() == ((Mozo)otro).getCuil();
    }
}
