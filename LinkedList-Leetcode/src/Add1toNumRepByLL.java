public class Add1toNumRepByLL {
    public static void main(String[] args) {
        ListNode head= new ListNode(9);
        head.next=new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next = new ListNode(9);

        printLL(head);
        head =addOne(head);
        printLL(head);
    }

    private static ListNode addOne(ListNode head) {
        head=reverseLL(head);
        ListNode curr=head;
        boolean flag=false;
        while (curr!=null){
            switch (curr.val){
                case 0,1,2,3,4,5,6,7,8 -> {
                    curr.val++;
                    flag=true;
                }
                case 9 -> curr.val=0;
            }
            if(flag)
                break;
            if(curr.next==null) {
                curr.next = new ListNode(1);
                break;
            }
            curr=curr.next;
        }
        return reverseLL(head);
    }

    private static ListNode reverseLL(ListNode head) {
        ListNode prev=null;
        ListNode next=null;
        ListNode curr=head;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
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
