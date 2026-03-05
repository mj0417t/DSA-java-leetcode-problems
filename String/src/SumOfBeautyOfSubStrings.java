public class SumOfBeautyOfSubStrings {
    public static void main(String[] args) {
        String s="aabcbaa";
//        int sum=countSumOfBeautyOfSubStr(s);
        int sum=countSumOfBeautyOfSubStrBetter(s);
        System.out.println("Sum of beauty of all substrings: "+sum);
    }

    private static int countSumOfBeautyOfSubStrBetter(String s) {
        int sum=0;
        for (int i=0;i<s.length();i++){
            int[] freq= new int[26];
            for (int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int maxFreq=0, minFreq=Integer.MAX_VALUE;
                for(int f: freq){
                    if(f>0){
                        maxFreq=Math.max(maxFreq,f);
                        minFreq = Math.min(minFreq,f);
                    }
                }
                sum+=(maxFreq-minFreq);
            }

        }
        return sum;
    }

    private static int countSumOfBeautyOfSubStr(String s) {
        int cnt=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                cnt+=countBeauty(s.substring(i,j));
            }
        }

        return cnt;
    }

    private static int countBeauty(String str) {
        int[] cnt = new int[26];
        for(int i=0;i<str.length();i++)
            cnt[str.charAt(i)-'a']++;
        int mostFreq=-1, leastFreq=Integer.MAX_VALUE;
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]>0 && cnt[i]>mostFreq)
                mostFreq=cnt[i];
            if(cnt[i]>0 && cnt[i]<leastFreq)
                leastFreq=cnt[i];
        }
        return mostFreq-leastFreq;
    }
}
