public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    private static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i=0;i< strs.length;i++){
            while(strs[i].indexOf(prefix)!=0)
                prefix=prefix.substring(0,prefix.length()-1);
        }
        return prefix;
    }

}
