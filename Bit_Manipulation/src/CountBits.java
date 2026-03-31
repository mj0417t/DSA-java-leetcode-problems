public class CountBits {
    public static void main(String[] args) {
        int n=35;
//        System.out.println(countBits(n));
//        System.out.println(countBitsBet(n));
        System.out.println(countBitsOpt(n));
    }

    private static int countBitsOpt(int n) {
        int cnt=0;
        while(n>0){
            n=n&(n-1);
            cnt++;
        }
        return cnt;
    }

    private static int countBitsBet(int n) {
        int cnt=0;
        while (n!=0){
            cnt+=n&1;
            n=n>>1;
        }
        return cnt;
    }

    private static int countBits(int n) {
        String binary=Integer.toBinaryString(n);
        int cnt=0;
        for (int i=0;i<binary.length(); i++)
            if(binary.charAt(i)=='1')
                cnt++;
        return cnt;
    }
}
