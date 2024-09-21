
package Model;

import java.sql.*;
import javax.swing.JOptionPane;

public class booking_model 
{
    public void insertModel(String customer_id, String name, String mail, int phone, String booking_id, String service, String country,int passanger, String date, String notes)
    {
        try
        {
            //Validations
            //if(name.isEmpty() || mail.isEmpty() || booking_id.isEmpty() || phone != 0 || service.isEmpty() || country.isEmpty() || passanger != 0 || date.isEmpty())
            //{
                //JOptionPane.showMessageDialog(null, "Fields Cannot Be Empty");
            //}
            //else
            //{
                Statement st = connection_model.DatabaseConnect().createStatement();
                Statement st1 = connection_model.DatabaseConnect().createStatement();
                int i = st.executeUpdate("insert into customer values ('"+customer_id+"', '"+name+"', '"+mail+"', '"+phone+"')");
                
                if(i > 0)
                {
                    int n = st1.executeUpdate("insert into booking values ('"+booking_id+"', '"+customer_id+"', '"+service+"', '"+country+"','"+passanger+"', '"+date+"', '"+notes+"')");
                    if(n > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Booking Added", "Customer", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            //}
            
            
            
            
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public String cid()
    {
        String ctxt = null;
        try
        {
            Statement st2 = connection_model.DatabaseConnect().createStatement();
            
            ResultSet result = st2.executeQuery("Select Customer_Id from Customer Order by Customer_Id DESC LIMIT 1");
            
            if(result.next())
            {
                String id = result.getString(1);
                
                int i = id.length();
                
                String txt = id.substring(0, 1);
                String num = id.substring(1, i);
                
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                 ctxt = txt+snum;
                
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        return ctxt;
    }
    
    
    
    public String bid()
    {
        String btxt = null;
        try
        {
            Statement st3 = connection_model.DatabaseConnect().createStatement();
            
            ResultSet result = st3.executeQuery("Select Booking_ID from Booking Order by Booking_ID DESC LIMIT 1");
            
            if(result.next())
            {
                String id = result.getString(1);
                
                int i = id.length();
                
                String txt = id.substring(0, 1);
                String num = id.substring(1, i);
                
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                btxt = txt+snum;
                //bookinId = ftxt;
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
        return btxt;
    }
    
}
