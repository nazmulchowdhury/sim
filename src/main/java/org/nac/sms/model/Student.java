package org.nac.sms.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import org.nac.sms.validator.NID;
import org.nac.sms.validator.Roll;
import org.nac.sms.validator.CGPA;
import org.nac.sms.validator.Word;
import org.nac.sms.validator.Blood;
import org.nac.sms.validator.Phone;

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Word
    private String name;
    @Roll
    private String roll;
    @Email
    @Size(min = 5, max = 30)
    private String email;
    @Word
    private String district;
    @Column(name = "phone")
    @Phone
    private String phoneNumber;
    @CGPA
    private String cgpa;
    @Column(name = "blood_group")
    @Blood
    private String bloodGroup;
    @NID
    private String nid;

    public Student() {
    }

    public Student(String name, String roll, String email, String district,
            String phoneNumber, String cgpa, String bloodGroup, String nid) {
        this.name = name;
        this.roll = roll;
        this.email = email;
        this.district = district;
        this.phoneNumber = phoneNumber;
        this.cgpa = cgpa;
        this.bloodGroup = bloodGroup;
        this.nid = nid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }
}
