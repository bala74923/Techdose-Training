package CONTEST_PROBLEMS.HARD_4;

public class _w310_Longest_Increasing_Subsequence_II {
    public int lengthOfLIS(int[] nums, int k) {
        return solve(nums,k);
    }
    static int solve(int[] arr,int k){
        segmentTree seg = new segmentTree();
        int res = 0;

        for(int val: arr){
            int gotVal = seg.query( Math.max(val-k,0) , val)+1;// val because strictly increasing
            //System.out.println("res = "+res+" for val="+val);
            seg.update(val,gotVal);
            res = Math.max(res,gotVal);
        }

        return res;
    }
}
class segmentTree{
    int size = 100001;
    int[] arr;
    segmentTree(){
        arr = new int[2*size];
    }
    void update(int pos,int val){
        pos+=size;
        arr[pos] = val;
        while(pos>1){
            arr[pos>>1] = Math.max(arr[pos],arr[pos^1]);
            pos>>=1;
        }
    }
    int query(int left,int end){
        left+=size;
        end+=size;
        int res= 0;
        while(left<end){
            if((left&1)==1) // right children
                res = Math.max(res,arr[left++]);
            if((end&1)==1)
                res = Math.max(res,arr[--end]);
            //System.out.printf("lo=%d hi=%d\n",left,end);
            left>>=1;
            end>>=1;
        }
        return  res;
    }
}
