/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtabletennismatchsystem_;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author chris
 */
public class fixturesAndResults {
    
    //////
    // this class creates a new window when the button 'viewFixRes' and displays the match scores.
    //////
    
    static Stage window = new Stage();
    static String uweVsPage, uweVsFilton, uweVsKcc, pageVsUwe, pageVsFilton, pageVsKcc, filtonVsUwe, filtonVsPage, filtonVsKcc, kccVsUwe, kccVsPage, kccVsFilton;
    
    
    public static void display(){
        window.setTitle("Fixtures & Results");
        window.setMinWidth(200);
        window.setMinHeight(200);
        
        FlowPane layout = new FlowPane();
        Scene scene = new Scene(layout);
        
        if (pageVsUwe == null){
            pageVsUwe = "np";
        }
        if (filtonVsUwe == null){
            filtonVsUwe = "np";
        }
        if (kccVsUwe == null){
            kccVsUwe = "np";
        }
        if (uweVsPage == null){
            uweVsPage = "np";
        }
        if (filtonVsPage == null){
            filtonVsPage = "np";
        }
        if (kccVsPage == null){
            kccVsPage = "np";
        }
        if (uweVsFilton == null){
            uweVsFilton = "np";
        }
        if (pageVsFilton == null){
            pageVsFilton = "np";
        }
        if (kccVsFilton == null){
            kccVsFilton = "np";
        }
        if (uweVsKcc == null){
            uweVsKcc = "np";
        }
        if (pageVsKcc == null){
            pageVsKcc = "np";
        }
        if (filtonVsKcc == null){
            filtonVsKcc = "np";
        }
        
        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(10,10,10,10));
        
        Label blank = new Label("---");
        Label uweLeft = new Label("UWE");
        Label pageLeft = new Label("Page");
        Label filtonLeft = new Label("Filton");
        Label kccLeft = new Label ("KCC");
        
        vbox1.getChildren().addAll(blank, uweLeft, pageLeft, filtonLeft, kccLeft);
        
        VBox vbox2 = new VBox();
        vbox2.setPadding(new Insets(10,10,10,10));
        
        Label uweTop = new Label("UWE");
        Label blank0 = new Label("---");
        Label pVu = new Label(pageVsUwe);
        Label fVu = new Label(filtonVsUwe);
        Label kVu = new Label(kccVsUwe);
        
        vbox2.getChildren().addAll(uweTop, blank0, pVu, fVu, kVu);
        
        VBox vbox3 = new VBox();
        vbox3.setPadding(new Insets(10,10,10,10));
        
        Label pageTop = new Label("Page");
        Label uVp = new Label(uweVsPage);
        Label blank2 = new Label("---");
        Label fVp = new Label(filtonVsPage);
        Label kVp = new Label(kccVsPage);
        
        vbox3.getChildren().addAll(pageTop, uVp, blank2, fVp, kVp);
        
        VBox vbox4 = new VBox();
        vbox4.setPadding(new Insets(10,10,10,10));
        
        Label filtonTop = new Label("Filton");
        Label uVf = new Label(uweVsFilton);
        Label pVf = new Label(pageVsFilton);
        Label blank3 = new Label("---");
        Label kVf = new Label(kccVsFilton);
        
        vbox4.getChildren().addAll(filtonTop, uVf, pVf, blank3, kVf);
        
        VBox vbox5 = new VBox();
        vbox5.setPadding(new Insets(10,10,10,10));
        
        Label kccTop = new Label("KCC");
        Label uVk = new Label(uweVsKcc);
        Label pVk = new Label(pageVsKcc);
        Label fVk = new Label(filtonVsKcc);
        Label blank4 = new Label("---");
        Label np = new Label("np = 'Not Played'");
        Button closeWindow = new Button("OK");
        closeWindow.setOnAction(e -> window.close());
        
        
        vbox5.getChildren().addAll(kccTop, uVk, pVk, fVk, blank4, closeWindow, np);
     
        layout.getChildren().addAll(vbox1, vbox2, vbox3, vbox4, vbox5);
        layout.setAlignment(Pos.CENTER);
        
        window.setScene(scene);
        window.show();

    }
}