package Controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Database.Room;
import Database.Rooms;

public class D_Ser {
	
	public static void serialize(){
		try {
            FileOutputStream fileOut = new FileOutputStream("./src/serfiles/room.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Rooms.rooms);
            out.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static ArrayList<Room> Deserialize(ArrayList<Room> room){
		try	{	
			FileInputStream file = new FileInputStream("./src/serfiles/room.txt");
            ObjectInputStream in = new ObjectInputStream(file);
             
            // Method for deserialization of object
            room = (ArrayList<Room>)in.readObject();
            in.close();	
			file.close();
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
		return room;
	}

}
