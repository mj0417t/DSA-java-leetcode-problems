public class ArrayStack {

    int[] stack;
    int capacity;
    int topIndex;
    public ArrayStack(int capacity){
        this.capacity=capacity;
        stack = new int[capacity];
        topIndex=-1;
    }
    void push(int n){
        if(topIndex>=capacity-1){
            System.out.println("Stack Overflow");
            return;
        }

        stack[++topIndex]=n;
    }

    int pop(){
        if(topIndex<0){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[topIndex--];
    }

    int top(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[topIndex];
    }

    boolean isEmpty(){
        if(topIndex <0)
            return true;
        return false;
    }
}
