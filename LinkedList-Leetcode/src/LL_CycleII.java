import java.util.HashMap;

public class LL_CycleII {
    public static void main(String[] args) {
        ListNode head= new ListNode(10);
        head.next=new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next=head.next;
//        ListNode cycleBegins=findNodeWhereCycleBegins(head);
        ListNode cycleBegins=findNodeWhereCycleBeginsOpt(head);
        System.out.println(cycleBegins.val);
    }

    private static ListNode findNodeWhereCycleBeginsOpt(ListNode head) {
        if(head==null) return null;
        ListNode fast=head;
        ListNode slow=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }

        }
        return null;
    }

    private static ListNode findNodeWhereCycleBegins(ListNode head) {
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
        if(curr==null) return null;
        return curr;
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
