public class DeleteMidNode {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(6);
        printLL(head);
        head=deleteMiddle(head);
        printLL(head);
    }
    private static ListNode deleteMiddle(ListNode head) {
        if(head.next==null)
            return null;
//        ListNode fast=head;
//        ListNode slow=head;
//        ListNode prev=null;
//        while(fast.next!=null && fast.next.next!=null){
//            prev=slow;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        if(fast.next!=null){
//            ListNode temp=slow.next;
//            slow.next=temp.next;
//            temp.next=null;
//        }else{
//            prev.next=slow.next;
//            slow.next=null;
//        }
//        return head;

        ListNode fast=head.next.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
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
