import java.util.HashMap;

public class CopyListWithRandomPtr {
    public static void main(String[] args) {
        Node head=new Node(7);
        head.child=null;
        head.next= new Node(13);
        head.next.child= head;
        head.next.next= new Node(11);

        head.next.next.next = new Node(10);
        head.next.next.next.child = head.next.next;
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.child = null;
        head.next.next.child= head.next.next.next.next;

//        Node copyList= deepCopyHead(head);
        Node copyList= deepCopyHeadOpt(head);
    }

    private static Node deepCopyHeadOpt(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode= new Node(temp.data);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }

        temp=head;
        while (temp!=null){
            Node copyN=temp.next;
            if(temp.child!=null)
                copyN.child= temp.child.next;
            temp=temp.next.next;
        }

        Node dNode=new Node(-1);
        Node res=dNode;
        temp=head;
        while (temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return dNode.next;
    }

    private static Node deepCopyHead(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node temp=head;
        while (temp!=null){
            Node newN= new Node(temp.data);
            map.put(temp,newN);
            temp=temp.next;
        }
        temp=head;
        while (temp!=null){
            Node copyN=map.get(temp);
            copyN.next= map.get(temp.next);
            copyN.child=map.get(temp.child);
            temp=temp.next;
        }
        return map.get(head);
    }


}

