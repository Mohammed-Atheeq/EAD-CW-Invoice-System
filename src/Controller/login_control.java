package Controller;

import Model.login_model;

public class login_control 
{
    public void loginControl(String uname, String upassword)
    {
        login_model obj = new login_model();
        obj.login(uname, upassword);
    }
}
