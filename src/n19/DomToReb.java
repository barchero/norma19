/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;



/**
 *
 * @author DAW
 */
public class DomToReb {
    HashMap<String,String> config;
    
    public DomToReb(String values[]){
        config = new HashMap<>();
        genConfig("src/n19/config.txt");
        try{
            inputData(values);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private void genConfig(String file){
        
        File fc = new File(file);
        if (fc.exists()){
            try{
                String params[];
                FileReader fr = new FileReader(fc);
                BufferedReader br = new BufferedReader(fr);
                String s;

                while((s = br.readLine()) != null) {
                    params = s.split("=");
                    config.put(params[0], params[1]);
                }
                if (fr != null) fr.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }  
    }
    
    public Connection MySQLConnect() {
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+config.get("db_dbName"),config.get("db_UserName"),config.get("db_Password"));                
                return con;
            }
            catch(Exception e){
                e.printStackTrace();
                return null;
            }
            
        }
    
     public void inputData(String values[]) throws SQLException{
         Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String dateNow = sdf.format(date.getTime());

         
         
         String DDLCrearTabla = "INSERT INTO rebuts VALUES (NULL,"
                + Integer.parseInt(values[0])+","
                + "'"+values[1]+"',"
                + "'"+dateNow+"',"
                + "'QUOTA "+values[2]+"'"
                + ")";
        Statement stmt = null;
        try{
            Connection con = this.MySQLConnect();
            stmt = con.createStatement();
            stmt.executeUpdate(DDLCrearTabla);
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        finally {
            stmt.close();
        }
    }
     
     
    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                if( ignoreSQLException(((SQLException)e).getSQLState()) == false) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " +((SQLException)e).getSQLState());
                    System.err.println("Error Code: " +((SQLException)e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while(t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
    }




    public static boolean ignoreSQLException(String sqlState) {
        if (sqlState == null) {
            System.out.println("The SQL state is not defined!");
            return false;
        }
        // X0Y32: Jar file already exists in schema
        if (sqlState.equalsIgnoreCase("X0Y32")){
            return true;
        }
        // 42Y55: Table already exists in schema
        if (sqlState.equalsIgnoreCase("42Y55")){
            return true;
        }
        return false;
    }
    
    
}
