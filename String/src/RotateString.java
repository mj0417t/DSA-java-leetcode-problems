public class RotateString {
    public static void main(String[] args) {
//        String s = "abcde", goal = "bcdea";
//        String s = "aabb", goal = "bbaa";
        String s = "defdefdefabcabc", goal = "defdefabcabcdef";
        System.out.println(rotateString(s,goal));
    }
    private static boolean rotateString(String s, String goal) {
//        s=s+s; //since circular rotation provides goal
//
//        //longest prefix suffix
//        int[] lps= new int[goal.length()];
//        for(int i=1,j=0;i<goal.length();i++){
//            if(goal.charAt(i)==goal.charAt(j)){
//                lps[i]=j+1;
//                j++;
//
//            }else if(j>0){
//                j=lps[i-1];
//            }
//        }
////        System.out.println(Arrays.toString(lps));
//        for(int i=0,j=0;i<s.length();i++){
//            if(j==goal.length())
//                return true;
//            if(s.charAt(i)==goal.charAt(j)){
//                j++;
//            }else {
//                if(j>0)
//                    j=lps[j-1];
//            }
//        }
//
//        return false;

        if(s.length()!=goal.length())
            return false;

        s=s+s;

        return s.contains(goal);
    }
}
