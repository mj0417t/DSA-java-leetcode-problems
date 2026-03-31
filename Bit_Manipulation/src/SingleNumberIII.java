import java.util.Arrays;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums= {2,4,2,14,3,7,7,3};
        System.out.println(Arrays.toString(singleNumberOpt(nums)));

    }
    private static int[] singleNumberOpt(int[] nums) {
        long xorr=0;
        for (int j : nums) xorr ^= j;
        long rightmostSetBit=(xorr&(xorr-1))^xorr;
        int b1=0,b2=0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0)
                b1 ^= num;
            else
                b2 ^= num;
        }

        return new int[]{b1,b2};
    }
    public int[] singleNumber(int[] nums) {
        int[] res=new int[2];
        int k=0, n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i]!=nums[i+1])
                    res[k++]=nums[i];
            }else if(i==n-1){
                if(nums[i]!=nums[i-1])
                    res[k++]=nums[i];
            }else{
                if((nums[i]!=nums[i-1])&&(nums[i]!=nums[i+1]))
                    res[k++]=nums[i];
            }
        }
        return res;
    }
}
