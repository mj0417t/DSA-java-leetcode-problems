import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class SubArrMinMumsSum {
    public static void main(String[] args) {
        int[] arr = {1,4,6,7,3,7,8,1};
//        System.out.println(sumSubarrayMins(arr)); //TLE for large size array / values
        System.out.println(sumSubarrayMinsOpt(arr));
    }

    private static int sumSubarrayMinsOpt(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        int[]nseIndex=nextSmallElement(map,arr);
        int[]pseIndex=prevSmallElement(map,arr);
        System.out.println(Arrays.toString(nseIndex));
        System.out.println(Arrays.toString(pseIndex));
        return 0;
    }

    private static int[] prevSmallElement(HashMap<Integer, Integer> map, int[] arr) {
        int[] pseInd= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!st.isEmpty() && st.peek()>=arr[i])
                st.pop();
            if(st.isEmpty())
                pseInd[i]=-1;
            else
                pseInd[i]=map.get(st.peek());

            st.push(arr[i]);
        }
        return pseInd;
    }

    private static int[] nextSmallElement(HashMap<Integer, Integer> map, int[] arr){

        int[] nseInd=new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty() && st.peek()>=arr[i])
                st.pop();
            if(st.isEmpty())
                nseInd[i]=arr.length;
            else
                nseInd[i]=map.get(st.peek());

            st.push(arr[i]);
        }
        return nseInd;
    }

    public static int sumSubarrayMins(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int mini=arr[i];
            for (int j = i; j < arr.length; j++) {
                mini=Math.min(mini,arr[j]);
                sum+=mini;
            }
        }
        return sum;
    }
}
