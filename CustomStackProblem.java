package stacksAndQueuesCodes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CustomStackProblem {
	public static class CustomStack {
	    int[] data;
	    int tos;

	    public CustomStack(int cap) {
	      data = new int[cap];
	      tos = -1;
	    }

	    int size() {
	      return this.tos+1;
	    }

	    void display() {
	      if(this.tos == -1) {
	    	  System.out.println("Stack underflow");
	      }
	      else {
	    	  for(int i=this.tos;i>=0;i--) {
		    	  System.out.print(this.data[i]+" ");
		      }  
	    	  System.out.println();
	      }	      
	    }

	    void push(int val) {
	      if(this.tos+1<this.data.length) {
	    	  this.tos++;
	    	  data[this.tos] = val;
	      }	      
	      else
	      System.out.println("Stack overflow");	    	  
	    }

	    int pop() {
	      if(this.tos == -1) {
	    	  System.out.println("Stack underflow");
	    	  return -1;
	      }
	      int val = this.data[this.tos];
	      this.data[this.tos] = 0;
	      this.tos--;
	      return val;
	    }

	    int top() {
	       if(this.tos == -1) {
	    	   System.out.println("Stack underflow");
	    	   return -1;
	       }
	       else {
	    	   return this.data[this.tos];
	       }
	    }
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    CustomStack st = new CustomStack(n);

	    String str = br.readLine();
	    while(str.equals("quit") == false){
	      if(str.startsWith("push")){
	        int val = Integer.parseInt(str.split(" ")[1]);
	        st.push(val);
	      } else if(str.startsWith("pop")){
	        int val = st.pop();
	        if(val != -1){
	          System.out.println(val);
	        }
	      } else if(str.startsWith("top")){
	        int val = st.top();
	        if(val != -1){
	          System.out.println(val);
	        }
	      } else if(str.startsWith("size")){
	        System.out.println(st.size());
	      } else if(str.startsWith("display")){
	        st.display();
	      }
	      str = br.readLine();
	    }
	  }
}
