import java.util.ArrayList;
import java.util.List;

class MergeSort{

    private void merge(int[] arr, int low, int mid, int high){
        List<Integer> temp=new ArrayList<Integer>();
        int left=low, right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }

        while(left<=mid)
            temp.add(arr[left++]);
        while(right<=high)
            temp.add(arr[right++]);

        for(int i=low;i<=high;i++)
            arr[i]=temp.get(i-low);
    }

    private void mergeSort(int[] arr, int low, int high){
        int mid=(low+high)/2;
        if(low>=high) return;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        MergeSort ms= new MergeSort();
        int[] arr= new int[]{3,1,2,4,1,5,2,6,4};
        ms.mergeSort(arr,0,arr.length-1);
        System.out.println("Sorted Array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" " );
    }
}