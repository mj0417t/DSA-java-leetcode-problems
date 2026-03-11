import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FlatteningALL {
    public static void main(String[] args) {
        Node head=new Node(3);
        head.next= new Node(2);
        head.next.child=new Node(10);
        head.next.next= new Node(1);
        head.next.next.child = new Node(7);
        head.next.next.child.child = new Node(11);
        head.next.next.child.child.child = new Node(12);
        head.next.next.next=new Node(4);
        head.next.next.next.child =new Node(9);
        head.next.next.next.next =new Node(5);
        head.next.next.next.next.child =new Node(6);
        head.next.next.next.next.child.child =new Node(8);
//
//        ListNode flatHead=flattenLL(head);
//        printLL(flatHead);

        printOriginalLL(head);

//        Node flattened=flattenLLBet(head);
        Node flattened = flattenLLOpt(head); //using priority queue - nlogk
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }

    private static Node flattenLLOpt(Node head) {
        PriorityQueue<Node> pq =
                new PriorityQueue<>((a,b)->a.data-b.data);

        Node temp = head;

        while(temp != null){
            pq.add(temp);
            temp = temp.next;
        }

        Node dummy = new Node(-1);
        Node curr = dummy;

        while(!pq.isEmpty()){

            Node node = pq.poll();

            curr.child = node;
            curr = curr.child;

            if(node.child != null)
                pq.add(node.child);
        }

        return dummy.child;
    }

    private static void printOriginalLL(Node head) {
        Node curr=head;
        while (curr!=null){
            Node currChild=curr;
            while(currChild!=null){
                System.out.print(currChild.data +" ");
                currChild=currChild.child;
            }
            System.out.println();
            curr=curr.next;
        }
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }

    private static Node flattenLLBet(Node head) {
        if (head == null || head.next==null) {
            return head;
        }
        Node mergedHead= flattenLLBet(head.next);
        head.next=null;
        return merge2List(head,mergedHead);

    }

    private static Node merge2List(Node l1, Node l2) {
        Node dNode=new Node(-1);
        Node res=dNode;

        while (l1!=null && l2!=null){
            if(l1.data<l2.data){
                res.child=l1;
                res=l1;
                l1=l1.child;
            }else{
                res.child=l2;
                res=l2;
                l2=l2.child;
            }
            res.next=null;
        }
        if(l1!=null)
            res.child=l1;
        else
            res.child=l2;

        return dNode.child;
    }

    private static ListNode flattenLL(Node head) {
        List<Integer> list =new ArrayList<>();
        ListNode flatHead= new ListNode(-1);
        Node curr=head;
        while (curr!=null){
            Node currChild=curr;
            while(currChild!=null){
                list.add(currChild.data);
                currChild=currChild.child;
            }
            curr=curr.next;
        }
        list.sort((a,b)->a-b);
        ListNode temp=flatHead;
        for (int i = 0; i < list.size(); i++) {
            temp.next=new ListNode(list.get(i));
            temp=temp.next;
        }
        return flatHead.next;
    }

    private static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp!=null) {
            System.out.print(temp.val);
            if(temp.next!=null)
                System.out.print("->");
            temp=temp.next;
        }
        System.out.println();
    }
}
