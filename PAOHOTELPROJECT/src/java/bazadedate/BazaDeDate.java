/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadedate;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static void cauta_extra(String opt,PrintWriter out){
        
        PreparedStatement stmt = null;
        ResultSet res = null;
        try(Connection conn = dbRes.getConnection();){
            if(opt!=null){
          PreparedStatement ps= conn.prepareStatement("Select nr_camera from hotelare where nume_optiune=?");
          ps.setString(1,opt);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
              out.println("Numar camera: "+rs.getInt("nr_camera")+" Extraoptiune: "+opt);
              out.println("<br>");}
            }
        }
             catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(stmt != null)
                    stmt.close();
                if(res != null)
                    res.close();
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }         
    
    
    
   public static void cauta_camere(String optiune,String tip,PrintWriter out) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try(Connection conn = dbRes.getConnection();)
        {
        
        if(optiune!=null){
            if(tip!=null){
        if(optiune.compareTo("pretdescrescator")==0){
                ps = conn.prepareStatement("Select nr_camera,tip,pret from hotelcamere where tip=? order by pret desc ");
                ps.setString(1, tip);
        }
                
        else  if(optiune.compareTo("pretcrescator")==0) {
                ps = conn.prepareStatement("Select nr_camera,tip,pret from hotelcamere where tip=? order by pret ");
                 ps.setString(1, tip);
        }
        }
            else
            {
                if(optiune.compareTo("pretdescrescator")==0)
                ps = conn.prepareStatement("Select nr_camera,tip,pret from hotelcamere order by pret desc ");
              
        
                
        else  if(optiune.compareTo("pretcrescator")==0) 
                ps = conn.prepareStatement("Select nr_camera,tip,pret from hotelcamere order by pret ");
            
          
        }}
        
        if(tip!=null && optiune==null){
            ps = conn.prepareStatement("Select nr_camera,tip,pret from hotelcamere where tip=?  ");
                 ps.setString(1, tip);
            
        }
        
        if(tip==null && optiune == null)
        {
            ps = conn.prepareStatement("Select nr_camera,tip,pret from hotelcamere");
            
        }
          rs = ps.executeQuery();
            while(rs.next())
            { out.println("Numar camera: "+rs.getInt("nr_camera")+" Tip: "+rs.getString("tip")+" Pret: "+rs.getDouble("pret"));
              out.println("<br>");
            }
            
        }
            catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
   
    public static int etajmax(){
        
         PreparedStatement ps = null;
         ResultSet rs = null;
         int nr=0;
        try(Connection conn = dbRes.getConnection();)
        {
            
                ps = conn.prepareStatement("select max(nr_etaj) from hoteletaje ");
               
                rs = ps.executeQuery();
                if(rs.next())
                    nr=rs.getInt(1);
                                    
            
        } 
        catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(ps != null)
                    ps.close();
                if(rs != null)
                    rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return nr;
        
    }
     public static void add(String numarcamera, String etaj, String tip, String pret) {
         PreparedStatement ps = null;
        
        try(Connection conn = dbRes.getConnection();)
        {
            
                ps = conn.prepareStatement("insert into hotelcamere values(?,?,?,?,?)");
                ps.setString(1,numarcamera);
                ps.setString(2,tip);
                ps.setString(3,etaj);
                ps.setString(4,"libera");
                ps.setString(5,pret);
                ps.executeUpdate();
             
          }
         catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(ps != null)
                    ps.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    }

    public static void addopt(String numarcamera, String extra) {
           PreparedStatement ps = null;
        
        try(Connection conn = dbRes.getConnection();)
        {
            
                ps = conn.prepareStatement("insert into hotelare values(?,?)");
                ps.setString(1, numarcamera);
                ps.setString(2,extra);
                ps.executeUpdate();
             
          }
         catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(ps != null)
                    ps.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public static boolean login(String username, String password, String mod)
    {
        boolean gasit = false;
        
        PreparedStatement stmt = null;
        ResultSet res = null;
        try(Connection conn = dbRes.getConnection();)
        {
            
                stmt = conn.prepareStatement("select * from hoteluseri where username=? and parola=? and tip=?");
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, mod);
                res = stmt.executeQuery();
                if(res.next())
                    gasit = true;
                
        } 
        catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(stmt != null)
                    stmt.close();
                if(res != null)
                    res.close();
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return gasit;
    }
	
     public static void insertetajcamere(Integer nretaj, Integer numarcamere) {
        
        PreparedStatement ps = null;
        
        try(Connection conn = dbRes.getConnection();)
        {
            
                ps = conn.prepareStatement("insert into hoteletaje values(?,?)");
                ps.setString(1, nretaj.toString());
                ps.setString(2,numarcamere.toString());
                ps.executeUpdate();
             
          }
         catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(ps != null)
                    ps.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
        
     }
     
     
    public static String verificaCamere()
    {
        PreparedStatement stmt = null;
        ResultSet res = null;
        
        String tabel = "";
        
        try(Connection conn = dbRes.getConnection();)
        {
                stmt = conn.prepareStatement("Select nr_camera,stare from hotelcamere");
                
                res = stmt.executeQuery();
                
                while(res.next())
                {           
                    tabel += "<tr>";
                    tabel += "<td>" + res.getString(1) + "</td>";
                    tabel += "<td>" + res.getString(2) + "</td>";
                    tabel += "</tr>";
                }
        } 
        catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(stmt != null)
                    stmt.close();
                if(res != null)
                    res.close();
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return tabel;
    }
    
    
    public static String afiseazaCamera(String nr_camera)
    {
        PreparedStatement stmt = null;
        ResultSet res = null;
        
        String rezultat = "";
        
        try(Connection conn = dbRes.getConnection();)
        {
                stmt = conn.prepareStatement("Select * from hotelcamere where nr_camera=?");
                
                stmt.setString(1, nr_camera);
                
                res = stmt.executeQuery();
                
                if(res.next())
                {           
                    rezultat = "Nr. camera = " + res.getString("nr_camera") + ", nr. etaj = " + res.getString("nr_etaj") + ", tip = ";
                    rezultat += res.getString("tip") + ", stare = " + res.getString("stare") + ", pret = " + res.getString("pret");
                }
                else
                {
                    rezultat = "Nu exista nicio camera cu numarul introdus";
                }
        } 
        catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(stmt != null)
                    stmt.close();
                if(res != null)
                    res.close();
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return rezultat;
    }
	
    
    
    public static String rezervaCamera(String nr_camera, String data_check_in, String data_check_out)
    {
        PreparedStatement stmt = null;
        ResultSet res = null;
        
        String rezultat = "";
        
        try(Connection conn = dbRes.getConnection();)
        {
                stmt = conn.prepareStatement("Select stare from hotelcamere where nr_camera=?");
                
                stmt.setString(1, nr_camera);
                
                res = stmt.executeQuery();
                
                if(res.next())
                {           
                    if(res.getString(1).equals("ocupat"))
                        rezultat = "Camera este deja ocupata";
                    else
                        if(res.getString(1).equals("liber, dar necuratata"))
                            rezultat = "Camera este libera, dar necuratata";
                    else
                        if(res.getString(1).equals("libera"))
                        {
                            stmt = conn.prepareStatement("select max(nr_rezervare) from hotelrezervari");
                            res = stmt.executeQuery();
                            Integer id = 0;
                            if(res.next())
                                id = res.getInt(1);
                            id = id + 1;
                            stmt = conn.prepareStatement("insert into hotelrezervari values(?,?,?,?)");
                            stmt.setString(1, id.toString());
                            stmt.setString(2, nr_camera);
                            stmt.setString(3, data_check_in);
                            stmt.setString(4, data_check_out);
                            stmt.executeUpdate();
                            
                            stmt = conn.prepareStatement("update hotelcamere set stare =? where nr_camera=?");
                            stmt.setString(1, "ocupat");
                            stmt.setString(2, nr_camera);
                            stmt.executeUpdate();
                            
                            rezultat = "Rezervare efectuata cu succes";
                        }
                }
                else
                {
                    rezultat = "Nu exista nicio camera cu numarul introdus";
                }
        } 
        catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(stmt != null)
                    stmt.close();
                if(res != null)
                    res.close();
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return rezultat;
    }
    
    
    public static String curataCamera(String nr_camera)
    {
        PreparedStatement stmt = null;
        ResultSet res = null;
        
        String rezultat = "";
        
        try(Connection conn = dbRes.getConnection();)
        {
                stmt = conn.prepareStatement("Select stare from hotelcamere where nr_camera=?");
                
                stmt.setString(1, nr_camera);
                
                res = stmt.executeQuery();
                
                if(res.next())
                {           
                    if(res.getString(1).equals("ocupat"))
                        rezultat = "Camera este ocupata, nu poate fi curatata";
                    else
                        if(res.getString(1).equals("libera"))
                            rezultat = "Camera este libera si deja curatata";
                    else
                        if(res.getString(1).equals("libera, dar necuratata"))
                        {
                            stmt = conn.prepareStatement("update hotelcamere set stare =? where nr_camera=?");
                            stmt.setString(1, "liber");
                            stmt.setString(2, nr_camera);
                            stmt.executeUpdate();
                            
                            rezultat = "Camera a fost curatata";
                        }
                }
                else
                {
                    rezultat = "Nu exista nicio camera cu numarul introdus";
                }
        } 
        catch (SQLException ex) 
        {
             Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if(stmt != null)
                    stmt.close();
                if(res != null)
                    res.close();
            } catch (SQLException ex) {
                Logger.getLogger(BazaDeDate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return rezultat;
    }
        
        
        
}
