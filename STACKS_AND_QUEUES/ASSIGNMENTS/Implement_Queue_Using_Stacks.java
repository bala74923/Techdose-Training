package STACKS_AND_QUEUES.ASSIGNMENTS;

import java.util.Stack;

public class Implement_Queue_Using_Stacks {
    /*
 2 stack implementation
 push- o(1) storage oriented queue
 pop- o(n)
 top -o(n)
*/
    class MyQueue1 {
        Stack<Integer> stack,help;
        public MyQueue1() {
            stack = new Stack<>();
            help = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            int res=  -1;
            while(!stack.isEmpty()){
                help.push(stack.pop());
            }
            res = help.pop();
            while(!help.isEmpty()){
                stack.push(help.pop());
            }
            return res;
        }

        public int peek() {
            int res=  -1;
            while(!stack.isEmpty()){
                help.push(stack.pop());
            }
            res = help.peek();
            while(!help.isEmpty()){
                stack.push(help.pop());
            }
            return res;
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
    /*
     2 stack implementation
     push- o(n)  retrieval oriented queue
     pop- o(1)
     top -o(1)
    */
    class MyQueue {
        Stack<Integer> stack,help;
        public MyQueue() {
            stack = new Stack<>();
            help = new Stack<>();
        }

        public void push(int x) {
            while(!stack.isEmpty())
                help.push(stack.pop());
            stack.push(x);
            while(!help.isEmpty())
                stack.push(help.pop());
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
