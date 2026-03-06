//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Node head= new Node(10);
        head.next= new Node(20);
        head.next.prev=head;
        head.next.next=new Node(30);
        head.next.next.prev= head.next;
        head.next.next.next=new Node(40);
        head.next.next.next.prev=head.next.next;

        printDLL(head);

        //forwardTraversal using iteration
        forwardTraversal(head);

        //forwardTraversal using recursion
        forwardTraversalRec(head);

        //backward traversal using iteration
        Node tail=head.next.next.next;
        backwardTraversal(tail);

        //backward traversal using recursion
        backwardTraversalRec(tail);

        //insertions:-
        head=insertAtBegin(head, 15);
        printDLL(head);
        head=insertAtEnd(head, 45);
        printDLL(head);
        head=insertAtPos(head, 67, 3);
        printDLL(head);

        //Deletion
        head=deleteAtBegin(head);
        printDLL(head);
        head=deleteAtEnd(head);
        printDLL(head);
        head=deleteAtPos(head,4);
        printDLL(head);


    }

    private static Node deleteAtPos(Node head, int pos) {
        if (head==null) return null;
        Node curr=head;
        for (int i = 1; i < pos & curr!=null; i++) {
            curr=curr.next;
        }
        if(curr==null) return head;
        if(head==curr)
            head=curr.next;
        if(curr.next!=null){
            curr.next.prev=curr.prev;
            curr.prev.next=curr.next;
        }
        curr=null;
        return head;

    }

    private static Node deleteAtEnd(Node head) {
        if(head==null || head.next==null) return null;
        Node curr=head;
        while(curr.next!=null)
            curr=curr.next;
        if(curr.prev!=null)
            curr.prev.next=null;
        return head;
    }

    private static Node deleteAtBegin(Node head) {
        if(head==null || head.next==null) return null;
        Node temp=head;
        head=head.next;
        head.prev=null;
        temp.next=null;
        return head;
    }

    private static Node insertAtPos(Node head, int data, int pos) {
        Node newNode= new Node(data);
        if(pos==1){
            newNode.next=head;
            if(head!=null)
                head.prev=newNode;
            head=newNode;
            return head;
        }else{
            Node curr=head;
            for (int i = 1; i < pos & curr!=null; i++) {
                curr=curr.next;
            }
            if(curr==null)
                return head;

            curr.next.prev=newNode;
            newNode.next=curr.next;
            curr.next=newNode;
            newNode.prev=curr;
            return head;
        }
    }

    private static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if(head==null) return newNode;

        Node curr=head;
        while (curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
        newNode.prev=curr;
        return head;
    }

    private static Node insertAtBegin(Node head, int data) {
        Node newNode = new Node(data);
        if(head==null)
            return newNode;
        newNode.next=head;
        head.prev=newNode;
        return newNode;
    }

    private static void backwardTraversalRec(Node tail) {
        if(tail==null) return;
        System.out.println(tail.data);
        backwardTraversalRec(tail.prev);
    }

    private static void backwardTraversal(Node tail) {
        Node curr=tail;
        while (curr!=null){
            System.out.println(curr.data);
            curr=curr.prev;
        }
    }

    private static void forwardTraversalRec(Node head) {
        if(head==null) return;
        System.out.println(head.data);
        forwardTraversalRec(head.next);
    }

    private static void forwardTraversal(Node head) {
        Node curr=head;
        while (curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }

    private static void printDLL(Node head) {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null)
                System.out.print("<->");
            temp=temp.next;
        }
        System.out.println();
    }
}