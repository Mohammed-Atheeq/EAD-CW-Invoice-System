package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class payment_model 
{
    public void insertModel(String invoiceId, String custId, String date, int total, int paid, int due)
    {
        try
        {
            Statement st = connection_model.DatabaseConnect().createStatement();
            
            int i = st.executeUpdate("insert into Payment values ('"+invoiceId+"', '"+custId+"', '"+date+"', '"+total+"', '"+paid+"', '"+due+"') ");
            
            if(i > 0)
            {
                JOptionPane.showMessageDialog(null, "Payment Success", "Payment", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public ResultSet inId()
    {
        ResultSet result;
        try
        {
            Statement st = connection_model.DatabaseConnect().createStatement();
            result = st.executeQuery("select invoice_no from invoice ");
            return result;
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet total(String id)
    {
        ResultSet result;
        try
        {
            Statement st = connection_model.DatabaseConnect().createStatement();
            
            //result = st.executeQuery("Select total from invoice Where invoice_no = '"+id+"'  ");
            result = st.executeQuery("Select total, Cust_Id from invoice Where invoice_no = '"+id+"'  ");
            
            return result;
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
