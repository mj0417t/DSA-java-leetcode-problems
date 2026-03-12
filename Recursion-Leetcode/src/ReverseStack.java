import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()|| stack.size()==1)
            return;
        int temp=stack.pop();
        reverse(stack);
        insertAtBottom(stack,temp);
    }
    private static void insertAtBottom(Stack<Integer> stack, int temp) {
        if(stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        int elem=stack.pop();
        insertAtBottom(stack,temp);
        stack.push(elem);
    }
}

