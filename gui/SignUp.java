package gui;
// SignUp page


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Database.Room;
import Database.Rooms;
import javafx.application.Application; 
import javafx.collections.FXCollections; 
import javafx.collections.ObservableList; 

import javafx.geometry.Insets; 
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button; 
import javafx.scene.control.CheckBox; 
import javafx.scene.control.ChoiceBox; 
import javafx.scene.control.DatePicker; 
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.*;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ToggleButton; 
import javafx.stage.Stage; 

/**
 * 
 * @author Adarsh Deepanshu
 * <h1>It the Serializable Class </h1>
 * <p>This class Stores the data of {Student,Faculty,Admin} Name ,UserType Whether the user is (Student,faculty, Admin)</p>
 * <p>This Also store the data of Mail Id and Password</p>
 *
 */
class login implements Serializable{
	
	static ArrayList<login> arr=new ArrayList<login>();
	   private String name;
	   private String userType;
	   private String password;
	   private String emailid;
	   /**
	    * 
	    * @param a name of User
	    * @param b mail id of user
	    * @param c password of user
	    * @param d User type
	    */
	   login(String a,String b,String c,String d){
		   this.name=a;
		   this.emailid=b;
		   this.password=c;
		   this.userType=d;
		  
	   }
	  
		   
	   
	   String gettype(){
		   return(userType.toLowerCase());
	   }
	   String getid(){
		   return(emailid);
	   }
	   String getpassword(){
		   return(password);
	   }
	   ArrayList<login> getarr(){
		   return(arr);
	   }
	   
	   
}
/**
 * 
 * @author Adarsh Deepanshu
 *<h1>GUI OF SIGN UP<h1>
 *<p>here user can sign up and just add their data to our database and then can get an access to login</p>
 */
public class SignUp extends Application { 
	static ArrayList<login> arr=new ArrayList<login>();
	ArrayList<login> arr2=new ArrayList<login>();
   @Override 
   public void start(Stage stage) throws FileNotFoundException {    
      //Label for name 
//	  stage=new Stage();


	     
      Text nameLabel = new Text("Email ID"); 
      
      //Text field for name 
      TextField nameText = new TextField(); 
       
      //Label for date of birth 
      Text dobLabel = new Text("Password"); 
      
      //date picker to choose date 
      PasswordField datePicker = new PasswordField();
      datePicker.setPromptText("Your password");
      final Tooltip tooltip = new Tooltip();
      tooltip.setText(
          "\nYour password must be\n" +
          "at least 8 characters in length\n"
      );
      datePicker.setTooltip(tooltip);
   
      //Label for location 
      Text locationLabel = new Text("Type of User"); 
      TextField LocationText = new TextField();
      Text elabel = new Text("Name"); 
      TextField gtext = new TextField();
      elabel.setStyle("-fx-font: normal bold 15px 'serif' ");
      ////////////////////////////////////////////////////////
      Text text1=new Text();
      text1.setText("Sign UP");
      text1.setStyle("-fx-font-family:Pacifico; -fx-font-size: 25;");
      text1.setX(120); 
      text1.setY(60);
      
      ////////////////////////////////////////////////////////
      
//      Image image4 = new Image(new FileInputStream("D:\\books\\javascript\\HTML and CSS\\flight-login.gif"),300,400,false,true);
//
//	   ImageView imageView1 = new ImageView(image4);
//	      imageView1.setX(405); 
//	      imageView1.setY(5);
      
      ////////////////////////////////////////////////////////
	  gtext.setLayoutY(100);
	  gtext.setLayoutX(210);
      elabel.setLayoutY(120);             /////jiuygvyjkhbigkyuhbjbvmnjlbkjlhbn
      elabel.setLayoutX(45);
      nameText.setLayoutY(150);
      nameText.setLayoutX(210);
      nameLabel.setLayoutY(170);
      nameLabel.setLayoutX(45);
      datePicker.setLayoutY(200);
      datePicker.setLayoutX(210);
      dobLabel.setLayoutY(220);
      dobLabel.setLayoutX(45);
      locationLabel.setLayoutY(270);
      locationLabel.setLayoutX(45);
      LocationText.setLayoutY(250);
      LocationText.setLayoutX(210);
      ////////////////////////////////////////////////////////////
      //Label for register 
      Button buttonRegister = new Button("Sign_UP");
      buttonRegister.setLayoutY(330);
      buttonRegister.setLayoutX(140);
      buttonRegister.setOnAction(event -> {
    	 
          login w=(new login(gtext.getText(),nameText.getText(),datePicker.getText(),LocationText.getText().toLowerCase()));
		 arr.add(w);
		 String[] a=nameText.getText().split("");
		 boolean value=true;
		 if(a.length==12){
			 value=false;
		 }
		 String test="!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~+";
		 int res=0;
		 for(int i=a.length-1;i>0;i--){
			 
			 if(res>11){
				 
				 if(test.contains((String)a[i])){
					 System.out.print(a[i]);
					 value=false;
					 break;
					 
				 }
				
			 }
			 res=res+1;
		 }
		 
		 
		 if(nameText.getText().endsWith("@iiitd.ac.in") && value && (LocationText.getText().toLowerCase().equals("student")||LocationText.getText().toLowerCase().equals("faculty")||LocationText.getText().toLowerCase().equals("admin"))){
          FileInputStream fout = null;
          
          FileOutputStream write=null;
          ArrayList<login> l=new ArrayList<>();
//          l.add(w);
//          try{
//          write=new FileOutputStream("./src/serfiles/p.txt");  
//          ObjectOutputStream out=new ObjectOutputStream(write);  
//          
//          out.writeObject(l);  
//          out.flush();  
//    			
//    		} catch (IOException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    		}  
          try {
  			
  			fout = new FileInputStream("./src/serfiles/p.txt");
  		  ObjectInputStream in=new ObjectInputStream(fout);  
  		  l=(ArrayList<login>)in.readObject();  
//      	 l=(ArrayList<login>)s;
      	  l.add(w);
//      	  System.out.println(arr2.get(0).getpassword());
      	  in.close();
     write=new FileOutputStream("./src/serfiles/p.txt");  
        ObjectOutputStream out=new ObjectOutputStream(write);  
        
        out.writeObject(l);  
        out.flush();  
  			
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		  LoginT ctc = new LoginT();
          Stage stage1 = new Stage();
          
			try {
				
				ctc.start(stage1);
				stage.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   }
		 else{
			 Alert alert = new Alert(AlertType.ERROR);
			  alert.setTitle("Login Error");
			  alert.setHeaderText("SORRY !");
			  alert.setContentText("you have to enter your @iiitd.ac.in :: MAIL ID also USER:Student,faculty,Admin only");
			  
			  alert.showAndWait();
		 }
      });
      /**
       * <p>Back Button TO get back to Home Page</p>
       */
      Button back=new Button("<--");
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
	    back.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);-fx-background-radius: 30;-fx-background-insets: 0;-fx-text-fill: white;");
      
      //Creating a Grid Pane 
      Group one=new Group();
      ObservableList<Node> list = one.getChildren(); 
      

		
//		stage.getIcons().add(new Image(new FileInputStream("D://books//javascript//HTML and CSS//template//index3.jpg")));
		 stage.setTitle("Sign-Up MENU");
		 list.add(text1);
		 list.add(gtext );
		 list.add(elabel);
		  list.add(nameLabel ); 
		  list.add(nameText);
		  list.add(dobLabel);
		  list.add(datePicker);
		  list.add(locationLabel );
		  list.add(LocationText);
		  list.add(buttonRegister);
		  list.add(back);
//		  list.add(imageView1);
      
      
      //Styling nodes   
      buttonRegister.setStyle(
    "-fx-text-fill: white; -fx-font-family: Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
      
      nameLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      dobLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
      locationLabel.setStyle("-fx-font: normal bold 15px 'serif' "); 
       
      //Setting the back ground color 
     // gridPane.setStyle("-fx-background-image");       
      
      //Creating a scene object 
      Scene scene = new Scene(one,700,400); 
    /////////////////////////////////
     Stop[] stops = new Stop[] { new Stop(0, Color.CADETBLUE), new Stop(1, Color.CYAN)};
		 LinearGradient wtz=new LinearGradient(0, 0, 1, 1,true,CycleMethod.NO_CYCLE, stops);
		 scene.setFill(wtz);
      scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Pacifico");
      ////////////////////////////////
      //Setting title to the Stage 
      stage.setTitle("LOGIN Form"); 
      stage.setResizable(false);
      //Adding scene to the stage 
      stage.setScene(scene);  
      
      //Displaying the contents of the stage 
      stage.show(); 
   }  
   /**
    * 
    * @param args to launch the This GUI
    */
   public static void main(String args[]){ 
      launch(args); 
   } 
}