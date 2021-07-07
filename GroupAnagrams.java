package base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagrams {
	
	static List<List<String>> solver(String[] arr) {
		Map<String, List<String>> map = new HashMap<>();
		for(String s: arr) {
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String sorted = new String(temp);
			if(!map.containsKey(sorted)) 
				map.put(sorted, new LinkedList<>());
			map.get(sorted).add(s);
		}
		List<List<String>> list = new LinkedList<>(map.values());
		return list;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) 
			arr[i] = sc.next();
		List<List<String>> list = solver(arr);
		for(List<String> l: list) {
			System.out.println(l);
		}
		sc.close();
		
	}

}
