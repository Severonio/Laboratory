package com.ntu.domain;

public class Load  {

    private long id;
    private String type;
    private String customer;
    private int made;
    private int weight;

    public Load() {
        super();
    }
    //����������� 2
    public Load(String type, String customer, int made, int weight) {
        super();
        this.type = type;
        this.customer = customer;
        this.made = made;
        this.weight = weight;
    }
    //����������� 3
    public Load(long id, String type, String customer, int made, int weight) {
        super();
        this.id = id;
        this.type = type;
        this.customer = customer;
        this.made = made;
        this.weight = weight;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getMade() {
        return made;
    }

    public void setMade(int made) {
        this.made = made;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(id=" + id + ") " + type + ", " + customer ;
    }
}
