package Database;

import java.io.Serializable;
import java.util.ArrayList;

class Student  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Name;
	private String id;
	private String password;
	private String user;
	
	Student(String Name, String id, String password, String user){
		this.Name=Name;
		this.id=id;
		this.password=password;
		this.user=user;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUser() {
		return user;
	}
}

public class Students implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Student> s_list;
	
	Students(){
		s_list=new ArrayList<Student>();
	}
	
	public void addStudent(Student S){
		s_list.add(S);
	}

}
