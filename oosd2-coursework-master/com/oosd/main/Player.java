package com.oosd.main;

public class Player {

    private int id;
    private String name;
    
    public Player(String name, int id){
        this.name = name;
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
