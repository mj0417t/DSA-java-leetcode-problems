import java.util.ArrayList;
import java.util.List;

public class KthElemOf2SortedArrays {
    public static void main(String[] args) {
        int[] arr1 ={7,12,14,15};
        int[] arr2 ={1,2,3,4,9,11};

//        int[] arr1 ={100,112,256,349,770};
//        int[] arr2 ={72,86,113,119,265,445,893};
        int k=7;

//        int kthElem=findKthElem(arr1,arr2,k);
//        int kthElem=findKthElemBetterSol(arr1,arr2,k);
        int kthElem=findKthElemOptSol(arr1,arr2,k);
        System.out.println("kth Element: "+kthElem);



    }

    private static int findKthElemOptSol(int[] arr1, int[] arr2, int k) {
        int m = arr1.length;
        int n = arr2.length;

        if(m>n) return findKthElemOptSol(arr2,arr1,k);

        int left=k;
        int low=Math.max(0,k-n);
        int high =Math.min(k,m);

        while (low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;

            int l1 = (mid1>0)?arr1[mid1-1]:Integer.MIN_VALUE;
            int l2 = (mid2>0)?arr2[mid2-1] : Integer.MIN_VALUE;

            int r1 = (mid1<m)?arr1[mid1]:Integer.MAX_VALUE;
            int r2 = (mid2<n)?arr2[mid2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1)
                return Math.max(l1,l2);
            else if(l1>r2)
                high=mid1-1;
            else
                low=mid1+1;
        }
        return -1;
    }

    private static int findKthElemBetterSol(int[] arr1, int[] arr2, int k) {
        int cnt=1;
        int i=0,j=0;

        while (i<arr1.length && j< arr2.length){
            if(arr1[i]<=arr2[j]){
                if(cnt==k) return arr1[i];
                cnt++;
                i++;

            }else {
                if(cnt==k) return arr2[j];
                cnt++;
                j++;
            }
        }
        while(i< arr1.length){
            if(cnt==k) return arr1[i];
            cnt++;
            i++;
        }
        while (j< arr2.length) {
            if(cnt==k) return arr2[j];
            cnt++;
            j++;
        }

        return -1;
    }

    private static int findKthElem(int[] arr1, int[] arr2, int k) {
        int i=0,j=0;
        List<Integer> ds = new ArrayList<>();
        while (i<arr1.length && j< arr2.length){
            if(arr1[i]<=arr2[j]){
                ds.add(arr1[i]);
                i++;
            }else {
                ds.add(arr2[j]);
                j++;
            }
        }
        while(i< arr1.length){
            ds.add(arr1[i++]);
        }
        while (j< arr2.length)
            ds.add(arr2[j++]);

        return ds.get(k-1);
    }
}
