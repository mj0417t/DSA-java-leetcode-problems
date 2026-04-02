import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
//        String infix="(a+b)*(c-d)";
//        String infix="(a+b)/(c-d)-(e*f)";
        String infix="a+b*(c^d-e)^(f+g*h)-i/j";
        System.out.println(convertToPostfix(infix));
    }

    public static int prec(char c) {
        if (c == '^')  // Exponent operator has highest precedence
            return 3;
        else if (c == '/' || c == '*')  // Multiplication and division have higher precedence than addition
            return 2;
        else if (c == '+' || c == '-')  // Addition and subtraction have lowest precedence
            return 1;
        else
            return -1;
    }

    public static boolean isleftAssoc(char c) {
        if (c == '/' || c == '*'||c == '+' || c == '-')  // Multiplication and division have higher precedence than addition
            return true;
        else return false;

    }


    private static String convertToPostfix(String infix) {
        StringBuilder postfix=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<infix.length();i++){
            char ch= infix.charAt(i);
            if(Character.isLetterOrDigit(ch))
                postfix.append(ch);
            else if (ch=='(') {
                stack.push(ch);
            }else if(ch==')'){
                while(stack.peek()!='('){
                    postfix.append(stack.pop());
                }
                stack.pop();
            }else{
                if(stack.isEmpty()|| prec(stack.peek())<prec(ch))
                    stack.push(ch);
                else{
                    while (!stack.isEmpty()
                            && ((prec(stack.peek())>prec(ch))
                            || (prec(stack.peek())==prec(ch) && isleftAssoc(ch))))
                        postfix.append(stack.pop());
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty())
            postfix.append(stack.pop());

        return postfix.toString();
    }
}
