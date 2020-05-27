package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixEvaluation {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        System.out.println(infixEval(exp));
    }

    public static int infixEval(String exp) {
        Stack < Integer > numbrs = new Stack < > ();
        Stack < Character > optrs = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numbrs.push(ch - '0');
            } else if (ch == '(') {
                optrs.push(ch);
            } else if (ch == ')') {
                while (optrs.size() > 0 && optrs.peek() != '(') {
                    char optr = optrs.pop();
                    int num2 = numbrs.pop();
                    int num1 = numbrs.pop();
                    int ans = solve(optr, num1, num2);
                    numbrs.push(ans);
                }
                optrs.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (optrs.size() > 0 && optrs.peek() != '(' && pred(optrs.peek()) >= pred(ch)) {
                    char optr = optrs.pop();
                    int num2 = numbrs.pop();
                    int num1 = numbrs.pop();
                    int ans = solve(optr, num1, num2);
                    numbrs.push(ans);
                }
                optrs.push(ch);
            }
        }

        while (optrs.size() > 0) {
            char optr = optrs.pop();
            int num2 = numbrs.pop();
            int num1 = numbrs.pop();
            int ans = solve(optr, num1, num2);
            numbrs.push(ans);
        }

        return numbrs.peek();

    }

    public static int solve(char op, int num1, int num2) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else if (op == '*') {
            return num1 * num2;
        } else {
            return num1 / num2;
        }
    }

    public static int pred(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        else{
            return 0;
        }
    }
}
