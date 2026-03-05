public class ReversePair {
//    static int cnt=0;
    public static void main(String[] args) {
//        int[] arr= {1,2,3,4,5};
//        int[] arr= {5,4,3,2,1};
        int[] arr= {40,25,19,12,9,6,2};
//        System.out.println("Total inversions: "+countInversions(arr));
        int cnt=countReversePair(arr);
        System.out.println("Total no. of reverse pairs: "+cnt);
    }

    private static int countReversePair(int[] arr) {
        return mergeSort(arr,0,arr.length-1);

    }


    private static int mergeSort(int[] arr, int low, int high) {
        int cnt=0;
        if(low>=high) return cnt;
        int mid=(low+high)/2;
        cnt+=mergeSort(arr,low,mid);
        cnt+=mergeSort(arr,mid+1,high);
        cnt+=countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return cnt;
    }

    private static int countPairs(int[] arr, int low, int mid, int high) {
        int cnt=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while (right<=high && arr[i]>2*arr[right]){
                right++;
            }
            cnt+=right-(mid+1);
        }
        return cnt;
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left=low;
        int right=mid+1;
        int k=0;
        int[] temp=new int[high-low+1];
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k++]=arr[left++];
            }else{
                temp[k++]=arr[right++];
            }
        }
        while (left<=mid){
            temp[k++]=arr[left++];
        }

        while(right<=high)
            temp[k++]=arr[right++];

        for(int i=low;i<=high;i++)
            arr[i]=temp[i-low];
    }


}
