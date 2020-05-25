package stacksAndQueuesCodes;
import java.util.*;

public class BalancedBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        System.out.println(balB(exp));
        scn.close();
    }
    public static boolean balB(String exp) {

        Stack < Character > st = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else if (ch == '}') {
                if (st.size() == 0 || st.peek() != '{')
                    return false;
                else
                    st.pop();

            } else if (ch == ']') {
                if (st.size() == 0 || st.peek() != '[')
                    return false;
                else
                    st.pop();

            } else if (ch == ')') {
                if (st.size() == 0 || st.peek() != '(')
                    return false;
                else
                    st.pop();
            }
        }

        return st.size() == 0;
    }

}
