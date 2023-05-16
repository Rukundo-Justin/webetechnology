package com.church.adeprchurchmanagement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.AppSecurity.userSecurity;
import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.userRepository;
import com.church.adeprchurchmanagement.Tables.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class index {
    public static message message=new message("Welcome to adpr membership management system", "");;
   @Autowired
    private userRepository userrepo;
    private userSecurity usersecurity=new userSecurity();
    public static User user;
    @GetMapping("/")
    public String getIndex(Model model)
    {  
        model.addAttribute("message", message);
        return "index";
    }
    @PostMapping("/login")
    public String logIn(Model model,HttpServletRequest request,@RequestParam("email") String email,@RequestParam("password") String password)
    { 
        if(email.isEmpty()|| password.isEmpty())
        {
            message=new message("Empty Field","Fill Empty Field");
           
            return "index";
        }
        else{
            email=usersecurity.encrypteEmail(email);
            password=usersecurity.encryptePassword(password);
             user=userrepo.findByEmailAndpassword(email, password);
            if(user==null)
            {
                message=new message("Invalid credential","");
                model.addAttribute("message", message); 
                return "index";
            }
            else{
                message=new message("Success","Log in Successfully");
                model.addAttribute("message", message); 
                String encid=usersecurity.encrypteUrl(String.valueOf(user.getId()));
                String path="/user/home/"+encid;
                return "redirect:"+path;
            }
             
            
            
        }
        
    }

    // admin/church

 
}
