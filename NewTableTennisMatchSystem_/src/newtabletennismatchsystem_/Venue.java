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
public class Venue {
    
    String venueName;
    
    public Venue(String name){
        this.venueName = name;
        
    }
    
    public String getName(){
        return venueName;
    }
    
    public void setName(String venueName){
        this.venueName = venueName;
    }
    
    
}

