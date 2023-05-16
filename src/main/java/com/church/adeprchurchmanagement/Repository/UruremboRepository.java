package com.church.adeprchurchmanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.church.adeprchurchmanagement.Tables.Ururembo;

public interface UruremboRepository extends JpaRepository<Ururembo,Integer>{
    @Query("select u from Ururembo u where u.type='URUREMBO'")
    List<Ururembo>getAllUrurembo();
    @Query("select u from Ururembo u where u.type='PARISH'")
    List<Ururembo>getAllParish();
    Ururembo findById(int id);
    @Query("select u from Ururembo u where u.type='CHURCH'")
    List<Ururembo>getAllChurch();
}
