import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElem {
    public static void main(String[] args) {
        int[] nums1 = {2,4}, nums2 = {1,2,3,4};
//        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
        System.out.println(Arrays.toString(nextGreaterElementOpt(nums1,nums2)));

    }

    private static int[] nextGreaterElementOpt(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map_nums1 = new HashMap<>();
        int[] res= new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            map_nums1.put(nums1[i],i);
        }
        int[] nge=new int[nums2.length];
        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length-1; i >=0 ; i--) {
            while (!st.isEmpty() && st.peek()<=nums2[i])
                st.pop();
            if(st.isEmpty())
                nge[i]=-1;
            else
                nge[i]=st.peek();
            st.push(nums2[i]);

            if(map_nums1.containsKey(nums2[i]))
                res[map_nums1.get(nums2[i])]=nge[i];
        }

        return res;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j]==nums1[i]){
                    int k = j+1;
                    for (; k < nums2.length; k++) {
                        if(nums2[k]>nums1[i]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    if(k>=nums2.length)
                        res[i]=-1;

                }
            }
        }
        return res;
    }
}
