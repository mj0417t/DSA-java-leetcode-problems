public class FindXORRange {
    public static void main(String[] args) {
        int l=3, r=5;
        System.out.println(findXORRange(l,r));
    }

    private static int findXORRange(int l, int r) {
        return xorTillN(l-1)^xorTillN(r);
    }

    private static int xorTillN(int n) {
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        if(n%4==3) return 0;
        return n;
    }
}
