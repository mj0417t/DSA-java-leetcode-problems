public class CountNumOfSubStringWithExactlyKDistinctChars {

    public static void main(String[] args) {
//        String s="pqpqs";
//        int k=2;

        String s="abcbaa";
        int k=3;

        int n=s.length();
        int subStrings = countSubStr(s,k,n)-countSubStr(s,k+1,n);
        System.out.println(subStrings);

    }

    private static int countSubStr(String s, int k, int n) {
        int l=0,r=0, dist=0, subStr=0;

        int[] cnt =new int[26];
        for(;l<n;l++) {
            while (r < n && dist<k) {
                int i = cnt[s.charAt(r) - 'a'];
                i++;
                if (i == 1) dist++;
                r++;
            }
            if(dist>=k){
                subStr+=n-r+1;
            }

            int j=cnt[s.charAt(l)-'a'];
            j--;
            if(j==0) dist--;
        }

        return subStr;
    }
}
