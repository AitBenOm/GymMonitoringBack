package com.AitBenOm.GymMonitor.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Charge {

    @Id
    @GeneratedValue
    private Long idLoad;
    private String charge;
    @Temporal(TemporalType.DATE)
    private Date lastModification;

    @ManyToOne(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private Exercise exercise;

    public Long getIdLoad() {
        return idLoad;
    }

    public void setIdLoad(Long idLoad) {
        this.idLoad = idLoad;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Charge() {
    }

    public Charge(String load, Date lastModification) {
        this.charge = load;
        this.lastModification = lastModification;
    }


    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }
}
