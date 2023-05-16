package com.church.adeprchurchmanagement.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class assignDuty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    @ManyToOne()
    private User userId;   
    @ManyToOne()
    private Ururembo ururemboId;
    @ManyToOne()
    private duty dutyid;
    
    public assignDuty() {
    }
    public assignDuty(int id, User userId, Ururembo ururemboId, duty dutyid) {
        this.id = id;
        this.userId = userId;
        this.ururemboId = ururemboId;
        this.dutyid = dutyid;
    }
    public assignDuty(User userId, Ururembo ururemboId, duty dutyid) {
        this.userId = userId;
        this.ururemboId = ururemboId;
        this.dutyid = dutyid;
    }
    public duty getDutyid() {
        return dutyid;
    }
    public Ururembo getUruremboId() { return ururemboId;}
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}
    public User getUserId() {return userId;}
}
