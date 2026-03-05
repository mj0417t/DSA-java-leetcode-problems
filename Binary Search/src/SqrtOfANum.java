public class SqrtOfANum{
    public static void main(String[] args) {
        int num =50;
//        System.out.println("Square root of "+num+" is "+findSqtrt(num));
        System.out.println("Square root of "+num+" is "+findSqtrtBS(num));

    }
    public static int findSqtrt(int num){
        for(int i=2;i<num/3;i++){
            int temp = i*i;
            if(temp==num)
                return i;
            if(temp<num && (i+1)*(i+1)>num)
                return i;
        }
        return -1;
    }

    public static int findSqtrtBS(int x){
        if(x<2) return x;
        int left=1,right=x/2;
        int ans=0;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid<=x){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
}