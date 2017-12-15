package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Adarsh and Deepanshu contribution page
 *
 * This program creates a GUI layout with 
 * a GridPane.
 *
 * Author: Adarsh Kumar and Deepanshu kumain
 * 
 * Last modified: November 2017
 */

public class help extends Application {

    @Override
    public void start(Stage stage1) {

        initUI(stage1);
    }

    private void initUI(Stage stage1) {

        GridPane root = new GridPane();
        root.setHgap(1);
        root.setVgap(1);
        root.setPadding(new Insets(1));
        
        
        
        
        
        Text lbl=new Text();
        lbl.setStyle("-fx-font-family: Frijole; -fx-font-size: 20;");
        lbl.setText("About The Designer :");
        
        lbl.setFill(Color.AQUAMARINE);
        lbl.setX(90); 
	    lbl.setY(80); 
	    lbl.setTranslateX(40);
	    lbl.setTranslateY(0);
	    Text lbl1=new Text();
	    Text lbl3=new Text();
	    Text lbl2=new Text();
	    lbl1.setText("Contributed By");
	    lbl1.setStyle("-fx-font-family: Frijole; -fx-font-size: 20;");
        lbl2.setText("Adarsh Kumar");
        lbl2.setStyle("-fx-font-family: Frijole; -fx-font-size: 15;");
        lbl3.setText("Deepanshu Kumain");
        lbl3.setTranslateX(200);
	    lbl3.setTranslateY(65);
        lbl3.setStyle("-fx-font-family: Frijole; -fx-font-size: 15;");
        lbl1.setFill(Color.GREY);
        lbl2.setFill(Color.DARKCYAN);
        lbl3.setFill(Color.DARKCYAN);
	    ProgressBar pb = new ProgressBar(-1);
	    ProgressIndicator pi = new ProgressIndicator(0.5);
	    ProgressBar pb1 = new ProgressBar(-1);
	    ProgressIndicator pi1 = new ProgressIndicator(0.5);
	    pb.setTranslateX(10);pb.setTranslateY(110);
	    pi.setTranslateX(0);pi.setTranslateY(120);
	    pb1.setTranslateX(250);pb1.setTranslateY(110);
	    pi1.setTranslateX(230);pi1.setTranslateY(120);
	    Button back=new Button("BACK");
	    back.setOnAction((ActionEvent e) -> {
	        Welcome rev=new Welcome();
	        try {
				rev.start(stage1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    back.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);-fx-background-radius: 30;-fx-background-insets: 0;-fx-text-fill: white;");
        root.setStyle("-fx-text-fill: white; -fx-font-family: Courier New ;-fx-font-weight: bold;-fx-background-color: linear-gradient(#FFAFBD,#ffc3a0);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
//        TextField field = new TextField();
//        ListView view = new ListView();
        //Button okBtn = new Button("OK");
        //Button closeBtn = new Button("Close");

       // GridPane.setHalignment(okBtn, HPos.RIGHT);

        root.add(lbl, 0, 0);
        root.add(lbl1, 0, 2);
        root.add(lbl2, 0, 4);
        root.add(lbl3, 0, 0);
        root.add(pb, 0, 0);
        root.add(pi, 0, 0);
        root.add(pb1, 0, 0);
        root.add(pi1, 0, 0);
        root.add(back, 1, 80);
       
        
        Scene scene = new Scene(root, 400, 200);
        scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Frijole");
        stage1.setTitle("About APP");
        stage1.setScene(scene);
        stage1.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
