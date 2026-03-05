package SinglyLL;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Node head= new Node(10);
        head.next=new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        printLL(head);
        traverseLLRec(head);

        head = insertAtFront(head,5);
        printLL(head);
        head = insertAtEnd(head,45);
        printLL(head);

        head = insertAtpos(head,25,4);
        printLL(head);

        head = deleteAtFront(head);
        printLL(head);

        head = deleteAtEnd(head);
        printLL(head);

        head = deleteAtpos(head,4);
        printLL(head);

        //search key
        if(searchKey(head,45))
            System.out.println("data found");
        else System.out.println("data not found");
        if(searchKeyRec(head,25))
            System.out.println("data found");
        else System.out.println("data not found");

        head=insertAtEnd(head,45);
        head=insertAtpos(head,23,3);
        head=insertAtEnd(head,55);
        //reverse a LL
        head = reverseLLusing3ptr(head);
        printLL(head);
        head = reverseLLusingRec(head);
        printLL(head);
        head = reverseLLusingStack(head);
        printLL(head);
    }

    private static Node reverseLLusingStack(Node head) {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }

        //make last node as head

        if(!stack.isEmpty()){
            head=stack.pop();
            temp=head;
            while (!stack.isEmpty()){
                temp.next=stack.pop();
                temp=temp.next;
            }
            temp.next=null;
        }
        return head;
    }

    private static Node reverseLLusingRec(Node head) {
        if(head==null|| head.next==null)
            return head;
        Node rest=reverseLLusingRec(head.next);
        head.next.next=head;
        head.next=null;
        return rest;
    }

    private static Node reverseLLusing3ptr(Node head) {
        Node prev=null;
        Node curr=head;
        Node next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private static boolean searchKeyRec(Node head, int key) {
        if(head==null) return false;
        if(head.data==key) return true;
        return searchKeyRec(head.next,key);
    }

    private static Node deleteAtpos(Node head, int pos) {
        if(pos==1)
            return head.next;
        Node prev=null;
        Node temp =head;
        for (int i = 1; i <pos ; i++) {
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        return head;
    }

    private static boolean searchKey(Node head, int key) {
        Node temp =head;
        while(temp!=null){
            if(temp.data==key)
                 return true;
            temp=temp.next;
        }
        return false;
    }

    private static Node deleteAtEnd(Node head) {
        if(head==null || head.next==null)
            return null;
        Node temp = head;
        while(temp.next.next!=null)
            temp=temp.next;
        temp.next=null;
        return head;
    }

    private static Node deleteAtFront(Node head) {
        if(head==null)
            return null;
        head=head.next;
        return head;
    }

    private static Node insertAtpos(Node head, int data, int pos) {
        if(pos<1)
            return head;
        Node newNode=new Node(data);
        if(pos==1){
            newNode.next=head;
            return newNode;
        }

        Node curr=head;

        for (int i = 1; i < pos-1 && curr!=null; i++) {
            curr=curr.next;
        }

        if(curr==null) //pos> size
            return head;


        newNode.next=curr.next;
        curr.next=newNode;

        return head;
    }

    private static Node insertAtEnd(Node head, int data) {
        Node newNode= new Node(data);
        if(head==null)
            return newNode;
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=newNode;
        return head;
    }

    private static Node insertAtFront(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next=head;
//        head=newNode;
        return newNode;
    }

    private static void traverseLLRec(Node head) {
        if(head==null){
            System.out.println();
            return;
        }
        System.out.print(head.data);
        if(head.next!=null)
            System.out.print("->");
        traverseLLRec(head.next);
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
