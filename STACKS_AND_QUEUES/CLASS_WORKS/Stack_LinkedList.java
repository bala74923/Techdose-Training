package STACKS_AND_QUEUES.CLASS_WORKS;

import java.util.Scanner;

public class Stack_LinkedList {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        StackLL stack = new StackLL();
        while (true) {
            System.out.println("Enter the option \n" +
                    "1)push \n2)pop \n3)peek \n4)exit");
            int option = sc.nextInt();
            boolean exit = false;
            switch (option) {
                case 1:
                    System.out.println("Enter the value to push:");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    System.out.println("popped element is: " + stack.pop());
                    break;
                case 3:
                    System.out.println("peek element is: " + stack.peek());
                    break;
                default:
                    exit = true;
                    break;
            }
            if (exit) break;
        }
    }
}
class StackLL{
    Node top;
    StackLL(){
        // add at front delete at front
        top= null;
    }
    void push(int data){
        Node nn = new Node(data);
        nn.next = top;
        top = nn;
    }
    int pop(){
        if(isEmpty())
            return -1;
        int res= top.data;
        top = top.next;
        return res;
    }
    int peek(){
        if(isEmpty())
            return -1;
        int res= top.data;
        return res;
    }
    boolean isEmpty(){
        return top==null;
    }

}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
    Node(){}
    Node(int data,Node next){
        this.data=  data;
        this.next=  next;
    }
}