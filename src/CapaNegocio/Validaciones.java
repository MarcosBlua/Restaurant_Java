package CapaNegocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    //Validacion de un nombre
    public static boolean nombre (String n){
        Pattern pat_nombre= Pattern.compile("([A-Za-z,ñ,á,é,í,ó,ú]{1,})");
        Matcher m= pat_nombre.matcher(n);
        return m.find();
    }
    
    //Validacion de un apellido
    public static boolean apellido (String n){
        Pattern pat_nombre= Pattern.compile("([A-Za-z,ñ,á,é,í,ó,ú]{1,})");
        Matcher m= pat_nombre.matcher(n);
        return m.find();
    }
    
    //Validacion de una direccion
    public static boolean direccion (String n){
        Pattern pat_nombre= Pattern.compile("(^.*\\s\\d*$)");
        Matcher m= pat_nombre.matcher(n);
        return m.matches();
    }
    
    //Validacion de un mail
    public static boolean mail (String email){
        Pattern pat_nombre= Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher m= pat_nombre.matcher(email);
        return m.find();
    }
    
    //Validacion de un cuil
    public static boolean cuil (long cuil){
        Pattern pat_nombre= Pattern.compile("^(20|23|24|27|30|33|34)\\d{8}(0|1|2|3|4|5|6|7|8|9)$");
        Matcher m= pat_nombre.matcher(cuil+"");
        if (m.find()) {
            
            String cuit = cuil+"";
            char[] cuitArray = cuit.toCharArray();
            int[] serie = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
            long aux = 0;
            
            for (int i = 0 ; i < serie.length ; i++){
                aux += Character.getNumericValue(cuitArray[i]) * serie[i];
            }
            
            aux = 11 - (aux % 11);
            
            if (aux == 11)
            {
                aux = 0;
            }
            
            return aux == Character.getNumericValue(cuitArray[10]);
        }else{
            return false;
        }
    }
        
    //Validacion de un username en un nuevo usuario
    public static boolean newUsuario(String user){
        return CapaDatos.UsuarioBD.existeNuevoUser(user);
    }
    
    //Validacion de un username en un usuario modificado
    public static boolean modUsuario(long cuil, String user){
        return CapaDatos.UsuarioBD.existeModUser(cuil, user);
    }
    
    //Validacion de la existencia de un nombre de categoria
    public static boolean categoria(String categ){
        return CapaDatos.CategoriaBD.existe(categ);
    }
    
    //Validacion de activadad de un numero de mesa para comanda
    public static boolean comandaDeMesaActiva(int nromesa){
        return CapaDatos.ComandaBD.comandaDeMesaActiva(nromesa);
    }
    
    //Validacion de la existencia de un nombre para nuevo insumo
    public static boolean newInsumo(String nombre){
        return CapaDatos.InsumoBD.existeNombre(nombre);
    }
    
    //Validacion de la existencia de un nombre para insumo modificado
    public static boolean modInsumo(int idIns, String nombre){
        return CapaDatos.InsumoBD.existeNombreMod(idIns, nombre);
    }
}
