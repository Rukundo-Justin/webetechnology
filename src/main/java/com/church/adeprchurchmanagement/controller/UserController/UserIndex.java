package com.church.adeprchurchmanagement.controller.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Service.userAuthorization;
import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.controller.index;

@Controller
public class UserIndex {
   private userAuthorization auth=new userAuthorization();
    @GetMapping("/user/home/{id}")
   public String  getPage(Model model,@PathVariable String id)
   { 
    String identity=id;
    boolean isAllowed=auth.checkDataValidity(identity);
        User user=index.user;
      if(isAllowed==true)
     {  model.addAttribute("id",identity);
        model.addAttribute("user",user);
        if(user.getRole().equals("USER"))
        return "userView/index";
        else
        return "adminView/church/index";
     }
     else{
       index.message=new message("Invalid Credential try again","");
       return "redirect:/";
     }
    } 
    @GetMapping(value = "/user/logout/{userid}")
    public String logout(@PathVariable String userid)  
    {
      index.user=null;
      index.message=new message("Logout Successfully", "");
      return "redirect:/";
    }
   } 

