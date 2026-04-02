import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String prefix="*+ab-cd";
        System.out.println(convertToPostfix(prefix));
    }

    private static String convertToPostfix(String prefix) {
        Stack<String> st = new Stack<>();
        for (int i = prefix.length()-1;i>=0;i--) {
            char ch=prefix.charAt(i);
            if(Character.isLetterOrDigit(ch))
                st.push(String.valueOf(ch));
            else{
                String a=st.pop();
                String b=st.pop();
                st.push(a+b+String.valueOf(ch));
            }
        }
        return st.pop();
    }
}
