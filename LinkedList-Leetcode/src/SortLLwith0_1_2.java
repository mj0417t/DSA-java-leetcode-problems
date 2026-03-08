public class SortLLwith0_1_2 {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next.next = new ListNode(0);

        printLL(head);
//        head=sortLL(head);
        head=sortLLOnePass(head);
        printLL(head);
    }

    private static ListNode sortLLOnePass(ListNode head) {
        ListNode dNode0=new ListNode(-1);
        ListNode dNode1=new ListNode(-1);
        ListNode dNode2=new ListNode(-1);
        ListNode zero=dNode0;
        ListNode one=dNode1;
        ListNode two=dNode2;

        ListNode temp=head;
        while (temp!=null){
            if(temp.val==0) {
                zero.next = temp;
                zero=zero.next;
            }
            else if(temp.val==1) {
                one.next = temp;
                one=one.next;
            }
            else {
                two.next = temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next=dNode1.next;
        one.next=dNode2.next;
        two.next=null;
        return dNode0.next;
    }

    private static ListNode sortLL(ListNode head) {
        int cnt0=0, cnt1=0, cnt2=0;
        ListNode temp = head;
        while (temp!=null){
            switch (temp.val){
                case 0->cnt0++;
                case 1->cnt1++;
                case 2->cnt2++;
            }
            temp=temp.next;
        }
        temp =head;
        while (temp!=null){
            if(cnt0-->0)
                temp.val=0;
            else if(cnt1-->0)
                temp.val=1;
            else
                temp.val=2;

            temp=temp.next;
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
