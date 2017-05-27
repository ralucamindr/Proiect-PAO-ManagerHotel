/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadedate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 *
 * @author Alexandra-Andreea
 */
public class BazaDeDate
{
     static private DataSource dbRes;

    private BazaDeDate()
    {
    }
    
    static
    {
        try
        {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        dbRes = (DataSource) envCtx.lookup("jdbc/paohotel");
        }
        catch (NamingException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void cauta_camere_pret(String optiune,String tip) throws ClassNotFoundException, SQLException{
        
        Connection conn = dbRes.getConnection();
        PreparedStatement ps=null;
        if(optiune!=null){
        if(optiune.compareTo("descrescator")==0)
                ps = conn.prepareStatement("Select nr_camera,tip,pret from camere order pret desc");
        else  if(optiune.compareTo("crescator")==0) 
                ps = conn.prepareStatement("Select nr_camera,tip,pret from camere order pret ");
        }
         ResultSet rs = ps.executeQuery();
            while(rs.next())
              System.out.println("Numar camera: "+rs.getInt("nr_camera")+" Tip: "+rs.getString("tip")+" Pret: "+rs.getDouble("pret"));
              
             rs.close();
             ps.close();
             conn.close();
            
        
       
    }
    
    
    
    
    
   
	
    
        
        
        
}
