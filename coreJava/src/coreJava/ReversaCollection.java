package coreJava;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ReversaCollection {
	
	
	public static TreeSet<String> data(TreeSet<String> set) {		
		return set;
	}
	
	public static TreeSet<String> reverseCollection(){		 
		return new TreeSet<String>((a,b)->b.compareTo(a));
	}
	
	public static TreeSet<String> naturalCollection(){		 
		return new TreeSet<String>((a,b)->a.compareTo(b));
	}
	
	
	
	
	public static void main(String[] args) {
		
		TreeSet<String> data=	data(reverseCollection());
		data.add("A");
		data.add("E");
		data.add("C");
		data.add("D");
		data.add("B");
		for(String st:data) {
			System.out.println(st);
		}

	}

}
