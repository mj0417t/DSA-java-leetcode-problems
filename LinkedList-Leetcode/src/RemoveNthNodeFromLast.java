public class RemoveNthNodeFromLast {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n=4;

        printLL(head);
//        head=removeNthFromEnd(head,n);
        head=removeNthFromEndOnePass(head,n);
        printLL(head);

    }

    private static ListNode removeNthFromEndOnePass(ListNode head, int n) {
        if(head==null) return null;
        if(head.next == null){
            if(n==1) return null;
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        int i = 0;
        for (; i < n && fast.next!=null; i++) {
            fast=fast.next;
        }
        if(i<n){
            head=head.next;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode temp=slow.next;
        slow.next=temp.next;
        temp.next=null;
        return head;
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        if(head.next == null){
            if(n==1) return null;
            return head;
        }
        int cnt=0;
        ListNode curr=head;
        while (curr!=null){
            cnt++;
            curr=curr.next;
        }
        int posToDel=cnt-n;

        if(posToDel==0){
            head=head.next;
            return head;
        }
        curr=head;
        for(int i=1;i<posToDel-1 && curr!=null;i++){
            curr=curr.next;
        }
        if(curr.next!=null){
            ListNode temp=curr.next;
            curr.next=temp.next;
            temp.next=null;

        }


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
