package base;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax { 
	static int[] solver(int[] arr, int k) {
		int n = arr.length;
		if(n <= 1) return arr;
		int[] ans = new int[n-k+1];
		Deque<Integer> dq = new LinkedList<>();
		int i = 0;
		for(; i < k; i++) {
			while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		for(; i < n; i++) {
			ans[i-k] = arr[dq.peekFirst()];
			while (!dq.isEmpty() && dq.peekFirst() <= i-k) {
				dq.removeFirst();
			}
			while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);	
		}
		ans[i-k] = arr[dq.peekFirst()];
		return ans;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements of array: ");
		for(int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		System.out.println("Enter value of k: ");
		int k = sc.nextInt();
		int[] ans = solver(arr, k);
		for(int temp: ans) System.out.print(temp + " ");
		sc.close();
	}

}
