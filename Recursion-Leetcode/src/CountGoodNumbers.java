public class CountGoodNumbers {

    static final int  MOD=1_000_000_007;
    public static void main(String[] args) {
        long n=50;
        System.out.println(countGoodNumbers(n));
    }

    private static  int countGoodNumbers(long n) {
        long oddPlaces=0;
        long evenPlaces=0;
        if(n%2==0){
            oddPlaces=n/2;
            evenPlaces=n/2;
        }else{
            oddPlaces=n/2;
            evenPlaces=(n/2)+1;
        }

        //4 choices for odd places-2,3,5,7
        //5 choices for even places-0,2,4,6,8
        return (int)(pow(4,oddPlaces)*pow(5,evenPlaces)%MOD);
    }

    private static long pow(int x, long n) {
        if(n==0) return 1;
        if (n==1) return x;
        long temp=pow(x,n/2)%MOD;
        if (n%2==0)
            return (temp*temp)%MOD;
        else
            return (x*temp*temp)%MOD;
    }
}
