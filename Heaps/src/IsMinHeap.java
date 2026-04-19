public class IsMinHeap {
    public static void main(String[] args) {
        int[] arr={10,20,30,20,25};
        System.out.println(isMinHeap(arr));
    }

    private static boolean isMinHeap(int[] arr) {
        int n= arr.length;
        for (int i = 0; i < n/2; i++) {
            int li=2*i+1;
            if(li<n && arr[i]>arr[li])
                return false;
            int ri=2*i+2;
            if(ri<n && arr[i]>arr[ri])
                return false;
        }
        return true;
    }
}
