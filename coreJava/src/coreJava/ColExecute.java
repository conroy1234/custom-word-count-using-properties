package coreJava;

import java.util.Map.Entry;
import java.util.Set;

public class ColExecute {

	public static void main(String[] args) {
		CollectMap.MyMap<String, String> my = new CollectMap.MyMap<String, String>();
		my.put("1", "conroy");
		my.put("2", "zulhra");
		
		Set<Entry<String, String>> str = my.entrySet();
		
	
		
		for(CollectMap.MyMap.Entry<String, String> entry:str) {
			System.out.println(entry.getValue());
		}
		
	}

}
