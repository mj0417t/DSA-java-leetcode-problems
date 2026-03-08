public class AddTwoNumLL {
    public static void main(String[] args) {
        ListNode l1= new ListNode(0);
//        l1.next=new ListNode(4);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(9);
//        l1.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2= new ListNode(0);
//        l2.next= new ListNode(6);
//        l2.next.next= new ListNode(4);
//        l2.next.next.next= new ListNode(9);
        printLL(l1);
        printLL(l2);
        ListNode res =addTwoNumbers(l1,l2);
        printLL(res);
    }
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null) return null;
        ListNode t1=l1, t2=l2;
        ListNode sum=new ListNode(-1);
        ListNode res=sum;
        int carry=0;
        while (t1!=null && t2!=null){

            int digSum=t1.val+t2.val+carry;

            if(digSum<=9) {
                sum.next = new ListNode(digSum);
                sum=sum.next;
                carry=0;
            }
            else{
                sum.next= new ListNode(digSum%10);
                carry=digSum/10;
                sum=sum.next;
            }

            t1=t1.next;
            t2=t2.next;
        }
        while(t1!=null){
            int digSum=t1.val+carry;
            if(digSum<=9) {
                sum.next = new ListNode(digSum);
                sum=sum.next;
                carry=0;
            }
            else{
                sum.next= new ListNode(digSum%10);
                carry=digSum/10;
                sum=sum.next;
            }
            t1=t1.next;
        }
        while(t2!=null){
            int digSum=t2.val+carry;
            if(digSum<=9) {
                sum.next = new ListNode(digSum);
                sum=sum.next;
                carry=0;
            }
            else{
                sum.next= new ListNode(digSum%10);
                carry=digSum/10;
                sum=sum.next;
            }
            t2=t2.next;
        }

        if(carry!=0) {
            sum.next = new ListNode(carry);
            sum=sum.next;
        }
        return res.next;
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
