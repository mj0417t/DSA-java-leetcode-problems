import java.util.Stack;

public class SubArrMinMumsSum {

    public static void main(String[] args) {
//        int[] arr = {3,1,2,4};
        int[] arr = {71,55,82,55};
//        System.out.println(sumSubarrayMins(arr)); //TLE for large size array / values
        System.out.println(sumSubarrayMinsOpt(arr));
    }

    private static int sumSubarrayMinsOpt(int[] arr) {
        int MOD=(int)(1e9+7);
        int[]nseIndex=nextSmallElement(arr);
        int[]pseIndex=prevSmallElement(arr);

        int total=0;

        for (int i = 0; i < arr.length; i++) {
            long subArrs=(long) (i-pseIndex[i])*(nseIndex[i]-i);
            long contribution=(arr[i]*subArrs)%MOD;
            total=(int)((total+contribution)%MOD);
        }

        return total;
    }

    private static int[] prevSmallElement(int[] arr) {
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

    private static int[] nextSmallElement(int[] arr){

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
