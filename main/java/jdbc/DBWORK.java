package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBWORK {

    //PostgreSql bağlantısı methodu.
    public Connection connect_to_db(String dbName, String user, String password){
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbName,user,password);
            if(con!=null){
                System.out.println("Bağlantı sağlandı");
            }else {
                System.out.println("Bağlantı sağlanamadı");
            }


        }catch (Exception e){
            System.out.println(e);
        }


        return con;
    }


}