package coreJava;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Comps {

	public static void main(String[] args) {

		Set<String> set = new TreeSet<>((a, b) -> b.compareTo(a));
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");

		for (String s : set) {
			System.out.println(s);
		}
	}

	
	public Set reversComparing(TreeSet<String> str) {
		TreeSet<String> set = new TreeSet<>((a, b) -> b.compareTo(a));
		str=set;
		return str;
	}
}
