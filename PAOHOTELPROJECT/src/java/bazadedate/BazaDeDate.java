/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadedate;

import java.sql.Connection;
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
        dbRes = (DataSource) envCtx.lookup("jdbc/sys");
        }
        catch (NamingException ex)
        {
            ex.printStackTrace();
        }
    }
        
        
        
}
