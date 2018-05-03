package com.ntu.domain;

import java.io.Serializable;
import java.sql.Date;

public class LoadRegister implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private Load load;
    private Date broughtDt;
    private OwnerList ownerList;
    private Date takenDt;

    public LoadRegister() {
        super();
    }

    //����������� 2
    public LoadRegister(Load load, Date broughtDt, OwnerList ownerList, Date takenDt) {
        super();
        this.load = load;
        this.broughtDt = broughtDt;
        this.ownerList = ownerList;
        this.takenDt = takenDt;
    }
    //����������� 3
    public LoadRegister(long id, Load load, Date broughtDt, OwnerList ownerList, Date takenDt) {
        super();
        this.id = id;
        this.load = load;
        this.broughtDt = broughtDt;
        this.ownerList = ownerList;
        this.takenDt = takenDt;
    }

    public LoadRegister(Load load, Date broughtDt, OwnerList ownerList) {
        super();
        this.load = load;
        this.broughtDt = broughtDt;
        this.ownerList = ownerList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public Date getBroughtDt() {
        return broughtDt;
    }

    public void setBroughtDt(Date broughtDt) {
        this.broughtDt = broughtDt;
    }

    public OwnerList getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(OwnerList ownerList) {
        this.ownerList = ownerList;
    }

    public Date getTakenDt() {
        return takenDt;
    }

    public void setTakenDt(Date takenDt) {
        this.takenDt = takenDt;
    }

    @Override
    public String toString() {
        return "LoadRegister [id=" + id + ", load=" + load.getId() + " - " + load.getType()+ " - " + load.getCustomer() + ", broughtDt=" + broughtDt + ", ownerList="
                + ownerList.getId() + " - " + ownerList.getFirstName() + " - " + ownerList.getLastName()+ " - " + ownerList.getPhone() + ", takenDt=" + takenDt + "]";
    }
}
