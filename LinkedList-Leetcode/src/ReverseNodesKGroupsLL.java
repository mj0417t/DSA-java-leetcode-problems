public class ReverseNodesKGroupsLL {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        int k=4;

        printLL(head);
        head =reverseKGroup(head,k);
        printLL(head);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head, prevNode=null, nextNode=null;
        while(temp!=null) {
            ListNode kthNode = findkthNode(temp, k);
            if(kthNode==null){
                if(prevNode!=null) prevNode.next=temp;
                break;
            }else {
                nextNode = kthNode.next;
                kthNode.next=null;
                kthNode=reverse(temp);
                if(head==temp)
                    head=kthNode;
                else
                    prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }

        return  head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev=null, next=null, curr=head;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private static ListNode findkthNode(ListNode head, int k) {
        ListNode curr=head;
        for(int i=1;i<k && curr!=null;i++)
            curr=curr.next;
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
