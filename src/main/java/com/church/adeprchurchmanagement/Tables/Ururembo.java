package com.church.adeprchurchmanagement.Tables;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Ururembo {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(unique = true)
private String name;
private String type;

@ManyToOne()
private Ururembo foreignkey;
@OneToMany(mappedBy = "church",cascade = CascadeType.REMOVE)
private List<User>users;
@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "foreignkey")
private List<Ururembo> getAll;
@OneToMany(mappedBy = "churchmember",cascade = CascadeType.REMOVE)
private List<choir>listofchoir;
@OneToMany(mappedBy = "ururemboId",cascade = CascadeType.REMOVE)
private List<assignDuty>listofassignedDuty;
@OneToMany(mappedBy = "ururemboid",cascade = CascadeType.REMOVE)
private List<titheandoffering> ururembooffer;
public List<titheandoffering> getUrurembooffer() { return ururembooffer;}
public List<assignDuty> getListofassignedDuty() { return listofassignedDuty;}
public Ururembo(String name, String type) {
    this.name = name;
    this.type = type;
}
public Ururembo(){}
public Ururembo( String name, String type, Ururembo foreignkey) {
    this.name = name;
    this.type = type;
    this.foreignkey = foreignkey;
}
public void setId(int id) {this.id = id;}
public Ururembo getForeignkey() {return foreignkey;}
public String getType() {return type;}
public String getName() { return name;}
public int getId() {return id;}
public List<Ururembo> getGetAll() {return getAll;}
public List<User> getUsers() {return users;}

}
