package Model;

import java.sql.*;

public class connection_model 
{
    private static Connection con;
    
    public static Connection DatabaseConnect()
    {
        try
        {
            String path = "jdbc:mysql://localhost/flyloka";
            con = DriverManager.getConnection(path,"root", "");
            
            return con;
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
