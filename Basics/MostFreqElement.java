import java.util.*;

class MostFreqElement {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,9,9,9,9,9,9,9,9};
        int k=10;

        Arrays.sort(nums);

        int l=0, r=0, total=0, res=0;

        while(r<nums.length){
            total+=nums[r];
            while(nums[r]*(r-l+1) > total+k){
                total-=nums[l];
                l++;
            }
            res=(res>r-l+1)?res:r-l+1;
            r++;

        }


        System.out.println(res);
    }
}