package STACKS_AND_QUEUES.CLASS_WORKS;

import java.util.Scanner;

public class Queue_LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QueueLL q= new QueueLL();
        while(true){
            System.out.println("Enter the option \n" +
                    "1)enqueue \n2)dequeue \n3)front \n4)rear \n5)print queue \n6)exit");
            int option = sc.nextInt();
            boolean exit= false;
            switch(option){
                case 1:
                    System.out.println("Enter the value to enqueue:");
                    int val = sc.nextInt();
                    q.enQueue(val);
                    break;
                case 2:
                    System.out.println("dequeued element is: "+q.deQueue());
                    break;
                case 3:
                    System.out.println("front element is: "+q.Front());
                    break;
                case 4:
                    System.out.println("rear element is: "+q.Rear());
                    break;
                case 5:
                    q.printQueue();
                    break;
                default:
                    exit = true;
                    break;
            }
            if(exit)break;
        }
    }
}
class QueueLL{
    Node front,rear;
    QueueLL(){
        front= rear = null;
    }
    void enQueue(int data){
        Node nn = new Node(data);
        if(isEmpty()) front =rear = nn;
        else{
            // there are some nodes
            rear.next = nn;
            rear = nn;
        }
    }
    int deQueue(){
        // check is em pty
        if(isEmpty()) {
            System.out.println("no more elements left please insert some :)");
            return -1;
        }
        int res= front.data;
        front= front.next;
        return res;
    }
    int Front(){
        // check is em pty
        if(isEmpty()) {
            System.out.println("no more elements left please insert some :)");
            return -1;
        }
        int res= front.data;
        return res;
    }
    int Rear(){
        if(isEmpty()) {
            System.out.println("no more elements left please insert some :)");
            return -1;
        }
        return rear.data;
    }
    boolean isEmpty(){
        return front==null;
    }
    void printQueue(){
        Node tmp = front;
        while(tmp!=null){
            System.out.print(tmp.data+",");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
}
/*
class Node{
    int data;
    Node next;
    Node(){}
    Node(int data){this.data=data;}
    Node(int data,Node next){this.data = data; this.next= next;}
}
 */
