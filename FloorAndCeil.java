class FloorAndCeil{
    public static void main(String[] args) {
        int[] nums={3,4,4,7,8,10};
        int target=8;
        int[] pos = new int[2];
        pos=findFloorAndCeil(nums,target);
        System.out.printf("Floor = %d\nCeil = %d",pos[0], pos[1]);
    }

    private static int[] findFloorAndCeil(int[] nums, int target){
        int mid=0,low=0,high=nums.length-1;
        int[] resPos = new int[2];
        while(low<=high){
            mid=(low+high)/2;
            System.out.printf("low ->%d, high -> %d, mid ->%d \n",low,high,mid);
            if(nums[mid]==target){
                resPos[0]=nums[mid];
                resPos[1]=nums[mid];
                return resPos;
            } else if (nums[mid]>target) {
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.printf("low ->%d, high -> %d, mid ->%d \n",low,high,mid);
        resPos[0]=nums[high];
        resPos[1]=nums[low];
        return resPos;
    }
}