import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n=3;
//        List<String> parentheseses = generateParenthesis(n);
        List<String> parentheseses = generateParenthesisOpt(n);
        System.out.println(parentheseses);

    }

    private static List<String> generateParenthesisOpt(int n) {
        List<String> res = new ArrayList<>();
        generateOpt("",0,0,n,res);
        return res;
    }

    private static void generateOpt(String s, int open, int close, int n, List<String> res) {
        if(s.length()==2*n){
            res.add(s);
            return;
        }
        if(open<n)
            generateOpt(s+'(',open+1,close,n,res);
        if(close<open)
            generateOpt(s+')',open,close+1,n,res);

    }

    private static List<String> generateParenthesis(int n) {
        StringBuilder bs = new StringBuilder();
        List<String > binStrs = new ArrayList<>();
        List<String > res = new ArrayList<>();
        generate(n,bs,binStrs);
        for(String str:binStrs){
            if(checkValidParenStr(str))
                res.add(str);
        }
        return res;
    }

    private static boolean checkValidParenStr(String str) {
        int cnt=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') {
                cnt++;
            }else if (str.charAt(i)==')') {
                cnt--;
            }
            if(cnt<0)
                return false;
        }
        if(cnt==0)
            return true;
        return false;
    }

    private static void generate(int n, StringBuilder bs, List<String> binStrs) {
        if(bs.length()==2*n){
            binStrs.add(bs.toString());
            return;
        }
            generate(n, bs.append('('), binStrs);
            bs.deleteCharAt(bs.length() - 1);
            generate(n, bs.append(')'), binStrs);
            bs.deleteCharAt(bs.length()-1);

    }
}
