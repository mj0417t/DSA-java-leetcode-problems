class BubbleSort{
    private void bubbleSort(int[] a){
        //put max to the last by adjacent swaps
        int len= a.length;
        boolean isSwapped =false;
        for(int i=len-1;i>=1;i--){
            for(int j=1;j<=i;j++){
                if(a[j-1]>a[j]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    isSwapped=true;
                }
            }
            if(!isSwapped) break;
        }
    }

    private void bubbleSortRecursion(int[] arr, int endIndex){
        if(endIndex==0) return;
        for(int i=0;i<endIndex;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        bubbleSortRecursion(arr,endIndex-1);
    }

    public static void main(String[] args) {
        BubbleSort bs= new BubbleSort();
        int[] arr= new int[]{5,4,2,3,1};
        //bs.bubbleSort(arr);
        bs.bubbleSortRecursion(arr,arr.length-1);
        System.out.println("Sorted Array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" " );
    }
}