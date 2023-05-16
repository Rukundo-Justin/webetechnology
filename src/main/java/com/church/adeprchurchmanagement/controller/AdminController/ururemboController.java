package com.church.adeprchurchmanagement.controller.AdminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Service.ururemboService;
import com.church.adeprchurchmanagement.Tables.Ururembo;

@Controller
public class ururemboController {
    public message message;
    defaultview view=new defaultview();
    @Autowired
    private ururemboService ururembodao=new ururemboService();
    @Autowired
    ururemboService dao=new ururemboService();
   
    @PostMapping("/admin/ururembo/add")
    public String  getIndex(Model model,@RequestParam int id,@RequestParam("name")String name,@RequestParam String type,
    @RequestParam String foreignkey)
    {  Ururembo ururembo=null;
        if(foreignkey.equals("@"))
        {
            ururembo=new Ururembo(name, type);
        }
        else{
            int identity=Integer.parseInt(foreignkey);
            Ururembo rembo=dao.findById(identity);
            ururembo=new Ururembo(name, type, rembo);
        }
        try {
            
            dao.saveUrurembo(ururembo);
            defaultview.message=new message(ururembo.getName(), "has been Saved Successfull");
        model.addAttribute("message", message);
        } catch (Exception e) {
            defaultview.message=new message(e.getMessage(), "Already Exist");
            model.addAttribute("message", message);
        } 
        return "redirect:/admin/church";
    }
    @GetMapping(value="/admin/church/update")
    public String update(Model model,@RequestParam("id")int id,@RequestParam("name") String name)
    {   
        try {
            Ururembo u=new Ururembo();       
            dao.saveUrurembo(u);
            message message=new message(name, "Updated Successfully");
            defaultview.message=message;
        } catch (Exception e) {
            message message=new message(e.getMessage(), "Saved Successfully");
            defaultview.message=message;
        }
        model.addAttribute(name, message);
        List<Ururembo>getAll=ururembodao.getAllururembo();
        model.addAttribute("ururembolist",getAll);
        return "redirect:/admin/church";
    }
    @GetMapping(value="/admin/church/del")
    public String getDelete(Model model,@RequestParam("id")int id)
    {   
        String result= dao.delete(id);
        defaultview.message=new message("Ururembo", result);
        model.addAttribute("message", message);
        List<Ururembo>getAll=ururembodao.getAllururembo();
        model.addAttribute("ururembolist",getAll);
        return "redirect:/admin/church";
}
}
