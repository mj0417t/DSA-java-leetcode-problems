public class MaxSubArrayDivAndCon {
    public static void main(String[] args) {
        int[] arr= new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr,0,arr.length-1));
    }

    private static int maxSubArray(int[] arr, int p, int r) {
        if(p==r) return arr[p];
        int q=(p+r)/2;
        int leftMaxSum=maxSubArray(arr, p, q);
        int rightMaxSum=maxSubArray(arr,q+1,r);
        int maxCrossingSum= maxCrossingSubArray(arr,p,q,r);
        return Math.max(Math.max(leftMaxSum,rightMaxSum),maxCrossingSum);

    }

    private static int maxCrossingSubArray(int[] arr, int p, int q, int r) {
        int leftSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=q;i>=p;i--){
            sum+=arr[i];
            if(sum>leftSum)
                leftSum=sum;
        }
        int rightSum=Integer.MIN_VALUE;
        sum=0;
        for(int i=q+1;i<=r;i++){
            sum+=arr[i];
            if(sum>rightSum)
                rightSum=sum;
        }

        return (leftSum+rightSum);

    }
}
