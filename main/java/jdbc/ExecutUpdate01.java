package jdbc;

import java.sql.*;

public class ExecutUpdate01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","HTC.clk3637");
        Statement st=con.createStatement();

        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan number_of_employees değerlerini 16000 olarak UPDATE edin.

        String sql1="update companies\n" +
                "set number_of_employees=16000\n" +
                "where number_of_employees<(select avg(number_of_employees)\n" +
                "                           from companies)";

        int updatesatırsayısı=st.executeUpdate(sql1);//update edilen satır sayısını return eder.
        System.out.println("updatesatırsayısı = " + updatesatırsayısı);

        String sql2="select * from companies";
        ResultSet result1=st.executeQuery(sql2);

        while (result1.next()){
            System.out.println(result1.getInt(1)+"----"+result1.getString(2)+"---"+result1.getInt(3));

        }
        con.close();
        st.close();
    }
}
