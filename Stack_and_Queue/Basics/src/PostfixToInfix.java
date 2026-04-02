import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String postfix ="ab+ef/*";
        System.out.println(convertToInfix(postfix));
    }

    private static String convertToInfix(String postfix) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char ch=postfix.charAt(i);
            if(Character.isLetterOrDigit(ch))
                st.push(String.valueOf(ch));
            else{
                String a=st.pop();
                String b=st.pop();
                st.push("("+b+String.valueOf(ch)+a+")");
            }
        }
        return st.pop();
    }
}
