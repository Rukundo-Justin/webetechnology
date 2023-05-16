package com.church.adeprchurchmanagement.Tables;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class duty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Name;
  
    public duty(int id, String name, String category) {
        Id = id;
        Name = name;
        this.category = category;
    }
    // Example Ururembo,Parish,Church
    private String category;
    public duty(){}
    public duty(String name, String category) {
        Name = name;
        this.category = category;
    }
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "duty")
    private List<User>users;
    @OneToMany(mappedBy="dutyid")
    private List<assignDuty>dutylist;
    public List<assignDuty> getDutylist() {
        return dutylist;
    }
    public List<User> getUsers() {
        return users;
    }
    public String getName() {
        return Name;}
    public int getId() {return Id;}
    public String getCategory() {
        return category;
    }
}
