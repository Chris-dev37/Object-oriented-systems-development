/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtabletennismatchsystem_;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author c23-day
 */
public class controller {

    public Button addTeamButton;
    public Button addPlayer;
    public ArrayList<String> allTeams;
    public ComboBox<Team> selectTeamBox;
    
    public HashMap<Player, Team> teamAndPlayers;
    
    TextField addTeamNameText;
    TextField addNewPlayer;
    
  
    public void teamButton(){
        addTeamButton.setOnAction((ActionEvent e) -> {
            String newTeam = addTeamNameText.getText();
            allTeams.add(newTeam);
            System.out.println(allTeams);
        });
    }
   
    public void playerToTeamButton(){
        addPlayer.setOnAction((ActionEvent e) ->{
            String newPlayer = addNewPlayer.getText();
            String playersTeam = selectTeamBox.getText();
        });
    }
  
    
}
