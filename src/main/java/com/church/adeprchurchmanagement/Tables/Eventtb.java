package com.church.adeprchurchmanagement.Tables;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Eventtb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name; 
private String type; 
private Date fromDate;
private Date toDate;
private String Place;
private String participant;
public Eventtb(int id, String name, String type, Date fromDate, Date toDate, String place, String participant) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.fromDate = fromDate;
    this.toDate = toDate;
    Place = place;
    this.participant = participant;
}
public Eventtb(){}
public Eventtb(String name, String type, Date fromDate, Date toDate, String place, String participant) {
    this.name = name;
    this.type = type;
    this.fromDate = fromDate;
    this.toDate = toDate;
    Place = place;
    this.participant = participant;
}
public String getParticipant() {return participant;}
public String getPlace() { return Place;}
public Date getToDate() {return toDate;}
public Date getFromDate() {return fromDate;}
public String getType() {return type;}
public String getName() {return name;}
public int getId() {return id;}
public void setId(int id) {this.id = id;}
}
