package SinglyLL;

public class ModifySinglyLL {
    public static void main(String[] args) {
        Node head= new Node(10);
        head.next=new Node(4);
        head.next.next = new Node(5);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(6);
        printLL(head);
        //modify LL such that 1st half=lastnode-ith node and second half = prev value of first half
//        head=modifyLL_UsingArr(head);

        //modifyLL without using array
        head=modifyLL(head);
        printLL(head);
    }

    private static Node modifyLL(Node head) {
        //if only one node present then return
        if(head.next==null)
            return head;

        //find mid node
        Node fast=head;
        Node slow= head;

        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node mid=slow;

        //storing 2nd half of the list
        Node reverseList = mid.next;
        //reversing 2nd half
        reverseList=reverse(reverseList);

        Node curr1=head;
        Node curr2=reverseList;
        while(curr2!=null){
            int x=curr1.data;
            curr1.data=curr2.data-x;
            curr2.data=x;
            curr1=curr1.next;
            curr2=curr2.next;
        }

        //reversing 2nd half & connecting two halfs
        mid.next=reverse(reverseList);
        return head;

    }

    private static Node reverse(Node head) {
        //using 3 ptr method
        Node prev=null, curr=head, next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private static Node modifyLL_UsingArr(Node head) {
        int cnt = countNode(head);
        int[] arr = new int[cnt];
        Node temp=head;
        int i=0;
        while (temp!=null){
            arr[i++]=temp.data;
            temp=temp.next;
        }

        for (int j = 0; j < cnt/2; j++) {
            int tem =arr[j];
            arr[j]=arr[cnt-1-j]-arr[j];
            arr[cnt-1-j]=tem;
        }

        temp=head;
        int k=0;
        while (temp!=null){
            temp.data=arr[k++];
            temp=temp.next;
        }
        return head;
    }

    private static int countNode(Node head) {
        Node temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
         return cnt;
    }
    private static void printLL(Node head) {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data);
            if(temp.next!=null)
                System.out.print("->");
            temp=temp.next;
        }
        System.out.println();
    }
}
