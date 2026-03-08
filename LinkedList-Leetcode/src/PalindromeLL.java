import java.util.ArrayList;
import java.util.List;

public class PalindromeLL {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        System.out.println(isPalindrome(head)); //TC-O(n) SC-O(n)
        System.out.println(isPalindromeOpt(head)); //TC-O(n) SC-O(1)
    }

    private static boolean isPalindromeOpt(ListNode head) {
        //finding mid node
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        //splitting into 2 halves & reversing 2nd half
        ListNode secHalf=mid.next;
        secHalf=reverse(secHalf);

        ListNode curr1=head;
        ListNode curr2=secHalf;
        //comparing the 2 halves
        while (curr2!=null){
            if(curr1.val!=curr2.val)
                return false;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private static boolean isPalindrome(ListNode head) {
        if(head==null) return false;
        if(head.next ==null) return true;
        List<Integer> list=new ArrayList<>();
        ListNode curr=head;
        while (curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        int n=list.size();
        for(int i=0;i<n/2;i++)
            if (list.get(i)!=list.get(n-1-i))
                return false;
        return true;
    }
}
