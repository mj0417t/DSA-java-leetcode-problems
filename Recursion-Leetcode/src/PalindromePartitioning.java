import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> parts= partition(str);
        System.out.println(parts);
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> part= new ArrayList<>();
        dfs(res,part,s,0);
        return res;
    }

    private static void dfs(List<List<String>> res, List<String> part, String s, int index) {
        if(index==s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s,index,i)) {
                part.add(s.substring(index,i+1));
                dfs(res, part, s, i+1);
                part.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while (start<=end){
            if (str.charAt(start++)!=str.charAt(end--))
                return false;
        }
        return true;
    }

}
