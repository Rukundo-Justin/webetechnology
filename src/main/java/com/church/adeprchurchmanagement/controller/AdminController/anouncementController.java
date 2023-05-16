package com.church.adeprchurchmanagement.controller.AdminController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.AnouncementRepository;
import com.church.adeprchurchmanagement.Tables.anouncement;

@Controller
public class anouncementController {
    @Autowired
    private AnouncementRepository repo;
    private anouncement anouncement;
    @GetMapping(value = "/anouncement/add")
    public String addanouncement(Model model,@RequestParam int id,@RequestParam String head,@RequestParam String description)
    {  if(id==0)
        {
            anouncement=new anouncement(head, description, new Date());
        }else{
            anouncement=new anouncement(id, head, description, new Date());
        }
        try {
           anouncement anounc= repo.save(anouncement);
           defaultview.message=new message(anounc.getHead(), "Saved Sucessfully");
        } catch (Exception e) {
            defaultview.message=new message("error", e.getMessage());
        }
        return "redirect:/admin/anouncement"; 
    }
    @GetMapping(value = "/anouncement/delete")
    public String deleteanouncement(Model model,@RequestParam int id )
    {   
        try {
             repo.deleteById(id);
           defaultview.message=new message("Delete", "Anouncement Deleted Sucessfully");
        } catch (Exception e) {
            defaultview.message=new message("error", e.getMessage());
        }
        return "redirect:/admin/anouncement"; 
    }
}
