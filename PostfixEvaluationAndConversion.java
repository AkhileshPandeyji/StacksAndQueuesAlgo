package stacksAndQueuesCodes;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationAndConversion {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String exp = scn.nextLine();
		postfixEval(exp);
		scn.close();
	}
	
	public static void postfixEval(String exp) {
		Stack<Integer> eval = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<String> prefix = new Stack<>();
		
		for(int i=0;i<exp.length();i++) {
			char ch = exp.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				int num2 = eval.pop();
				int num1 = eval.pop();
				int ans = solve(ch,num1,num2);
				eval.push(ans);
				
				String iop2 = infix.pop();
				String iop1 = infix.pop();
				infix.push("("+iop1+ch+iop2+")");
				
				String pop2 = prefix.pop();
				String pop1 = prefix.pop();
				prefix.push(ch+pop1+pop2);
			}
			else {
				eval.push(ch-'0');
				infix.push(""+ch);
				prefix.push(""+ch);
			}
		}
		
		System.out.println(eval.peek());
		System.out.println(infix.peek());
		System.out.println(prefix.peek());
	}
	public static int solve(char ch,int num1,int num2) {
		if(ch == '+') {
			return num1+num2;
		}
		else if(ch == '-') {
			return num1-num2;
		}
		else if(ch == '*'){
			return num1*num2;
		}
		else {
			return num1/num2;
		}
	}
}
