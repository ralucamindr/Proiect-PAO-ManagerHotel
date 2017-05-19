
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandra-Andreea
 */
public class Main {
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@188.25.37.26:1521:XE";
   static final String USER = "system";
   static final String PASS = "bd12345";
   
@Resource(name = "jdbc/myDb")   
private static DataSource dbRes;
       
   public static void main(String args[]) throws ClassNotFoundException, SQLException
   {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
	   System.out.println("Connecting to database...");
	   //Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
           Connection conn = dbRes.getConnection();
           System.out.println("Connecteed!");
	   Statement stmt = conn.createStatement();
	   //String sql = "Select count(*) from useri where username='"+username+"' and password='"+password+"' ";
	   String sql = "select * from camere";
           ResultSet rs = stmt.executeQuery(sql);
           rs.next();
           System.out.println(rs.getString("tip"));
   }
}
