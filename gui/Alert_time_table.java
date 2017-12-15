
package gui;

import java.io.PrintWriter;
import java.io.StringWriter;

import Database.CSVReaderInJava;
import Database.CSVTimeReader;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import gui.table.Person;

/**
 * 
 * <h1> Time Table </h1>
 * <p>this class takes data from CSV file and Convert it Into text and 
 *    then it is added to our GUI Source
 *  </p>
 */
public class Alert_time_table extends Application {
	public void table(StringWriter sw){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Time Table");
		alert.setHeaderText("Time Schedule");
		alert.setContentText("Click Show Details for Scedule");
		TextArea textArea = new TextArea();
	
		CSVReaderInJava f=new CSVReaderInJava();
		
		String exceptionText = sw.toString();
		Label label = new Label("The Time table:");

		textArea.setText(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

	textArea.setMaxWidth(Double.MAX_VALUE);
	textArea.setMaxHeight(Double.MAX_VALUE);
	GridPane.setVgrow(textArea, Priority.ALWAYS);
	GridPane.setHgrow(textArea, Priority.ALWAYS);
	
	GridPane expContent = new GridPane();
	expContent.setMaxWidth(Double.MAX_VALUE);
	expContent.add(label, 0, 0);
	expContent.add(textArea, 0, 1);
	Stop[] stops = new Stop[] { new Stop(0, Color.DARKCYAN), new Stop(1, Color.TURQUOISE)};
	LinearGradient wtz=new LinearGradient(0, 0, 1, 0,true,CycleMethod.NO_CYCLE, stops);
	// Set expandable Exception into the dialog pane.
	alert.getDialogPane().setStyle("-fx-text-fill: white; -fx-font-family: Courier New ;-fx-font-weight: bold;-fx-background-color: linear-gradient(#85D8CE,#85D8CE);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 )");
	alert.getDialogPane().setExpandableContent(expContent);
		
		alert.showAndWait();
		
	}
	public void table0(int num){
		CSVTimeReader f=new CSVTimeReader();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		for(int j=0;j<6;j++){
    		
			if(f.s[j][num].equals("-")){
				pw.println(f.s[j][0]+":"+" \n"+"                 "+"No class");
			}
			else{
				String[] i=f.s[j][num].split("");
				String ki="";
				for(String p:i){
					if(p.equals("$")||p.equals("^")){
						ki=ki+" ";
					}
					else if(p.equals(";")){
						ki=ki+"   ";
					}
					else{
						ki=ki+p;
					}
				}
				pw.println(f.s[j][0]+":"+" \n"+"                 "+ki);
				
			}
    		
    		
    		}
		table(sw);
	}
	public void table1(){
		table0(1);
	}
	public void table2(){
		table0(2);
	}public void table3(){
		table0(3);
	}
	public void table4(){
		table0(4);
	}public void table5(){
		table0(5);
	}public void table6(){
		table0(6);
	}public void table7(){
		table0(7);
	}public void table8(){
		table0(8);
	}public void table9(){
		table0(9);
	}public void table10(){
		table0(10);
	}public void table11(){
		table0(11);
	}public void table12(){
		table0(12);
	}public void table13(){
		table0(13);
	}public void table14(){
		table0(14);
	}public void table15(){
		table0(15);
	}public void table16(){
		table0(16);
	}

	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public void start(Stage arg0) throws Exception {
		Alert_time_table t=new Alert_time_table();
		t.table1();
	}

}