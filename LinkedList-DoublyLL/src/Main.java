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

    }

    private static void printDLL(Node head) {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null)
                System.out.print("<->");
            temp=temp.next;
        }
    }
}