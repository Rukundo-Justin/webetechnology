package com.church.adeprchurchmanagement.controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.church.adeprchurchmanagement.Repository.AnouncementRepository;
import com.church.adeprchurchmanagement.Service.userAuthorization;
import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.controller.index;

@Controller
public class announcementController {
    private userAuthorization auth=new userAuthorization();
    @Autowired
    private AnouncementRepository repo;
    @GetMapping(value = "/user/announcement/{id}")
    public String getPage(Model model,@PathVariable String id)
    {   boolean isvalid=auth.checkDataValidity(id);
        if(isvalid==true)
        { User user=index.user;
          model.addAttribute("user", user);  
          model.addAttribute("announcement", repo.findAll());
        }
        return "userView/announcement";
    }
}
