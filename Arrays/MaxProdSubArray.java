public class MaxProdSubArray {
    public static void main(String[] args) {
        int[] arr= {2,3,-2,4};

        System.out.println("Max Product subarray: "+maxProduct(arr));
    }
    public static int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];

        long prefix=1l, suffix=1l;
        long maxProd=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix == 0)
                prefix=1;
            if(suffix==0)
                suffix=1;
            prefix*=nums[i];
            suffix*=nums[n-1-i];
            maxProd = Math.max(maxProd,Math.max(prefix,suffix));
        }
        return (int)maxProd;
    }
}
