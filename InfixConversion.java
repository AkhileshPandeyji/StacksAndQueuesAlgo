package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixConversion {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		infixConv(exp);
	}

	public static void infixConv(String exp) {
		Stack<String> prefix = new Stack<>();
		Stack<String> postfix = new Stack<>();
		Stack<Character> optrs = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (isOprnd(ch)) {
				prefix.push(ch + "");
				postfix.push(ch + "");
			} else if (ch == '(') {
				optrs.push(ch);
			} else if (ch == ')') {
				while (optrs.size() > 0 && optrs.peek() != '(') {
					String optr = "" + optrs.pop();
					String preOp2 = prefix.pop();
					String preOp1 = prefix.pop();
					prefix.push(optr + preOp1 + preOp2);
					String postOp2 = postfix.pop();
					String postOp1 = postfix.pop();
					postfix.push(postOp1 + postOp2 + optr);
				}
				optrs.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (optrs.size() > 0 && optrs.peek() != '(' && pred(ch) <= pred(optrs.peek())) {
					String optr = "" + optrs.pop();
					String preOp2 = prefix.pop();
					String preOp1 = prefix.pop();
					prefix.push(optr + preOp1 + preOp2);
					String postOp2 = postfix.pop();
					String postOp1 = postfix.pop();
					postfix.push(postOp1 + postOp2 + optr);
				}
				optrs.push(ch);
			}

		}
		while (optrs.size() > 0) {
			String optr = "" + optrs.pop();
			String preOp2 = prefix.pop();
			String preOp1 = prefix.pop();
			prefix.push(optr + preOp1 + preOp2);
			String postOp2 = postfix.pop();
			String postOp1 = postfix.pop();
			postfix.push(postOp1 + postOp2 + optr);
		}
		System.out.println(postfix.peek());
		System.out.println(prefix.peek());
	}

	public static int pred(char ch) {
		if (ch == '+' || ch == '-') {
			return 1;
		} else {
			return 2;
		}
	}

	public static boolean isOprnd(char ch) {
		if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
			return true;
		} else {
			return false;
		}
	}
}
