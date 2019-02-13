/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oosd.main;

/**
 *
 * @author jt2-curtis
 */
public class Match {
    
    private int id;
    private int homeTeam;
    private int awayTeam;
    
    

    public Match(int id, int homeTeam, int awayTeam) {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + '}';
    }
    
    
}
