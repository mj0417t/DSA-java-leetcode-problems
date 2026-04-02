import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String str=")(){}";
        System.out.println(isValid(str));
    }
    private static boolean isValid(String s) {
        if(s.length()==1) return false;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            switch (ch){
                case '(','{','['-> st.push(ch);
                case ')' ->{
                    if(!st.isEmpty()&&st.peek()=='(')
                        st.pop();
                    else st.push(ch);
                }
                case '}' ->{
                    if(!st.isEmpty()&&st.peek()=='{')
                        st.pop();
                    else st.push(ch);
                }
                case ']' ->{
                    if(!st.isEmpty()&&st.peek()=='[')
                        st.pop();
                    else st.push(ch);
                }
            }
        }
        return st.isEmpty();
    }
}
