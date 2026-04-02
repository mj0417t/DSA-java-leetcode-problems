import java.util.Stack;

public class StackQueue {
    Stack<Integer> queue;
    public StackQueue() {
        queue=new Stack<>();
    }

    public void push(int x) {
        queue.push(x);

    }

    public int pop() {
        Stack<Integer> que2 = new Stack<>();
        while (!queue.isEmpty())
            que2.push(queue.pop());
        int x= que2.pop();

        while (!que2.isEmpty())
            queue.push(que2.pop());

        return x;
    }

    public int peek() {
        Stack<Integer> que2 = new Stack<>();
        while (!queue.isEmpty())
            que2.push(queue.pop());
        int x= que2.peek();

        while (!que2.isEmpty())
            queue.push(que2.pop());

        return x;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}