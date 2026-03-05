import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {

//        int[] nums= new int[]{2,5,1,4,3,0,0};
        int[] nums= new int[]{1,2,3};

        //Brute Force
        String originalArray = Arrays.toString(nums);
        System.out.println("Original Array: "+originalArray);

        List<String> ans = new ArrayList<>();
        String nextPermutation;

        findPermutations(0,nums,ans);
        ans.sort(Comparator.naturalOrder());
//        System.out.println(ans);
        int ind=-1;
        for(String perm:ans){
            if(perm.equals(originalArray)){
                ind=ans.indexOf(perm);
                break;
            }

        }

        if(ind==ans.size()-1)
            nextPermutation = ans.get(0);
        else
            nextPermutation =ans.get(ind+1);

        System.out.println("Next Permutation: "+nextPermutation);

    }

    private static void findPermutations(int index, int[] nums, List<String>  ans) {
        if(index==nums.length){
            ans.add(Arrays.toString(nums));
            return;
        }
        for(int i=index;i< nums.length;i++){
            //swap
            swap(index,i,nums);
            findPermutations(index+1,nums,ans);
            swap(index,i,nums); //backtracking
        }
    }

    private static void swap(int index, int i, int[] nums) {
        int temp=nums[i];
        nums[i]=nums[index];
        nums[index]=temp;
    }
}
