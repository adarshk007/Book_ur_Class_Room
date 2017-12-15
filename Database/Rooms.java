package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class Rooms implements Serializable{
	
	
	public static ArrayList<Room> rooms=new ArrayList<Room>();
	
//	public Rooms(){
//		rooms=new ArrayList<Room>();
//	}
//	public void add(Room r){
//		rooms.add(r);
//	}
//	public int getsize(){
//		return rooms.size();
//	}
//	public void serialize() throws FileNotFoundException, IOException{
//			ObjectOutputStream out = null;	
//			try	{	
//				out	=	new	ObjectOutputStream	(new FileOutputStream("./src/serfiles/room.txt"));	
//					out.writeObject(rooms);
//			
//				}finally	{	
//				out.close();	
//				}
//		}
//	
//	public void deserialize(){	
//		try	{	
//			FileInputStream file = new FileInputStream("./src/serfiles/room.txt");
//            ObjectInputStream in = new ObjectInputStream(file);
//             
//            // Method for deserialization of object
//            rooms = (ArrayList<Room>)in.readObject();
//            in.close();	
//			file.close();
//		}catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//		System.out.println(rooms.size());
//	}
}
