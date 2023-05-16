package com.church.adeprchurchmanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.church.adeprchurchmanagement.Tables.assignDuty;

public interface AssignDutyRepository extends JpaRepository<assignDuty,Integer>{
   @Query("select u,c,a from User u,Ururembo c,assignDuty a where u.id=?1")
    List<Object[]>getUserDuty(int id); 
}
