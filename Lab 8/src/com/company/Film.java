package com.company;

import java.io.Serializable;

public class Film implements Serializable {
    private final String title;
    private final int year;
    private final String actor;
    private final String format;
    private final int sizeMb;
    private boolean available;
    private String dostup;

    public Film(String title, int year, String actor, String format, int sizeMb, String dostup) {
        this.title = title;
        this.year = year;
        this.actor = actor;
        this.format = format;
        this.sizeMb = sizeMb;
        this.available = true;
        this.dostup = dostup;

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getActor() {
        return actor;
    }

    public String getFormat() {
        return format;
    }

    public int getSizeMb() {
        return sizeMb;
    }

    public boolean isAvailable() {
        return available;
    }
    public String getDostup(){
        return dostup;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" " + "in " + year + ", actors: " + actor + ". Format " + format + " " + sizeMb + "," + dostup + ".";
    }
}
