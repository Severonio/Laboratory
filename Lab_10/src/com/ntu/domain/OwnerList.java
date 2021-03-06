package com.ntu.domain;

import java.io.Serializable;
import java.sql.Date;


public class OwnerList implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private Date birthDt;
    private String address;

    //����������� 1
    public OwnerList() {
        super();
    }

    //����������� 2
    public OwnerList(String firstName, String middleName, String lastName, String phone, Date birthDt, String address) {
        super();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDt = birthDt;
        this.address = address;
    }

    public OwnerList(long id, String firstName, String middleName, String lastName, String phone, Date birthDt, String address) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthDt = birthDt;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(Date birthDt) {
        this.birthDt = birthDt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return "(id=" + id + ") " + firstName + " " + ((middleName != null)?middleName:"") + " "
                + lastName;
    }









}
