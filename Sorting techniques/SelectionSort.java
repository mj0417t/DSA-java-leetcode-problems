class SelectionSort{
    private void selectionSort(int[] arr){
        //select min & swap
        int len= arr.length;
        boolean isSwapReq = false;
        for(int i=0;i<len-1;i++){
            int min=i;
            //selecting min
            for(int j=i+1;j<len;j++){
                if(arr[j]<arr[min]){
                    min=j;
                    isSwapReq=true;
                }
            }
            //swap a[i] & a[min]
            if(isSwapReq){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    }

    private void selectionSortRecursion(int[] arr, int begIndex){
        if(begIndex>= arr.length)
            return;
        int min = begIndex;
        for(int i=begIndex+1;i< arr.length;i++){
            if(arr[i]<arr[min])
                min=i;
        }
        int temp=arr[begIndex];
        arr[begIndex]=arr[min];
        arr[min]=temp;
        selectionSortRecursion(arr, begIndex+1);
    }

    public static void main(String[] args) {
        SelectionSort s= new SelectionSort();
        int[] arr= new int[]{13,46,24,52,20,9};
        //s.selectionSort(arr);
        s.selectionSortRecursion(arr,0);
        System.out.println("Sorted Array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" " );
    }
}