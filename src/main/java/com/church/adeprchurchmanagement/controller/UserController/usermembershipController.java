package com.church.adeprchurchmanagement.controller.UserController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.church.adeprchurchmanagement.AppSecurity.userSecurity;
import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.userRepository;
import com.church.adeprchurchmanagement.Service.UserServices;
import com.church.adeprchurchmanagement.Service.ururemboService;
import com.church.adeprchurchmanagement.Service.userAuthorization;
import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.controller.index;
import com.church.adeprchurchmanagement.validation.Auth_validation;

import jakarta.servlet.http.Part;

@Controller
public class usermembershipController {
    Auth_validation auth=new Auth_validation();
    private User user;
    public static message message=new message("Welcome to User membership management System", "");
    @Autowired
    private UserServices userdao=new UserServices();
    userSecurity security=new userSecurity();
    @Autowired
    userRepository userrepo;
    // @Autowired
    // private userRepository repo;
    private userSecurity usersecurity=new userSecurity();
    private userAuthorization authorization=new userAuthorization();
    @Autowired
    private ururemboService ururembodao=new ururemboService();
    @GetMapping(value = "/user/membership/{id}")
    public String getPage(Model model,@PathVariable String id)
    {  boolean isValid=authorization.checkDataValidity(id);
        if(isValid==true)
        {   int res=Integer.parseInt(security.decrypteUrl(id));
            index.user=userrepo.findById(res);
            User user=index.user;
            model.addAttribute("message", message);
            model.addAttribute("user",user);
            model.addAttribute("church", ururembodao.getAllcHURCH());
            return "userView/membership";
        }
        else{
            return "redirect:/";
        }
        
    }
    @PostMapping("/signup")
    public String signup(Model model,@RequestPart Part profile,@RequestParam("name") String name,
    @RequestParam("gender") String gender,@RequestParam("phone") String phone,
    @RequestParam("email") String email,@RequestParam("cpassword") String cpassword,
    @RequestParam("rpassword") String rpassword) throws IOException
    {      
        
        String result[]= auth.signup(name, gender, phone, email, cpassword, rpassword).split(":");
            message=new message(result[0],result[1]);
            if(result[0].equals("Success"))
            {   
                cpassword=usersecurity.encryptePassword(cpassword);
                email=usersecurity.encrypteEmail(email);
                InputStream in=profile.getInputStream();
                byte[] arr=new byte[(int)profile.getSize()];
                in.read(arr);
                String image=Base64.getEncoder().encodeToString(arr);
                user=new User(image,name, gender, phone, email, cpassword, "USER", "");
                try {
                    userdao.saveUser(user);
                    index.message=new message(name, "Saved");
                } catch (Exception e) {
                   index.message=new message("error", "Credential Arleady Exist");
                }
            }
            return "redirect:/";
    }
    private UserServices dao=new UserServices();
    @PostMapping(value="/requestmembership/{userid}")
    public String requestMembership(Model model,@RequestParam int churchid,@PathVariable String userid)
    {   
        boolean isValid=authorization.checkDataValidity(userid);
        if(isValid==true)
       {  
             User user=index.user;
             int useridentity=user.getId();
             dao.RequestRegisteredInchurch(useridentity, churchid);
           message=new message("Your Church membership has been appended wait for Churh secretary to approve", "");
           model.addAttribute("message", message);
           return "redirect:/user/membership/"+userid+"";
        }
        else
            return "redirect:/";
    }
}
