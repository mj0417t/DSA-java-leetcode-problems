import java.util.LinkedList;

public class LinkedListStack {

    LinkedList<Integer> stack;
    public LinkedListStack(){
        stack = new LinkedList<>();
    }
    void push(int n){
        stack.addLast(n);
    }

    int pop(){
        if(stack.size()==0){
            System.out.println("Stack is empty");
            return -1;
        }
        int x=stack.getLast();
        stack.removeLast();
        return x;
    }

    int top(){
        if(stack.size()==0){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack.getLast();
    }

    boolean isEmpty(){
        return stack.size()==0;
    }
}
