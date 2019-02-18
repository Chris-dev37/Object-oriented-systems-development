package newtabletennismatchsystem_;

import java.io.IOException;
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
    
    
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Ping Pong! Ping Pong! Ping Pong!");
        ComboBox <String> teamSelection = new ComboBox();
        
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root,600, 430);
        
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
        addTeamPane.setStyle("-fx-border-style: solid");
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
            teamSelection.getItems().add(teamNames.getText());
            teamNames.clear();        
        });
      
        /////////////////
        // Second Pane //
        /////////////////
        GridPane addPlayer = new GridPane();
        addPlayer.setMinSize(600, 100);
        addPlayer.setStyle("-fx-border-style: solid");
        addPlayer.setHgap(10);
        addPlayer.setVgap(2);
        addPlayer.setPadding(new Insets(10,10,10,10));
        
        Label enterPlayerName = new Label("Please Enter Player Name:");
        TextField playerName = new TextField();
        playerName.setPromptText("Player Name Here");
        teamSelection.setValue("Select Team");
        Button registerPlayer = new Button("Register Player");
        
        addPlayer.add(enterPlayerName, 0, 0);
        addPlayer.add(playerName, 0, 1);
        addPlayer.add(teamSelection, 2, 1);
        addPlayer.add(registerPlayer, 2, 2);
        
        //TODO Enter Button and ComboBox functionality
        registerPlayer.setOnAction(e -> {
            
        });
        
        ////////////////
        // Third Pane //
        ////////////////
        GridPane generateFixtures = new GridPane();
        generateFixtures.setMinSize(600, 100);
        generateFixtures.setStyle("-fx-border-style: solid");
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
        
        /////////////////
        // Fourth Pane //
        /////////////////
        GridPane teamStats = new GridPane();
        teamStats.setMinSize(600, 100);
        teamStats.setStyle("-fx-border-style: solid");
        teamStats.setHgap(10);
        teamStats.setVgap(2);
        teamStats.setPadding(new Insets (10,10,10,10));
       
        Label tSLabel = new Label("Team Stats Will Be Automatically Updated Every 100 Seconds");
        Label tSButtonLabel = new Label("You Can Also Update The Stats Manually With The Button -->");
        Button tSManual = new Button("Generate Team Stats");
        
         //TODO Enter Button functionality
        
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