import java.util.HashMap;

public class LL_Cycle {
    public static void main(String[] args) {
        ListNode head= new ListNode(10);
        head.next=new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next=head.next;
        System.out.println(hasCycle(head));
//        System.out.println(hasCycleOpt(head));

    }

    private static boolean hasCycleOpt(ListNode head) {
        if(head==null) return false;
        ListNode fast=head;
        ListNode slow=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;

        }
        if(fast.next==null || fast.next.next==null)
            return false;
        return true;
    }

    private static boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode curr=head;
        while (curr!=null){
            if(map.containsKey(curr))
                break;
            else{
                map.put(curr,map.getOrDefault(curr,0)+1);
            }
            curr=curr.next;
        }
        if(curr==null) return false;
        return true;
    }
}
