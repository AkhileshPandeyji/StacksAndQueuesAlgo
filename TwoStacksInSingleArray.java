package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoStacksInSingleArray {
	  public static class TwoStack {
		    int[] data;
		    int tos1;
		    int tos2;

		    public TwoStack(int cap) {
		      data = new int[cap];
		      tos1=-1;
		      tos2=data.length;		      
		    }

		    int size1() {
		      return this.tos1+1;
		    }

		    int size2() {
		      return this.data.length - this.tos2;
		    }

		    void push1(int val) {
		    	if(this.tos1+1 == this.data.length || this.tos1+1 == this.tos2) {
		    		System.out.println("Stack overflow");
		    	}
		    	else {
		    		this.tos1++;
		    		this.data[this.tos1] = val;
		    	}
		    }

		    void push2(int val) {
		    	if(this.tos2-1 == -1 || this.tos2-1 == this.tos1) {
		    		System.out.println("Stack overflow");
		    	}
		    	else {
		    		this.tos2--;
		    		this.data[this.tos2] = val;
		    	}
		    }

		    int pop1() {
		      if(this.tos1==-1) {
		    	  System.out.println("Stack underflow");
		    	  return -1;
		      }
		      else {
		    	  int rv = this.data[this.tos1];
		    	  this.data[this.tos1] = 0;
		    	  this.tos1--;
		    	  return rv;
		      }
		    }

		    int pop2() {
		    	if(this.tos2 == this.data.length) {
		    		System.out.println("Stack underflow");
		    		return -1;
		    	}
		    	else {
		    		int rv = this.data[this.tos2];
		    		this.data[this.tos2] = 0;
		    		this.tos2++;
		    		return rv;
		    	}
		    }

		    int top1() {
		      if(this.tos1 == -1) {
		    	  System.out.println("Stack underflow");
		    	  return -1;
		      }
		      else {
		    	  return this.data[this.tos1];
		      }
		    }

		    int top2() {
		      if(this.tos2 == this.data.length) {
		    	  System.out.println("Stack underflow");
		    	  return -1;
		      }
		      else {
		    	  return this.data[this.tos2];
		      }
		    }
		  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine());
		    TwoStack st = new TwoStack(n);

		    String str = br.readLine();
		    while (str.equals("quit") == false) {
		      if (str.startsWith("push1")) {
		        int val = Integer.parseInt(str.split(" ")[1]);
		        st.push1(val);
		      } else if (str.startsWith("pop1")) {
		        int val = st.pop1();
		        if (val != -1) {
		          System.out.println(val);
		        }
		      } else if (str.startsWith("top1")) {
		        int val = st.top1();
		        if (val != -1) {
		          System.out.println(val);
		        }
		      } else if (str.startsWith("size1")) {
		        System.out.println(st.size1());
		      } else if (str.startsWith("push2")) {
		        int val = Integer.parseInt(str.split(" ")[1]);
		        st.push2(val);
		      } else if (str.startsWith("pop2")) {
		        int val = st.pop2();
		        if (val != -1) {
		          System.out.println(val);
		        }
		      } else if (str.startsWith("top2")) {
		        int val = st.top2();
		        if (val != -1) {
		          System.out.println(val);
		        }
		      } else if (str.startsWith("size2")) {
		        System.out.println(st.size2());
		      }
		      str = br.readLine();
		    }
		  }
}
