package STACKS_AND_QUEUES.CLASS_WORKS;

import java.util.Scanner;

public class Stack_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter stack capacity:");
        int capacity=  sc.nextInt();
        Stack stack = new Stack(capacity);
        while(true){
            System.out.println("Enter the option \n" +
                    "1)push \n2)pop \n3)peek \n4)exit");
            int option = sc.nextInt();
            boolean exit= false;
            switch(option){
                case 1:
                    System.out.println("Enter the value to push:");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    System.out.println("popped element is: "+stack.pop());
                    break;
                case 3:
                    System.out.println("peek element is: "+stack.peek());
                    break;
                default:
                    exit = true;
                    break;
            }
            if(exit)break;
        }
    }
}
class Stack{
    int[] arr;
    int size,capacity,top;
    Stack(int capacity){
        this.capacity = capacity;
        size = 0;
        top = -1;
        arr= new int[capacity];
    }
    boolean isEmpty(){
        return size==0;
    }
    boolean isFull(){
        return size==capacity;
    }
    boolean push(int val) {
        if(isFull()){
            return false;
        }
        arr[++top] =val;
        size++;
        return true;
    }
    int pop(){
        if(isEmpty()){
            return -1;
        }
        size--;
        return arr[top--];
    }
    int peek(){
        if(isEmpty())
            return -1;
        return arr[top];
    }
}