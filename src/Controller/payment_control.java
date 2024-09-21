package Controller;


import Model.payment_model;
import java.sql.ResultSet;

public class payment_control 
{
    public void insertControl(String invoiceId, String custId, String date,int total, int paid, int due)
    {
         payment_model obj = new payment_model();
         obj.insertModel(invoiceId, custId, date, total, paid, due);
    }
    
    public ResultSet invoice_id()
    {
        payment_model obj = new payment_model();
        
        ResultSet result = obj.inId();
        
        return result;
    }
    
    public ResultSet amount(String no)
    {
        payment_model obj = new payment_model();
        
        ResultSet result = obj.total(no);
        
        return result;
    }
}
