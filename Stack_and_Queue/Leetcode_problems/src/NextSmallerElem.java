import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElem {
    public static void main(String[] args) {
        int[] nums = {10,9,8,6,7,5};
//        int[] nums = {4,8,5,2,25};
        System.out.println(Arrays.toString(nextSmallerElements(nums)));
    }

    private static int[] nextSmallerElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            while (!st.isEmpty() && st.peek()>=nums[i])
                st.pop();
            if(!st.isEmpty())
                res[i]=st.peek();
            st.push(nums[i]);
        }
        return res;
    }
}
