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
public class Player {
    
    String playerName;
    
    public Player(String name){
        this.playerName = name;
    }
    
    public String getPlayerName(){
        return playerName;
    } 
    
    public void setPlayerName(String playerName){
        this.playerName = playerName; 
    }
}