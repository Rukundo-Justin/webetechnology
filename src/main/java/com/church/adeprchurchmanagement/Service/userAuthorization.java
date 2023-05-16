package com.church.adeprchurchmanagement.Service;

import com.church.adeprchurchmanagement.AppSecurity.userSecurity;
import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.controller.index;

public class userAuthorization {
    userSecurity security=new userSecurity();
    public boolean checkDataValidity(String id)
    { boolean isValid=false;
     try {
        User user=index.user;
        int userId=Integer.parseInt(security.decrypteUrl(id));
     if(user.getId()==userId && user.getRole().equals("USER"))
     { 
        isValid=true;
     }
     else{
       isValid=false;
     }
    } catch (Exception e) {
       return isValid=false;
    }
    return isValid;
    }
}
