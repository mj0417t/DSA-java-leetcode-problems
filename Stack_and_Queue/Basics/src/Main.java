public class Main {
    public static void main(String[] args) {
        LinkedListStack stack=new LinkedListStack();
        stack.push(24);
        stack.push(12);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        if(stack.isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println("stack is not empty");


        ArrayQueue queue=new ArrayQueue(8);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        if (queue.isEmpty())
            System.out.println("Queue is empty");
        else
            System.out.println("Queue is not empty");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
