package com.church.adeprchurchmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.church.adeprchurchmanagement.Tables.Eventtb;

public interface EventRepository extends JpaRepository<Eventtb,Integer>{
    
}
