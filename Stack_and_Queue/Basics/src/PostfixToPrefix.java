import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String postfix="abc*+d-";
        System.out.println(convertToPrefix(postfix));
    }

    private static String convertToPrefix(String postfix) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char ch=postfix.charAt(i);
            if(Character.isLetterOrDigit(ch))
                st.push(String.valueOf(ch));
            else{
                String a=st.pop();
                String b=st.pop();
                st.push(String.valueOf(ch)+b+a);
            }
        }
        return st.pop();
    }
}
