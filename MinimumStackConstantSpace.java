package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumStackConstantSpace {
	public static class MinStack {
		Stack<Integer> data;
		int min;

		public MinStack() {
			data = new Stack<>();
		}

		int size() {
			return this.data.size();
		}

		void push(int val) {			
			if(this.data.size() == 0) {
				this.data.push(val);
				this.min = val;
			}
			else if(val >= this.min) {
				this.data.push(val);
			}
			else {
				int x = (2*val)-this.min;
				this.data.push(x);
				this.min = val;
			}
		}

		int pop() {
			if(this.data.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}
			else if(this.data.peek() >= this.min) {
				return this.data.pop();
			}
			else {
				int x = this.data.pop();
				int currMin = this.min;
				this.min = 2*(currMin)-x;
				return currMin;
			}
		}

		int top() {
			if(this.data.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}
			else if(this.data.peek() >= this.min) {
				return this.data.peek();
			}
			else {
				return this.min;
			}
		}

		int min() {
			if(this.data.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}
			else {
				return this.min;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MinStack st = new MinStack();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("push")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				st.push(val);
			} else if (str.startsWith("pop")) {
				int val = st.pop();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("top")) {
				int val = st.top();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(st.size());
			} else if (str.startsWith("min")) {
				int val = st.min();
				if (val != -1) {
					System.out.println(val);
				}
			}
			str = br.readLine();
		}
	}
}
