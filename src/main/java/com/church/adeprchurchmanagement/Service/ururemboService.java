package com.church.adeprchurchmanagement.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.adeprchurchmanagement.Repository.UruremboRepository;
import com.church.adeprchurchmanagement.Tables.Ururembo;

@Service
public class ururemboService {
 @Autowired
 private UruremboRepository repo;   
 public Ururembo saveUrurembo(Ururembo ururembo)
 {
    return repo.save(ururembo);
 }
 public List<Ururembo>getAllururembo()
 {
    return repo.getAllUrurembo();
 }
 public List<Ururembo>getAllParish()
 {
    return repo.getAllParish();
 }
public String delete(int id){
 try {
   repo.deleteById(id);
   return " Deleted Sucessfully";
 } catch (Exception e) {
 return e.getMessage();
 }
}
public Ururembo findById(int id)
{
   return repo.findById(id);  
}
   public List<Ururembo>getAllcHURCH()
    {
      return repo.getAllChurch();
    }
}