package com.persistent.aicrew.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="Underwriting")
public class Underwriting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "bmi")
    private Long bmi;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "medical_history")
    private String medicalHistory;

    @Column(name = "risk_meter")
    private Long riskMeter;

    @Column(name = "rate_meter")
    private Long rateMeter;

    @Column(name = "approved")
    private String approved;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getBmi() {
        return bmi;
    }

    public void setBmi(Long bmi) {
        this.bmi = bmi;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Long getRiskMeter() {
        return riskMeter;
    }

    public void setRiskMeter(Long riskMeter) {
        this.riskMeter = riskMeter;
    }

    public Long getRateMeter() {
        return rateMeter;
    }

    public void setRateMeter(Long rateMeter) {
        this.rateMeter = rateMeter;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }
}
