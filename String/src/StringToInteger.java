public class StringToInteger {
    public static void main(String[] args) {
        String s1="42";
        String s2=" -042";
        String s3="1337c0d3";
        String s4="-91283472332";
        String s5="words and 987";

//        System.out.println("Integer value of s1: "+myAtoi(s1));
//        System.out.println("Integer value of s2: "+myAtoi(s2));
//        System.out.println("Integer value of s3: "+myAtoi(s3));
        System.out.println("Integer value of s4: "+myAtoi(s4));
        System.out.println("Integer value of s5: "+myAtoi(s5));
    }


    private static int myAtoi(String s) {
        s=s.trim();
        boolean positive=true;
        long res=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i==0 & ch=='-'){
                positive=false;
                continue;
            }
            if(i==0 & ch=='+'){
                continue;
            }
            if(ch >= '0' && ch <= '9')
                res=(res*10)+ (int) (ch-'0');
            else
                break;

            if(res>Integer.MAX_VALUE)
                break;

        }

        if(positive){
            if(res>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else return (int) res;
        }
        if(-res<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return -(int)res;
    }

}
