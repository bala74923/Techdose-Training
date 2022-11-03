package HASH_MAP.ASSIGNMENT;

import java.util.HashSet;
import java.util.Set;

public class _1044_Longest_Duplicate_Substring {
    int base = 33, mod = (int)1e9+7;
    long[] pow,hash;
    int start,end;
    public String longestDupSubstring(String s) {
        int N = s.length();
        start = end = -1;

        pow = new long[N+2];
        hash = new long[N+2];
        pow[0]=1;
        for(int i=1;i<=N;i++){
            pow[i] = pow[i-1]*base;
            hash[i] = hash[i-1]*base + (s.charAt(i-1)-'a');
        }
        int lo =0,hi  = s.length(),res=-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(check(s,mid)){
                res = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return res==-1?"":s.substring(start,end);
    }
    long get(int l,int r){
        return hash[r]- hash[l-1]*pow[r-l+1];
    }
    boolean check(String s,int len){
        Set<Long> set = new HashSet<>();
        // here hash array is 1 based indexing
        for(int i=1;i+len-1<=s.length();i++){
            if(!set.add(get(i,i+len-1))){
                start = i-1;// 1based index so reduce 1
                end = i+len-1;// no need to increment as it is already 1 based indexing
                return true;
            }
        }
        return false;
    }
}
