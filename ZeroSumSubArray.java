package base;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ZeroSumSubArray {
	// K SUM SUB ARRAY
	static void solver(int[] arr, int k) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		boolean present = false;
		for(int temp: arr) {
			set.add(sum);
			sum+=temp;
			if(set.contains(sum-k) || temp == k || sum == k) {
				present = true;
				break;
			}
		}
		if(present) System.out.println("present");
		else System.out.println("not present");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int k = sc.nextInt();
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		solver(arr, k);
		sc.close();
	}

}
