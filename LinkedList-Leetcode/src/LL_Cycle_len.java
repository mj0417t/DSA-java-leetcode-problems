import java.util.HashMap;

public class LL_Cycle_len {
    public static void main(String[] args) {
        ListNode head= new ListNode(10);
        head.next=new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next=head.next;
//        System.out.println(cntLength(head));
        System.out.println(cntLengthOpt(head));
    }

    private static int cntLengthOpt(ListNode head) {
        int cnt=0;
        if(head==null) return 0;
        ListNode fast=head;
        ListNode slow=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cnt++;
                fast=fast.next;
                while (slow!=fast){
                    cnt++;
                    fast=fast.next;
                }
                return cnt;
            }

        }
        return 0;
    }

    private static int cntLength(ListNode head) {
        int cnt=0, nodeCnt=0;
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode curr=head;
        while (curr!=null){
            if(map.containsKey(curr)){
                return cnt-map.get(curr);
            }
            else{
                cnt++;
                map.put(curr,nodeCnt++);
            }
            curr=curr.next;
        }
        return -1;
    }
}
