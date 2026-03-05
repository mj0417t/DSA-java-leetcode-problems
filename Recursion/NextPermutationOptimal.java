import java.util.Arrays;

public class NextPermutationOptimal {
    public static void main(String[] args) {
        int[] nums= new int[]{2,5,1,4,3,0,0};
        System.out.println("Original Array: "+Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("Next Permutation: "+Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int n= nums.length;
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1)
            Arrays.sort(nums);
        else {
            for(int i=n-1;i>=index;i--){
                if(nums[i]>nums[index]){
                    int temp=nums[i];
                    nums[i]=nums[index];
                    nums[index]=temp;
                    break;
                }
            }
            reverse(nums, index+1, n-1);
        }

    }

    private static void reverse(int[] nums, int first, int last) {
        for(int i=0;i<=(last-first)/2;i++){
            int temp=nums[first+i];
            nums[first+i]=nums[last-i];
            nums[last-i]=temp;
        }

    }
}
