public class Node {
    int data;
    Node next;
    Node child;

    Node(){
        this(0);
    }
     Node(int data){
        this(data,null,null);
    }
    Node(int data1, Node next1, Node child1) {
        data = data1;
        next = next1;
        child = child1;
    }
}
