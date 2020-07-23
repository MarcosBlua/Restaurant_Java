package CapaDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Config {
    /*Esta clase se encarga de leer el archivo de configuracion de la aplicacion.
    Dicho archivo se encuentra en la Raiz del programa y se llama Config.txt*/
    
    //Variables
    //Administrador
    private String admin;
    private String passAdmin;
    
    //Cantidad de mesas
    private int mesas;
    
    //Conexion a base de datos
    private String driver;          // Línea 7
    private String user;            // Línea 8
    private String password;        // Línea 9
    private String url;             // Línea 10

    //Constructor
    public Config() {
        leer_config();
    }
    
    //Getters y setters
    public String getDriver() {
        return driver;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getUrl() {
        return url;
    }

    public int getMesas() {
        return mesas;
    }

    public String getAdmin() {
        return admin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }
        
    //Lee el archivo txt que almacena la configuracion
    public void leer_config(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File (".\\Config.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            driver = br.readLine();
            user = br.readLine();
            password = br.readLine();
            url = br.readLine();            
            admin = br.readLine();
            passAdmin = br.readLine();
            mesas = Integer.valueOf(br.readLine());
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                  fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
}
