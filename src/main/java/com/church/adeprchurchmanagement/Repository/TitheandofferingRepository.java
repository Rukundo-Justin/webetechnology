package com.church.adeprchurchmanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.church.adeprchurchmanagement.Tables.User;
import com.church.adeprchurchmanagement.Tables.titheandoffering;

public interface TitheandofferingRepository extends JpaRepository<titheandoffering,Integer>{
    @Query("select b from titheandoffering b where b.userid=?1")
    List<titheandoffering> findUserOffering(User id);
}
