import java.util.HashMap;

public class Intersectionof2LL {
    public static void main(String[] args) {
        ListNode head1=new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(8);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode head2= new ListNode(5);
        head2.next= new ListNode(6);
        head2.next.next= new ListNode(1);
        head2.next.next.next=head1.next.next;

//        ListNode intersectionNode=findIntersectionPt(head1, head2);
//        ListNode intersectionNode=findIntersectionPtBet(head1, head2);
        ListNode intersectionNode=findIntersectionPtOpt(head1, head2);
        if(intersectionNode==null)
            System.out.println("No Intersection pt found");
        else
            System.out.println(intersectionNode.val);
    }

    private static ListNode findIntersectionPtOpt(ListNode head1, ListNode head2) {
        if(head1==null || head2==null) return null;
        ListNode t1= head1, t2=head2;
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if(t1==t2) return t1;
            if(t1==null)
                t1=head2;
            if(t2==null)
                t2=head1;
        }
        return t1;
    }

    private static ListNode findIntersectionPtBet(ListNode head1, ListNode head2) {
        ListNode t1 = head1;
        ListNode t2 = head2;

        int cnt1=0;
        int cnt2=0;
        while(t1!=null){
            cnt1++;
            t1=t1.next;
        }
        while(t2!=null){
            cnt2++;
            t2=t2.next;
        }
        t1=head1;
        t2=head2;
        if(cnt1>cnt2) {
            for (int i = 1; i < cnt1 - cnt2; i++)
                t1 = t1.next;
        } else if(cnt2>cnt1) {
            for (int i = 1; i <= cnt2 - cnt1; i++)
                t2 = t2.next;
        }

        while(t1!=null && t2!=null){
            if(t1==t2)
                return t1;
            t1=t1.next;
            t2=t2.next;
        }
    return  null;
    }

    private static ListNode findIntersectionPt(ListNode head1, ListNode head2) {
        ListNode t1 = head1;
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode t2 = head2;

        while(t1!=null){
            map.put(t1, map.getOrDefault(t1,0)+1);
            t1=t1.next;
        }
        while(t2!=null){
            if(map.containsKey(t2))
                return t2;
            t2=t2.next;
        }
        return null;
    }
}
