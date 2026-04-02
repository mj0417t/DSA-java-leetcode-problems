import java.util.Stack;

public class MinStackOptimised {
    Stack<Long> stack;
    static long mini;

    public MinStackOptimised() {
        stack=new Stack<>();
        mini=Integer.MAX_VALUE;
    }

    public void push(int val) {
        long value=val;
        if(stack.isEmpty()){
            stack.push(value);
            mini = value;
        }else{
            if(value>=mini)
                stack.push(value);
            else{
                stack.push(2*value-mini);
                mini=value;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        long lastElem=stack.peek();
        stack.pop();
        if(lastElem<mini)
            mini=2*mini-lastElem;

    }

    public int top() {
        if(stack.isEmpty())
            return -1;
        long lastElem=stack.peek();
        if(mini<=lastElem)
            return (int)lastElem;
        return (int)mini;
    }

    public int getMin() {
        return (int)mini;

    }
}


