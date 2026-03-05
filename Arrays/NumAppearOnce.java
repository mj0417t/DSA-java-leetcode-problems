import java.util.Arrays;

public class NumAppearOnce {
    public static void main(String[] args) {
        int[] arr=new int[]{2,2,1};
        Arrays.sort(arr);
        System.out.println("Element appearing once: "+findElementAppearingOnce(arr));

    }

    private static int findElementAppearingOnce(int[] arr) {
        if(arr[0]!=arr[1]) return arr[0];
        int n=arr.length;
        if(arr[n-1]!=arr[n-2]) return arr[n-1];
        for(int i=1; i<n-1;i++){
            if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1])
                return arr[i];
        }
        return -1;

    }
}
