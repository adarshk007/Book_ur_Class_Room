
package gui;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
* <h1>Request Approval</h1>

* this allows Admin to make decisions  
* Whether he wants to accept or reject request.
* <p>
* used Accept and remove buttons
* 
* 
*
* @author  Adarsh Kumar
* @author  Deepanshu kumain
* @version 1.0
* @since   2017-10-12 
*/
public class TableViewSample extends Application {
 
    private TableView<Person> table = new TableView<Person>();
    
    /**
     * <p><strong>Data</Strong> is an Observable List of Person to store Data</p> 
     * @see ObservableList<Person>
     */
    private final ObservableList<Person> data =
            FXCollections.observableArrayList();
    
    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    /**
     * @param stage Primary Stage of Scene
     * 
     */
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("permission");
        stage.setWidth(450);
        stage.setHeight(550);
 
        final Label label = new Label("Notification");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(false);
 
        TableColumn firstNameCol = new TableColumn("DAY");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setFirstName(t.getNewValue());
                }
            }
        );
 
 
        TableColumn lastNameCol = new TableColumn("Class Room");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
                }
            }
        );
 
        TableColumn emailCol = new TableColumn("Time");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("email"));
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
            new EventHandler<CellEditEvent<Person, String>>() {
                @Override
                public void handle(CellEditEvent<Person, String> t) {
                    ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                }
            }
        );
 
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
 
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("day");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("class Room");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Time");
 
        final Button addButton = new Button("Accept");
        final Button addButton1 = new Button("Reject");
        /**
         * <p> Button Listener used to Accept requests</p>
         */
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Person(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        });
        /**
         * <p> Button Listener used to reject requests</p>
         */
        addButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	for(int i=0;i<data.size();i++){
            		if(data.get(i).getFirstName().equals(addFirstName.getText()) && data.get(i).getLastName().equals(addLastName.getText()) && data.get(i).getEmail().equals(addEmail.getText())){
            			data.remove(i);
            			}
            	}
            
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        });
 
        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton,addButton1);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
    /**
     * 
     * @author adarsh
     * <h3>Person class is static  class</h3> 
     * <p>which is used to take 3 parameters @param firstname lastName email of String Type to add in the Box</p>
     *
     */
 
    public static class Person {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
 
        /**
         * 
         * @param fName
         * @param lName
         * @param email
         * Constructor Have 3 String Values That comes From Table as A String.
         */
        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }
 
        /**
         * <p>It is used to get the Day</p>
         * @return firstName.get()
         */
        public String getFirstName() {
            return firstName.get();
        }
		 /**
		  * <p>fname is String to set the Day</p>
		  * @param fName
		  */
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
        /**
         * <p>lastName is the class room</p>
         * @return lastName.get()
         */
 
        public String getLastName() {
            return lastName.get();
        }
        /**
         * <p>It is Used to set the Class</p>
         * @param fName
         */
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
        /**
         * <p>It is Used to get the Timing of class</p>
         * @return email.get()
         */
        public String getEmail() {
            return email.get();
        }
        /**
         * <p>It is Used to Set the Timing of class</p>
         * @param fName
         */
        public void setEmail(String fName) {
            email.set(fName);
        }
    }
}