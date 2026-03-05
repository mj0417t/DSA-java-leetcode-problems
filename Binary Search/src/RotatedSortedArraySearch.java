class RotatedSortedArraySearch {
    public static void main(String[] args) {
        int[] nums = {7,8,1,2,3,3,3,4,5,6};
        int target = 0;
//        boolean elem = findElemWithDups(nums, target);
//        boolean elem = findElem(nums, target);

        if (elem)
            System.out.println("Target found");
        else
            System.out.println("target not found");
    }


    public static boolean findElemWithDups(int[] arr, int x){
        int n=arr.length;
        int low=0, mid=0, high= n-1;
        while (low<=high){
            mid=low+(high-low)/2;
            if(arr[mid]==x)
                return true;

            if((arr[low]==arr[mid]) && (arr[mid]==arr[high])){
                low++;
                high--;
                continue;
            }
            //check if left half is sorted
            if(arr[low]<=arr[mid]){
                //check if elem is present in left half
                if(x>=arr[low] && x<arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }else{
                //check if elem is present in right half
                if(x>arr[mid] && x<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }

        }
        return false;
    }

    public static int findElem(int[] arr, int x){
        int n=arr.length;
        int low=0, mid=0, high= n-1;
        while (low<=high){
            mid=low+(high-low)/2;
            if(arr[mid]==x)
                return mid;
            //check if left half is sorted
            if(arr[low]<=arr[mid]){
                //check if elem is present in left half
                if(x>=arr[low] && x<arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }else{
                    //check if elem is present in right half
                    if(x>arr[mid] && x<=arr[high])
                        low=mid+1;
                    else
                        high=mid-1;
                }

        }
        return -1;
    }
}