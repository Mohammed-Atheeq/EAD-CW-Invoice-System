
package Controller;

import Model.invoice_model;
import java.sql.*;

public class invoice_control 
{
    public void insertControl(String invoice, String booking, String customer, String description, String idate, String duedate, int total)
    {
        invoice_model obj = new invoice_model();
        obj.insertModel(invoice, booking, customer, description, idate, duedate, total);
    }
    
    public ResultSet bookingId()
    {
        invoice_model obj = new invoice_model();
        
        ResultSet result = obj.bookId();
        
        return result;
    }
    
    public ResultSet name(String id)
    {
        invoice_model obj = new invoice_model();
        
        ResultSet result = obj.cust_name(id);
        
        return result;
    }
    
    public String invoiceNo()
    {
        String iNo = null;
        invoice_model obj = new invoice_model();
        
        iNo = obj.iNo();
        
        return iNo;
    }
    
    
}
