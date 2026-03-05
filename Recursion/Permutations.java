import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums= new int[]{1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> ds = new ArrayList<>();
//        boolean freq[] = new boolean[nums.length];
//        recurPermute(nums,ds,ans,freq);
        findPermutations(0,nums,ans);
        System.out.println("Total permutations: "+ans.size());
        for (List<Integer> elem: ans)
            System.out.println(elem);


    }

    private static void findPermutations(int index, int[] nums, List<List<Integer>> ans) {
        if(index==nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i:nums){
                ds.add(i);
            }
            ans.add(ds);
//            System.out.println(Arrays.toString(nums));
            return;
        }
        for(int i=index;i< nums.length;i++){
            //swap
            swap(index,i,nums);
            findPermutations(index+1,nums,ans);
            swap(index,i,nums);
        }
    }

    private static void swap(int index, int i, int[] nums) {
        int temp=nums[i];
        nums[i]=nums[index];
        nums[index]=temp;
    }

    private static void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if(ds.size()== nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i< nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recurPermute(nums,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }

}
