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
public class Team {
    
    String teamName;
    
    public Team(String name){
        this.teamName = name;
        System.out.println("New Team " + name + " Added.");
    }
    
    public String getName(){
        return teamName;
    }
    public void setName(String teamName){
        this.teamName = teamName;
        
    }
    
    
    @Override
    public String toString(){
        return this.getName();
  
    }

}