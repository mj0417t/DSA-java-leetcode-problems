class QuickSort{

    private int getPartitionIndex(int[] arr, int low, int high){
        int pivot=low;
        int i=low, j=high;
        while(i<j){
            while(arr[i]<=arr[pivot] && i<high)
                i++;
            while(arr[j]>arr[pivot] && j>low)
                j--;
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        int temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;

        return j;

    }

    private void quickSort(int[] arr,int low, int high){
        if(low<high){
            int part_index = getPartitionIndex(arr, low, high);
            quickSort(arr,low,part_index-1);
            quickSort(arr,part_index+1,high);
        }
    }

    public static void main(String[] args) {
        QuickSort qs= new QuickSort();
        int[] arr= new int[]{5,4,3,2,1};
        qs.quickSort(arr,0,arr.length-1);
        System.out.println("Sorted Array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" " );
    }
}