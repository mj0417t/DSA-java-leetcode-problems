public class SmallestDivisor {
    public static void main(String[] args) {
//        int[] num={1,2,5,9};
//        int threshold=6;
        int[] num={44,22,33,11,11};
        int threshold=5;
        int ans=findSmallestDiv(num,threshold);
        System.out.printf("Smallest divisor: %d %n ",ans);
    }

    private static int findSmallestDiv(int[] num, int threshold) {
        int maxElem=Integer.MIN_VALUE;
        for(int i=0;i< num.length;i++){
            maxElem=Math.max(maxElem,num[i]);
        }
        int left=1;
        int right=maxElem;
        while(left<=right){
            int mid=left+(right-left)/2;
            int sum = checkSum(num,mid);
            if(sum<=threshold)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }

    private static int checkSum(int[] num, int mid) {
        int sum=0;
        for(int i=0;i< num.length;i++){
            sum+=(num[i]/mid);
            if(num[i]%mid>0)
                sum++;
        }
        return sum;
    }

}
