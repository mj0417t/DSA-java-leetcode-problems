class LastOccurence{
    public static void main(String[] args) {
        int[] nums={3,4,13,13,13,20,40};
        int target=13;
        int lastOccur=findLastOccurence(nums,target);
        if(lastOccur==-1)
            System.out.println("Target not found");
        else
            System.out.println("last occurance of target found at index "+lastOccur);

        int firstOccur=findFirstOccurence(nums,target);
        System.out.println("first occurance of target found at index "+firstOccur);
        System.out.printf("Total occurence of %d = %d",target,(lastOccur-firstOccur+1));
    }
    private static int findLastOccurence(int[] nums, int target){
        int l=0, h=nums.length-1,mid=0, ans=-1;
        while(l<=h){
            mid=(l+h)/2;
            if(nums[mid]==target){
                ans=mid;
                l=mid+1;
            } else if (nums[mid]<target) {
                l=mid+1;
            }else {
                h=mid-1;
            }
        }
        return ans;
    }

    private static int findFirstOccurence(int[] nums, int target){
        int l=0, h=nums.length-1,mid=0, ans=-1;
        while(l<=h){
            mid=(l+h)/2;
            if(nums[mid]==target){
                ans=mid;
                h=mid-1;
            } else if (nums[mid]<target) {
                l=mid+1;
            }else {
                h=mid-1;
            }
        }
        return ans;
    }
}