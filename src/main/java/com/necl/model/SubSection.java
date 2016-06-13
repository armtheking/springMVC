package com.necl.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblMaster_SubSection")
public class SubSection implements Serializable {

    public SubSection() {
    }

    public SubSection(String divisionCode, String sectionCode, String subSectionCode) {
        this.divisionCode = divisionCode;
        this.sectionCode = sectionCode;
        this.subSectionCode = subSectionCode;
    }

    public SubSection(String divisionCode, String sectionCode, String subSectionCode, String subSectionName, Boolean status) {
        this.divisionCode = divisionCode;
        this.sectionCode = sectionCode;
        this.subSectionCode = subSectionCode;
        this.subSectionName = subSectionName;
        this.status = status;
    }

    @Id
    @Column(name = "DivisionCode", length = 20)
    private String divisionCode;

    @Id
    @Column(name = "SectionCode", length = 20)
    private String sectionCode;

    @Id
    @Column(name = "SubSectionCode", length = 20)
    private String subSectionCode;

    @Column(name = "SubSectionName")
    private String subSectionName;

    @Column(name = "Status", columnDefinition = "BIT default 0", nullable = false)
    private Boolean status = false;

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

    public String getSubSectionCode() {
        return subSectionCode;
    }

    public void setSubSectionCode(String subSectionCode) {
        this.subSectionCode = subSectionCode;
    }

    public String getSubSectionName() {
        return subSectionName;
    }

    public void setSubSectionName(String subSectionName) {
        this.subSectionName = subSectionName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    

}
