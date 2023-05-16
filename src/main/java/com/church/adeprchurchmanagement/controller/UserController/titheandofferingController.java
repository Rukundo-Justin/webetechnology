package com.church.adeprchurchmanagement.controller.UserController;

import java.awt.print.PrinterException;
import java.util.Date;
import java.util.Random;

import javax.swing.JTextArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.church.adeprchurchmanagement.Messages.message;
import com.church.adeprchurchmanagement.Repository.TitheandofferingRepository;
import com.church.adeprchurchmanagement.Repository.UruremboRepository;
import com.church.adeprchurchmanagement.Repository.userRepository;
import com.church.adeprchurchmanagement.Service.userAuthorization;
import com.church.adeprchurchmanagement.Tables.Ururembo;
import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.Tables.titheandoffering;
import com.church.adeprchurchmanagement.controller.index;

@Controller
public class titheandofferingController {
    public static message message=new message("Welcome", "Welcome to tithe and offering Service ");
    @Autowired
    TitheandofferingRepository repo;
    @Autowired
    userRepository userrepo;
    @Autowired
    UruremboRepository ururemborepo;
    private userAuthorization auth=new userAuthorization();
    @GetMapping(value = "/user/tithe/{id}")
    public String getPage(Model model,@PathVariable String id)
    {  String identity=id;
       boolean isValid=auth.checkDataValidity(identity);
       if(isValid==true)
       {
        model.addAttribute(message.getMessageheader(), message.getMessagename());
        User user=index.user;
        double totalofferings=0;
        model.addAttribute("user", user);
        for(titheandoffering i:repo.findUserOffering(user))
                totalofferings=+i.getAmount();

        model.addAttribute("offeringlist", repo.findUserOffering(user));
        model.addAttribute("total",totalofferings);
        model.addAttribute("churchlist", ururemborepo.getAllChurch());
        return "userView/titheandoffering";
       }
       else{
        index.message=new message("Please Log in before Accessing Authorized page","");
        return "redirect:/";
       }
    }
    @PostMapping(value = "/addoffering/{userid}")
    public String addOffering(Model model,@RequestParam String category,@RequestParam double amount,@PathVariable String userid,@RequestParam int churchid)
    {
        boolean isValid=auth.checkDataValidity(userid);
       if(isValid==true)
       {
        Random rand=new Random();
        int rand1=rand.nextInt(10000);
        int rand2=rand.nextInt(10000);
        int rand3=rand.nextInt(10000);
        String randomnumber=rand1+"-"+rand2+"-"+rand3;
        User user=index.user;
        Ururembo ururembo=ururemborepo.findById(churchid);
        titheandoffering offer=new titheandoffering(category, amount, user, randomnumber,new Date(),ururembo);
        repo.save(offer);
        message=new message(category, "Saved Successfully");
        return "redirect:/user/tithe/"+userid+"";
       }
       else{
        return "redirect:/";
       }

       
    }
    @GetMapping(value = "/user/print/{id}")
    public String getPrint(Model model,@PathVariable String id) throws PrinterException
    {  String identity=id;
       boolean isValid=auth.checkDataValidity(identity);
       if(isValid==true)
       {
        model.addAttribute(message.getMessageheader(), message.getMessagename());
        User user=index.user;
        model.addAttribute("offeringlist", repo.findUserOffering(user));
        JTextArea text=new JTextArea();
        text.append("Name "+user.getName()+"\n"+"Gender "+user.getGender()+"\nPhone Number " +user.getPhoneNumber());
     
        double total=0;
        for(titheandoffering i:repo.findUserOffering(user))
        {   
            text.append("\n\n\n");
            text.append("Church Name::"+i.getUruremboid().getName()+"\nType Of Offering ::"
            +i.getCategory()+"\n"+"Payment Code ::"+i.getPaymentCode()+"\nPayment Date ::"+i.getIssuedDate()
            +"\nAmount ::"+i.getAmount()+" Frw"
            );
            total=total+i.getAmount();
        }

        text.append("\n\n=========================================================================\nTotal="+total+" Frw");
        text.append("\n\n\n\nThanks God Ble you!!!");
        text.print();
        return "redirect:/user/tithe/"+id;
       }
       else{
        index.message=new message("Please Log in before Accessing Authorized page","");
        return "redirect:/";
       }
    }
}
