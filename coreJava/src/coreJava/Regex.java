package coreJava;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	static List<String> lists = Arrays.asList(" conroy white ", " delroy lindo ", " conroy white ", " timothy white ",
			" conroy white ", " stephen white ", " conroy white ", " zulhra white ");
	

	public static void main(String[] args) {
//		String name = "the value of the data id the value of the data the";
//
//		Pattern pattern = Pattern.compile("the");
//		Matcher matches = pattern.matcher(name);
//		int i = 0;
//		while (matches.find()) {
//			i++;
//
//		}
//		System.out.println(i);
//
//		System.out.println(findChar(name, 't'));
//		for(String st:lists) {
//			Pattern pattern2 = Pattern.compile("conroy white");
//			Matcher match = pattern2.matcher(st);
//			int s = 0;
//			while(match.find()) {
//				System.out.println(s++);
//				
//				
//			}
//			
//		}
		int index=0;
		String result = S();
		Pattern pattern = Pattern.compile("white");
		Matcher matcher = pattern.matcher(result);
		while(matcher.find()) {
			
			index++;
		}
		System.out.println(index);
		
	}

	public static int findChar(String name, char c) {
		int x = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == c) {
				x++;
			}

		}
		return x;

	}
	
	public static String S() {
		String st="";
		for(String string:lists) {
			st+=string;
		}
		return st;
		
	}

}
