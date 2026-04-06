import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num,k));
    }
    public static String removeKdigits(String num, int k) {
        if(num.length()== k) return "0";
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k>0 && (st.peek()-'0'>num.charAt(i)-'0')){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while (k>0){
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";
        StringBuilder res= new StringBuilder();
        while (!st.isEmpty())
            res.append(st.pop());
        while (!res.isEmpty() && res.charAt(res.length()-1)=='0')
            res.deleteCharAt(res.length()-1);

        res.reverse();

        return res.length()==0?"0":res.toString();

    }
}
