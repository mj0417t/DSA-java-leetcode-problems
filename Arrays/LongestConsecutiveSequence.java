import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr= {100,4,200,1,3,2};
        int[] arr2 = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println("Length of longest sub sequence: "+findLengthOfLongestConsqSeq(arr));
        System.out.println("Length of longest sub sequence: "+findLengthOfLongestConsqSeq(arr2));
    }

    private static int findLengthOfLongestConsqSeq(int[] arr) {
        int maxLength=Integer.MIN_VALUE,len=1;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=0;i< arr.length-1;i++){
            if(arr[i+1]==arr[i]+1)
                len++;
            else{
                maxLength=Math.max(maxLength,len);
                len=1;
            }
        }
        return Math.max(maxLength,len);
    }
}
