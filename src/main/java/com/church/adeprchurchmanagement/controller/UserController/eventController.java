package com.church.adeprchurchmanagement.controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.church.adeprchurchmanagement.Repository.EventRepository;
import com.church.adeprchurchmanagement.Service.userAuthorization;
import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.controller.index;

@Controller
public class eventController {
    @Autowired
    EventRepository eventrepo;
    private userAuthorization auth=new userAuthorization();
    @GetMapping(value = "/user/event/{id}")
  public String getPage(Model model,@PathVariable String id)
  { String identity=id;
    boolean isValid=auth.checkDataValidity(id);
    if(isValid==true)
    { User user=index.user;
      model.addAttribute("user", user);
      model.addAttribute("event", eventrepo.findAll());
      model.addAttribute("id", identity);
    return "userView/event";
    }
    else{
      return "redirect:/";
    }
  }  
}
