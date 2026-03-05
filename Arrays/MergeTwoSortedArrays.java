import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=3,n=3;
//        merge(nums1,m,nums2,n);
        mergeOptimal(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    private static void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1;
        int right=0;
        while(left>=0 && right<n){
            if(nums1[left]>nums2[right]){
                int temp=nums1[left];
                nums1[left]=nums2[right];
                nums2[right]=temp;
            }else{
                break;
            }
        }
        Arrays.sort(nums1,0,m-1);
        Arrays.sort(nums2);
        for(int i=0;i<n;i++)
            nums1[m+i]=nums2[i];
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            nums1= new int[n];
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }
        else if(n==0){
            return;
        }
        else{
            for(int i=0;i<n;i++){
                nums1[m+i]=nums2[i];
            }
            Arrays.sort(nums1);
        }
    }
}
