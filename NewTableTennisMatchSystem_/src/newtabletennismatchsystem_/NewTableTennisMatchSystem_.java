package newtabletennismatchsystem_;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
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
import javafx.stage.Stage;
/**
 *
 * @author c23-day
 */
public class NewTableTennisMatchSystem_ extends Application{
    
    Stage window;
    private final ComboBox <String> teamSelection = new ComboBox(); 
    private final ComboBox <String> scoreHomeTeam = new ComboBox(); 
    private final ComboBox <String> scoreAwayTeam = new ComboBox(); 
    private final ComboBox <String> homeBox = new ComboBox<>();
    private final ComboBox <String> homeBox2 = new ComboBox<>();
    private final ComboBox <String> awayBox = new ComboBox<>();
    private final ComboBox <String> awayBox2 = new ComboBox<>();
    private final HashMap <String, String> teamPlayers = new HashMap<>();
    Integer [] sortTeamRankings;
    List<String> homeTeamPlayers = new ArrayList();
    List<String> awayTeamPlayers = new ArrayList();
    int uweVsPage, uweVsFilton, uweVsKcc, pageVsUwe, pageVsFilton, pageVsKcc, filtonVsUwe, filtonVsPage, filtonVsKcc, kccVsUwe, kccVsPage, kccVsFilton;
    int uweMatchesPlayed, uweMatchesWon, uweSetsWon, pageMatchesPlayed, pageMatchesWon, pageSetsWon, filtonMatchesPlayed, filtonMatchesWon, filtonSetsWon, kccMatchesPlayed, kccMatchesWon, kccSetsWon;
    int arrayLength;
    
    TextField teamNames = new TextField();   
    TextField playerName = new TextField();
    Button registerPlayer = null;

    public NewTableTennisMatchSystem_() {
        this.sortTeamRankings = new Integer[]{uweSetsWon, pageSetsWon, filtonSetsWon, kccSetsWon};
        
    }
    
    public void addTeam(String name) {                  //////
        Team team = new Team(name);                     // creates an object of the 'Team' class and adds the name parameter to the teamSelection comboBox.
        teamSelection.getItems().add(team.getName());   //////
    }
    
    public void addPlayer(String teamName, String name) {
        Player player = new Player(name);                               //////
        teamPlayers.put(teamName, player.getPlayerName());              // creates an object of the 'Player' class then adds the name parameter and the teamName parameter to the HashMap teamPlayers.
        System.out.println(name + " has been added to " + teamName);    //////
        };
    
    public void generateMatches (String homeTeam, String awayTeam){
        boolean bool = false;
    
        for (String i : teamPlayers.keySet()){                                  
            for (String j : teamPlayers.keySet()){                              
                if (teamPlayers.get(i).equals(teamPlayers.get(j)) && !bool){    //////    
                    bool = true;                                                //////    
                }else if (bool){                                                // comparing key(i) and key(j) from the teamPlayers HashMap. if they dont match then they are placed in object of the 'Matches' class.
                    Match matches = new Match(i,j);                             // then (i) and (j) is added into seperate comboBoxes placed on the score sheet.
                    scoreHomeTeam.getItems().add(matches.getHomeTeam());        //////
                    scoreAwayTeam.getItems().add(matches.getAwayTeam());        //////
                    
                    for (String x : teamPlayers.keySet()){
                        for (String z : teamPlayers.values()){                  //////
                            if(x.equals(i)){                                    //////        
                                homeBox.getItems().add(z);                      //////
                                homeBox2.getItems().add(z);                     // here, x is used to find the key that matches i and z is used to get the value connected with the key. 
                            }                                                   // z is then added to the comboBoxes placed on the score sheet.
                        }                                                       //////
                    }                                                           //////
                    for (String x : teamPlayers.keySet()){                      //////        
                        for (String z : teamPlayers.values()){
                            if(x.equals(j)){
                                awayBox.getItems().add(z);
                                awayBox2.getItems().add(z);
                            }
                        }       
                    }   
                    System.out.println("\nMatch created between "+ i + " & "+ j);
                    bool = false;
                }
            }
        }
    }
    
    public void finalScoresCal(String homeTeam,String awayTeam,String finalScore,String lbl_S1,String lbl_S3,String lbl_S5,String lbl_S7,String lbl_S9,String lbl_S11,String lbl_S2,String lbl_S4,String lbl_S6,String lbl_S8,String lbl_S10,String lbl_S12){
        char charAtZero = finalScore.charAt(0);                                 //////
        char charAtTwo = finalScore.charAt(2);                                  //////
        String eleven = "1";                                                    // this function is activated after the user has pressed the 'calculateFinalScore' button.
                                                                                // it will then check the textfields where the scores are added and increment setsWon if their side had reached 11 and matchesWon if they have the greater final score.     
        switch (homeTeam) {                                                     //////                                                  
            case "uwe":                                                         //////                                                
                uweMatchesPlayed =+ 1;                                                                                          
                if (charAtZero > charAtTwo){                                                                                    
                    uweMatchesWon =+ 1;                                                                                         
                } if (lbl_S1.length() >= 3 && lbl_S1.charAt(0) == eleven.charAt(0) && lbl_S1.charAt(1) == eleven.charAt(0)){       
                    uweSetsWon =+ 1;                                                                                            
                } if (lbl_S3.length() >= 3 && lbl_S3.charAt(0) == eleven.charAt(0) && lbl_S3.charAt(1) == eleven.charAt(0)){     
                    uweSetsWon =+ 1;
                } if (lbl_S5.length() >= 3 && lbl_S5.charAt(0) == eleven.charAt(0) && lbl_S5.charAt(1) == eleven.charAt(0)){
                    uweSetsWon =+ 1;
                } if (lbl_S7.length() >= 3 && lbl_S7.charAt(0) == eleven.charAt(0) && lbl_S7.charAt(1) == eleven.charAt(0)){
                    uweSetsWon =+ 1;
                } if (lbl_S9.length() >= 3 && lbl_S9.charAt(0) == eleven.charAt(0) && lbl_S9.charAt(1) == eleven.charAt(0)){
                    uweSetsWon =+ 1;
                } if (lbl_S11.length() >= 3 && lbl_S11.charAt(0) == eleven.charAt(0) && lbl_S11.charAt(1) == eleven.charAt(0)){
                    uweSetsWon =+ 1;
                }   break;
            case "page":
                pageMatchesPlayed =+ 1;
                if (charAtZero > charAtTwo){
                    pageMatchesWon =+ 1;
                } if (lbl_S1.length() >= 3 && lbl_S1.charAt(0) == eleven.charAt(0) && lbl_S1.charAt(1) == eleven.charAt(0)){
                    pageSetsWon =+ 1;
                } if (lbl_S3.length() >= 3 && lbl_S3.charAt(0) == eleven.charAt(0) && lbl_S3.charAt(1) == eleven.charAt(0)){
                    pageSetsWon =+ 1;
                } if (lbl_S5.length() >= 3 && lbl_S5.charAt(0) == eleven.charAt(0) && lbl_S5.charAt(1) == eleven.charAt(0)){
                    pageSetsWon =+ 1;
                } if (lbl_S7.length() >= 3 && lbl_S7.charAt(0) == eleven.charAt(0) && lbl_S7.charAt(1) == eleven.charAt(0)){
                    pageSetsWon =+ 1;
                } if (lbl_S9.length() >= 3 && lbl_S9.charAt(0) == eleven.charAt(0) && lbl_S9.charAt(1) == eleven.charAt(0)){
                    pageSetsWon =+ 1;
                } if (lbl_S11.length() >= 3 && lbl_S11.charAt(0) == eleven.charAt(0) && lbl_S11.charAt(1) == eleven.charAt(0)){
                    pageSetsWon =+ 1;
                }   break;
            case "filton":
                filtonMatchesPlayed =+ 1;
                if (charAtZero > charAtTwo){
                    filtonMatchesWon =+ 1;
                } if (lbl_S1.length() >= 3 && lbl_S1.charAt(0) == eleven.charAt(0) && lbl_S1.charAt(1) == eleven.charAt(0)){
                    filtonSetsWon =+ 1;
                } if (lbl_S3.length() >= 3 && lbl_S3.charAt(0) == eleven.charAt(0) && lbl_S3.charAt(1) == eleven.charAt(0)){
                    filtonSetsWon =+ 1;
                } if (lbl_S5.length() >= 3 && lbl_S5.charAt(0) == eleven.charAt(0) && lbl_S5.charAt(1) == eleven.charAt(0)){
                    filtonSetsWon =+ 1;
                } if (lbl_S7.length() >= 3 && lbl_S7.charAt(0) == eleven.charAt(0) && lbl_S7.charAt(1) == eleven.charAt(0)){
                    filtonSetsWon =+ 1;
                } if (lbl_S9.length() >= 3 && lbl_S9.charAt(0) == eleven.charAt(0) && lbl_S9.charAt(1) == eleven.charAt(0)){
                    filtonSetsWon =+ 1;
                } if (lbl_S11.length() >= 3 && lbl_S11.charAt(0) == eleven.charAt(0) && lbl_S11.charAt(1) == eleven.charAt(0)){
                    filtonSetsWon =+ 1;
                }   break;
            case "kcc":
                kccMatchesPlayed =+ 1;
                if (charAtZero > charAtTwo){
                    kccMatchesWon =+ 1;
                } if (lbl_S1.length() >= 3 && lbl_S1.charAt(0) == eleven.charAt(0) && lbl_S1.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S3.length() >= 3 && lbl_S3.charAt(0) == eleven.charAt(0) && lbl_S3.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S5.length() >= 3 && lbl_S5.charAt(0) == eleven.charAt(0) && lbl_S5.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S7.length() >= 3 && lbl_S7.charAt(0) == eleven.charAt(0) && lbl_S7.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S9.length() >= 3 && lbl_S9.charAt(0) == eleven.charAt(0) && lbl_S9.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S11.length() >= 3 && lbl_S11.charAt(0) == eleven.charAt(0) && lbl_S11.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                }   break;
            default:
                break;
        }
        switch (awayTeam) {
            case "uwe":
                uweMatchesPlayed =+ 1;
                if (charAtZero < charAtTwo){
                    uweMatchesWon =+ 1;
                } if (lbl_S2.length() >= 3 && lbl_S2.charAt(0) == eleven.charAt(0) && lbl_S2.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S4.length() >= 3 && lbl_S4.charAt(0) == eleven.charAt(0) && lbl_S4.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S6.length() >= 3 && lbl_S6.charAt(0) == eleven.charAt(0) && lbl_S6.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S8.length() >= 3 && lbl_S8.charAt(0) == eleven.charAt(0) && lbl_S8.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S10.length() >= 3 && lbl_S10.charAt(0) == eleven.charAt(0) && lbl_S10.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S12.length() >= 3 && lbl_S12.charAt(0) == eleven.charAt(0) && lbl_S12.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;  
                }   break;
            case "page":
                pageMatchesPlayed =+ 1;
                if (charAtZero < charAtTwo){
                    pageMatchesWon =+ 1;
                } if (lbl_S2.length() >= 3 && lbl_S2.charAt(0) == eleven.charAt(0) && lbl_S2.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S4.length() >= 3 && lbl_S4.charAt(0) == eleven.charAt(0) && lbl_S4.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S6.length() >= 3 && lbl_S6.charAt(0) == eleven.charAt(0) && lbl_S6.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S8.length() >= 3 && lbl_S8.charAt(0) == eleven.charAt(0) && lbl_S8.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S10.length() >= 3 && lbl_S10.charAt(0) == eleven.charAt(0) && lbl_S10.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S12.length() >= 3 && lbl_S12.charAt(0) == eleven.charAt(0) && lbl_S12.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;  
                }   break;
            case "filton":
                filtonMatchesPlayed =+ 1;
                if (charAtZero < charAtTwo){
                    filtonMatchesWon =+ 1;
                } if (lbl_S2.length() >= 3 && lbl_S2.charAt(0) == eleven.charAt(0) && lbl_S2.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S4.length() >= 3 && lbl_S4.charAt(0) == eleven.charAt(0) && lbl_S4.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S6.length() >= 3 && lbl_S6.charAt(0) == eleven.charAt(0) && lbl_S6.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S8.length() >= 3 && lbl_S8.charAt(0) == eleven.charAt(0) && lbl_S8.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S10.length() >= 3 && lbl_S10.charAt(0) == eleven.charAt(0) && lbl_S10.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S12.length() >= 3 && lbl_S12.charAt(0) == eleven.charAt(0) && lbl_S12.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;  
                }   break;
            case "kcc":
                kccMatchesPlayed =+ 1;
                if (charAtZero < charAtTwo){
                    kccMatchesWon =+ 1;
                } if (lbl_S2.length() >= 3 && lbl_S2.charAt(0) == eleven.charAt(0) && lbl_S2.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S4.length() >= 3 && lbl_S4.charAt(0) == eleven.charAt(0) && lbl_S4.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S6.length() >= 3 && lbl_S6.charAt(0) == eleven.charAt(0) && lbl_S6.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S8.length() >= 3 && lbl_S8.charAt(0) == eleven.charAt(0) && lbl_S8.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S10.length() >= 3 && lbl_S10.charAt(0) == eleven.charAt(0) && lbl_S10.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;
                } if (lbl_S12.length() >= 3 && lbl_S12.charAt(0) == eleven.charAt(0) && lbl_S12.charAt(1) == eleven.charAt(0)){
                    kccSetsWon =+ 1;  
                }   break;
            default:
                break;
        }
         
    }
    public void showTeamRankings(){
            Arrays.sort(sortTeamRankings, Collections.reverseOrder());
            arrayLength = sortTeamRankings.length;                              //////
            int i = 0;                                                          //////
            int j = 0;                                                          // here, teams 'setsWon' is used to orginise the team rankings with the most sets won being first and least being last.   
                                                                                //////
            while (i<arrayLength){                                              //////    
                if(sortTeamRankings[j] == uweSetsWon ){
                    System.out.println("UWE: Matches Played: " + uweMatchesPlayed + ", Matches Won: "+ uweMatchesWon +", Sets Won: "+sortTeamRankings[i]+"\n");
                    j++;
                    }
                    else if(sortTeamRankings[j] == pageSetsWon ){
                        System.out.println("Page: Matches Played: " + pageMatchesPlayed + ", Matches Won: "+ pageMatchesWon +", Sets Won: "+sortTeamRankings[i]+"\n");
                        j++;
                    }
                    else if(sortTeamRankings[j] == filtonSetsWon ){
                        System.out.println("Filton: Matches Played: " + filtonMatchesPlayed + ", Matches Won: "+ filtonMatchesWon +", Sets Won: "+sortTeamRankings[i]+"\n");
                        j++;
                    }
                    else if(sortTeamRankings[j] == kccSetsWon ){
                        System.out.println("KCC: Matches Played: " + kccMatchesPlayed + ", Matches Won: "+ kccMatchesWon +", Sets Won: "+sortTeamRankings[i]+"\n");
                        j++;
                    }
                i++;
            }
        }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Ping Pong! Ping Pong! Ping Pong!");
        
        
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 680, 448);
        
        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        
        //////////////////////////
        // First Tab/Admin page //
        //////////////////////////
        Tab adminTab = new Tab();
        adminTab.setText("Admin Page");
        FlowPane adminPane = new FlowPane();
        
        ////////////////
        // First Pane //
        ////////////////
        GridPane addTeamPane = new GridPane();
        addTeamPane.setMinSize(680, 100);
        addTeamPane.setStyle("-fx-border-style: solid;" + "-fx-border-radius: 5;");
        addTeamPane.setHgap(10);
        addTeamPane.setVgap(2);
        addTeamPane.setPadding(new Insets(10,10,10,10));
        
        Label enterTeam = new Label("Enter a new team:");
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
        addPlayer.setMinSize(680, 100);
        addPlayer.setStyle("-fx-border-style: solid;" + "-fx-border-radius: 5;");
        addPlayer.setHgap(10);
        addPlayer.setVgap(2);
        addPlayer.setPadding(new Insets(10,10,10,10));
        
        Label enterPlayerName = new Label("Please Enter Player Name:");
        playerName.setPromptText("Player Name Here");
        teamSelection.setValue("Select Team");
        registerPlayer = new Button("Register Player");
        
        addPlayer.add(enterPlayerName, 0, 0);
        addPlayer.add(playerName, 0, 1);
        addPlayer.add(teamSelection, 2, 1);
        addPlayer.add(registerPlayer, 2, 2);
        
        registerPlayer.setOnAction(e ->{
            addPlayer(teamSelection.getValue(), playerName.getText());
            playerName.clear();  
        });
        
        ////////////////
        // Third Pane //
        ////////////////
        GridPane generateFixtures = new GridPane();
        generateFixtures.setMinSize(680, 100);
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
        
        
        gMatch.setOnAction(e -> generateMatches("a","b"));
        
        /////////////////
        // Fourth Pane //
        /////////////////
        GridPane teamStats = new GridPane();
        teamStats.setMinSize(680, 100);
        teamStats.setStyle("-fx-border-style: solid;" + "-fx-border-radius: 5;");
        teamStats.setHgap(10);
        teamStats.setVgap(2);
        teamStats.setPadding(new Insets (10,10,10,10));
       
        Label tSLabel = new Label("Team Stats Will Be Automatically Updated Every 100 Seconds");
        Label tSButtonLabel = new Label("You Can Also Update The Stats Manually With The Button -->");
        
        Button tSManual = new Button("Generate Team Stats");
        tSManual.setOnAction(e -> System.out.println("UWE: Matches Played: " + uweMatchesPlayed + ", Matches Won: "+ uweMatchesWon +", Sets Won: "+ uweSetsWon +
                "\nPage: Matches Played: " + pageMatchesPlayed + ", Matches Won: "+ pageMatchesWon +", Sets Won: "+ pageSetsWon + 
                "\nFilton: Matches Played: " + filtonMatchesPlayed + ", Matches Won: "+ filtonMatchesWon +", Sets Won: "+ filtonSetsWon +
                "\nKCC: Matches Played: " + kccMatchesPlayed + ", Matches Won: "+ kccMatchesWon +", Sets Won: "+ kccSetsWon +"\n"
        ));
        
        //////////////////////////////////////
        //Print Team Stats Every 100 Seconds//
        //////////////////////////////////////
        Timer time = new Timer();
        time.schedule(new printStats(), 0, 100000);
        System.out.println(time);
        
        teamStats.add(tSLabel, 0, 0);
        teamStats.add(tSButtonLabel, 0, 1);
        teamStats.add(tSManual, 1, 1);
        
        ////////////////////////////
        // Second Tab/Viewer page //
        ////////////////////////////
        Tab viewerTab = new Tab();
        viewerTab.setText("Viewer Page");
        FlowPane viewerPane = new FlowPane();
        
        //////////////
        //First Pane//
        //////////////
        GridPane btns = new GridPane();
        btns.setVgap(10);
        btns.setHgap(2);
        btns.setPadding(new Insets(10,10,10,10));
        
        Button viewFixRes = new Button("View Fixture and Results Chart");
        viewFixRes.setOnAction(e -> fixturesAndResults.display());
        
        Button showAllTeamStats = new Button("Show All Team Stats");
        showAllTeamStats.setOnAction(e -> System.out.println("UWE: Matches Played: " + uweMatchesPlayed + ", Matches Won: "+ uweMatchesWon +", Sets Won: "+ uweSetsWon +
                "\nPage: Matches Played: " + pageMatchesPlayed + ", Matches Won: "+ pageMatchesWon +", Sets Won: "+ pageSetsWon + 
                "\nFilton: Matches Played: " + filtonMatchesPlayed + ", Matches Won: "+ filtonMatchesWon +", Sets Won: "+ filtonSetsWon +
                "\nKCC: Matches Played: " + kccMatchesPlayed + ", Matches Won: "+ kccMatchesWon +", Sets Won: "+ kccSetsWon +"\n"
        ));
         
        Button teamRankings = new Button("Show All Team Rankings");
        teamRankings.setOnAction(e -> showTeamRankings());
        
        
        btns.add(viewFixRes, 0, 0);
        btns.add(showAllTeamStats, 0, 1);
        btns.add(teamRankings, 0, 2);
        
        ///////////////
        //Second Pane//
        ///////////////
        
        GridPane displayBtnsData = new GridPane();
        displayBtnsData.setPadding(new Insets(10,10,10,10));
        
        TextField displayInfo = new TextField();
        displayInfo.setMinSize(300, 400);
        
        displayBtnsData.add(displayInfo, 0, 0);
        
        ///////////////////////////
        // Third Tab/Score Sheet //
        ///////////////////////////
        Tab scoreTab = new Tab();
        scoreTab.setText("Score Sheet");
        FlowPane scorePane = new FlowPane();
        
        //////////////
        //First Pane//
        //////////////
        GridPane newModPane = new GridPane();
        newModPane.setHgap(10);
        newModPane.setVgap(2);
        newModPane.setPadding(new Insets(10,10,10,10));
        
        Button btnNewSheet = new Button("New Sheet");
        Button btnModifySheet = new Button("Modify Sheet");
        Label lblHomeTeam = new Label("Home team:");
        scoreHomeTeam.setValue("Select Team");
        Label lblAwayTeam = new Label("Away team:");
        scoreAwayTeam.setValue("Select Team");
            
        ///////////////
        //Second Pane//
        ///////////////
        GridPane showScorePane = new GridPane();
        showScorePane.setMinSize(680, 100);
        showScorePane.setHgap(10);
        showScorePane.setVgap(2);
        showScorePane.setPadding(new Insets(10,10,10,10));
        
        Label lblSingleSet = new Label("Single Set");
        lblSingleSet.setStyle("-fx-font-weight: bold");
        homeBox.setValue("Select Player"); 
        homeBox2.setValue("Select Player"); 
        TextField lbl_S1 = new TextField("0:0");   
        TextField lbl_S2 = new TextField("0:0");   
        TextField lbl_S3 = new TextField("0:0");   
        TextField lbl_S4 = new TextField("0:0");   
        TextField lbl_S5 = new TextField("0:0");   
        TextField lbl_S6 = new TextField("0:0");
        awayBox.setValue("Select Player");
        awayBox2.setValue("Select Player");
        TextField lbl_S7 = new TextField("0:0");
        TextField lbl_S8 = new TextField("0:0");
        TextField lbl_S9 = new TextField("0:0");
        TextField lbl_S10 = new TextField("0:0");
        TextField lbl_S11 = new TextField("0:0");
        TextField lbl_S12 = new TextField("0:0");
        
        Label lblDoubleSet = new Label("Double set");
        lblDoubleSet.setStyle("-fx-font-weight: bold");
        TextField lbl_S13 = new TextField("0:0");
        TextField lbl_S14 = new TextField("0:0");
        TextField lbl_S15 = new TextField("0:0");
        TextField lblFinalScore = new TextField();
        lblFinalScore.setPromptText("Enter Final. E.G 4:2");
        Button calculateFinalScore = new Button("Calculate and Save Scores");
        
        calculateFinalScore.setOnAction(e -> {
            finalScoresCal(scoreHomeTeam.getValue(), scoreAwayTeam.getValue(), lblFinalScore.getText(),lbl_S1.getText(), lbl_S3.getText(), lbl_S5.getText(), lbl_S7.getText(), lbl_S9.getText(), lbl_S11.getText(), lbl_S2.getText(), lbl_S4.getText(), lbl_S6.getText(), lbl_S8.getText(), lbl_S10.getText(), lbl_S12.getText());
                });
        
        
        newModPane.add(btnNewSheet, 0, 0);
        newModPane.add(btnModifySheet, 1, 0);
        
        newModPane.add(lblHomeTeam, 3, 0);
        newModPane.add(scoreHomeTeam, 4, 0);
        newModPane.add(lblAwayTeam, 5, 0);
        newModPane.add(scoreAwayTeam, 6, 0);
        
        showScorePane.add(lblSingleSet, 0, 7);       
        showScorePane.add(awayBox, 0, 8);    
        showScorePane.add(homeBox, 1, 7);
        showScorePane.add(lbl_S1, 1, 8);
        showScorePane.add(lbl_S2, 2, 8);
        showScorePane.add(lbl_S3, 1, 9);
        showScorePane.add(lbl_S4, 2, 9);
        showScorePane.add(lbl_S5, 1, 10);
        showScorePane.add(lbl_S6, 2, 10);      
        showScorePane.add(awayBox2, 0, 11);       
        showScorePane.add(homeBox2, 2, 7);
        showScorePane.add(lbl_S7, 1, 11);
        showScorePane.add(lbl_S8, 2, 11);
        showScorePane.add(lbl_S9, 1, 12);
        showScorePane.add(lbl_S10, 2, 12);
        showScorePane.add(lbl_S11, 1, 13);
        showScorePane.add(lbl_S12, 2, 13);
        
        showScorePane.add(lblDoubleSet, 0, 15);
        showScorePane.add(lbl_S13, 1, 14);
        showScorePane.add(lbl_S14, 1, 15);
        showScorePane.add(lbl_S15, 1, 16);
        showScorePane.add(lblFinalScore, 2, 15);
        showScorePane.add(calculateFinalScore, 3, 17);
        
        
        adminTab.setContent(adminPane);
        viewerTab.setContent(viewerPane);
        scoreTab.setContent(scorePane);
        
        tabPane.getTabs().add(adminTab);
        tabPane.getTabs().add(viewerTab);
        tabPane.getTabs().add(scoreTab);
        
        adminPane.getChildren().addAll(addTeamPane, addPlayer, generateFixtures, teamStats);
        viewerPane.getChildren().addAll(btns, displayBtnsData);
        scorePane.getChildren().addAll(newModPane,showScorePane);
        
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        window.setScene(scene);
        window.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
