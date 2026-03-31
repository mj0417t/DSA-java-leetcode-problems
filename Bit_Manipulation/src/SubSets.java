import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        List<List<Integer>> res=subsets(nums); //using recursion
        List<List<Integer>> res=subsetsOpt(nums); //using bit manipulation
        System.out.println(res);

    }

    private static List<List<Integer>> subsetsOpt(int[] nums) {
        int n=nums.length;
        int subsets = (1<<n); //2^n
        List<List<Integer>> ans=new ArrayList<>();
        for (int num = 0; num < subsets ; num++) {
            List<Integer> subset=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((num&(1<<i))!=0)
                    subset.add(nums[i]);
            }
            ans.add(subset);
        }
        return ans;
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ds =new ArrayList<>();
        generateSubset(0,nums,ds,res);
        return res;
    }

    private static void generateSubset(int index, int[] nums, List<Integer> ds, List<List<Integer>> res) {
        if(index==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        generateSubset(index+1,nums,ds,res);
        ds.removeLast();
        generateSubset(index+1,nums,ds,res);
    }

}
