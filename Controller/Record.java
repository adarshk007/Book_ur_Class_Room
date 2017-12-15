package Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Record{
    private final SimpleStringProperty room;
    private final SimpleStringProperty capacity;
    private final SimpleStringProperty time;
    private final SimpleStringProperty purpose;
    Record(String room, String capacity, String time){
        this.room = new SimpleStringProperty(room);
        this.capacity = new SimpleStringProperty(capacity);
        this.time = new SimpleStringProperty(time);
        purpose=null;
    }
    Record(String room, String purpose){
        this.room = new SimpleStringProperty(room);
        this.capacity =null;
        this.purpose = new SimpleStringProperty(purpose);
        time=null;
    }
    
    public StringProperty roomProperty() {
        return room ;
    }
    public StringProperty capacityProperty() {
        return capacity ;
    }
    public StringProperty timeProperty() {
        return time ;
    }
    public StringProperty purposeProperty() {
        return purpose ;
    }
    public String getroom() {
        return room.get();
    }
   
    public String getcapacity() {
        return capacity.get();
    }
    public String gettime() {
        return time.get();
    }
    public String getpurpose() {
        return purpose.get();
    }
}
