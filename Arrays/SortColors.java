class SortColors {

    public static void sortColors(int[] nums) {
        //Bubble Sort
        int n=nums.length;
        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    int t=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        for(int i=0;i<nums.length;i++)
            System.out.printf(nums[i]+"  ");
        System.out.println();
    }
}