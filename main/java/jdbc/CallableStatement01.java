package jdbc;

import java.sql.*;

public class CallableStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","HTC.clk3637");
        Statement st=con.createStatement();

        //1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.

        //1.adım:fonksiyon kodunu yaz
        String sql1=
                "create OR REPLACE FUNCTION toplamaF(x numeric,y numeric)\n" +
                "returns numeric\n" +
                "language plpgsql\n" +
                "as \n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN x+y;\n" +
                "\n" +
                "END\n" +
                "$$";

        //2. adım :Fonksiyonuçalıştır.
        st.execute(sql1);

        //3. adım:fonksiyonu çağır
       CallableStatement cst1= con.prepareCall("{? =call toplamaF(?,?)}");

       //4.adım:return için egisterOutParameter() ,parametler için ise set() methodlarından uygun olanları kullan
        cst1.registerOutParameter(1,Types.NUMERIC);
        cst1.setInt(2,15);
        cst1.setInt(3,25);

       //5. adım:çalıştımak için execute () methodu kullaılır
        cst1.execute();

       //6.adım:sonucu çağırmak için return data tipine göre "get" methodarından uygun olanı kullanırız
        System.out.println("cst1.getBigDecimal(1) = " + cst1.getBigDecimal(1));


    }
}
