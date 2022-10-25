package LINKED_LIST.Class_Work;
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

    }
}
