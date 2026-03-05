package SinglyLL;

public class DeleteNode {
    public static void main(String[] args) {
        Node head= new Node(4);
        head.next=new Node(5);
        head.next.next = new Node(1);
        head.next.next.next = new Node(9);
        printLL(head);
        Node node = head.next;
        deleteNode(node);
        printLL(head);
    }
    private static void deleteNode(Node node) {
        Node prev=null;
        while(node.next!=null){
            node.data=node.next.data;
            prev=node;
            node=node.next;
        }
        prev.next=node.next;
    }
    private static void printLL(Node head) {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data);
            if(temp.next!=null)
                System.out.print("->");
            temp=temp.next;
        }
        System.out.println();
    }
}
