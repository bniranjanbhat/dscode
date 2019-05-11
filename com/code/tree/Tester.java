package com.code.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tester {

	public static void main(String[] args) {
		Map<Integer, String> testMap = new HashMap<>();
			
		testMap.put(2,"test2");
		testMap.put(3,"test3");
		testMap.put(4,"test4");
		Set<Map.Entry<Integer, String>> entrySet = testMap.entrySet();
		for(Map.Entry<Integer, String> testEntry: entrySet) {
			if(testEntry.getKey().equals(3))
					testEntry.setValue("");
		}
		
		Set<String> testSet = new HashSet<>();
		for(String s : testSet) {
			System.out.println(s);
		}
	}

}
