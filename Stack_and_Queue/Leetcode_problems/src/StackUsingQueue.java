import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> st;
    public StackUsingQueue() {
        st = new LinkedList<>();
    }

    public void push(int x) {
        int size=st.size();
        st.add(x);
        for (int i = 0; i < size; i++) {
            st.add(st.poll());

        }
    }

    public int pop() {
        if(!st.isEmpty())
            return st.poll();
        else return -1;
    }

    public int top() {
        if(!st.isEmpty())
            return st.peek();
        else return -1;
    }

    public boolean empty() {
        return st.isEmpty();
    }
}
