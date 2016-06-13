package com.necl.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblMaster_Section")
public class Section implements Serializable {

     public Section() {
    }

    public Section(String divisionCode, String sectionCode) {
        this.divisionCode = divisionCode;
        this.sectionCode = sectionCode;
    }

    public Section(String divisionCode, String sectionCode, String sectionName) {
        this.divisionCode = divisionCode;
        this.sectionCode = sectionCode;
        this.sectionName = sectionName;
    }
    
    @Id
    @Column(name = "DivisionCode", length = 20)
    private String divisionCode;
    
    @Id
    @Column(name = "SectionCode", length = 20)
    private String sectionCode;
    
    @Column(name = "SectionName")
    private String sectionName;

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    

}
