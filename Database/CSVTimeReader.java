package Database;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
//import gui.table_student;

public class CSVTimeReader {
	
	public String [][] s;
//	PostCondition from 11-18(0 - based)
	public CSVTimeReader(){
		s=new String[30][40];
		 try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/prerna/Desktop/Time.csv"))) {
	        	int i=0;
	        	while(i<6){
	        		StringTokenizer tk = new StringTokenizer(br.readLine(),",");
	        		int j=0;
	        		while (tk.hasMoreTokens()) {
	        			
	        			s[i][j] = tk.nextToken();
	        			j++;
	        		}
	        		i++;
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	
	
    public static void main(String[] args) {

        String csvFile = "C:/java/Time.csv";
        CSVTimeReader f=new CSVTimeReader();
//        String line = "";
//        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	int i=0;
        	while(i<6){
//        		String line=br.readLine();
//        		System.out.println(line);
        		StringTokenizer tk = new StringTokenizer(br.readLine(),",");
        		int j=0;
        		while (tk.hasMoreTokens()) {
        			
        			// use comma as separator
        			f.s[i][j] = tk.nextToken();
        			j++;
//        			System.out.print(s[i][j]+"  ");
        		}
//        		System.out.println();
        		i++;
            }
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int j=0;j<6;j++){
    		
			
    		System.out.println(f.s[j][1]+" "+f.s[j][0]);
    		
    		}
 
//        }
    }

}
