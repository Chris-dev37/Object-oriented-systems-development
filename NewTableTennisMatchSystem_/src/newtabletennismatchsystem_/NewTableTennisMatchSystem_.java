package newtabletennismatchsystem_;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public void start(Stage primaryStage) throws IOException{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXML.GUI.fxml"));
        window.setTitle("Table Tennis Match and Score System");
        window.setScene(new Scene(root, 700, 400));
        window.show();
        
       
  
    }
  
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /*@Override // Base stage
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Script for changing between scenes
     //button 1
        Label label1 = new Label("welcome to the first screen");
        Button button1 = new Button("Go to scene 2!");
        button1.setOnAction(e -> window.setScene(scene2));
        
        //layout1
        HBox layout1 = new HBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 600, 600);
        
        //button 2
        Button button2 = new Button("This scene bad, go back");
        button2.setOnAction(e -> window.setScene(scene1));
        
        //layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 600);
        
        window.setScene(scene1);
        window.setTitle("WOOOOOO");
        window.show();
    
    
    */
}