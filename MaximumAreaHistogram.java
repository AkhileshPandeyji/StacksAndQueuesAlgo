package stacksAndQueuesCodes;

import java.util.*;

public class MaximumAreaHistogram {


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int heights[] = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }
        System.out.println(maxHist(heights));
        scn.close();
    }

    public static int maxHist(int[] heights) {
        Stack < Integer > st = new Stack < > ();
        int nSETL[] = new int[heights.length];
        int nSETR[] = new int[heights.length];

        
        nSETL[0] = -1;
        st.push(0);       

        for (int i = 1; i < heights.length; i++) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.size() > 0) {
                nSETL[i] = st.peek();
            } else {
                nSETL[i] = -1;
            }

            st.push(i);
        }
        
        st.clear(); 
        nSETR[heights.length - 1] = heights.length;
        st.push(heights.length-1);
        
        for (int i = heights.length - 2; i >= 0; i--) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.size() > 0) {
                nSETR[i] = st.peek();
            } else {
                nSETR[i] = heights.length;
            }

            st.push(i);
        }

        int width = 0;
        int fin = 0;
        
        for(int i=0;i<heights.length;i++){
            width = nSETR[i] - nSETL[i] - 1;
            if(fin<(width*heights[i])){
                fin = width*heights[i];
            }
        }
        
        for(int i=0;i<heights.length;i++) {
        	System.out.print(nSETL[i]+":");
        }
        System.out.println();
        for(int i=0;i<heights.length;i++) {
        	System.out.print(nSETR[i]+":");
        }
        System.out.println();

        return fin;
    }

}