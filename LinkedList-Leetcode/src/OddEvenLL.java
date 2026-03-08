import java.util.ArrayList;
import java.util.List;

public class OddEvenLL {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        printLL(head);
//        head=oddEvenList(head);
        head=oddEvenListOpt(head);
        printLL(head);

    }

    private static ListNode oddEvenListOpt(ListNode head) {
        if(head==null || head.next ==null || head.next.next==null) return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenStrt = even;

        while(odd.next!=null && even.next!=null){
            if(odd.next.next!=null){
                odd.next=odd.next.next;
                odd=odd.next;
            }
            if(even.next.next!=null){
                even.next=even.next.next;
                even=even.next;
            }
        }
        if(even.next!=null)
            even.next=null;

        odd.next=evenStrt;
        return head;
    }

    private static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next ==null || head.next.next==null) return head;
        List<Integer> list = new ArrayList<>();
        ListNode odd = head;
        ListNode even=head.next;

        while (odd!=null && odd.next!=null){
            list.add(odd.val);
            odd=odd.next.next;
        }
        if(odd!=null)
            list.add(odd.val);
        while (even!=null&& even.next!=null){
            list.add(even.val);
            even=even.next.next;
        }
        if(even!=null)
            list.add(even.val);
        ListNode curr=head;
        for (int i = 0; i < list.size() && curr!=null; i++) {
            curr.val=list.get(i);
            curr=curr.next;
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
