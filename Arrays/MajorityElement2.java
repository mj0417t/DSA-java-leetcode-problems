import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr= new int[]{3,2,3};
        System.out.println(findMajorityElements(arr));
    }

    private static List<Integer> findMajorityElements(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            System.out.printf("Key: %d            Value: %d\n",e.getKey(),e.getValue());
            if(e.getValue()>n/3)
                res.add(e.getKey());
        }
        return res;
    }
}
