package com.church.adeprchurchmanagement.Tables;

import java.util.List;

import jakarta.persistence.*;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   public void setId(int id) {
        this.id = id;
    }
private String name;
   private String gender;
   @Column(unique=true)
   private String email;
   @Column(unique = true)
   private String phoneNumber;
   private String password;
    private String role;
    @ManyToOne()
    private duty duty;
    private String location;
    @ManyToOne()
    private Ururembo church; 
    private int requestChurchId;
    private int transeferchurchid;
    @OneToMany(mappedBy = "userid")
    private List<titheandoffering>listofoffering;
    @OneToMany(mappedBy = "userId")
    private List<assignDuty>assigndutylist;
    @Column(columnDefinition = "longBlob")
    private String profile;
    
    public List<assignDuty> getAssigndutylist() {
        return assigndutylist;
    }
    public User(){ }
    public User(String profile,String name, String gender, String phoneNumber, String email, String password, String role,
    String location) {
    this.name = name;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.role = role;
    this.location = location;
    this.profile=profile;
}
    public User( String name, String gender, String phoneNumber, String email, String password,String role,duty duty,String location,Ururembo church) {
    this.name = name;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.role=role;
    this.duty=duty;
    this.location=location;
    this.church=church;
}  
public String getRole() {
    return role;
}
    public String getPassword() {
    return password;
}

    public String getEmail() {
    return email;
}
public Ururembo getChurch() {
    return church;
}
    public String getPhoneNumber() {
    return phoneNumber;
}

    public String getGender() {
    return gender;
}

public String getName() {
    return name;
}

public int getId() {
    return id;
}

public String getLocation() {
    return location;
}
public duty getDuty() {
    return duty;
}
public List<titheandoffering> getListofoffering() {
    return listofoffering;
}
public String getProfile() {
    return profile;
}
public int getRequestChurchId() {
    return requestChurchId;
}
public void setRequestChurchId(int requestChurchId) {
    this.requestChurchId = requestChurchId;
}
public int getTranseferchurchid() {
    return transeferchurchid;
}
public void setTranseferchurchid(int transeferchurchid) {
    this.transeferchurchid = transeferchurchid;
}
}
