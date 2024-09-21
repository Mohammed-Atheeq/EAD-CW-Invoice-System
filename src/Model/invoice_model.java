
package Model;

import java.sql.*;
import javax.swing.JOptionPane;

public class invoice_model 
{
    public void insertModel(String invoice, String booking, String customer, String description, String idate, String duedate, int total)
    {
        try
        {
            Statement st = connection_model.DatabaseConnect().createStatement();
            
            int i = st.executeUpdate("insert into invoice values ('"+invoice+"', '"+booking+"', '"+customer+"', '"+description+"','"+idate+"', '"+duedate+"', '"+total+"' )");
            
            if(i > 0)
            {
                //JOptionPane.showMessageDialog(null, "Booking Added", "Customer", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    
    public ResultSet bookId()
    {
        ResultSet result;
        try
        {
            Statement st = connection_model.DatabaseConnect().createStatement();
            result = st.executeQuery("select Booking_Id from Booking ");
            return result;
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet cust_name(String id)
    {
        ResultSet result;
        try
        {
            Statement st = connection_model.DatabaseConnect().createStatement();
            
            //result = st.executeQuery("Select Customer_name FROM customer Inner Join Booking ON Customer_Id = Cust_id Where Booking_Id = '"+id+"'  ");
            result = st.executeQuery("Select Customer_Id, Customer_name, Service, Country, Passenger FROM customer Inner Join Booking ON Customer_Id = Cust_id Where Booking_Id = '"+id+"'  ");
            
            return result;
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public String iNo()
    {
        String itxt = null;
        try
        {
            Statement st3 = connection_model.DatabaseConnect().createStatement();
            
            ResultSet result = st3.executeQuery("Select Invoice_No from Invoice Order by Invoice_No DESC LIMIT 1");
            
            if(result.next())
            {
                String id = result.getString(1);
                
                int i = id.length();
                
                String txt = id.substring(0, 4);
                String num = id.substring(4, i);
                
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                itxt = txt+snum;
                //bookinId = ftxt;
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        return itxt;
    }
}
