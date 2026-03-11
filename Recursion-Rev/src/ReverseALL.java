class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseALL {
    public static void main(String[] args) {
        ListNode head= new ListNode(10);
        head.next=new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        printLL(head);
        head=reverseLL(head);
        System.out.println("After reversal");
        printLL(head);
    }

    private static ListNode reverseLL(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode p=reverseLL(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }

    private static void printLL(ListNode head) {
        ListNode curr=head;
        while (curr!=null){
            System.out.print(curr.val);
            if (curr.next!= null) {
                System.out.printf("->");
            }
            curr=curr.next;
        }
        System.out.println();
    }
}
