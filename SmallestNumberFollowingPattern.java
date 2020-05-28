package stacksAndQueuesCodes;

import java.util.Scanner;
import java.util.Stack;

public class SmallestNumberFollowingPattern {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		String exp = scn.nextLine();
		printPattern(exp);
		scn.close();
	}
	
	public static void printPattern(String exp) {
		Stack<Integer> st = new Stack<>();
		int count = 1;
		String ans = "";
		
		for(int i=0;i<=exp.length();i++) {
			st.push(count);
			count++;
			while(st.size()>0 && (i == exp.length() || exp.charAt(i) == 'i')) {
				ans+=st.pop();
			}
		}
		
		System.out.println(ans);		
	}
	
	
}
