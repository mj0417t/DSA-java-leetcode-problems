public class MaximumNestedDepth {
    public static void main(String[] args) {
        String s1 = "(1+(2*3)+((8)/4))+1";
        String s2 = "(1)+((2))+(((3)))";
        String s3 ="()(())((()()))";

        System.out.println("Max nested depth in s1: "+maxDepth(s1));
        System.out.println("Max nested depth in s2: "+maxDepth(s2));
        System.out.println("Max nested depth in s3: "+maxDepth(s3));
    }
    private static int maxDepth(String s) {
        int cnt=0,maxCnt=-1;
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch=='('){
                cnt++;
            }else if(ch==')'){
                cnt--;
            }
            if(cnt>maxCnt)
                maxCnt=cnt;
        }
        return maxCnt;
    }
}
