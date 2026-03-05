import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraysWithXOR_k {
    public static void main(String[] args) {
        int[] arr={4,2,2,6,4};
        int k1=6;
        int[] arr2={5,6,7,8,9};
        int k2=5;

        System.out.println("No. of subarray with xor equals "+k1+"in the array "
                + Arrays.toString(arr)+ " is "+findSubArrayCnt(arr,k1));
        System.out.println("No. of subarray with xor equals "+k2+"in the array "+
                Arrays.toString(arr2)+ " is "+findSubArrayCnt(arr2,k2));
    }

    private static int findSubArrayCnt(int[] arr, int k) {
        int cnt=0,xOR=0;
        Map<Integer,Integer> map = new HashMap<>();//to store front xor & cnt
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            xOR^=arr[i];
            int x=xOR^k;
            if(map.containsKey(x)){
                cnt+= map.get(x);
            }
            map.put(xOR,map.getOrDefault(xOR,0)+1);
        }
        return cnt;
    }
}
