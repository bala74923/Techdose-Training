package CONTEST_PROBLEMS.HARD_4;

import java.util.*;

public class _B89_Create_Components_With_Same_Value {
    public static void main(String[] args) {

    }
    static int solve(int[] nums,int[][] edges){
        int sum =0 ;
        for(int n: nums) sum+=n;
        List<Integer> factors = getFactors(sum);

        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] e: edges){
            int from= e[0],to=  e[1];
            // parent to child
            List<Integer> child = map.getOrDefault(from,new ArrayList<Integer>());
            child.add(to);
            map.put(from,child);

            List<Integer>  parent = map.getOrDefault(to,new ArrayList<Integer>());
            parent.add(from);
            map.put(to,parent);
        }
        System.out.println(factors);

        // total sum = partSum* count of Components
        /*
            part sum = totalsum/count of components
             so part sum is a factor of total sum so check min sum -> max number of components
             part sum inversely proportional to no of componentts
             so as soon as found less part sum which is suitable that is the answer
        */
        for(int partSum: factors){
            int got=  countComponents(map,nums,partSum);
            //System.out.printf("got = %d partsum=%d req=  %d\n",got,partSum,sum/partSum);
            if(got==sum/partSum){
                System.out.println(partSum);
                return got-1;
            }
        }
        return -1;
    }
    static int components = 0;
    static int countComponents(Map<Integer,List<Integer>> map,int[] arr,
                               int partSum){
        components = 0;
        visitTree(0,map,arr,partSum,new boolean[arr.length]);
        return components;
    }
    static int visitTree(int current,Map<Integer,List<Integer>> map,
                         int[] arr,int componentSum,boolean[] visited){
        if(visited[current]) return 0;;
        visited[current] = true;
        List<Integer> childs = map.getOrDefault(current,new ArrayList<>());
        int total = arr[current];
        for(int child: childs){
            total+= visitTree(child,map,arr,componentSum,visited);
        }
        if(total==componentSum){
            components++;
            return 0;
        }
        //System.out.printf(" total=%d sum=%d current =%d\n",total,componentSum,current);
        return total;
    }
    static List<Integer> getFactors(int n){
        int i= 1;
        List<Integer> list = new ArrayList<>();
        while(i*i<n){
            if(n%i==0){
                list.add(i);
                list.add(n/i);
            }
            i++;
        }
        if(n%i==0) list.add(i);
        Collections.sort(list);
        return list;
    }
}
