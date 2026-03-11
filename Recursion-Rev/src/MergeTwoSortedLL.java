public class MergeTwoSortedLL {
    public static void main(String[] args) {
        ListNode list1= new ListNode(10);
        list1.next=new ListNode(20);
        list1.next.next = new ListNode(30);
        list1.next.next.next = new ListNode(40);
        list1.next.next.next.next = new ListNode(50);

        ListNode list2= new ListNode(5);
        list2.next=new ListNode(15);
        list2.next.next = new ListNode(25);
        list2.next.next.next = new ListNode(30);
        list2.next.next.next.next = new ListNode(50);
        System.out.println("List1:");
        printLL(list1);
        System.out.println("List2:");
        printLL(list2);

        System.out.println("Merged List: ");
        ListNode head=mergeLL(list1,list2);
        printLL(head);
    }

    private static ListNode mergeLL(ListNode list1, ListNode list2) {
        if(list1==null ) return list2;
        if(list2==null) return list1;
        if(list1.val<=list2.val){
            list1.next=mergeLL(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeLL(list1,list2.next);
            return list2;
        }
    }

    private static void printLL(ListNode head) {
        ListNode curr=head;
        while (curr!=null){
            System.out.print(curr.val);
            if (curr.next!= null) {
                System.out.printf("->");
            }
            curr=curr.next;
        }
        System.out.println();
    }
}
