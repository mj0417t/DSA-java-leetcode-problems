import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayZeroSum {
    public static void main(String[] args) {
//        int[] arr = {1,-1,3,2,-2,-8,1,7,10,23};
//        int[] arr={9,-3,3,-1,6,-5};
        int[] arr={6,-2,2,-8,1,7,4,-10};
        int size=findLongestSubArray(arr);
        System.out.println("Maximum length of subarray with sum 0 : "+size);
    }

    private static int findLongestSubArray(int[] arr) {
        int maxi=0,sum=0;
        Map<Integer,Integer> map = new HashMap<>(); //to store preSub sum & index
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0)
                maxi=i+1;
            else{
                if (map.get(sum)!=null)
                    maxi=Math.max(maxi,i-map.get(sum));
                else
                    map.put(sum,i);
            }
        }
        return maxi;
    }
}
