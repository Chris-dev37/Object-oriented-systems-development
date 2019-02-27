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
    
    
    public Match(String home, String away){
        this.homeTeam = home;
        this.awayTeam = away;
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
    
}
