package com.oosd.main;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.VBox;

/**
 * @author jt2-curtis
 */
public class Main extends Application {

    private int currentID = 0;
    private ComboBox<Team> cb = new ComboBox<>();

    private HashMap<Integer, Team> teams = new HashMap<>();
    private HashMap<Integer, Player> players = new HashMap<>();
    private HashMap<Integer, Match> matches = new HashMap<>();


    /**
     * @author jt2-curtis, a2-matuzeviciu
     *
     * @param name
     * @param teamID
     */
    public void addPlayer(String name, int teamID) {
        Player player = new Player(name, newID());
        players.put(player.getID(), player);

        // Retrieve team from teams, add playerID to team, return team to teams
        // TODO I think that this could potentially be written in one line of 
        // code using the HashMap.get() function but I'm not sure.
        Team team = teams.get(teamID);
        team.addPlayer(player.getID());
        teams.put(teamID, team);

        System.out.println("Player " + name + " " + player.getID() + " added to " + team.getName());
        
    }

    public void addTeam(String name) {

        for (Team teamName : teams.values()) {
            if (name.equals(teamName.toString())) {
                System.out.println("yes");
                showError("someone else took that name already");
                return;
            }
        }
        System.out.println("no");
        Team team = new Team(name, newID());
        teams.put(team.getId(), team);
        //TODO Move this 
        cb.getItems().add(team);

    }

    /**
     * generates matches
     * 
     * @author jt2-curtis, a2-matuzeviciu
     */
    //TODO Error management - if there are no teams, if there is an odd # of teams, any other errors
    public void generateMatches() {
        boolean b = false;
        for (int i : teams.keySet()) {
            System.out.println(teams.get(i));
            for (int j : teams.keySet()) {
                if (teams.get(i).toString().equals(teams.get(j).toString()) && !b) {
                    b = true;
                } else if (b) {
                    Match homeMatch = new Match(newID(), i, j);
                    Match awayMatch = new Match(newID(), j, i);
                    matches.put(homeMatch.getID(), homeMatch);
                    matches.put(awayMatch.getID(), awayMatch);
                    System.out.println("Match created: " + homeMatch.toString());
                    System.out.println("Match created: " + awayMatch.toString());
                }
            }
            b = false;
        }
    }

    /**
     * Finds the next integer that has not already been used as an ID. Should
     * only be called when creating a new Team, Player or Match.
     *
     * @return Suitable int.
     * @author jt2-curtis
     */
    public int newID() {
        //TODO - Do we want to reuse IDs in the event that we ever delete players/teams?
        //     - Should players/teams/matches have different ID continuity?
        currentID++;
        return currentID;
    }

    /**
     * @param errorText Text to be displayed. No more than two sentences.
     * @author jt2-curtis
     */
    public void showError(String errorText) {
        Alert alert = new Alert(Alert.AlertType.ERROR, errorText, ButtonType.OK);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    /**
     * Creates and applies stylisation to a GridPane.
     *
     * @return The correctly stylised GridPane.
     * @author jt2-curtis, a2-matuzeviciu
     * @usage GridPane gp = createGridPane();
     */
    public GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        //gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setMinSize(400, 100);
        gridPane.setStyle("-fx-padding: 5;" + "-fx-border-style: solid" + " inside;" + "-fx-border-radius: 4;");
        return gridPane;
    }

    public Tab createTab(String tabText) {
        Tab tab = new Tab();
        tab.setText(tabText);

        FlowPane contentPane = new FlowPane();
        contentPane.setOrientation(Orientation.VERTICAL);
        contentPane.setAlignment(Pos.CENTER);
        return tab;
    }
    
    //TODO think of a better name
    public VBox scoreTab() {
        VBox scorePane = new VBox();
        //scorePane.setAlignment(Pos.TOP_CENTER);
        
        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setStyle("-fx-padding: 5;");
        Button newSheet = new Button("New Sheet");
        Button modifySheet = new Button("Modify Sheet");
        //newSheet.setStyle("-fx-padding: 5;");
        //modifySheet.setStyle("-fx-padding: 5;");
        
        Separator sp = new Separator();
        //sp.setValignment(VPos.CENTER);
        
        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setStyle("-fx-padding: 5;");
        Label homeTeam = new Label("Home Team");
        Label awayTeam = new Label("Away Team");
        ComboBox<Team> ht = new ComboBox<>();
        ComboBox<Team> at = new ComboBox<>();
        
        hb.getChildren().add(newSheet);
        hb.getChildren().add(modifySheet);
        hb1.getChildren().add(homeTeam);
        hb1.getChildren().add(ht);
        hb1.getChildren().add(awayTeam);
        hb1.getChildren().add(at);
        
        GridPane gp = new GridPane();
        Label ss = new Label("Single Sets");
        Label ds = new Label("Double Sets");
        ComboBox<Player> ap = new ComboBox<>();
        ComboBox<Player> ap1 = new ComboBox<>();
        ComboBox<Player> hp = new ComboBox<>();
        ComboBox<Player> hp1 = new ComboBox<>();
        ap.setPrefWidth(164);
        ap1.setPrefWidth(164);
        hp.setPrefWidth(164);
        hp1.setPrefWidth(164);
        hp.setPrefHeight(79);
        hp1.setPrefHeight(79);
        ap.setPrefHeight(79);
        ap1.setPrefHeight(79);
        //
        gp.setGridLinesVisible(true);
        ss.setMaxWidth(Double.MAX_VALUE);
        ss.setAlignment(Pos.CENTER);
        ds.setMaxWidth(Double.MAX_VALUE);
        ds.setAlignment(Pos.CENTER);

        
        gp.setHgap(5);
        gp.setVgap(4);
        gp.setPadding(new Insets(4, 4, 4, 4));
        
        
        TextField s = new TextField("0:0");
        TextField s1 = new TextField("0:0");
        TextField s2 = new TextField("0:0");
        TextField s3 = new TextField("0:0");
        TextField s4 = new TextField("0:0");
        TextField s5 = new TextField("0:0");
        TextField s6 = new TextField("s6");
        TextField s7 = new TextField("0:0");
        TextField s8 = new TextField("0:0");
        TextField s9 = new TextField("0:0");
        TextField s10 = new TextField("0:0");
        TextField s11 = new TextField("0:0");
        TextField s12 = new TextField("0:0");
        TextField s13 = new TextField("0:0");
        TextField s14 = new TextField("0:0");
        
        TextField fts = new TextField("Final team scores");
        fts.setPrefHeight(79);
        
        VBox hpap = createScoreBox(s, s1, s2);
        VBox hpap1 = createScoreBox(s3, s4, s5);
        VBox hp1ap = createScoreBox(s6, s7, s8);
        VBox hp1ap1 = createScoreBox(s9, s10, s11);
        VBox hp2ap2 = createScoreBox(s12, s13, s14);

        gp.add(ss, 0, 0);
        gp.add(ap, 1, 0);
        gp.add(ap1, 2, 0);
        gp.add(hp, 0, 1);
        gp.add(hpap, 1, 1);
        gp.add(hpap1, 2, 1);
        gp.add(hp1, 0, 2);
        gp.add(hp1ap, 1, 2);
        gp.add(hp1ap1, 2, 2);
        gp.add(ds, 0, 3);
        gp.add(hp2ap2, 1, 3);
        gp.add(fts, 2, 3);
        

        scorePane.getChildren().add(hb);
        scorePane.getChildren().add(sp);
        scorePane.getChildren().add(hb1);
        scorePane.getChildren().add(gp);
        
        
        return scorePane;
    }

    
    public VBox createScoreBox(TextField tf, TextField tf1, TextField tf2) {
        
        VBox vBox = new VBox();
        vBox.setSpacing(2);
        vBox.getChildren().add(tf);
        vBox.getChildren().add(tf1);
        vBox.getChildren().add(tf2);
        return vBox;
    }
    
    /**
     * Initialises the UI and handles relationships between UI elements.
     *
     * @param primaryStage
     * @author jt2-curtis, a2-matuzeviciu
     */
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Brian's Ping Pong Administration Tool");
        primaryStage.setResizable(false);

        Group root = new Group();

        Scene scene = new Scene(root, 410, 455);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        BorderPane borderPane = new BorderPane();

        Tab adminTab = new Tab();
        adminTab.setText("Admin");
        FlowPane adminPane = new FlowPane(Orientation.VERTICAL);
        adminPane.setAlignment(Pos.CENTER);

        GridPane newTeamPane = createGridPane();

        Label newTeam = new Label("Enter a new team:");
        TextField teamName = new TextField();
        Button addTeam = new Button("Add Team");

        //TODO Learn how lambdas work
        addTeam.setOnAction(e -> addTeam(teamName.getText()));

        newTeamPane.add(newTeam, 0, 0);
        newTeamPane.add(teamName, 0, 1);
        newTeamPane.add(addTeam, 1, 1);

        GridPane newPlayerPane = createGridPane();
        cb.setPromptText("Select the team");

        Label newPlayer = new Label("Enter new player name:");
        TextField playerName = new TextField();
        Button addPlayer = new Button("Add player");

        addPlayer.setOnAction(e -> {
            try {
                if (playerName.getText() == null || playerName.getText().trim().isEmpty()) {
                    showError("Please specify player name.");
                } else if (cb.getValue() == null) {
                    showError("Please select a team.");
                } else {
                    addPlayer(playerName.getText(), cb.getValue().getId());
                }
            } catch (NullPointerException ex) {
                showError("Error: " + ex.getMessage());
            }
        });

        newPlayerPane.add(newPlayer, 0, 0);
        newPlayerPane.add(playerName, 0, 1);
        newPlayerPane.add(cb, 2, 1);
        newPlayerPane.add(addPlayer, 2, 3);

        GridPane generateMatchesPane = createGridPane();
        Label generateMatches = new Label("Generate a match between all teams.");
        Button generateMatchesBtn = new Button("Generate fixtures");

        generateMatchesBtn.setOnAction(e -> generateMatches());

        generateMatchesPane.add(generateMatches, 0, 0);
        generateMatchesPane.add(generateMatchesBtn, 0, 1);

        GridPane generateStatsPane = createGridPane();
        Label generateStats = new Label("Generate Stats");
        Button generateStatsBtn = new Button("Generate Stats");
        
        generateStatsBtn.setOnAction( e -> showError("WIP"));
        
        generateStatsPane.add(generateStats, 0, 0);
        generateStatsPane.add(generateStatsBtn, 0 , 1);

        adminPane.getChildren().add(newTeamPane);
        adminPane.getChildren().add(newPlayerPane);
        adminPane.getChildren().add(generateMatchesPane);
        adminPane.getChildren().add(generateStatsPane);

        adminPane.setVgap(5);

        adminTab.setContent(adminPane);
        tabPane.getTabs().add(adminTab);

        Tab viewerTab = new Tab();
        viewerTab.setText("Viewer");
        HBox hboxViewer = new HBox();
        hboxViewer.getChildren().add(new Label("Viewer"));
        hboxViewer.setAlignment(Pos.CENTER);
        viewerTab.setContent(hboxViewer);
        tabPane.getTabs().add(viewerTab);

        Tab tabScore = new Tab();
        tabScore.setText("Score");
        VBox scorePane = scoreTab();
        tabScore.setContent(scorePane);
        tabPane.getTabs().add(tabScore);

        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
