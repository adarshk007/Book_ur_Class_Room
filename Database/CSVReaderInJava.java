package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CSVReaderInJava {
	
	public String [][] s;
//	PostCondition from 11-18(0 - based)
	public CSVReaderInJava(){
		s=new String[30][40];
		 try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/prerna/Desktop/finalcoursedata.csv"))) {
	        	int i=0;
	        	while(i<17){
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
	
	
//    public static void main(String[] args) {
//
//        String csvFile = "C:/Users/prerna/Desktop/finalcoursedata.csv";
////        String line = "";
////        String cvsSplitBy = ",";
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//        	int i=0;
//        	while(i<17){
////        		String line=br.readLine();
////        		System.out.println(line);
//        		StringTokenizer tk = new StringTokenizer(br.readLine(),",");
//        		int j=0;
//        		while (tk.hasMoreTokens()) {
//        			
//        			// use comma as separator
//        			s[i][j] = tk.nextToken();
//        			j++;
////        			System.out.print(s[i][j]+"  ");
//        		}
////        		System.out.println();
//        		i++;
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        
////        for(int i=0;i<19;i++){
//        	for(int j=0;j<17;j++){
//        		 System.out.println(s[j][1]+"  ");
//        	} System.out.println();
////        }
//    }

}