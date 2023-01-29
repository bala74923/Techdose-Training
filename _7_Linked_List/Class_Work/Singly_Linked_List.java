package _7_Linked_List.Class_Work;

import java.util.Scanner;

class Node{
    int val;
    Node next;
    // constructor
    Node(int val){this.val = val;}
    Node(int val,Node next){this.val = val;this.next = next;}
    Node(){}
}
class LinkedList{
    Node head;
    LinkedList(){
        this.head =null;
    }
    // append
    void append(int val){
        Node nn=  new Node(val);
        if(head==null){
            head = nn;
            return ;
        }
        Node tmp = head;
        while(tmp.next!=null){
            tmp= tmp.next;
        }
        tmp.next = nn;

    }

    // add at beginning
    void prepend(int val){
        Node nn = new Node(val);
        nn.next=  head;
        head = nn;
    }

    // insert at particular position
    void insertAt(int pos,int val){
        Node nn=  new Node(val);
        int currPos= 0;
        pos--;
        Node tmp = head,prev=null;
        while(tmp!=null && pos!=currPos){
            currPos++;
            prev= tmp;
            tmp=tmp.next;
        }
        if(prev==null) prepend(val);
        else{
            Node nextNode = tmp;
            prev.next = nn;
            nn.next = tmp;
        }
    }

    //search an element in linked list
    boolean search(int val){
        Node tmp = head;
        while(tmp!=null){
            if(val==tmp.val) return true;
            tmp= tmp.next;
        }
        return false;
    }

    // delete first
    int poll(){
        if(head==null){
            return -1;
        }
        int res=  head.val;
        head = head.next;
        return res;
    }

    // delete last
    int pop(){
        // no elements
        if(head==null){
            return -1;
        }
        Node prev = null,tmp = head;
        while(tmp.next!=null){
            prev= tmp;
            tmp = tmp.next;
        }
        // prev->previous to last,tmp-> last node
        if(prev==null){
            // only one node
            return poll();
        }else{
            int res= tmp.val;
            prev.next=  null;
            return res;
        }
    }

    //delete at particular position
    int deleteAt(int pos){
        pos--;
        int currPos = 0;
        Node tmp = head,prev = null;
        while(tmp!=null && currPos!=pos){
            currPos++;
            prev = tmp;
            tmp = tmp.next;
        }
        if(prev==null){ // deleting first element
            return poll();
        }else{
            int res= tmp.val;
            prev.next = tmp.next;
            return res;
        }
    }

    //delete at middle
    int deleteMid(){
        Node turtle=  head, hare = head;
        if(turtle==null) return -1;
        Node prev = null;
        while(hare!=null && hare.next!=null){
            prev=  turtle;
            turtle = turtle.next;
            hare= hare.next.next;
        }
        // deleting the first element
        if(prev==null) return poll();
        int res = turtle.val;//currently at middle
        prev.next = turtle.next;
        return res;
    }

    // display the linked list
    void display(){
        Node tmp = head;
        while(tmp!=null){
            System.out.print(tmp.val+",");
            tmp = tmp.next;
        }
        System.out.println("Null");
    }

}
public class Singly_Linked_List {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        LinkedList ll = new LinkedList();
        while(true){
            System.out.println("Enter the option \n1)append " +
                    "\n2)prepend \n3)insertAt \n4)search \n" +
                    "5)deleteAt\n 6)poll \n7)pop \n8)deleteAtMid \n" +
                    "9)display");
            int option = sc.nextInt();
            boolean exit= false;
            switch(option){
                case 1:
                    System.out.println("Enter the value to append:");
                    int val = sc.nextInt();
                    ll.append(val);
                    break;
                case 2:
                    System.out.println("Enter the value to prepend:");
                    int val2 = sc.nextInt();
                    ll.prepend(val2);
                    break;
                case 3:
                    System.out.println("Enter the value :");
                    int val3 = sc.nextInt();
                    System.out.println("Enter the position :");
                    int pos3 = sc.nextInt();
                    ll.insertAt(pos3,val3);
                    break;
                case 4:
                    System.out.println("Enter the value to search:");
                    int val4 = sc.nextInt();
                    System.out.println(ll.search(val4));
                    break;
                case 5:
                    System.out.println("Enter the position :");
                    int pos5 = sc.nextInt();
                    ll.deleteAt(pos5);
                    break;
                case 6:
                    System.out.println("polled element is "+ll.poll());
                    break;
                case 7:
                    System.out.println("popped element is"+ll.pop());
                    break;
                case 8:
                    ll.deleteMid();
                    System.out.println("middle element is deleted");
                    break;
                case 9:
                    System.out.println("linked list is");
                    ll.display();
                    break;

                default:
                    exit = true;
                    break;
            }
            if(exit)break;
        }
    }
}
