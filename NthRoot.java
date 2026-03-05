class NthRoot {
    public static void main(String[] args) {
        int n = 3, m = 216;
//        System.out.println(n + "th root of " + m + " is " + findNthRoot(n, m));
        System.out.println(n + "th root of " + m + " is " + findNthRootBS(n, m));
    }

    static int findNthRoot(int n, int m) {
        for (int i = 0; i < m / 3; i++) {
            if (Math.pow(i, n) == m)
                return i;
        }
        return -1;
    }

    static int findNthRootBS(int n, int m) {
        if(n==1) return m;
        if(n>1 && m<4) return -1;

        int left=1;
        int right=m/2;
        int ans=0;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(Math.pow(mid,n)==m)
                return mid;
            else if(Math.pow(mid,n)>m)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
}