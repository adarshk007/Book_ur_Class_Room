package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import Database.CSVReaderInJava;
import Database.Room;
import Database.Rooms;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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

//class Record{
//    private final SimpleStringProperty room;
//    private final SimpleStringProperty capacity;
//    private final SimpleStringProperty time;
//   
//    Record(String room, String capacity, String time){
//        this.room = new SimpleStringProperty(room);
//        this.capacity = new SimpleStringProperty(capacity);
//        this.time = new SimpleStringProperty(time);
//    }
//   
//    public StringProperty roomProperty() {
//        return room ;
//    }
//    public StringProperty capacityProperty() {
//        return capacity ;
//    }
//    public StringProperty timeProperty() {
//        return time ;
//    }
//    public String getroom() {
//        return room.get();
//    }
//   
//    public String getcapacity() {
//        return capacity.get();
//    }
//    public String gettime() {
//        return time.get();
//    }
//   
//}

public class Studentcontrol implements Initializable {
	
/////////////////  Student var	
	
	
    @FXML
    private MenuItem help;

    @FXML
    private MenuItem logout;

    @FXML
    private Button timetable;

    @FXML
    private Button b_room;

    @FXML
    private Button check_stat;

    @FXML
    private Button search_co;

    @FXML
    private AnchorPane aroom_pane;

    @FXML
    private TableView<Record> roomview;

    @FXML
    private TableColumn<Record, String> room_col;

    @FXML
    private TableColumn<Record, String> cap_col;

    @FXML
    private TableColumn<Record, String> time_col;

    @FXML
    private TableView<Record> roomview1;

    @FXML
    private TableColumn<Record, String> room_col1;

    @FXML
    private TableColumn<Record, String> cap_col1;

    @FXML
    private TableColumn<Record, String> time_col1;
    
    @FXML
    private DatePicker date1;
    
    @FXML
    private DatePicker date2;
//////////////// Student
//    @FXML
//    private void initialize() {
//        // Initialize the person table with the two columns.
//    	room_col.setCellValueFactory(cellData -> cellData.getValue().groom());
//        cap_col.setCellValueFactory(cellData -> cellData.getValue().cap());
//        time_col.setCellValueFactory(cellData -> cellData.getValue().tim());
//        
//    }
    
/////////////// Student    
	ObservableList<Record> data;
    @FXML
    void showTable2(ActionEvent event) {				//Mon-1 ; Sun-7   Booked Rooms
//    	
//    	for ( int i = 0; i<roomview.getItems().size(); i++) {
//    		roomview.getItems().clear();
//    	}
		data= FXCollections.observableArrayList();
    	CSVReaderInJava f=new CSVReaderInJava();
    	DayOfWeek day=date1.getValue().getDayOfWeek();
    	int week=day.getValue();
    	int j=week+5;
    	for(int i=1;i<17;i++){
    		if(!f.s[i][j].equals("-")){
    			String[] a=f.s[i][j].split("\\;");
    			for(int k=0;k<a.length;k++){
//    				System.out.println(a[k]);
    				String[] b=a[k].split("\\$");
//    				System.out.println(b.length);
//    				System.out.println(b[0]+" "+b[1]);
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
//    				roomview.getItems().setAll("2","3","3");
//    				System.out.println(data.get(i).getroom()+" "+data.get(i).getcapacity()+" "+data.get(i).gettime());
//    				System.out.println(b[1]+" "+b[0]);
    			}
//    			System.out.println(f.s[i][j]);
    		}
    	}
//    	for(int i=0;i<data.size();i++){
//    		System.out.print(data.get(i).getroom()+" ");
//    		System.out.print(data.get(i).getcapacity()+" ");
//    		System.out.println(data.get(i).gettime());
//    	}
    	
    	roomview1.getItems().setAll(data);
    	
//    	roomview.getColumns().clear();
//    	roomview.getColumns().addAll(room_col,cap_col,time_col);
    }
    @FXML
    void showTable(ActionEvent event) {

    }

    @FXML
    void bookroom(ActionEvent event) {
//    	loadwindow("/ui/bookRoom.fxml","Book A Room");
    	try{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/bookRoom.fxml"));
		loader.setController(new MainController());
		StackPane pane = loader.load();
        Scene scene = new Scene(pane);
        Stage stage=new Stage(StageStyle.DECORATED);
        stage.setTitle("Search Courses");
        stage.setScene(scene);
        stage.show();
    	}catch(IOException e){
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
    void checkstatus(ActionEvent event) {
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
//    	D_Ser.serialize();
//    	try {
//            FileOutputStream fileOut = new FileOutputStream("./src/serfiles/room.txt");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(Rooms.rooms);
//            out.close();
//            fileOut.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    	Stage stage = (Stage) timetable.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void searchcourses(ActionEvent event) {
//    	loadwindow("Search.fxml","Book A Room");
    	try{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/Search.fxml"));
//		loader.setController(new Studentcontrol());
    	Stage stage=new Stage(StageStyle.DECORATED);
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage.setTitle("Search Courses");
        stage.setScene(scene);
        stage.show();
    	}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    		
    	}
    }

    @FXML
    void viewtimetable(ActionEvent event) {
    	table t=new table();
    	Stage stage = new Stage();
			t.start(stage);
    }
    
/////////// Student    
    
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		room_col1.setCellValueFactory(new PropertyValueFactory<>("room"));
//
        cap_col1.setCellValueFactory(new PropertyValueFactory<>("capacity"));
//
        time_col1.setCellValueFactory(new PropertyValueFactory<>("time"));
        room_col.setCellValueFactory(new PropertyValueFactory<>("room"));
        cap_col.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        time_col.setCellValueFactory(new PropertyValueFactory<>("time"));
        
//		TableColumn<Record,String> roomscol = new TableColumn("Rooms");
//		roomscol.setCellValueFactory(
//	              new PropertyValueFactory<Record,String>("room"));
//	 
//	      TableColumn<Record,Integer> capcol = new TableColumn("capacity");
//	      capcol.setCellValueFactory(
//	              new PropertyValueFactory<Record,Integer>("capacity"));
//	      
//	      TableColumn<Record,String> timecol = new TableColumn("Time-Slot");
//	      timecol.setCellValueFactory(
//	              new PropertyValueFactory<Record,String>("timeslot"));
	}

}
