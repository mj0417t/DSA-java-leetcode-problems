import java.util.LinkedList;

public class LinkedListQueue {

    LinkedList<Integer> queue;

    public LinkedListQueue(){
        queue=new LinkedList<>();
    }

    void push(int x){
        queue.add(x);
    }
    int pop(){
        if(queue.size()==0){
            System.out.println("Queue is empty");
            return -1;
        }
        int x= queue.getFirst();
        queue.removeFirst();
        return x;

    }

    int peek(){
        if(queue.size()==0){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue.getFirst();
    }

    boolean isEmpty(){
        if(queue.size()==0)
            return true;
        return false;
    }
}
