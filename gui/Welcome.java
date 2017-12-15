package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
/**
 * 
 * @author adarsh
 * @author Deepanshu
 * <h1>WelCome Page</h1>
 * <p> this the Welcome Page From here U can Go to the Following
 *      <ul>
 *     <li> SignUP</li>
 *     <li>Login</li>
 *     <li>About Page</li>
 *     
 *      </ul>
 * </p>
 */
public class Welcome extends Application {
	/**
	 * <p>this is Start() method from here it creates the Stage etc</p>
	 *@throws Exception
	 */
	
	@Override
	public void start(Stage stage1) throws Exception {
		EventHandler<ActionEvent> action = changeTabPlacement(stage1);
		GridPane root = new GridPane();
		Text text = new Text();
		Text text1 = new Text();
		Group one=new Group();
		text.setStyle("-fx-font-family: Frijole; -fx-font-size: 50;");
		text1.setStyle("-fx-font-family: Frijole; -fx-font-size: 30;");
		
	      //setting the position of the text 
	      text.setX(190); 
	      text.setY(80);          
	      text1.setX(80); 
	      text1.setY(140);
	      //Setting the text to be added. 
	      text.setText("Welcome");
	      text1.setText("BOOK_YOUR_CLASS_ROOM");
//		   Image image4 = new Image(new FileInputStream("D:\\books\\javascript\\HTML and CSS\\giphy.gif"),300,200,false,true);

//		   ImageView imageView1 = new ImageView(image4);
//		      imageView1.setX(200); 
//		      imageView1.setY(210);
		      MenuBar menuBar = new MenuBar();
		      Menu menu1 = new Menu("User");
		      Menu x = new Menu();
		     MenuItem menu2 = new MenuItem("Login");
		     menu2.setOnAction(action);
		     MenuItem menu4 = new MenuItem("Sign Up");
		     menu4.setOnAction(action);
		     menu4.setStyle("-fx-text-fill: white; -fx-font-family: Courier New ;-fx-font-weight: bold;-fx-background-color: linear-gradient(#ed4264,#ffedbc);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
		     menu2.setStyle("-fx-text-fill: white; -fx-font-family: Courier New ;-fx-font-weight: bold;-fx-background-color: linear-gradient(#ed4264,#ffedbc);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
		     menu1.getItems().add(menu2);
		     menu1.getItems().add(menu4);
		       Menu menu3 = new Menu("Help");
		       
		       MenuItem top = new MenuItem("about");
		       top.setStyle("-fx-text-fill: white; -fx-font-family: Courier New ;-fx-font-weight: bold;-fx-background-color: linear-gradient(#ed4264,#ffedbc);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
		       top.setOnAction(action);
		       
		       menu3.getItems().add(top);
		       
		       menu2.setOnAction(action);
		     
		       menu1.setOnAction(action);
		       
		      
		     
		      menuBar.getMenus().addAll(menu1,x, menu3);
	       menuBar.setStyle("-fx-text-fill: white; -fx-font-family: Courier New ;-fx-font-weight: bold;-fx-background-color: linear-gradient(#ed4264,#ffedbc);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
	      menuBar.setLayoutY(190);

	      menuBar.setLayoutX(290);
	      //Retrieving the observable list object 
	      ObservableList<Node> list = one.getChildren(); 
	      

		
//		stage1.getIcons().add(new Image(new FileInputStream("D://books//javascript//HTML and CSS//template//index3.jpg")));
		 stage1.setTitle("Sign-Up MENU");
		  list.add(text); 
		  list.add(text1);
//		  list.add(imageView1);
		  list.add(menuBar);
		 
		  
		  //list.add(k);
		 Scene scene1=new Scene(one,700,400);
		 Stop[] stops = new Stop[] { new Stop(0, Color.DARKCYAN), new Stop(1, Color.TURQUOISE)};
		 LinearGradient wtz=new LinearGradient(0, 0, 1, 0,true,CycleMethod.NO_CYCLE, stops);
		 scene1.setFill(wtz);
		
		 scene1.getStylesheets().add("http://fonts.googleapis.com/css?family=Frijole");
		 
		 stage1.setScene(scene1);
		 

			//then you set to your node
		 
		 stage1.setResizable(false);
	     stage1.show();
	     
	        
	}
	  /**
	   * Main class of Welcome.java 
	   * @param args
	   */
	
	public static void main(String[] args) {
		launch(args);

	}

	/**
	 * @see EventHandler<ActionEvent> 
	 * @param stage1
	 * <h3>This is an eventListner</h3>
	 * <p>Basically it is a Button action listener this will remotely helps to 
	 * Move to Gui of SignUp, About and Login page
	 * </p>
	 * 
	 */
	   private EventHandler<ActionEvent> changeTabPlacement(Stage stage1) {
	        return new EventHandler<ActionEvent>() {
	        	/**
	        	 * @param event
	        	 * <p>It is Used to handle Events After clicking the data</p>
	        	 */
	            public void handle(ActionEvent event) {
	                MenuItem mItem = (MenuItem) event.getSource();
	                String side = mItem.getText();
	                if ("Sign Up".equalsIgnoreCase(side)) {
	                	 SignUp ctc = new SignUp();
	 	                Stage stage = new Stage();
	 	               /**
	 		        	 * @exception FileNotFoundException
	 		        	 * 
	 		        	 */
	 	                try {
	 						
	 						ctc.start(stage);
	 						//stage1.close();
	 						
	 					} catch (FileNotFoundException e) {
	 						// TODO Auto-generated catch block
	 						e.printStackTrace();
	 					}
	                }else if ("about".equalsIgnoreCase(side)) {
	                    help h=new help();
	                    Stage stage = new Stage();
	 					h.start(stage);
						//stage1.close();
	                }else if ("top".equalsIgnoreCase(side)) {
		                    System.out.println("top");
	                } else if ("Login".equalsIgnoreCase(side)) {
	                LoginT ctc = new LoginT();
	                Stage stage = new Stage();
					try {
						
						ctc.start(stage);
						//stage1.close();
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	                }
	            }
	        };
	    }


	
	
	

}
