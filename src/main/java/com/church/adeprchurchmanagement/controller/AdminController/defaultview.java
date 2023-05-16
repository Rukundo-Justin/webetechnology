package com.church.adeprchurchmanagement.controller.AdminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.AnouncementRepository;
import com.church.adeprchurchmanagement.Repository.EventRepository;
import com.church.adeprchurchmanagement.Repository.TitheandofferingRepository;
import com.church.adeprchurchmanagement.Repository.choirRepository;
import com.church.adeprchurchmanagement.Service.UserServices;
import com.church.adeprchurchmanagement.Service.ururemboService;
import com.church.adeprchurchmanagement.Tables.Ururembo;
import com.church.adeprchurchmanagement.Tables.User;
@Controller
public class defaultview {

    public static message message=new message("Welcome", "welcome to Church management");;
    @Autowired
    private ururemboService ururembodao=new ururemboService();
    @Autowired
    private EventRepository eventrepo;
    @Autowired
    UserServices userdao=new UserServices();
    @Autowired
    choirRepository choirrepo;
    @Autowired
    private TitheandofferingRepository offeringrepo;
    @GetMapping(value="/admin")
    public String getAdmin()
    {
        return "adminView/index";
    }
    @GetMapping(value="/admin/church")
    public String getChurch(Model model)
    {  
        model.addAttribute("message", message);
        List<Ururembo>getAll=ururembodao.getAllururembo();
        model.addAttribute("ururembolist",getAll);
        model.addAttribute("parishlist",ururembodao.getAllParish());
        model.addAttribute("ururemboLeaderlist", userdao.getallLeaderList());
        return "adminView/church/church";
    }
    @Autowired
    AnouncementRepository anouncementrepo;
    @GetMapping(value="/admin/anouncement")
    public String getAnouncement(Model model)
    {   model.addAttribute("message", message);
        model.addAttribute("anouncement", anouncementrepo.findAll());
        return "adminView/church/anouncement";
    }

    @GetMapping(value="/admin/event")
    public String getEvent(Model model)
    { model.addAttribute("message", message);
      model.addAttribute("event", eventrepo.findAll());
        return "adminView/church/event";
    }
    @GetMapping(value="/admin/user")
    public String getUsers(Model model)
    {  User usr=new User();
        if(usr.getChurch()==null)
        {
            System.out.println("getAdmin()");
        }
        model.addAttribute("message", message);
         model.addAttribute("user", userdao.getAlluserList());
        return "adminView/church/user";
    }

    @GetMapping(value="/admin/tithe")
    public String getTithe(Model model)
    {   model.addAttribute("offeringlist", offeringrepo.findAll());
        return "adminView/church/tithe";
    }
    @GetMapping(value="/admin/choir")
    public String getChoir(Model model)
    {   model.addAttribute("message", message);
        model.addAttribute("parishlist",ururembodao.getAllParish());
        model.addAttribute("church",ururembodao.getAllcHURCH());
        model.addAttribute("choir", choirrepo.findAll());
        return "adminView/church/choir";
    }
    @GetMapping(value="/user")
    public String getUser()
    {
        return "userView/index";
    }
    @PostMapping(value = "/createururembo")
   public void CreateUrurrembo(Model model,@RequestParam("name") String name)
   {
    
   } 
   @GetMapping(value="/admin/membership")
   public String getMembership()
   {
       return "adminView/church/membership";
   }
}
