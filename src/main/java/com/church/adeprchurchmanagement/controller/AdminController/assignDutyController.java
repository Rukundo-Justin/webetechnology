package com.church.adeprchurchmanagement.controller.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.AssignDutyRepository;
import com.church.adeprchurchmanagement.Repository.Dutyrepository;
import com.church.adeprchurchmanagement.Repository.UruremboRepository;
import com.church.adeprchurchmanagement.Repository.userRepository;
import com.church.adeprchurchmanagement.Tables.Ururembo;
import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.Tables.assignDuty;
import com.church.adeprchurchmanagement.Tables.duty;

@Controller
public class assignDutyController {
    @Autowired
    private AssignDutyRepository repo;
    @Autowired
    private Dutyrepository dutyrepo;
    @Autowired
    private userRepository userrepo;
    @Autowired
    private UruremboRepository ururemboRepo;
    @PostMapping(value = "/assignduty")
    public String addDuty(Model model,@RequestParam int userid,@RequestParam int ururemboid,@RequestParam int dutyid)
    {
        User user=userrepo.findById(userid);
        Ururembo ururembo=ururemboRepo.findById(ururemboid);
        duty dut=dutyrepo.findById(dutyid);
        assignDuty asignduty=new assignDuty(user, ururembo, dut);
        repo.save(asignduty);
        DutyController.message=new message(user.getName(), "has assigned position of"+dut.getName());
        return "redirect:/admin/duty";
    }
}
