package STACKS_AND_QUEUES;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_Using_Queues {
    /*
    2 queues implementation (more push operations)
    push o(1)
    pop  o(n)
    top  o(n)
*/
    class MyStack1 {
        Queue<Integer> q,help;
        public MyStack1() {
            q = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int x) {
            q.add(x);
        }

        public int pop() {
            int res = -1;
            while(q.size()>1){
                help.add(q.poll());
            }
            res = q.poll();

            while(!help.isEmpty())
                q.add(help.poll());

            return res;
        }

        public int top() {
            int res = -1;
            while(q.size()>1){
                help.add(q.poll());
            }
            res = q.poll();
            help.add(res);

            while(!help.isEmpty())
                q.add(help.poll());

            return res;
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    /*
        2 queues implementation (more pop and top calls operations)
        push o(n)
        pop  o(1)
        top  o(1)
    */
    class MyStack2 {
        Queue<Integer> q,help;
        public MyStack2() {
            q = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int x) {
            // remove all elements
            while(!q.isEmpty()){
                help.add(q.poll());
            }
            q.add(x);
            while(!help.isEmpty()){
                q.add(help.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    /*
        1 queues implementation (more pop and top calls operations)
        push o(n)
        pop  o(1)
        top  o(1)
    */
    class MyStack3 {
        Queue<Integer> q;
        public MyStack3() {
            q = new LinkedList<>();
        }

        public void push(int x) {
            int size=  q.size();
            q.add(x);
            // remove n-1 elements so first element is x(n th element)
            // removed elements are added back wards
            while(size-->0){
                q.add(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }


}
