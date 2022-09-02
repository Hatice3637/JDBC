package jdbc;

import java.sql.Connection;

public class MAİN {



    public static void main(String[] args) {

        //DBWork objesini oluştur.
      DBWORK db = new DBWORK();
        Connection con = db.connect_to_db("Techpro","postgres","1234");




    }
}