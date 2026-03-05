import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3,-3,1,1,1,4,2,-3};
        int k=3;
//        System.out.println("No of subarrays with sum equals "+ k+"= "+countSubArray(arr,k));
        System.out.println("No of subarrays with sum equals "+ k+"= "+countSubArrayBF(arr,k));

    }

    private static int countSubArrayBF(int[] arr, int k) {
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==k)
                    cnt++;
            }
        }
       return cnt;
    }

    private static int countSubArray(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        int preSum=0,cnt=0;
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            preSum+=arr[i];
            int remove=preSum-k;
            if (map.containsKey(remove)) {
                cnt += map.get(remove);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return  cnt;
    }
}
