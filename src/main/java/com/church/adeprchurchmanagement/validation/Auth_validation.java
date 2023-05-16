package com.church.adeprchurchmanagement.validation;

public class Auth_validation {
    public String signup(String name, String gender,String phone,String email, String cpassword,String rpassword)
    { if(name.isEmpty()||gender.isEmpty()||phone.isEmpty()||email.isEmpty()||cpassword.isEmpty()||rpassword.isEmpty())
        {
            return "Empty:All Fields Are Required";
        }
        else if(!cpassword.equals(rpassword)){
             return" Password Err:Password Not Match";
        } 
        else if(cpassword.length()<8)
        {
            return" Password Err:minimum 8 character of password needed";
        }
        else{
            return "Success: Account Created Successfully";
        }
    }
    
}