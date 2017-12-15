package gui;


import java.io.IOException;

import Controller.Studentcontrol;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 
         
/**
 * 
 * @author Deepanshu Adarsh
 * <p>Used to Control S.fxml</p>
 *
 */
public class Dashboard extends Application { 

   private Stage primaryStage;

   @Override
   public void start(Stage primaryStage) {
       this.primaryStage = primaryStage; // connect primary stage
       mainWindow();
   }

   // main window
   public void mainWindow() {
       try {
           // view
//    	   System.out.println(getClass().getResource("/ui/bookRoom.fxml"));
    	   
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/S.fxml"));
           loader.setController(new Studentcontrol());
           StackPane pane = loader.load();
//    	   AnchorPane pane = (AnchorPane) FXMLLoader.load(Dashboard.class.getResource("/ui/Search.fxml"));
    	   
           // controller
//           MainWindowController mainWindowController = loader.getController();
//           mainWindowController.setMain(this);

           // scene on stage
           Scene scene = new Scene(pane);
           primaryStage.setTitle("Wow!! Stackoverflow Icon");
           primaryStage.setScene(scene);
           primaryStage.show();

       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static void main(String[] args) {
       launch(args);
   }
}
