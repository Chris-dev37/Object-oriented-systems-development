package com.oosd.main;

import java.util.ArrayList;

public class Team {

    private int id;
    private String name;
    private ArrayList<Integer> players = new ArrayList<>();
    
    public void addPlayer(int playerID){
        players.add(playerID);
    }
    
    public Team(String name, int id){
        this.name = name;
        this.id = id;
        System.out.println("New Team created. Name: " + this.name + " ID: " + this.id);
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

    @Override
    public String toString() {
        return this.getName();
    }
    
    public int parseInt() {
        return this.getId();
    }

}
