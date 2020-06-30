package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPopEfficient {

	public static class QueueToStackAdapter {
		Queue<Integer> mq;
		Queue<Integer> hq;

		public QueueToStackAdapter() {
			mq = new ArrayDeque<>();
			hq = new ArrayDeque<>();
		}

		int size() {
			return mq.size();
		}

		void push(int val) {
			hq.add(val);
			while (mq.size() > 0) {
				hq.add(mq.remove());
			}
			Queue<Integer> temp = mq;
			mq = hq;
			hq = temp;
		}

		int pop() {
			if (this.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}
			return mq.remove();
		}

		int top() {
			if (this.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}
			return mq.peek();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		QueueToStackAdapter st = new QueueToStackAdapter();

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
			}
			str = br.readLine();
		}
	}
}
