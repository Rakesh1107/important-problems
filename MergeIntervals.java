package base;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static List<Interval> mergeIntervals(List<Interval> list, Interval newInterval) {
        if(list == null) {
        	list = new LinkedList<Interval>();
        	list.add(newInterval);
        	return list;
        } else if(list.size() == 0) {
        	list.add(newInterval);
        	return list;
        }
    	
    	int i = 0;
        while(i < list.size()) {
            Interval current = list.get(i);
            if(current.end < newInterval.start) {
                i++;
                continue;
            } else if(current.start > newInterval.end) {
                list.add(i, newInterval);
                break;
            } else {
                newInterval.start = Math.min(current.start, newInterval.start);
                newInterval.end = Math.max(current.end, newInterval.end);
                list.remove(i);
            }
        }
        if(i == list.size()) {
            list.add(newInterval);
        }
        return list;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Interval> list = new LinkedList<>();
        System.out.println("Enter size of the array: ");
        int n = sc.nextInt();
        System.out.println("Enter interval pairs");
        for(int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Interval temp = new Interval(start, end);
            list.add(temp);
        }
        System.out.println("Enter interval to add: ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        Interval newInterval = new Interval(start, end);
        List<Interval> newList = mergeIntervals(list, newInterval);
        for(Interval temp: newList) {
            System.out.println(temp.start + ", " + temp.end);
        }
        sc.close();
    }
}