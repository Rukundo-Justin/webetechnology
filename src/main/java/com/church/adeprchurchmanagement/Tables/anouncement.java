package com.church.adeprchurchmanagement.Tables;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class anouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String head;
    private String description;
    private Date toDay;
    public anouncement(int id, String head, String description, Date toDay) {
        this.id = id;
        this.head = head;
        this.description = description;
        this.toDay = toDay;
    }
    public anouncement(){}
    public anouncement(String head, String description, Date toDay) {
        this.head = head;
        this.description = description;
        this.toDay = toDay;
    }
    public void setId(int id) {this.id = id;}
    public int getId() {return id;}    
    public String getHead() { return head;}  
    public String getDescription() { return description;}
    public Date getToDay() {return toDay;}
}
