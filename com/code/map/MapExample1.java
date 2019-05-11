package com.code.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;


public class MapExample1 {
	@Test
	public void test1() {
		// Does not maintain Insertion order
		Map<String, String> map = new HashMap<String, String>();
		map.put("i", "A");
		map.put("jt", "B");
		map.put("tk", "C");
		map.put("l", "D");
		map.put("mi", "E");
		map.put("n", "F");
		map.put("o", "F");
		System.out.println(map);

		// Maintain Insertion order
		LinkedHashMap<String, String> limap = new LinkedHashMap<String, String>();
		limap.put("i", "A");
		limap.put("jt", "B");
		limap.put("tk", "C");
		limap.put("l", "D");
		limap.put("mi", "E");
		limap.put("n", "F");
		limap.put("o", "F");
		limap.put(null, "");
		limap.put(null, "dsgsd");
		System.out.println(limap);

		// To Display Key and Values separtately
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());// [tk=C, i=A, jt=B, l=D, mi=E, n=F,
											// o=F]

		System.out.println(limap.equals(map));

		TreeMap<String, String> tm = new TreeMap<String, String>();
		tm.put("i", "A");
		tm.put("jt", "B");
		tm.put("tk", "C");
		tm.put("l", "D");
		tm.put("mi", "E");
		tm.put("n", "F");
		tm.put("o", "F");
		System.out.println(tm);

		//converting map to arraylist
		Set<Entry<String, String>> s = map.entrySet();
		ArrayList<Entry<String, String>> a = new ArrayList<Entry<String, String>>(s);
		System.out.println("---------------------------------------");
		for (Entry e : a) {
			System.out.println(e);
		}
	}
}
