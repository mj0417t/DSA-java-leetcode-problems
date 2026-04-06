import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] arr=new int[n];
        int maxRecArea=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='0')
                    arr[j]=0;
                else
                    arr[j]+=(matrix[i][j]-'0');
            }
            maxRecArea=Integer.max(maxRecArea,largestRectangleArea(arr));
        }
        return maxRecArea;
    }
    private static int largestRectangleArea(int[] heights) {
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
}
