package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackToQueueAdapterRemoveEfficient {
	public static class StackToQueueAdapter {
	    Stack<Integer> ms;
	    Stack<Integer> hs;

	    public StackToQueueAdapter() {
	      ms = new Stack<>();
	      hs = new Stack<>();
	    }

	    int size() {
	      return ms.size();
	    }

	    void add(int val) {
	      while(ms.size()>0) {
	    	  hs.push(ms.pop());
	      }
	      hs.push(val);
	      while(hs.size()>0) {
	    	  ms.push(hs.pop());
	      }
	    }

	    int remove() {
	      if(this.size() == 0) {
	    	  System.out.println("Queue underflow");
	    	  return -1;
	      }
	      return ms.pop();
	    }

	    int peek() {
	      if(this.size() == 0) {
	    	  System.out.println("Queue underflow");
	    	  return -1;
	      }
	      return ms.peek();
	    }
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StackToQueueAdapter qu = new StackToQueueAdapter();

	    String str = br.readLine();
	    while (str.equals("quit") == false) {
	      if (str.startsWith("add")) {
	        int val = Integer.parseInt(str.split(" ")[1]);
	        qu.add(val);
	      } else if (str.startsWith("remove")) {
	        int val = qu.remove();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("peek")) {
	        int val = qu.peek();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("size")) {
	        System.out.println(qu.size());
	      }
	      str = br.readLine();
	    }
	  }
}
