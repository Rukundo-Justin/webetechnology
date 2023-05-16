package com.church.adeprchurchmanagement.controller.AdminController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.choirRepository;
import com.church.adeprchurchmanagement.Service.ururemboService;
import com.church.adeprchurchmanagement.Tables.Ururembo;
import com.church.adeprchurchmanagement.Tables.choir;

@Controller
public class choirController {
    @Autowired
    choirRepository repo;
    @Autowired
    ururemboService ururembodao=new ururemboService();
    @PostMapping(value = "/addchoir")
    public String addChoir(@RequestParam int id,@RequestParam String name,@RequestParam String president,@RequestParam String fromDate
    ,@RequestParam int churchid,@RequestParam String phone)
    {   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fromDate, formatter);
        Date Fromdate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        Ururembo ururembo=ururembodao.findById(churchid);
        choir choir;

        if(id==-1)
        choir=new choir(name, president, Fromdate, ururembo, phone,new Date());
        else
          choir=new choir(id, name, president, Fromdate, ururembo, phone, Fromdate);
        try {
            repo.save(choir);
            defaultview.message=new message(choir.getName(), "Saved Sucessfully");
        } catch (Exception e) {
            defaultview.message=new message("eror", e.getMessage());
        }
        return "redirect:/admin/choir";
    }

    @PostMapping(value = "/deletechoir")
    public String deleteChoir(@RequestParam int id)
    {    
        try {
            repo.deleteById(id);
            defaultview.message=new message("Choir", "Deleted Sucessfully");
        } catch (Exception e) {
            defaultview.message=new message("error", e.getMessage());
        }
        return "redirect:/admin/choir";
    }
}
