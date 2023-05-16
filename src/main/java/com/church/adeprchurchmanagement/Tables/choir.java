package com.church.adeprchurchmanagement.Tables;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class choir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    private String name;
    private String President;
   
    private Date fromDate;
  
    @ManyToOne()
    private Ururembo churchmember;
    @Column(length = 15,unique = true)
    private String phone;
    private Date toDay;
    
    public choir(){}
    public choir(int id, String name, String president, Date fromDate, Ururembo churchmember, String phone,
            Date toDay) {
        this.id = id;
        this.name = name;
        President = president;
        this.fromDate = fromDate;
        this.churchmember = churchmember;
        this.phone = phone;
        this.toDay = toDay;
    }
    public choir(String name, String president, Date fromDate, Ururembo church, String phone,
    Date toDay) {
    this.name = name;
    President = president;
    this.fromDate = fromDate;
    churchmember = church;
    this.phone = phone;
    this.toDay = toDay;
    }
    public Ururembo getChurchmember() {return churchmember;}
    public Date getFromDate() {return fromDate;}
    public void setFromDate(Date fromDate) {this.fromDate = fromDate;}
    public String getPresident() {return President;}
    public String getName() {return name;}
    public int getId() {return id;}
    public Date getToDay() {return toDay;}
    public void setId(int id) { this.id = id;}
    public String getPhone() {return phone;}
}
