package com.church.adeprchurchmanagement.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.church.adeprchurchmanagement.Repository.userRepository;
import com.church.adeprchurchmanagement.Tables.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserServices {
    @PersistenceContext
    @Autowired
    private EntityManager entity;
   
    @Autowired
    private userRepository repo;
    public User saveUser(User user)
    { 
        return repo.save(user);
    }
    public List<User> getallLeaderList()
    {
       return repo.findAllururemboLeader();
    }
    public List<User> getAlluserList()
    {
       return repo.allSystemUser();
    }

    public void RequestRegisteredInchurch(int id,int church)
    {
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/adpr", "root", "");
            PreparedStatement st=conn.prepareStatement("update User set  request_church_id="+church+" where  id="+id+"");
            st.executeUpdate();
           
        } catch (Exception e) {
        }
    }
}