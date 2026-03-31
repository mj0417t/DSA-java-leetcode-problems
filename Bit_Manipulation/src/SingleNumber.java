public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={4,2,2,1,1,5,3,4,3};
        System.out.println(singleNumber(nums));
    }
    private static int  singleNumber(int[] arr){
        int ans=0;
        for (int i = 0; i < arr.length; i++) {
            ans^=arr[i];
        }
        return ans;
    }
}
