package coreJava;

import java.util.HashMap;
import java.util.HashSet;

public class CollectMap<E> extends HashSet<E> {
	MyMap map;
	CollectMap(E entry){
		this.map = (MyMap) entry;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6204375162490858485L;
	
	static class MyMap<K, V> extends HashMap<K,V>{
		
	}

}
