public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s="ababd";
//        System.out.println("Longest Palindrome Substring: "+longestPalindrome(s));
        System.out.println("Longest Palindrome Substring: "+longestPalindromeOpt(s));
    }

    private static String longestPalindromeOpt(String s) {
        if(s==null ||s.length()<1) return "";
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int len1=expandFromMid(s,i,i);
            int len2=expandFromMid(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }

        }
        return s.substring(start,end+1);
    }

    private static int expandFromMid(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    private static String longestPalindrome(String s) {
        String longestPalindrome="";

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String subStr = s.substring(i,j);
                int a=0, b=subStr.length()-1;
                while(a<b){
                    if(subStr.charAt(a)!=subStr.charAt(b))
                        break;
                    else {
                        a++;b--;
                    }

                }

                if(a>=b && subStr.length()>longestPalindrome.length())
                    longestPalindrome=subStr;
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String str) {
        int i=0, n= str.length();
        while(i<n/2){
            if(str.charAt(i)!=str.charAt(n-1-i))
                return false;

            i++;
        }
        return true;
    }
}
