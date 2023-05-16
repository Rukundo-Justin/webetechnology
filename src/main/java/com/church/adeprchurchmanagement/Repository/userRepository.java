package com.church.adeprchurchmanagement.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.church.adeprchurchmanagement.Tables.User;
public interface userRepository  extends JpaRepository<User,Integer>{
    @Query("SELECT u FROM User u where role='admin 1'")
    List<User> findAllururemboLeader(); 
    @Query("SELECT u FROM User u where role='USER'")
    List<User> allSystemUser(); 
    User findById(int id);
    @Query("select u from User u where u.email=?1 and u.password=?2")
    User findByEmailAndpassword(String email,String pasword);
    @Query("update User u set  u.requestChurchId=?2 where  u.id=?1")
    void RequestRegistration( int userId, int church);
}