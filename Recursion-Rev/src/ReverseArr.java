public class ReverseArr {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        System.out.println("Array: ");
        for(int a: arr)
            System.out.print(a+" ");
        reverseArr(arr);

        System.out.println("\nReversed Array: ");
        for(int a: arr)
            System.out.print(a+" ");
    }

    private static void reverseArr(int[] arr) {
        helper(arr,0,arr.length-1);
    }

    private static void helper(int[] arr, int l, int r) {
        if(l>=r) return;
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
        helper(arr,l+1,r-1);
    }

}
