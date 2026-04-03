import java.util.Arrays;
import java.util.Stack;

public class NextGreatElemII {
    //for circular array
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3}; //circular array
        System.out.println(Arrays.toString(nextGreaterElements(nums)));

    }

    public static int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2*n-1; i >=0; i--) {
            while(!st.isEmpty() && st.peek()<=nums[i%n])
                st.pop();
            if(st.isEmpty())
                nge[i%n]=-1;
            else
                nge[i%n]=st.peek();
            st.push(nums[i%n]);

        }

        return nge;
    }
}
