package CONTEST_PROBLEMS.HARD_4;

import java.util.PriorityQueue;
import java.util.Arrays;
public class _W309_Meeting_Rooms_3 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]==b[0]?a[1]-b[1]: a[0]-b[0]);
        // sort based on start time then we can sort based on end time for meet starts with same start time

        PriorityQueue<Integer> unused = new PriorityQueue<>(); // for unused rooms

        for(int room=0;room<n;room++)
            unused.add(room);

        // {end time,room no}
        PriorityQueue<int[]> using = new PriorityQueue<>((a,b)->
                a[0]==b[0]?a[1]-b[1]: a[0]-b[0]);
        // first nobody is using the room
        int[] count = new int[n]; // tracking no of meeting held by rooms

        for(int[] meet: meetings){
            int st = meet[0], end = meet[1];
            while(!using.isEmpty() && using.peek()[0]<= st){
                int[] removedRoom = using.poll(); // if meeting is ended before this starting time
                unused.add(removedRoom[1]);
            }
            if(unused.size()==0){ // no room is empty
                int[] firstFree = using.poll();
                int freed =firstFree[1];
                int newEndTime = (end-st)+ firstFree[0];
                using.add(new int[]{newEndTime,freed});
                count[freed]++;
                // room is not is unused and remove and suddenly used so dont put it in unused
            }else{ // some room is empty
                int free = unused.poll();
                count[free]++;
                using.add(new int[]{end,free});
            }
        }

        int maxi = 0;
        for(int i=0;i<n;i++){
            if(count[i]>count[maxi])
                maxi= i;
        }
        return maxi;
    }
}
