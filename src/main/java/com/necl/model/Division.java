package com.necl.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblMaster_Division")
public class Division implements Serializable{
    @Id
    @Column(name = "DivisionCode", length = 20)
    private String divisionCode;
    @Column(name = "DivisionName")
    private String divisionName;

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

 
}
