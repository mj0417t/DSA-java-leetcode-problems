import java.util.ArrayList;
import java.util.List;

public class PairsWithKSumSortedDLL {
    public static void main(String[] args) {
        NodeDLL head= new NodeDLL(1);
        head.next= new NodeDLL(2);
        head.next.prev=head;
        head.next.next=new NodeDLL(3);
        head.next.next.prev= head.next;
        head.next.next.next=new NodeDLL(4);
        head.next.next.next.prev=head.next.next;
        head.next.next.next.next=new NodeDLL(9);
        head.next.next.next.next.prev=head.next.next.next;
        int k=5;
        printDLL(head);
        List<List<Integer>> pairs;
//        pairs=findPairs(head,k);  //TC-O(n2)
        pairs=pairs=findPairsOpt(head,k);
        System.out.println(pairs);
    }

    private static List<List<Integer>> findPairsOpt(NodeDLL head, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        NodeDLL left=head;
        NodeDLL right=findLastNode(head);

        while(left.prev!=right){
            if(left.data+right.data==k){
                pairs.add(new ArrayList<>(List.of(left.data,right.data)));
                left=left.next;
                right=right.prev;
            }else if(left.data+right.data<k)
                left=left.next;
            else
                right=right.prev;

        }
        return pairs;
    }

    private static NodeDLL findLastNode(NodeDLL head) {
        NodeDLL curr=head;
        while (curr.next!=null){
            curr=curr.next;
        }
        return curr;
    }

    private static List<List<Integer>> findPairs(NodeDLL head, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        NodeDLL t1=head;
        while (t1!=null){
            NodeDLL t2=t1.next;
            while (t2!=null && (t1.data+t2.data<=k)){
                if (t1.data+t2.data==k){
                    pairs.add(new ArrayList<>(List.of(t1.data,t2.data)));
                }
                t2=t2.next;
            }
            t1=t1.next;

        }
        return pairs;
    }

    private static void printDLL(NodeDLL head) {
        NodeDLL temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null)
                System.out.print("<->");
            temp=temp.next;
        }
        System.out.println();
    }
}
