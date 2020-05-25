package stacksAndQueuesCodes;

import java.util.*;

public class DuplicateBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        System.out.println(dupB(exp));
        scn.close();
    }
    public static boolean dupB(String exp) {
        Stack < Character > st = new Stack < > ();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            // System.out.println(ch);
            if (ch != ' ') {
                if (ch == '}' || ch == ')' || ch == ']') {
                    if (st.peek() == '(' || st.peek() == '{' || st.peek() == '[') {
                        return true;
                    } else if (ch == '}') {
                        while (st.peek() != '{') {
                            st.pop();
                        }
                        st.pop();
                    } else if (ch == ')') {
                        while (st.peek() != '(') {
                            st.pop();
                        }
                        st.pop();
                    } else if (ch == ']') {
                        while (st.peek() != '[') {
                            st.pop();
                        }
                        st.pop();
                    }
                } else {
                    st.push(ch);
                }
                // System.out.println(st);
            }
        }
        return false;
    }
}