import java.util.Stack;

public class MinStack {
    Stack<int[]> stack;

    public MinStack() {
        stack=new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new int[]{val,val});
        else{
            int[] lastElem=stack.peek();
            if(lastElem[1]<=val)
                stack.push(new int[]{val,lastElem[1]});
            else
                stack.push(new int[]{val,val});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        int[] lastElem=stack.peek();
        return lastElem[0];
    }

    public int getMin() {
        int[] lastElem=stack.peek();
        return lastElem[1];
    }
}
