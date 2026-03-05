public class BookAllocation {

    public static void main(String[] args) {
        int[] booksWithPages = {12, 34, 67, 90};
        int students=2;
        int pages=findPagesAllocated(booksWithPages,students);
        System.out.println("Max pages allocated to each student is minimum: "+pages);
    }

    private static int findPagesAllocated(int[] nums, int k) {
        int sumOfArray=0, minInArray=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minInArray)
                minInArray=nums[i];
            sumOfArray+=nums[i];
        }
        int low=minInArray; //when no.of books==no. of k
        int high=sumOfArray;//when no. of student =1
        int res=-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(canBooksBeAllocated(nums,mid,k)){
                res=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return res;
    }

    private static boolean canBooksBeAllocated(int[] booksWithPages, int barrier, int students) {
        int studCnt=1, pageCount=0;
        for (int i=0;i<booksWithPages.length;i++){
            if(booksWithPages[i]>barrier) return false;
            if(pageCount+booksWithPages[i]>barrier){
                studCnt++;
                pageCount=booksWithPages[i];
            } else {
                pageCount+=booksWithPages[i];
            }
        }
        if(studCnt>students) return false;
        return true;
    }
}
