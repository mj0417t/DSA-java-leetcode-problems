public class deleteAllOccuranceInDLL {
    public static void main(String[] args) {
        NodeDLL head= new NodeDLL(10);
        head.next= new NodeDLL(4);
        head.next.prev=head;
        head.next.next=new NodeDLL(10);
        head.next.next.prev= head.next;
        head.next.next.next=new NodeDLL(10);
        head.next.next.next.prev=head.next.next;
        head.next.next.next.next=new NodeDLL(6);
        head.next.next.next.next.prev=head.next.next.next;
        head.next.next.next.next.next=new NodeDLL(10);
        head.next.next.next.next.next.prev=head.next.next.next.next;

        int k=10;
        printDLL(head);
        head=deleteAllK(head,k);
        printDLL(head);
    }

    private static NodeDLL deleteAllK(NodeDLL head, int k) {
        if(head==null || (head.next==null && head.data==k)) return null;
        NodeDLL curr=head;
        while (curr!=null){
            if(curr.data==k){
                if(curr==head) {
                    head = head.next;
                    head.prev = null;
                }else if(curr.next==null){
                    curr.prev.next=null;
                }else{
                    curr.prev.next=curr.next;
                    curr.next.prev=curr.prev;
                }
            }
            curr=curr.next;
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
