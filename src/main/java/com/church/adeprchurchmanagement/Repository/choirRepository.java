package com.church.adeprchurchmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.church.adeprchurchmanagement.Tables.choir;

public interface choirRepository extends JpaRepository<choir,Integer>{
    
}
