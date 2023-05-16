package com.church.adeprchurchmanagement.controller.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.Dutyrepository;
import com.church.adeprchurchmanagement.Repository.UruremboRepository;
import com.church.adeprchurchmanagement.Tables.duty;

@Controller
public class DutyController {
    public static message message=new message("Welcome to duty home page","");
    @Autowired
    Dutyrepository repo;
    @Autowired
    private UruremboRepository ururemborepo;
    @GetMapping(value = "/admin/duty")
    public String getpage(Model model)
    {   model.addAttribute("message", message);
        model.addAttribute("dutylist", repo.findAll());
        model.addAttribute("ururembolist", ururemborepo.getAllUrurembo());
        return "adminView/church/assignduty";
    }
    @PostMapping(value = "/adduty")
    public String  addorupdate(Model model,@RequestParam int id,@RequestParam String name,@RequestParam String category)
    { 
        duty duty;
        if(id==-1)
        { duty=new duty(name, category); }
        else{ duty=new duty(id, name, category);}
        repo.save(duty);
        message=new message(name,"New Duty is added Successfully");
        model.addAttribute("message", message);
        return "redirect:/admin/duty";
    }
    @PostMapping(value = "/deleteduty")
    public String deleteDuty(@RequestParam int id)
    { 
        repo.deleteById(id);
        message=new message("Delete","Duty Deleted Successfully");
        return "redirect:/admin/duty";
    }

}
