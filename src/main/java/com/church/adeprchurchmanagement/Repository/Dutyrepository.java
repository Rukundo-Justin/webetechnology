package com.church.adeprchurchmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.church.adeprchurchmanagement.Tables.duty;

public interface Dutyrepository extends JpaRepository<duty,Integer>{
   duty findById(int id);

}
