package com.code.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//sort the map objects in descending order of the key
import java.util.TreeMap;

public class MapSortingCustom {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(101, "john");
		map.put(185, "rack");
		map.put(220, "dim");
		map.put(111, "lor");
		map.put(91, "khan");
		map.put(78, "paran");

		System.out.println("Unsorted Map=" + map);

		TreeMap<Integer, String> tm = new TreeMap<Integer, String>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o2.compareTo(o1);
			}
		});
		tm.putAll(map);
		System.out.println("Sorted Map by key " + tm);

		tm.putAll(map);
		System.out.println("Sorted Map is " + tm);

		List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(map.entrySet());
	}

}
