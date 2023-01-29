package _5_Arrays.ClassWork;

public class FirstOne {
    public static void main(String[] args) {
        String s = "00111111"; //7
        System.out.println(firstOne(s,0,s.length()-1));
    }
    static int firstOne(String s,int lo,int hi){
        if(lo>hi) return lo;
        int mid = lo+ (hi-lo)/2;
        if(s.charAt(mid)=='1'){ // all of its right will be 1
            return firstOne(s,lo,mid-1);
        }else {
            return firstOne(s,mid+1,hi);
        }
    }

}
