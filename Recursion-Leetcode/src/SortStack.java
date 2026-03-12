import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    private static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty() || stack.size()==1)
            return;
        int temp=stack.pop();
        sortStack(stack);
        insertAtCorrPos(stack,temp);
    }

    private static void insertAtCorrPos(Stack<Integer> stack, int temp) {
        if(stack.isEmpty() || stack.peek()<temp) {
            stack.push(temp);
            return;
        }
        int elem=stack.pop();
        insertAtCorrPos(stack,temp);
        stack.push(elem);
    }

}
