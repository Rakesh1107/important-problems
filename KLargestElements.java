package base;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
	
	static void findKLargest(int[]arr, int k) {
		// MIN-HEAP METHOD
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for(int i = k; i < arr.length; i++) {
			if(arr[i] < pq.peek()) continue;
			else {
				pq.poll();
				pq.add(arr[i]);
			}
		}
		
		Iterator<Integer> iterator = pq.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter value of k: ");
		int k = sc.nextInt();
		System.out.println("Enter array elements: ");
		for(int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		findKLargest(arr, k);
		sc.close();
	}

}
