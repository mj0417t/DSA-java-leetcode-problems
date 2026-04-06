import java.util.Stack;

public class SubArrRangeSum {
    public static void main(String[] args) {
        int[]  nums = {4,-2,-3,4,1};
//        System.out.println(subArrayRanges(nums));
//        System.out.println(subArrayRangesBet(nums));
        System.out.println(subArrayRangesOpt(nums));
    }

    private static long subArrayRangesOpt(int[] nums) {
        //sum of subArr ranges = sum of subarr maxs- sum of subarr mins
        int[] nse = getNextSmallElem(nums);
        int[] pse = getPrevSmallElem(nums);
        int[] nge = getNextGreatElem(nums);
        int[] pge = getPrecGreatElem(nums);

        long sum=0L,sumMins=0L,sumMaxs=0L;
        //sum of subArr Mins
        for (int i = 0; i < nums.length; i++) {
            long left= i-pse[i];
            long right = nse[i]-i;
            long contributn = right*left*nums[i];
            sumMins+=contributn;
        }

        //sum of subArr Maxs
        for (int i = 0; i < nums.length; i++) {
            long left= i-pge[i];
            long right = nge[i]-i;
            long contributn = right*left*nums[i];
            sumMaxs+=contributn;
        }
        return sumMaxs-sumMins;
    }

    private static int[] getPrecGreatElem(int[] arr) {
        int[] pgeInd= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!st.isEmpty() && arr[st.peek()]<arr[i])
                st.pop();
            if(st.isEmpty())
                pgeInd[i]=-1;
            else
                pgeInd[i]=st.peek();

            st.push(i);
        }
        return pgeInd;
    }

    private static int[] getNextGreatElem(int[] arr) {
        int[] ngeInd=new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty() && arr[st.peek()]<=arr[i])
                st.pop();
            if(st.isEmpty())
                ngeInd[i]=arr.length;
            else
                ngeInd[i]=st.peek();

            st.push(i);
        }
        return ngeInd;
    }

    private static int[] getPrevSmallElem(int[] arr) {
        int[] pseInd= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!st.isEmpty() && arr[st.peek()]>arr[i])
                st.pop();
            if(st.isEmpty())
                pseInd[i]=-1;
            else
                pseInd[i]=st.peek();

            st.push(i);
        }
        return pseInd;
    }

    private static int[] getNextSmallElem(int[] arr){

        int[] nseInd=new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                nseInd[i]=arr.length;
            else
                nseInd[i]=st.peek();

            st.push(i);
        }
        return nseInd;
    }

    private static long subArrayRangesBet(int[] nums) {
        long sum= 0L;
        for (int i = 0; i < nums.length; i++) {
            int large=nums[i], small=nums[i];
            for (int j = i; j < nums.length; j++) {
                if(nums[j]>large) large=nums[j];
                if(nums[j]<small) small=nums[j];
                long range=large-small;
                sum+=range;
            }
        }
        return sum;
    }

    public static long subArrayRanges(int[] nums) {
        long sum= 0L;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int large=Integer.MIN_VALUE, small=Integer.MAX_VALUE;
                for (int k = i; k <=j; k++) {
                    if(nums[k]>large) large=nums[k];
                    if(nums[k]<small) small=nums[k];
                }
                long range=large-small;
                sum+=range;
            }
        }
        return sum;
    }
}
