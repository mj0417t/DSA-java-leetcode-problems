public class Fibonacci {
    public static void main(String[] args) {
        int n=10;
        System.out.println("fibonacci series: ");
        for (int i=1;i<=n;i++){
            System.out.printf(fibo(i)+" ");
        }


    }

    private static int fibo(int n) {
        if(n==0 || n==1){
            return n;
        }
        int fib0=fibo(n-1);
        int fib1=fibo(n-2);
        return fib0+fib1;
    }
}
