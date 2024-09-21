package Model;

import View.dashborad_final;
import java.sql.*;
import javax.swing.JOptionPane;

public class login_model 
{
    public void login(String uname, String upassword)
    {
        try
        {   
            Statement st = connection_model.DatabaseConnect().createStatement();
            
            //ResultSet result = st.executeQuery("select password from user where user_id = '"+uname+"' ");
            ResultSet result = st.executeQuery("select password from user where user_id = '"+uname+"' ");
            
            if (uname.equals("Username") || upassword.equals("Password"))
            {
                JOptionPane.showMessageDialog(null, "Provide UserName and the password");
            } 
            else
            {
                if(result.next())
                {
                    String password = result.getString(1);
                    if(upassword.equals(password))
                    //if(upassword == password)
                    {
                        dashborad_final obj =new dashborad_final();
                        obj.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "User Name or Password Is incorrect. Try again");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "User Name or Password Is incorrect. Try again");
                }
            }
            
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
