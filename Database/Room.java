package Database;

import java.io.Serializable;

public class Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Room_No;
	private int Capacity;
	private String reason;
	private String timeslot; //time for which room is free
	private String status;
	
	public Room(String Room_No, String reason, int Capacity ){
		this.Room_No=Room_No;
		this.Capacity=Capacity;
		this.reason=reason;
	}
	public Room(String Room_No, int Capacity , String timeslot){
		this.Room_No=Room_No;
		this.Capacity=Capacity;
		this.timeslot=timeslot;
	}
	public String getRoom_No() {
		return Room_No;
	}

	public String getReason(){
		return reason;
	}
	public int getCapacity() {
		return Capacity;
	}

	public String getTimeslot() {
		return timeslot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
