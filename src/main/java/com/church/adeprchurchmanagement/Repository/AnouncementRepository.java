package com.church.adeprchurchmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.church.adeprchurchmanagement.Tables.anouncement;

public interface AnouncementRepository extends JpaRepository<anouncement,Integer>{
    
}
