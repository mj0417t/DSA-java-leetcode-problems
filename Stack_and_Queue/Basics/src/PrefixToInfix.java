import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String prefix ="*+ab/ef";
        System.out.println(convertToInfix(prefix));
    }

    private static String convertToInfix(String prefix) {
        Stack<String> st = new Stack<>();
        for (int i = prefix.length()-1;i>=0;i--) {
            char ch=prefix.charAt(i);
            if(Character.isLetterOrDigit(ch))
                st.push(String.valueOf(ch));
            else{
                String a=st.pop();
                String b=st.pop();
                st.push("("+a+String.valueOf(ch)+b+")");
            }
        }
        return st.pop();
    }
}
