package com.church.adeprchurchmanagement.Tables;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class titheandoffering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String category;    
    private double amount;
    private String paymentCode;
    @ManyToOne()
    private  User userid;
    private Date issuedDate;
    @ManyToOne()
    private Ururembo ururemboid;
    public titheandoffering(){}
    public titheandoffering(String category, double amount, User userid,String paymentCode,Date issuedDate,Ururembo ururemboid) {
        this.category = category;
        this.amount = amount;
        this.userid = userid;
        this.paymentCode=paymentCode;
        this.issuedDate=issuedDate;
        this.ururemboid=ururemboid;
    }
    public String getPaymentCode() {
        return paymentCode;
    }
    public Ururembo getUruremboid() {
        return ururemboid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public double getAmount() {
        return amount;
    }
    public User getUserid() {
        return userid;
    }
    public Date getIssuedDate() {
        return issuedDate;
    }
}
