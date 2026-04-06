import java.util.Stack;

public class LargestRectinHistogram {
    public static void main(String[] args) {
        int[] heights = {3,2,10,11,5,10,6,3};
//        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleAreaOpt(heights));
    }

    private static int largestRectangleAreaOpt(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()]>heights[i]){
                int elemToDiscard=st.peek();
                st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                int area=heights[elemToDiscard]*(nse-pse-1);
                maxArea=Integer.max(area,maxArea);
            }
            st.push(i);
        }
        while (!st.isEmpty()){
            int nse=heights.length;
            int elemToDiscard=st.peek();
            st.pop();
            int pse =st.isEmpty()?-1:st.peek();
            int area=heights[elemToDiscard]*(nse-pse-1);
            maxArea=Integer.max(area,maxArea);
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea=Integer.MIN_VALUE;
        int[] nse=getNextSmallElem(heights);
        int[] pse=getPrevSmallElem(heights);
        for (int i = 0; i < heights.length; i++) {
            int area=heights[i]*(nse[i]-pse[i]-1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }

    private static int[] getPrevSmallElem(int[] heights) {
        int n=heights.length;
        int[] ans=new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <heights.length ; i++) {
            while (!st.isEmpty() && heights[st.peek()]>heights[i])
                st.pop();
            ans[i]=(st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        return ans;
    }

    private static int[] getNextSmallElem(int[] heights) {
        int n=heights.length;
        int[] ans=new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while (!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            ans[i]=(st.isEmpty())?n:st.peek();
            st.push(i);
        }
        return ans;
    }
}
