public class rotateList {
    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k=4;
        printLL(head);
        head=rotateByKplaces(head,k);
        printLL(head);

    }

    private static ListNode rotateByKplaces(ListNode head, int k) {
        int n=sizeOfLL(head);
        if(k==n) return head;
        else if (k>n) {
            return rotateByKplaces(head,k%n);
        }else{
            ListNode curr=head;
            for(int i=1;i<n-k;i++){
                curr=curr.next;
            }
            ListNode nextNode=curr.next;
            curr.next=null;


            curr=nextNode;
            while (curr.next!=null){
                curr=curr.next;
            }
            curr.next=head;
            return nextNode;
        }
    }

    private static int sizeOfLL(ListNode head) {
        int cnt=0;
        ListNode curr=head;
        while (curr!=null){
            cnt++;
            curr=curr.next;
        }
        return cnt;
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
