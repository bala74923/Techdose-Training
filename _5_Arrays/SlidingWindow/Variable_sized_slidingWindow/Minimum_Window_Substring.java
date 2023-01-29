package _5_Arrays.SlidingWindow.Variable_sized_slidingWindow;

import java.util.Scanner;

public class Minimum_Window_Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), p = sc.next();
        System.out.println(solve(s,p));
    }
    static String solve(String s,String p){
        int[] pmap = new int[128], smap = new int[128];
        for(char c: p.toCharArray()) pmap[c]++;

        String res = null;
        StringBuilder currString = new StringBuilder("");
        int resLen= Integer.MAX_VALUE, curr = 0,pre = 0;
        while(curr<s.length()){
            smap[s.charAt(curr)]++;
            //adding strings
            currString.append(s.charAt(curr));

            boolean preChanged = false;
            while(contains(smap,pmap)){
                smap[s.charAt(pre)]--;

                // removing character from window
                currString.deleteCharAt(0);

                pre++;
                preChanged = true;
            }
            if(preChanged){
                smap[s.charAt(--pre)]++;

                // pre character is necessary to maintain true state
                currString.insert(0,s.charAt(pre));
            }

            if(contains(smap,pmap) && resLen>curr-pre+1){
                resLen = curr-pre+1;
                //res = s.substring(pre,curr+1); (old way without sb pointer)
                res = currString.toString();
            }
            curr++;
        }
        return res;
    }
    static boolean contains(int[] s,int[] p){
        for(int i=0; i<128 ;i++){
            if(s[i]<p[i]) return false;
        }
        return true;
    }
}
