import java.util.ArrayList;
import java.util.List;

public class SortLL {
    public static void main(String[] args) {
        ListNode head= new ListNode(-1);
        head.next=new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        printLL(head);
        head=sortList(head);
        printLL(head);
    }
    private static ListNode sortList(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode curr=head;
        while (curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        list.sort((a,b)->a-b);
        curr=head;
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
