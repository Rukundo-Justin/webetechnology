package com.church.adeprchurchmanagement.controller.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.AppSecurity.userSecurity;
import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.Dutyrepository;
import com.church.adeprchurchmanagement.Service.UserServices;
import com.church.adeprchurchmanagement.Service.ururemboService;
import com.church.adeprchurchmanagement.Tables.Ururembo;
import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.Tables.duty;
import com.church.adeprchurchmanagement.validation.Auth_validation;
@Controller
public class leaderController {
    Auth_validation auth=new Auth_validation();
    userSecurity  usersecurity=new userSecurity();
    @Autowired
    UserServices userdao=new UserServices();
    @Autowired
    Dutyrepository dutydao;
    @Autowired
    ururemboService ururembodao=new ururemboService();
    @PostMapping("/dutiesmanagement")
    public String getsignup(Model model,@RequestParam("name") String name,
    @RequestParam("gender") String gender,@RequestParam("phone") String phone,
    @RequestParam("email") String email,@RequestParam("location") String location,
    @RequestParam("role") String role,@RequestParam("duty") int dutyId,@RequestParam int churchid)
    { 
            String password=usersecurity.encryptePassword("admin");
             email=usersecurity.encrypteEmail(email);
             duty du=dutydao.findById(dutyId);
             Ururembo church=ururembodao.findById(churchid);
               User user=new User(name, gender, phone, email, password, role, du, location, church);
                try {
                    userdao.saveUser(user);
                    defaultview.message=new message(user.getName(), "Saved Successfully");
                } catch (Exception e) {
                   defaultview.message=new message(e.getMessage(), "Credential Arleady Exist");
                }
            return "redirect:/admin/church";
}
}
