public class LongestSubArrayKSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-3,2,1};
        int k=6;
        int res=longestSubArrayKSum(arr,k);
        if(res==0)
            System.out.println("No subarray possible with sum equal to "+k);
        else
            System.out.println("Size of Longest Subarray with sum " +k+" is " + res);

    }

    private static int longestSubArrayKSum(int[] arr, int k) {
        int l=0,r=0,total=0,win=0;
        while(l<=r && r<arr.length){
            total+=arr[r];
            if(total>k){
                total-=arr[l];
                l++;
            }
            win=(total==k)? Math.max(win,r-l+1) : win;
            r++;
        }
        return win;
    }
}
