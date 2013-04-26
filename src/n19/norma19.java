/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n19;

import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import static n19.DomToReb.ignoreSQLException;

/**
 *
 * @author DAW
 */
public class norma19 {
    HashMap<String,String> config;
    Integer total=0;
    Integer i = 0;
    
    public norma19(ArrayList<Integer> users) throws SQLException, ParseException, IOException{
        config = new HashMap<>();
        genConfig("src/n19/config.txt");
        File fc = new File("./norma19.txt");
        try{
            if (!fc.exists()){
              fc.createNewFile();
            }
            
            FileWriter br = new FileWriter(fc);
            writePresentador(br,config);
            writeOrdenante(br,config);

            while(i<users.size()){
                writeIndividual(br,users.get(i));
                i++;
            }
            writeTOrdenante(br,config);
            writeGeneral(br,config);  
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        
        

        
        //System.out.println(String.valueOf(i)+"//"+total);
        //
        
        //String userData[] = getUserData()
        /*try{
            inputData(values);
        }
        catch(Exception e){
            e.printStackTrace();
        }*/
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
    

    private String full(String value,int longitude, String icon, String position){
        
        String ret;        
        int restant = longitude-value.length();
        String emptyContent = libre(restant,icon);
        
        if(position.equals("left")){
            ret= emptyContent+value;
        }else{
            ret = value+emptyContent; 
        }
        return ret;
        
    }
    
    private String libre(int num, String value){
        
        String result = "";
        for(int i=0; i<num; i++){
            result += value;
        }
        return result;
        
    }
    private String now(){
        
        Calendar now = Calendar.getInstance();
        SimpleDateFormat sdf_now = new SimpleDateFormat("ddMMyy");
        now.add(now.MONTH,1);//january == 0
        Date lastReb = now.getTime();    
        String lDate = sdf_now.format(lastReb);
        return lDate;
        
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
    
    
    
        private void writePresentador(FileWriter br,HashMap<String,String> config) throws IOException{
        
        String result = "5180";//indicatiu de linia
        result += config.get("p_nif");//nif del presentador
        result += full("", 3, "0","right");
        result += now();//data de confecció del document
        result += libre(6," ");
        result += full(config.get("p_nom").toUpperCase(),40," ","right");//nom del presentador
        result += libre(20," ");
        result += config.get("p_entidad");
        result += config.get("p_oficina");
        result += libre(12," ");
        result += libre(40," ");
        result += libre(14," ");
        
        br.write(result+"\r\n");

        System.out.println(result);    
        
        
        
        
    }
    private void writeOrdenante(FileWriter br,HashMap<String,String> config) throws IOException{
        String result = "5380";
        result += config.get("p_nif");//nif del presentador
        result += full("", 3, "0","right");
        result += now();//data de confecció del document
        result += now();
        result += full(config.get("p_nom").toUpperCase(),40," ","right");//nom del presentador
        result += config.get("p_entidad");
        result += config.get("p_oficina");
        result += config.get("p_dc");
        result += config.get("p_cuenta");
        result += libre(8," ");
        result += "01";
        result += libre(8," ");
        result += libre(40," ");
        result += libre(14," ");
        br.write(result+"\r\n");
        System.out.println(result);
    } 
    
    
    
    private void writeIndividual(FileWriter br,Integer soci) throws SQLException, ParseException, IOException{
            Connection con = this.MySQLConnect();
            Statement stmt = con.createStatement();
            ResultSet SQLResult = stmt.executeQuery("SELECT c.id,c.nif,c.nom,c.cognoms,c.ccc,r.quantitat,r.concepte FROM rebuts r INNER JOIN clients c ON c.id=r.id_soci WHERE c.id="+soci);
            SQLResult.next();
            
            String result = "5680";
            result += SQLResult.getString("nif");
            result += full("", 3, "0","right");
            result += full(SQLResult.getString("id"),12,"0","left");
            result += full(SQLResult.getString("nom").toUpperCase()+" "+SQLResult.getString("cognoms").toUpperCase(),40," ","right");
            result += SQLResult.getString("ccc").replace("-","");
            result += full(SQLResult.getString("quantitat").replace(".",""),10,"0","left");
            result += libre(16," ");
            result += full(SQLResult.getString("concepte").toUpperCase(),40," ","right");
            result += libre(8," ");
            br.write(result+"\r\n");
            
            
            total += Integer.parseInt(SQLResult.getString("quantitat").replace(".",""));
            System.out.println(result);
    } 
    
    
    
    private void writeTOrdenante(FileWriter br,HashMap<String,String> config) throws IOException{
        String result = "5880";
        result += config.get("p_nif");//nif del presentador
        result += full("", 3, "0","right");
        result += libre(12," ");
        result += libre(40," ");
        result += libre(20," ");
        result += full(String.valueOf(total),10,"0","left");
        result += libre(6," ");
        result += full(String.valueOf(i),10,"0","left");
        result += full(String.valueOf(i),10,"0","left");
        result += libre(20," ");
        result += libre(18," ");
        br.write(result+"\r\n");
        
        System.out.println(result);
    }
    private void writeGeneral(FileWriter br,HashMap<String,String> config) throws IOException{
        String result = "5980";
        result += config.get("p_nif");//nif del presentador
        result += full("", 3, "0","right");
        result += libre(12," ");
        result += libre(40," ");
        result += full("1",4,"0","left");
        result += libre(16," ");
        result += full(String.valueOf(total),10,"0","left");
        result += libre(6," ");
        result += full(String.valueOf(i),10,"0","left");
        result += full(String.valueOf(i+4),10,"0","left");
        result += libre(20," ");
        result += libre(18," ");
        br.write(result+"\r\n");
        
        System.out.println(result);
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
