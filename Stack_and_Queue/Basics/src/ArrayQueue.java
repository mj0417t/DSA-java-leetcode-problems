public class ArrayQueue {
    int capacity;
    int lastIndex;
    int[] queue;

    public ArrayQueue(int size){
        capacity=size;
        queue=new int[capacity];
        lastIndex=-1;
    }

    void push(int x){
        queue[++lastIndex]=x;
    }
    int pop(){
        if(lastIndex<0){
            System.out.println("Queue is empty");
            return -1;
        }
        int x=queue[0];
        for(int i=0;i<lastIndex;i++)
            queue[i]=queue[i+1];
        lastIndex--;
        return x;
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[0];
    }

    boolean isEmpty(){
        if(lastIndex<0)
            return true;
        return false;
    }
}
