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
//        head=sortList(head);
        head=sortListOptUsingMergeSort(head);
        printLL(head);
    }

    private static ListNode sortListOptUsingMergeSort(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode middle=findMidNode(head);
        ListNode left=head, right=middle.next;
        middle.next=null;
        ListNode leftHalf = sortListOptUsingMergeSort(left);
        ListNode rightHalf=sortListOptUsingMergeSort(right);
        return mergeLL(leftHalf,rightHalf);
    }

    private static ListNode mergeLL(ListNode head1, ListNode head2) {
        ListNode dNode= new ListNode(-1);
        ListNode temp=dNode;
        ListNode t1=head1, t2=head2;

        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){
                temp.next=t1;
                temp=temp.next;
                t1=t1.next;
            }else{
                temp.next=t2;
                temp=temp.next;
                t2=t2.next;
            }
        }
        if(t1!=null)
            temp.next=t1;
        if(t2!=null)
            temp.next=t2;

        return dNode.next;
    }

    private static ListNode findMidNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while (fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
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
