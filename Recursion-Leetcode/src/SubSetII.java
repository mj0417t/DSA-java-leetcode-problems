import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
    public static void main(String[] args) {
        int[] arr={1,2,2};
        List<List<Integer>> res=subsetsWithDup(arr);
        System.out.println(res);
    }
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        Arrays.sort(nums);
        generateSubset(nums,0,ds,res);
        return res;
    }

    private static void generateSubset(int[] nums, int ind, List<Integer> ds, List<List<Integer>> res) {
        if(ind>=nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        //include
        ds.add(nums[ind]);
        generateSubset(nums,ind+1,ds,res);
        ds.removeLast();

        //not include
        while(ind+1< nums.length && nums[ind]==nums[ind+1])
            ind++;
        generateSubset(nums, ind+1, ds, res);
    }
}
