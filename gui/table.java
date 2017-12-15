package gui;

//import gui.table_student.Person
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import gui.Alert_time_table;
import Database.CSVReaderInJava;


/**
 * 
 * <h1>Time Table Selector</h1>
 * 
 * <p>This Class Is Used to Select the Course of which We Want to see Its Time Table</p>
 *<p>The Values are Added to It Via Using CSV File Reader </p>
 */
public class table extends Application {
 
    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data =
        FXCollections.observableArrayList();
    
	
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(500);
 
        final Label label = new Label("Time Table");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        CSVReaderInJava f=new CSVReaderInJava();
    	for(int j=1;j<17;j++){
//    		if( f.s[j][0].equals("Elective")){
    			
    		data.add(new Person(f.s[j][1],f.s[j][0]));
//    		} 
    		}
 
        TableColumn firstNameCol = new TableColumn("Course");
        firstNameCol.setMinWidth(200);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
 
        TableColumn lastNameCol = new TableColumn("Type");
        lastNameCol.setMinWidth(210);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
 
 
 
        table.setItems(data);
        /**
         * 
         * 
         * <h3>Action listener of Table</h3> 
         * <p>It is used to add check Time Table for Selected Course <br></br>.Just click Once to check</p>
         *
         */
        /////// /////////////   Action Listener         //////////////////////
        table.setRowFactory(tv -> {
            TableRow<Person> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
                     && event.getClickCount() == 1) {

                    Person clickedRow = row.getItem();
                    String k=clickedRow.getFirstName();
                   // System.out.println(clickedRow.getFirstName()+" "+clickedRow.getLastName());
                    if(k.contains("Discrete")){
                    	Alert_time_table t=new Alert_time_table();
                    	t.table1();
                    }
                    Alert_time_table t=new Alert_time_table();
                    if(k.contains("Advance")){
                    	
                    	t.table2();
                    }
                    if(k.contains("Computer")){
                    	
                    	t.table3();
                    }
                    if(k.contains("Math-")){
                    	
                    	t.table4();
                    }
                    if(k.contains("Signal")){
                    	
                    	t.table5();
                    }
                    if(k.contains("Real")){
                    
                    	t.table6();
                    }
                    if(k.contains("Number")){
                    	
                    	t.table7();
                    }
                    if(k.contains("Knowledge")){
                    	
                    	t.table8();
                    }
                    if(k.contains("Psycho")){
                    
                    	t.table9();
                    }
                    if(k.contains("Ethics")){
                    	
                    	t.table10();
                    }
                    if(k.contains("Theatre")){
                    	
                    	t.table11();
                    }if(k.contains("Economic")){
                    	
                    	t.table12();
                    }if(k.contains("Digital")){
                    	
                    	t.table13();
                    }if(k.contains("Media")){
                    	
                    	t.table14();
                    }if(k.contains("Social")){
                    	
                    	t.table15();
                    }if(k.contains("Poetry")){
                    	
                    	t.table16();
                    }
                }
            });
            return row ;
        });
        
        ///////////////////////////////////////////////////////////////////////
        table.getColumns().addAll(firstNameCol, lastNameCol);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        Stop[] stops = new Stop[] { new Stop(0, Color.MEDIUMAQUAMARINE), new Stop(1, Color.TURQUOISE)};
        LinearGradient wtz=new LinearGradient(0, 0, 1, 0,true,CycleMethod.NO_CYCLE, stops);
		 scene.setFill(wtz);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * 
     * 
     * <h3>Person class is static  class</h3> 
     * <p>which is used to take 2 parameters Course and Type of Course as a of String Type to add in the Box</p>
     *
     */
    public static class Person {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;

        /**
         * 
         * @param fName it is the Course Name
         * @param lName it is The Course Type Mandatory/Elective
         */
        private Person(String fName, String lName) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);

        }
        /**
         * 
         * @return firstname.get() returns the Course name
         */
 
        public String getFirstName() {
            return firstName.get();
        }
        /**
         * 
         * @param fName this Sets the Course Name
         */
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
        /**
         * 
         * @return lastName.get() Returns the Course Type
         */
        public String getLastName() {
            return lastName.get();
        }
        /**
         * 
         * @param fName this Sets the Course Type
         */
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        
    }
}
