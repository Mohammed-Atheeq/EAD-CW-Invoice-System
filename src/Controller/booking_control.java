
package Controller;

import Model.booking_model;

public class booking_control 
{
    
    public void insertControl(String customer_id, String name, String mail, int phone, String booking_id, String service, String country,int passanger, String date, String notes)
    {
        booking_model obj = new booking_model();
        obj.insertModel(customer_id, name, mail, phone, booking_id, service, country, passanger, date, notes);
    }
    
    public String bookingId()
    {
        String bkid= null;
        booking_model obj = new booking_model();
        //obj.bid(); 
        
        bkid = obj.bid();
        
        return bkid;
    }
    
    public String customer_Id()
    {
        String cusid = null;
        booking_model obj = new booking_model();
        //obj.cid();
        
        cusid = obj.cid();
        
        return cusid;
    }
    
}
