package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPushEfficient {
	static class QueueToStackAdapter{
		Queue<Integer> mq;
		Queue<Integer> hq;
		QueueToStackAdapter(){
			mq = new ArrayDeque<Integer>();
			hq = new ArrayDeque<Integer>();
		}
		
		public void push(int val) {
			mq.add(val);
		}
		public int size() {
			return mq.size();
		}
		public int pop() {
			if(this.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}
			while(mq.size()>1) {
				int rem = mq.remove();
				hq.add(rem);
			}
			int rem = mq.remove();
			
			while(hq.size()>0){
				int val = hq.remove();
				mq.add(val);
			}
			return rem;
		}
		public int top() {
			if(this.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}
			int rem = 0;
			while(mq.size()>0) {
				rem = mq.remove();
				hq.add(rem);
			}
			while(hq.size()>0) {
				int val = hq.remove();
				mq.add(val);
			}
			return rem;
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
