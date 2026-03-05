import java.util.Arrays;

class LowerBound{
    public static void main(String[] args) {
        int[] arr={3,5,8,9,15,19};
        int x=9;
        int lb = findLowerBound(arr,x);
        System.out.println("Lower Bound of "+x+ "in the array "+Arrays.toString(arr) +" is "+lb);
    }
    private static int findLowerBound(int[] arr,int x){
//      //brute force
//        for(int i=0;i< arr.length;i++){
//            if(arr[i]>=x)
//                return i;
//        }
//        return arr.length;

        //optimal
        int low=0,high= arr.length-1,mid,res= arr.length;

        while (low<=high){
            mid=(low+high)/2;
//            System.out.printf("low ->%d, high -> %d, mid ->%d\n",low,high,mid);
            if(arr[mid]>=x){
                res=mid;
                high=mid-1;
            }else{
                low =mid+1;
            }
        }
        return res;
    }

}