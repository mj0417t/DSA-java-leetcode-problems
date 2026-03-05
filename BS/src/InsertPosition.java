class InsertPosition{
    public static void main(String[] args) {
        int[] nums={1,3,5};
        int target=4;
        int pos = findInsertPosition(nums,target);
        System.out.println(pos);
    }

    private static int findInsertPosition(int[] nums, int target)   {
        int low=0,high= nums.length-1,mid;
        if(nums.length==1){
        if(nums[0]>=target)
            return 0;
        else return 1;
    }

        while (low<=high){
        mid=(low+high)/2;
        System.out.printf("low ->%d, high -> %d, mid ->%d \n",low,high,mid);
        if(mid==0 || mid==nums.length-1){
            if(nums[mid] == target)
                return mid;
            else if((mid==0 && nums[mid]<target &&nums[mid+1]>=target)
                    ||(mid== nums.length-1 && nums[mid]<target))
                return mid+1;
            else if (mid== 0 && nums[mid]>target)
                return mid;
            else if(mid== nums.length-1 && nums[mid]>target && nums[mid-1]<=target)
                return mid-1;
        }
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]>target){
            if(nums[mid-1]<target)
                return mid;
            high=mid-1;
        }else{
            if(nums[mid+1]>target)
                return mid+1;
            low =mid+1;
        }
    }

        return -1;
}
}