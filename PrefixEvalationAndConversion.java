package stacksAndQueuesCodes;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvalationAndConversion {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String exp = scn.nextLine();
		prefixEval(exp);
		scn.close();
	}

	public static void prefixEval(String exp) {
		Stack<Integer> eval = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<String> postfix = new Stack<>();

		for (int i = exp.length() - 1; i >= 0; i--) {
			char ch = exp.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				int num1 = eval.pop();
				int num2 = eval.pop();
				int ans = solve(ch, num1, num2);
				eval.push(ans);

				String iop1 = infix.pop();
				String iop2 = infix.pop();
				infix.push("(" + iop1 + ch + iop2 + ")");

				String pop1 = postfix.pop();
				String pop2 = postfix.pop();
				postfix.push(pop1 + pop2 + ch);
			} else {
				eval.push(ch - '0');
				infix.push("" + ch);
				postfix.push("" + ch);
			}
		}

		System.out.println(eval.peek());
		System.out.println(infix.peek());
		System.out.println(postfix.peek());
	}

	public static int solve(char ch, int num1, int num2) {
		if (ch == '+') {
			return num1 + num2;
		} else if (ch == '-') {
			return num1 - num2;
		} else if (ch == '*') {
			return num1 * num2;
		} else {
			return num1 / num2;
		}
	}
}
