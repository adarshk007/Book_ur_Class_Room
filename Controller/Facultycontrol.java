package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.table;

public class Facultycontrol implements Initializable{

    @FXML
    private MenuItem logout;

    @FXML
    private Button t_table;

    @FXML
    private Button room;

    @FXML
    private Button status;

    @FXML
    private Tab rromA;
    
    @FXML
    private DatePicker date1;
    
    @FXML
    private DatePicker date2;

    @FXML
    private AnchorPane aroom_pane;

    @FXML
    private TableView<Record> roomview;

    @FXML
    private TableColumn<Record,String> room_col;

    @FXML
    private TableColumn<Record,String> cap_col;

    @FXML
    private TableColumn<Record,String> time_col;

    @FXML
    private Tab roomb;

    @FXML
    private TableView<Record> roomview1;

    @FXML
    private TableColumn<Record,String> room_col1;

    @FXML
    private TableColumn<Record,String> cap_col1;

    @FXML
    private TableColumn<Record,String> time_col1;
    
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
    			FileInputStream file = new FileInputStream("./src/serfiles/froom.txt");
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
    private TableView<Record> personTable;
    
    @FXML
    private TableColumn<Record, String> fullnameCol;

    @FXML
    private TableColumn<Record, String> addressCol;


    @FXML
    void check_status(ActionEvent event) {
//    	loadwindow("/ui/bookRoom.fxml","Book A Room");
    	try{
    	 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("/ui/checkstatus.fxml"));
         loader.setController(this);
         Parent parent = loader.load();
         Scene scene = new Scene(parent);
         Stage stage=new Stage(StageStyle.DECORATED);
         stage.setScene(scene);
        stage.show();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
        fullnameCol.setCellValueFactory(new PropertyValueFactory<Record, String>("room"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Record, String>("purpose"));
        
    	ArrayList<Room> roo = new ArrayList<Room>();
//    	D_Ser.Deserialize(roo);
		try	{	
			FileInputStream file = new FileInputStream("./src/serfiles/room.txt");
            ObjectInputStream in = new ObjectInputStream(file);
             
            // Method for deserialization of object
            roo = (ArrayList<Room>)in.readObject();
            in.close();	
			file.close();
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
//    	System.out.println("roo "+roo.size());
//    	System.out.println("rooms "+Rooms.rooms.size());
//		for(int i=0;i<Rooms.rooms.size();i++){
//			roo.add(Rooms.rooms.get(i));
//		}
//		for(int i=0;i<roo.size();i++){
//			Rooms.rooms.add(roo.get(i));
//		}
//		D_Ser.serialize();
		ObservableList<Record> persons = FXCollections.observableArrayList();
		for(int i=0;i<roo.size();i++){
			String s1;
			if(roo.get(i).getRoom_No().equals("")){
				s1="- ,\n";
			}else{
				s1=(roo.get(i).getRoom_No())+",\n";
			}
			s1=s1+roo.get(i).getCapacity()+" ,\n"+roo.get(i).getReason();
			String s2=roo.get(i).getStatus();
			if(s2==null || s2.equals("")){
				s2="Pending";
			}
			Record p1 = new Record(s1, s2);
//			System.out.println(roo.get(i).getRoom_No());
			persons.add(p1);
		}
//        Record p2 = new Record("Riyad Mahrez", "xxxxx, \n007 St.YYYY");
        fullnameCol.setCellFactory(column->{
            return new TableCell<Record, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if(item==null || empty) {
                        setGraphic(null);
                    } else {
                        VBox vbox = new VBox();
                        List<String> textList = Arrays.asList(item.split("\n"));
                        String[] colors = {"#3E50B4", "#FF3F80", "#727272"};
                        int colorCount = colors.length;
                        for(int i=0;i<textList.size();i++) {
                            Label lbl = new Label(textList.get(i));
                            lbl.setStyle("-fx-text-fill: "+colors[i%colorCount]);
                            vbox.getChildren().add(lbl);
                        }
                        setGraphic(vbox);
                    }
                }
            };
        });
//        personTable.getItems()
        personTable.setItems(persons);
    }

    @FXML
    void logout(ActionEvent event) {
    	Stage stage = (Stage) room.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void showTable1(MouseEvent event) {

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
    void viewt_table(ActionEvent event) {
    	table t=new table();
    	Stage stage=new Stage();
    	stage.setTitle("Time-Table");
    	t.start(stage);
    }
    
    void loadwindow(String loc, String title){
    	Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource(loc));
			Stage stage=new Stage(StageStyle.DECORATED);
	    	stage.setTitle(title);
	    	stage.setScene(new Scene(parent));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		room_col1.setCellValueFactory(new PropertyValueFactory<Record,String>("room"));
        cap_col1.setCellValueFactory(new PropertyValueFactory<Record,String>("capacity"));
        time_col1.setCellValueFactory(new PropertyValueFactory<Record,String>("time"));
        room_col.setCellValueFactory(new PropertyValueFactory<>("room"));
        cap_col.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        time_col.setCellValueFactory(new PropertyValueFactory<>("time"));
    }

}
