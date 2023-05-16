package com.church.adeprchurchmanagement.controller.AdminController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.EventRepository;
import com.church.adeprchurchmanagement.Tables.Eventtb;

@Controller
public class Eventcontroller {
    @Autowired
    EventRepository repo;
    @GetMapping(value = "/addevent")
public String  addEvent(@RequestParam int id,@RequestParam String name,@RequestParam String type,@RequestParam String fromdate,
 @RequestParam String todate,@RequestParam String place,@RequestParam String participant)  
{
    try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fromdate, formatter);
        Date Fromdate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime dateTime1 = LocalDateTime.parse(todate, formatter);
        Date Todate = Date.from(dateTime1.atZone(ZoneId.systemDefault()).toInstant());
        Eventtb event;
        if(id==-1)
          event=new Eventtb(name, type, Fromdate, Todate,place,participant);
        else
         event=new Eventtb(id, name, type, Fromdate, Todate, place, participant);
        repo.save(event);
        defaultview.message=new message(name, "Event Saved Succcessfully");
    } catch (Exception e) {
        defaultview.message=new message("Error", e.getMessage());
    }

    return "redirect:/admin/event";
}  
@PostMapping(value = "/deletevent")
public String  deleteEvent(@RequestParam int id)  
{
    try {
        
        repo.deleteById(id);
        defaultview.message=new message("Delete", "Event Deleted Succcessfully");
    } catch (Exception e) {
        defaultview.message=new message("Error", e.getMessage());
    }

    return "redirect:/admin/event";
}  
}
