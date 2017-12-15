package Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import Database.Rooms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import com.jfoenix.controls.*;

import Database.CSVReaderInJava;
import Database.Room;

public class MainController {

		private CSVReaderInJava file;
		
	    @FXML
	    private TextField input_PostCond;

	    @FXML
	    private Button searchb;

	    @FXML
	    private ListView<String> CourseList;
	    
	    @FXML
	    private JFXTextField proom;

	    @FXML
	    private JFXTextField capa;

	    @FXML
	    private JFXTextArea purpose;

	    @FXML
	    private JFXButton cancel;

	    @FXML
	    private JFXButton submit;

	    @FXML
	    void Cancel(MouseEvent event) {
	    	Stage stage = (Stage) cancel.getScene().getWindow();
	    	stage.close();
	    }
	    
	    public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
	    @FXML
	    void Submit(MouseEvent event) throws FileNotFoundException, IOException {
	    	String r=proom.getText();
	    	String c=capa.getText();
	    	String p=purpose.getText();
	    	
//	    	System.out.println(g);
	    	if(c.equals("") || p.equals("")){
	    		infoBox("Required Capacity and Purpose of Booking are need to be filled.","Error");
	    	}else{
	    		int c1=Integer.parseInt(capa.getText());
//	    		 Window ownerWindow = ( (Node) event.getTarget()).getScene().getWindow();
	    		 
//	    		if(roo.getsize()!=0){
//	    			roo.deserialize();
//	    		}
	    		try	{	
	    			FileInputStream file = new FileInputStream("./src/serfiles/room.txt");
	                ObjectInputStream in = new ObjectInputStream(file);
	                 
	                // Method for deserialization of object
	                Rooms.rooms = (ArrayList<Room>)in.readObject();
	                in.close();	
	    			file.close();
	    		}catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            }catch (IOException e) {
	                e.printStackTrace();
	            }
	    		Rooms.rooms.add(new Room(r,p,c1));
	    		D_Ser.serialize();
	    		infoBox("Room book request made.","Succes");
	    		Stage stage = (Stage) submit.getScene().getWindow();
	        	stage.close();
	    	}
	    }

	    @FXML
	    void loadCourses(ActionEvent event) {
	    	file=new CSVReaderInJava();
	    	ObservableList<String> course = FXCollections.observableArrayList();
	    	String c=input_PostCond.getText();
	    	for(int i=0;i<17;i++){
	    		int j=11;
	    		while(file.s[i][j]!=null){
//	    			StringTokenizer t=new StringTokenizer(file.s[i][j]);
//	    			System.out.println(t);
	    			
	    			if(file.s[i][j].toLowerCase().contains(c)){
	    					course.add(file.s[i][1]);
//	    			    	System.out.println(file.s[i][1]);
	    			    	break;
	    			}j++;
	    		}
	    	}
//	    		int j=11;
//	    		while(file.s[i][j]!=null){
//	    			StringTokenizer t=new StringTokenizer(file.s[i][j]);
//	    		}
	    	
	    	CourseList.getItems().setAll(course);
	    }

	    @FXML
	    void searchclick(MouseEvent event) {
	    	if(event.getSource()==searchb){
//	    		System.out.println("sdfasf");
	    		file=new CSVReaderInJava();
		    	ObservableList<String> course = FXCollections.observableArrayList();
		    	String c=input_PostCond.getText();
		    	System.out.println(c);
		    	for(int i=0;i<17;i++){
		    		for(int j=11;j<18;j++){
		    			StringTokenizer t=new StringTokenizer(file.s[i][j]);
		    			while(t.hasMoreTokens()){
		    				if(c.equals(t.nextToken())){
		    					course.add(file.s[i][1]);
		    			    	System.out.println(file.s[i][1]);
		    				}
		    			}
		    		}
		    	}
		    	CourseList.getItems().setAll(course);
	    	}
	    	
	    }

	
//	public void init() {
//	    
//	}

}
