package coreJava;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ProcessList {
	enum days {  
		  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY  
		}  
	public static void main(String[] args) {  
	    Set<days> set = EnumSet.of(days.MONDAY);  
	    // Traversing elements  
	   for(days day:set) {
		   System.out.println(day.name());
		   if(day.name().equals("MONDAY")) {
			   System.out.println("yes");
		   }else {
			   System.out.println("no");
		   }
	   }
	   
	  String in[] = new String[getAll().size()];
	   in = getAll().toArray(in);
	   
	   for(String st: in) {
		   System.out.println(st);
	   }
	  } 
	
	public static List<String> getAll(){
		
		return Arrays.asList("first","second","third","fourth");
	}
}
