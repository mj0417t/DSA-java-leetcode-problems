public class RemoveDupsfromSortedDLL {
    public static void main(String[] args) {
        NodeDLL head= new NodeDLL(1);
        head.next= new NodeDLL(2);
        head.next.prev=head;
        head.next.next=new NodeDLL(2);
        head.next.next.prev= head.next;
        head.next.next.next=new NodeDLL(3);
        head.next.next.next.prev=head.next.next;
        head.next.next.next.next=new NodeDLL(4);
        head.next.next.next.next.prev=head.next.next.next;
        head.next.next.next.next.next=new NodeDLL(5);
        head.next.next.next.next.next.prev=head.next.next.next.next;
        head.next.next.next.next.next.next=new NodeDLL(5);
        head.next.next.next.next.next.next.prev=head.next.next.next.next.next;
        head.next.next.next.next.next.next.next=new NodeDLL(5);
        head.next.next.next.next.next.next.next.prev=head.next.next.next.next.next.next;
        head.next.next.next.next.next.next.next.next=new NodeDLL(6);
        head.next.next.next.next.next.next.next.next.prev=head.next.next.next.next.next.next.next;

        printDLL(head);
//        head=removeDups(head);
        head=removeDupsAp2(head);

        printDLL(head);
    }

    private static NodeDLL removeDupsAp2(NodeDLL head) {
        NodeDLL curr = head;

        while (curr != null && curr.next != null) {

            if (curr.data == curr.next.data) {
                NodeDLL nextNode = curr.next;

                // remove duplicate
                curr.next = nextNode.next;

                if (nextNode.next != null) {
                    nextNode.next.prev = curr;
                }
            }
            else {
                curr = curr.next;
            }
        }

        return head;
    }

    private static NodeDLL removeDups(NodeDLL head) {
        NodeDLL t1=head;
        NodeDLL t2=head.next;
        while (t2!=null){
            while(t2!=null && t1.data==t2.data){
                if(t2.next!=null) t2.next.prev=t1;
                t1.next=t2.next;
                t2=t2.next;
            }
            if(t2==null) break;
            t1=t1.next;
            t2=t2.next;
        }
        return head;
    }

    private static void printDLL(NodeDLL head) {
        NodeDLL temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null)
                System.out.print("<->");
            temp=temp.next;
        }
        System.out.println();
    }
}
