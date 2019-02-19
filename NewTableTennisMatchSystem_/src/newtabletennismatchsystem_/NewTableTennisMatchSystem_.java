package newtabletennismatchsystem_;

import java.io.IOException;
import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 *
 * @author c23-day
 */
public class NewTableTennisMatchSystem_ extends Application{
    
    Stage window;
    private ComboBox <String> teamSelection = new ComboBox();
    private HashMap <String, String> teamPlayers = new HashMap<>();
    TextField teamNames = new TextField();   
    TextField playerName = new TextField();
    Button registerPlayer = null;
    
    public void addTeam(String name) {
        Team team = new Team(name);
        teamSelection.getItems().add(team.getName());
    }
    
    public void addPlayer(String teamName, String name) {
        Player player = new Player(name);
        teamPlayers.put(teamName, player.getPlayerName());
    }
   
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Ping Pong! Ping Pong! Ping Pong!");
        
        
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root,600, 448);
        
        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        
        //////////////////////////
        // First Tab/Admin page //
        //////////////////////////
        Tab adminTab = new Tab();
        adminTab.setText("Admin Page");
        FlowPane adminPage = new FlowPane();
        
        ////////////////
        // First Pane //
        ////////////////
        GridPane addTeamPane = new GridPane();
        addTeamPane.setMinSize(600, 100);
        addTeamPane.setStyle("-fx-border-style: solid;" + "-fx-border-radius: 5;");
        addTeamPane.setHgap(10);
        addTeamPane.setVgap(2);
        addTeamPane.setPadding(new Insets(10,10,10,10));
        
        Label enterTeam = new Label("Enter a new team:");
        TextField teamNames = new TextField();
        teamNames.setPromptText("Team Name Here");
        Button addTeam = new Button("Add Team");
        
        addTeamPane.add(enterTeam, 0, 0);
        addTeamPane.add(teamNames, 0, 1);
        addTeamPane.add(addTeam, 1, 1);
        
        addTeam.setOnAction(e -> {
            addTeam(teamNames.getText());
            teamNames.clear();
        });
      
        /////////////////
        // Second Pane //
        /////////////////
        GridPane addPlayer = new GridPane();
        addPlayer.setMinSize(600, 100);
        addPlayer.setStyle("-fx-border-style: solid;" + "-fx-border-radius: 5;");
        addPlayer.setHgap(10);
        addPlayer.setVgap(2);
        addPlayer.setPadding(new Insets(10,10,10,10));
        
        Label enterPlayerName = new Label("Please Enter Player Name:");
        TextField playerName = new TextField();
        playerName.setPromptText("Player Name Here");
        teamSelection.setValue("Select Team");
        registerPlayer = new Button("Register Player");
        
        addPlayer.add(enterPlayerName, 0, 0);
        addPlayer.add(playerName, 0, 1);
        addPlayer.add(teamSelection, 2, 1);
        addPlayer.add(registerPlayer, 2, 2);
        
        //TODO Enter Button and ComboBox functionality
        registerPlayer.setOnAction(e ->{
            addPlayer(teamSelection.getValue(), playerName.getText());
            playerName.clear();  
        });
            
        
        ////////////////
        // Third Pane //
        ////////////////
        GridPane generateFixtures = new GridPane();
        generateFixtures.setMinSize(600, 100);
        generateFixtures.setStyle("-fx-border-style: solid;" + "-fx-border-radius: 5;");
        generateFixtures.setHgap(10);
        generateFixtures.setVgap(2);
        generateFixtures.setPadding(new Insets(10,10,10,10));
        
        Label gFLabel = new Label("The Button Will Generate Match Fixtures Between All Teams");
        Label gFWarning = new Label("Warning! All Pre-Existing Match Info Will Be Replaced");
        gFWarning.setStyle("-fx-font-weight: bold");
        Button gMatch = new Button("Generate Match Fixtures");
        
        generateFixtures.add(gFLabel, 0, 0);
        generateFixtures.add(gFWarning, 0, 1);
        generateFixtures.add(gMatch, 0, 2);
        
        //TODO Enter Button functionality
        gMatch.setOnAction(e ->{
            
        });
        
        /////////////////
        // Fourth Pane //
        /////////////////
        GridPane teamStats = new GridPane();
        teamStats.setMinSize(600, 100);
        teamStats.setStyle("-fx-border-style: solid;" + "-fx-border-radius: 5;");
        teamStats.setHgap(10);
        teamStats.setVgap(2);
        teamStats.setPadding(new Insets (10,10,10,10));
       
        Label tSLabel = new Label("Team Stats Will Be Automatically Updated Every 100 Seconds");
        Label tSButtonLabel = new Label("You Can Also Update The Stats Manually With The Button -->");
        Button tSManual = new Button("Generate Team Stats");
        
         //TODO Enter Button functionality
        tSManual.setOnAction(e ->{
            
        });
        
        teamStats.add(tSLabel, 0, 0);
        teamStats.add(tSButtonLabel, 0, 1);
        teamStats.add(tSManual, 1, 1);
        
        ////////////////////////////
        // Second Tab/Viewer page //
        ////////////////////////////
        Tab viewerTab = new Tab();
        viewerTab.setText("Viewer Page");
        FlowPane viewerPane = new FlowPane();
        
        ///////////////////////////
        // Third Tab/Score Sheet //
        ///////////////////////////
        Tab scoreTab = new Tab();
        scoreTab.setText("Score Sheet");
        FlowPane scorePane = new FlowPane();
        
        GridPane showScorePane = new GridPane();
        showScorePane.setMinSize(600, 100);
        showScorePane.setStyle("-fx-border-style: solid");
        showScorePane.setHgap(10);
        showScorePane.setVgap(2);
        showScorePane.setPadding(new Insets(10,10,10,10));
        
        Button btnNewSheet = new Button("New Sheet");
        Button btnModifySheet = new Button("Modify Sheet");
        Label lblHomeTeam = new Label("Home team");
        awayTeamSelection.setValue("Select Team");
        Label lblAwayTeam = new Label("Home team");
        homeTeamSelection.setValue("Select Team");
        
        Label lblSingleSet = new Label("Single Set");      
        selAwayPlayer.setValue("Select Team");
        selHomePlayer.setValue("Select Team");
        Label lbl_S1 = new Label("0:0");   
        Label lbl_S2 = new Label("0:0");   
        Label lbl_S3 = new Label("0:0");   
        Label lbl_S4 = new Label("0:0");   
        Label lbl_S5 = new Label("0:0");   
        Label lbl_S6 = new Label("0:0");
        selHomePlayer.setValue("Select Team");
        selHomePlayer.setValue("Select Team");
        Label lbl_S7 = new Label("0:0");
        Label lbl_S8 = new Label("0:0");
        Label lbl_S9 = new Label("0:0");
        Label lbl_S10 = new Label("0:0");
        Label lbl_S11 = new Label("0:0");
        Label lbl_S12 = new Label("0:0");
        
        Label lblDoubleSet = new Label("Double set");
        Label lbl_S13 = new Label("0:0");
        Label lbl_S14 = new Label("0:0");
        Label lbl_S15 = new Label("0:0");
        Label lblFinalScore = new Label("Final team scores");
        Button btnCalculate = new Button("Calculate");
        
        showScorePane.add(btnNewSheet, 0, 0);
        showScorePane.add(btnModifySheet, 1, 0);
        showScorePane.add(lblHomeTeam, 2, 3);
        showScorePane.add(awayTeamSelection, 3, 3);
        showScorePane.add(lblAwayTeam, 4, 3);
        showScorePane.add(homeTeamSelection, 5, 3);
        
        showScorePane.add(lblSingleSet, 2, 4);       
        showScorePane.add(selAwayPlayer1, 3, 4);    
        showScorePane.add(selAwayPlayer2, 4, 4);
        showScorePane.add(lbl_S1, 3, 5);
        showScorePane.add(lbl_S2, 4, 5);
        showScorePane.add(lbl_S3, 3, 6);
        showScorePane.add(lbl_S4, 4, 6);
        showScorePane.add(lbl_S5, 3, 7);
        showScorePane.add(lbl_S6, 4, 7);      
        showScorePane.add(selHomePlayer1, 2, 5);       
        showScorePane.add(selHomePlayer2, 2, 6);
        showScorePane.add(lbl_S7, 3, 8);
        showScorePane.add(lbl_S8, 4, 8);
        showScorePane.add(lbl_S9, 3, 9);
        showScorePane.add(lbl_S10, 4, 9);
        showScorePane.add(lbl_S11, 3, 10);
        showScorePane.add(lbl_S12, 4, 10);
        
        showScorePane.add(lblDoubleSet, 2, 11);
        showScorePane.add(lbl_S13, 2, 11);
        showScorePane.add(lbl_S14, 2, 12);
        showScorePane.add(lbl_S15, 2, 13);
        showScorePane.add(lblFinalScore, 4, 11);       
        showScorePane.add(btnCalculate, 2, 14);    
        
        adminTab.setContent(adminPage);
        viewerTab.setContent(viewerPane);
        scoreTab.setContent(scorePane);
        
        tabPane.getTabs().add(adminTab);
        tabPane.getTabs().add(viewerTab);
        tabPane.getTabs().add(scoreTab);
        
        adminPage.getChildren().addAll(addTeamPane, addPlayer, generateFixtures, teamStats);
        
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
