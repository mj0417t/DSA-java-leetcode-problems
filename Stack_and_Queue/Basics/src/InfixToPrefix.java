import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
//        String infix="(a+b)*(c-d)";
//        String infix="(a+b)/(c-d)-(e*f)";
        String infix="a+b*(c^d-e)^(f+g*h)^i/j^k";
//        String infix="k+l-m*n+(o^p)*w/u/v*t+q";
        System.out.println(convertToPrefix(infix));
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


    private static String convertToPrefix(String infix) {
        StringBuilder prefix=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(int i=infix.length()-1;i>=0;i--){
            char ch= infix.charAt(i);
            if(Character.isLetterOrDigit(ch))
                prefix.append(ch);
            else if (ch==')') {
                stack.push(ch);
            }else if(ch=='('){
                while(stack.peek()!=')'){
                    prefix.append(stack.pop());
                }
                stack.pop();
            }else{
                if(stack.isEmpty()|| prec(stack.peek())<=prec(ch))
                    stack.push(ch);
                else{
                    while (!stack.isEmpty()
                            && (prec(stack.peek())>prec(ch)))
                        prefix.append(stack.pop());
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty())
            prefix.append(stack.pop());

        return prefix.reverse().toString();
    }
}
