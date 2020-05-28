package stacksAndQueuesCodes;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MergeOverlappingIntervals {
	static class Interval implements Comparable<Interval>{
		int start;
		int end;
		
		public int compareTo(Interval other) {
			return this.start - other.start;
		}
	}
	
	
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		Interval[] intervals = new Interval[n];
		
		for(int i=0;i<n;i++) {
			intervals[i] = new Interval();
			intervals[i].start = scn.nextInt();
			intervals[i].end = scn.nextInt();
		}
		
		Arrays.sort(intervals);		
		mergeOverlappingIntervals(intervals);
		scn.close();
	}
	
	public static void mergeOverlappingIntervals(Interval[] intervals) {
		
		Stack<Interval> st = new Stack<>();
		st.push(intervals[0]);	
		
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i].start <= st.peek().end) {
				int max = (intervals[i].end>=st.peek().end)?intervals[i].end:st.peek().end;
				Interval temp = new Interval();
				temp.start = st.peek().start;
				temp.end = max;
				st.pop();
				st.push(temp);				
			}
			else {
				st.push(intervals[i]);
			}
		}
		
		for(int i=0;i<st.size();i++) {
			System.out.println(st.get(i).start+" "+st.get(i).end);
		}
		
	}
}
