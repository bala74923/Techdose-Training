package CONTEST_PROBLEMS.MEDIUM_3;

public class _W297_Fair_Distribution_of_Cookies {
    public int distributeCookies(int[] cookies, int k) {
        return f(0,new int[k],cookies);
    }
    int f(int ind,int[] arr,int[] cookies){
        if(ind==cookies.length) return max(arr);
        // cookies can be given to any child 0 to k-1
        int res=  Integer.MAX_VALUE;
        for(int c=0;c<arr.length;c++){
            arr[c]+=cookies[ind];
            res = Math.min(res, f(ind+1,arr,cookies));
            arr[c]-=cookies[ind];
        }
        return res;
    }
    int max(int[] arr){
        //System.out.println(Arrays.toString(arr));
        int res = 0;
        for(int n:arr) res = Math.max(res,n);
        return res;
    }
}
