class InsertionSort{
    private void insertionSort(int[] arr){
       //takes an element and place it in its correct position
        int len = arr.length;
        for(int i=1;i<len;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }

    private void insertionSortRecursion(int[] arr,int size){
        if(size<=1) return; //since array of size 1 is already sorted
        insertionSortRecursion(arr,size-1);

        //inserting nth element in its correct position
        int key=arr[size-1];
        int j=size-2;
        while(j>=0 && arr[j]>key){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
    }
    public static void main(String[] args) {
        InsertionSort is= new InsertionSort();
        int[] arr= new int[]{11,2,2,1,323,12,44,1,11,1,1};
        //is.insertionSort(arr);
        is.insertionSortRecursion(arr, arr.length);
        System.out.println("Sorted Array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" " );
    }
}