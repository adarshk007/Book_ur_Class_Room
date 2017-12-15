package gui;
// Login Page

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Controller.Admincontrol;
import Controller.Facultycontrol;
import Controller.MainController;
import Controller.Studentcontrol;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle; 
/**
 * 
 * @author adarsh Deepanshu
 * <h1>LOGIN GUI</h1>
 * <p>Using this u can Login Easily and then After adding your's Mail Id, Password and Type Of User 
 * To Get the Access and redirected to the page if you are admin and student or faculty</p>
 *
 */
public class LoginT extends Application { 
	
	private TextField nameText;
	private PasswordField datePicker;
	private Button buttonRegister;
	private ChoiceBox<String> locationchoiceBox;
   /**
    * @see nameText datePicker 
    * @exception FileNotFoundException If the given serialized data is not on its correct place
    * 
    */
	@Override 
   public void start(Stage stage) throws FileNotFoundException {    
      //Label for name 
//	   stage=new Stage();
//	   Image image = new Image(new FileInputStream("D:\\books\\javascript\\HTML and CSS\\iiit.jpg"),300,40,true,true);
//	   ImageView imageView1 = new ImageView(image);
//
//	      imageView1.setPreserveRatio(true);
      Text nameLabel = new Text("Email ID"); 
      
      //Text field for name 
     nameText = new TextField(); 
       
      //Label for date of birth 
      Text dobLabel = new Text("Password"); 
      
      //date picker to choose date 
      datePicker = new PasswordField();
      datePicker.setPromptText("Your password");
 
   
      //Label for location 
      Text locationLabel = new Text("Type of User"); 
      
      //Choice box for location 
      locationchoiceBox = new ChoiceBox<String>(); 
      locationchoiceBox.getItems().addAll
         ("Admin", "Faculty", "Student"); 
      //group
      
      
      //Label for register 
      Button back=new Button("BACK");
      back.setLayoutY(380);
      back.setLayoutX(0);
	    back.setOnAction(event -> {
	        Welcome rev=new Welcome();
	        try {
				rev.start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    back.setStyle("-fx-background-color: linear-gradient(#4B79A1, #283E51);-fx-background-radius: 5;-fx-background-insets: 0;-fx-text-fill: white;");
      
      buttonRegister = new Button("LOGIN");
      buttonRegister.setOnAction(event -> {
    	  String s=(String)locationchoiceBox.getValue();

    	  ArrayList<login> arr=new ArrayList<login>();
    	  ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("./src/serfiles/p.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		  Object so = null;
		try {
			so = in.readObject();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String[] type={"admin","faculty","student"};
		
		
		String value = (String) locationchoiceBox.getValue();
		value=value.toLowerCase();
		
		  ArrayList sl=(ArrayList)so;
		  
		  
		  for(int i=0;i<sl.size();i++){
			 
			  if(nameText.getText().equals(((login) sl.get(i)).getid()) && datePicker.getText().equals(((login) sl.get(i)).getpassword()) && value.equals(((login) sl.get(i)).gettype())){
				
				  break;
			  }
			  else{
				  if(sl.size()-1==i){
				  Alert alert = new Alert(AlertType.ERROR);
				  alert.setTitle("Login Error");
				  alert.setHeaderText("SORRY !");
				  alert.setContentText("Either you are not registered or you have entered Wrong password or mail id or type of User");
				  
				  alert.showAndWait();
				  return;
				  }
				  
			  }
		  }
    	  if(s.equals("Admin")){
		  try{
			  FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/A.fxml"));
			  loader.setController(new Admincontrol());
			  StackPane pane = loader.load();
			  Scene scene = new Scene(pane);
			  Stage pstage=new Stage(StageStyle.DECORATED);
			  pstage.setTitle("Admin Dashboard");
			  pstage.setScene(scene);
			  pstage.show();
		  }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  
		  }
	  }
	  else if(s.equals("Student")){
		  try{
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/S.fxml"));
          loader.setController(new Studentcontrol());
          StackPane pane = loader.load();
          Scene scene = new Scene(pane);
          Stage pstage=new Stage(StageStyle.DECORATED);
          pstage.setTitle("Student Dashboard");
          pstage.setScene(scene);
          pstage.show();
		  }catch (IOException e) {
//				// TODO Auto-generated catch block
				e.printStackTrace();
		  }
	  }
	  else if(s.equals("Faculty")){
		  try{
    		  FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/F.fxml"));
              loader.setController(new Facultycontrol());
              StackPane pane = loader.load();
              Scene scene = new Scene(pane);
              Stage pstage=new Stage(StageStyle.DECORATED);
              pstage.setTitle("Faculty Dashboard");
              pstage.setScene(scene);
              pstage.show();
    		  }catch (IOException e) {
//    				// TODO Auto-generated catch block
    				e.printStackTrace();
    		  }
    	  }

          
      });
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane 
      gridPane.setMinSize(500, 200); 
       
      //Setting the padding    
      gridPane.setPadding(new Insets(10, 10, 10,10));  
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
//      gridPane.add(imageView1, 1, 0);
      gridPane.add(nameLabel, 0,4); 
      gridPane.add(nameText, 1, 4); 
       
      gridPane.add(dobLabel, 0, 6);       
      gridPane.add(datePicker, 1, 6); 
           
       
      gridPane.add(locationLabel, 0, 8); 
      gridPane.add(locationchoiceBox, 1, 8);    
      gridPane.add(buttonRegister, 2, 10);
      gridPane.add(back, 0, 10);
      
      //Styling nodes   
      buttonRegister.setStyle(
    "-fx-text-fill: white; -fx-font-family: Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
      
      nameLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      dobLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      locationLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
       
      //Setting the back ground color 
     // gridPane.setStyle("-fx-background-image");       
      
      //Creating a scene object 
      Scene scene = new Scene(gridPane); 
//      BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream("D://books//javascript//HTML and CSS//template//1.jpg"),900,400,false,true),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
//    	//then you set to your node
//    	gridPane.setBackground(new Background(myBI)); 
      //Setting title to the Stage 
      stage.setTitle("LOGIN Form"); 
      stage.setResizable(false);
      //Adding scene to the stage 
      stage.setScene(scene);  
      
      //Displaying the contents of the stage 
      stage.show(); 
      
   }  
//   void loadwindow(String loc, String title){
//   	
//		try {
//			
//			FXMLLoader loader = FXMLLoader.load(getClass().getResource(loc));
//			loader.setController(new Studentcontrol());
//			Parent parent = loader.load();
//			Stage stage=new Stage(StageStyle.DECORATED);
//	    	stage.setTitle(title);
//	    	stage.setScene(new Scene(parent));
//	        stage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//   	
//   }
   public static void main(String args[]){ 
	   
      launch(args); 
   }

	
} 

