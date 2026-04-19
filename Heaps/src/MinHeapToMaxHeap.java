import java.util.Arrays;

public class MinHeapToMaxHeap {
    public static void main(String[] args) {
        int[] arr={10,20,30,21,25};
        convertToMaxHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void convertToMaxHeap(int[] arr) {
        int n= arr.length;
        for (int i=n/2;i>=0;i--){
            maxHeapify(arr,i,n);
        }
    }

    private static void maxHeapify(int[] arr, int index, int n) {
        int largest=index;
        int li=2*index+1;
        int ri=2*index+2;
        if(li<n && arr[li]>arr[largest])
            largest=li;
        if(ri<n && arr[ri]>arr[largest])
            largest=ri;
        if(largest!=index){
            int temp=arr[index];
            arr[index]=arr[largest];
            arr[largest]=temp;
            maxHeapify(arr,largest,n);
        }
    }
}
