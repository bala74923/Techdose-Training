package _10_Heap.ASSIGNMENTS;

import java.util.PriorityQueue;

public class _1882_Process_Tasks_Using_Servers {
    static int[] solve(int[] servers,int[] tasks){
        int N = tasks.length;;
        int[] res = new int[N];

        // already tasks are based on timing so no need
        // sort based on timing

        //{index, end time}
        PriorityQueue<int[]> used =  new PriorityQueue<>((a,b)->
                a[1]==b[1]?(
                        servers[a[0]]==servers[b[0]]?
                        a[0]-b[0]: servers[a[0]]-servers[b[0]]
                )
                        :a[1]-b[1]);

        // {room value,index}
        PriorityQueue<int[]> unused = new PriorityQueue<>((a,b)->
                a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        for(int i=0;i<servers.length;i++){
            unused.add(new int[]{servers[i],i});
        }

        for(int time = 0;time<tasks.length;time++){
            // remove all used roooms that ending here
            while(!used.isEmpty() && used.peek()[1]<=time){
                int index = used.poll()[0];
                unused.add(new int[]{servers[index],index});
            }
            // check is any server is available
            if(unused.size()>0){
                int index = unused.poll()[1];
                used.add(new int[]{index,time+tasks[time]});
                res[time] = index;
            }else{ // if no server available
                int[] obj = used.poll();
                int firstFree = obj[0];
                int newStart = obj[1];
                // suddenly gonna use so dont add to unuse
                res[time] = firstFree;
                used.add(new int[]{firstFree,newStart+tasks[time]});
            }
        }



        return res;
    }
}
