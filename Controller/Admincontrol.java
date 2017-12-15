package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import Database.CSVReaderInJava;
import Database.Room;
import Database.Rooms;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import gui.TableViewSample;

public class Admincontrol implements Initializable {

    @FXML
    private MenuItem logout;

    @FXML
    private Button request;

    @FXML
    private Button room;

    @FXML
    private Button viewroom;


    @FXML
    private TableView<Record> roomview;

    @FXML
    private TableColumn<Record,String> room_col;

    @FXML
    private TableColumn<Record,String> cap_col;

    @FXML
    private TableColumn<Record,String> time_col;

    @FXML
    private TableView<Record> roomview1;

    @FXML
    private TableColumn<Record,String> room_col1;

    @FXML
    private TableColumn<Record,String> cap_col1;

    @FXML
    private TableColumn<Record,String> time_col1;

    @FXML
    private DatePicker date1;
    
    @FXML
    private DatePicker date2;
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
    	
//    	System.out.println(g);
    	if(c.equals("") || p.equals("")){
    		infoBox("Required Capacity and Purpose of Booking are need to be filled.","Error");
    	}else{
    		int c1=Integer.parseInt(capa.getText());
//    		 Window ownerWindow = ( (Node) event.getTarget()).getScene().getWindow();
    		 
//    		if(roo.getsize()!=0){
//    			roo.deserialize();
//    		}
    		try	{	
    			FileInputStream file = new FileInputStream("./src/serfiles/aroom.txt");
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
    void book_room(ActionEvent event) {
//    	loadwindow("/ui/bookRoom.fxml","Book Room");
    	try{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/bookRoom.fxml"));
		loader.setController(this);
		Stage stage=new Stage(StageStyle.DECORATED);
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setTitle("Book Room");
        stage.setScene(scene);
        stage.show();
    	}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    		
    	}
    }
    
    

    @FXML
    void logout(ActionEvent event) {
    	Stage stage = (Stage) request.getScene().getWindow();
    	stage.close();
    }


    @FXML
    void viewRequest(ActionEvent event) {
//    	/Classroom/src/ui/TableViewSample.java
    	TableViewSample t=new TableViewSample();
    	Stage stage=new Stage();
    	t.start(stage);
    }

    @FXML
    void view_room(ActionEvent event) {

    }
    ObservableList<Record> data;
    @FXML
    void showTable2(ActionEvent event) {
    	 data = FXCollections.observableArrayList();
    	CSVReaderInJava f=new CSVReaderInJava();
    	DayOfWeek day=date2.getValue().getDayOfWeek();
    	int week=day.getValue();
    	int j=week+5;
    	for(int i=1;i<17;i++){
    		if(!f.s[i][j].equals("-")){
    			String[] a=f.s[i][j].split("\\;");
    			for(int k=0;k<a.length;k++){
    				String[] b=a[k].split("\\$");
    				String a1=b[1].toUpperCase();
    				String s;
    				if(a1.charAt(0)=='C'){
    					if(a1.charAt(2)!='1'){
    						s="60";
    					}else{
    						s="120";
    					}
    				}else{
    					a1=a1.replace('^', ',');
    					s="25";
    				}
    				data.add(new Record(a1,s,b[0]));
    			}
    		}
    	}
    	roomview1.getItems().setAll(data);
    }
    @FXML
    void showTable(ActionEvent event) {

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		room_col1.setCellValueFactory(new PropertyValueFactory<Record,String>("room"));
        cap_col1.setCellValueFactory(new PropertyValueFactory<Record,String>("capacity"));
        time_col1.setCellValueFactory(new PropertyValueFactory<Record,String>("time"));
        room_col.setCellValueFactory(new PropertyValueFactory<>("room"));
        cap_col.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        time_col.setCellValueFactory(new PropertyValueFactory<>("time"));
    }
}

