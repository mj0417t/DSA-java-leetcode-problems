import java.util.Arrays;

class UpperBound{
    public static void main(String[] args) {
        int[] arr={3,5,8,9,15,19};
        int y=9;
        int ub= findUpperBound(arr,y);
        System.out.println("Upper Bound of "+y+ " in the array "+Arrays.toString(arr) +" is "+ub);
    }

    private static int findUpperBound(int[] arr,int x){
//        //brute force
//        for(int i= arr.length-1;i>=0;i--){
//            if(i==0){
//                if(arr[i]<=x)
//                    return -1;
//                else return i;
//            }
//
//            if(arr[i]>x && arr[i-1]<=x)
//                return i;
//        }
//        return -1;

        //optimal
        int low=0,high= arr.length-1,mid;

        while (low<=high){
            mid=(low+high)/2;
//            System.out.printf("low ->%d, high -> %d, mid ->%d \n",low,high,mid);
            if(mid==0){
                if(arr[mid]<=x)
                    return -1;
                else return mid;
            }
            if(arr[mid]>x){
                if(arr[mid-1]<=x)
                    return mid;
                high=mid-1;
            }else{
                low =mid+1;
            }
        }
        return -1;
    }
}