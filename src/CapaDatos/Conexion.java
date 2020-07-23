package CapaDatos;

import CapaUsuario.Mensajes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    //Se inicializan variables para conexion 
    private static Config conf = new Config();
    private static Connection conn;
    
    private static Statement sent;
    PreparedStatement pps;
    ResultSet rs;
    
    private static final String driver = conf.getDriver();
    private static final String user = conf.getUser();
    private static final String password = conf.getPassword();
    private static final String url = conf.getUrl();
    
    //Constructor
    public Conexion(){
        conn = null;
        try{
            //Crea la conexion a SQL
            Class.forName(driver);
            conn= (Connection) DriverManager.getConnection(url, user, password);
         }catch (ClassNotFoundException | SQLException e){
             //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError("Error al Conectar" + e);
        }
    }
    
    public void abrirLectura(String sentencia){
        try{
            sent = conn.createStatement();
            rs = sent.executeQuery(sentencia);
        }catch(SQLException e){
            Mensajes.msjError(e.getMessage());
        }
    }
    
    public void abrirEscritura(String sentencia){
        try{
            pps = conn.prepareStatement(sentencia);
        }catch(SQLException e){
            Mensajes.msjError(e.getMessage());
        }
    }
    
    //Cierra conexion a SQL
    public void desconectar (){
        try {
            conn.close();
        } catch (Exception e) {
            //En caso de ocurrir un error muestra un mensaje con lo que sucedio
            Mensajes.msjError("No se pudo cerrar la conexión");
        }
        
    }
}
