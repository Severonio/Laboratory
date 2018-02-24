package com.company;

public class Chopper extends Motocycle {
    private int cost = 9000;
    private double engineSize = 1.450;
    public Chopper(String name, int speed){
        super.setName(name);
        super.setSpeed(speed);
    }
    @Override
    public void OutPut() {
        System.out.println(super.getName() + ", current speed = " + super.getSpeed());
        System.out.println("Price = " + cost +"$");
        System.out.println("Engine size: " + engineSize);
        super.getInformation();
    }
}
