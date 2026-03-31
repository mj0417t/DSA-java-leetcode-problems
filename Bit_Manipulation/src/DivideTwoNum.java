public class DivideTwoNum {
    public static void main(String[] args) {
        int dividend=-1010369383,divisor=-2147483648;
        System.out.println(divide(dividend,divisor));
    }

    public static int divide(int dividend, int divisor) {
        if(dividend==divisor) return 1;
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        boolean sign =true;
        if(dividend<0 && divisor>0) sign=false;
        if(dividend>0 && divisor<0) sign=false;
        if (dividend==0) return 0;

        long n=(dividend==Integer.MIN_VALUE)?(long)Integer.MAX_VALUE+1:Math.abs(dividend);
        long d=(divisor==Integer.MIN_VALUE)?(long)Integer.MAX_VALUE+1:Math.abs(divisor);
        long ans=0;
        while(n>=d){
            int cnt=0;
            while (n>=(d<<(cnt+1))){
                cnt++;
            }
            ans+=(1<<cnt);
            n-=(d<<cnt);
        }

        if(ans>Integer.MAX_VALUE  && sign==true)
            return Integer.MAX_VALUE;
        if(ans>Integer.MAX_VALUE  && sign==false)
            return Integer.MIN_VALUE;

        return (int)(sign?ans:(-1*ans));
    }
}
