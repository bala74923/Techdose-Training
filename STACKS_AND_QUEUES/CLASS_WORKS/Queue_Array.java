package STACKS_AND_QUEUES.CLASS_WORKS;

import java.util.Scanner;

public class Queue_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter queue capacity:");
        int capacity=  sc.nextInt();
        MyCircularQueue q= new MyCircularQueue(capacity);
        while(true){
            System.out.println("Enter the option \n" +
                    "1)enqueue \n2)dequeue \n3)front \n4)rear \n5)exit");
            int option = sc.nextInt();
            boolean exit= false;
            switch(option){
                case 1:
                    System.out.println("Enter the value to enqueue:");
                    int val = sc.nextInt();
                    q.enQueue(val);
                    break;
                case 2:
                    System.out.println("dequeued element is: "+q.deQueueFront());
                    break;
                case 3:
                    System.out.println("front element is: "+q.Front());
                    break;
                case 4:
                    System.out.println("rear element is: "+q.Rear());
                    break;
                default:
                    exit = true;
                    break;
            }
            if(exit)break;
        }
    }
}
class MyCircularQueue {
    int[] arr;
    int size,front,rear,capacity;
    public MyCircularQueue(int k) {
        arr = new int[k];
        size = front= 0;
        rear = -1;
        capacity  = k;
    }

    public boolean enQueue(int value) {
        if(isFull()) {
            System.out.println("queue already full bruhh! delete some elements :)");
            return false;
        }
        arr[++rear%capacity] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) {
            System.out.println("no more elements left please insert some :)");
            return false;
        }
        size--;
        front++;
        return true;
    }
    public int deQueueFront() {
        if(isEmpty()) {
            System.out.println("no more elements left please insert some :)");
            return -1;
        }
        size--;
        return arr[front++%capacity];
    }

    public int Front() {
        if(isEmpty()) return -1;
        return arr[front%capacity];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return arr[rear%capacity];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size== capacity;
    }
}
