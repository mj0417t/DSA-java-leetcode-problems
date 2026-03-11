public class SumOfNnaturalNo {
    public static void main(String[] args) {
        int n=5;
        System.out.println("Sum of N natural nums: "+ findSum(n));
    }

    private static int findSum(int n) {
        if(n==1) return 1;
        return n+findSum(n-1);
    }
}
