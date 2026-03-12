public class PowerXn {
    public static void main(String[] args) {
        double x = 4;
        int n=50;
//        System.out.println(myPow(x,n));
        System.out.println(myPowIteratn(x,n));

    }

    private static double myPowIteratn(double x, int n) {
        double ans=1.0;
        long nn=n;
        if(nn<0)
            nn= -1*nn;
        while (nn>0){
            if(nn%2==1){
                ans=ans*x;
                nn--;
            }else {
                x=x*x;
                nn=nn/2;
            }
        }
        if(n<0)
            ans=1/ans;
        return ans;
    }

    private static double myPow(double x, int n) {
        return  myPowHelper(x,n);
    }

    private static double myPowHelper(double x, int n) {
        if(n==0) return 1.0;
        if(n==1) return x;
        if(x==0.0) return 0;
        if(n<0){
            if(n==Integer.MIN_VALUE)
                return 1/(x * myPowHelper(x,Integer.MAX_VALUE));

            n=-1*n;
            return 1/myPowHelper(x,n);
        }

        double temp=myPowHelper(x, n / 2);

        if (n%2==0) {
            return temp*temp;
        }
        else return x * temp*temp;
    }
}
