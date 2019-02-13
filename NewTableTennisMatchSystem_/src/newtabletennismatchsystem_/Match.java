/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtabletennismatchsystem_;

/**
 *
 * @author c23-day
 */
public class Match {
    
    String homeTeam;
    String awayTeam;
    int singleSets;
    int doubles;
    
    public Match(String home, String away, int singles, int doubles){
        this.homeTeam = home;
        this.awayTeam = away;
        this.singleSets = singles;
        this.doubles = doubles;
    }
    
    public String getHomeTeam(){
        return homeTeam;
    }
    
    public void setHomeTeam(String homeTeam){
        this.homeTeam = homeTeam;
    }
    
    public String getAwayTeam(){
        return awayTeam;
    }
    
    public void setAwayTeam(String awayTeam){
        this.awayTeam = awayTeam;
    }
    
    public int getSingleSets(){
        return singleSets;
    }
    
    public void setSingleSets(int singleSets){
        this.singleSets = singleSets;
    }
    
    public int getDoubles(){
        return doubles;
    }
    
    public void setDoubles(int doubles){
        this.doubles = doubles;
    }
}
