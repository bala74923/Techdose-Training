package CONTEST_PROBLEMS.MEDIUM_3;

import java.util.HashMap;
import java.util.Map;

public class _W302_Query_Kth_Smallest_Trimmed_Number {
    public static void main(String[] args) {

    }
    static Map<Integer,String> map;

    static int[] solve(String[] nums,int[][] queries){
        int N = queries.length;
        int[] res = new int[N];
        map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(i,nums[i]);
        int[][] sortedArray = getSortedArrays(nums);
        int resIndex=0;
        for(int[]q: queries){
            int pos = q[0]-1, size = q[1]-1;
            res[resIndex++] = sortedArray[size][pos];
        }
        return res;
    }
    static int[][] getSortedArrays(String[] arr){
        int maxLen = 0,N = arr.length;
        for(String s: arr) maxLen = Math.max(maxLen,s.length());
        int[] dup = new int[N];
        for(int i=0;i<N;i++) dup[i] = i;
        int[][] out = new int[maxLen][N];
        for(int pos=0;pos<maxLen;pos++){
            out[pos] = sort(pos==0?dup:out[pos-1],pos);
        }
        return out;
    }
    static int[] sort(int[] arr,int pos){
        int N = arr.length;
        int[] res = new int[N];
        int[] hash = new int[10];
        // frequency
        for(int ind: arr){
            String s = map.get(ind);
            if(pos<s.length()) hash[s.charAt(s.length()-pos-1)-'0']++;
            else hash[0]++; // we can  prepend 0 as much we want
        }
        //cumulative frequency
        for(int i=1;i<10;i++)
            hash[i]+=hash[i-1];
        for(int ind: arr){
            String s = map.get(ind);
            int index = pos<s.length()?s.charAt(s.length()-pos-1)-'0':0;
            res[--hash[index]] = ind;
        }
        return res;
    }
}
