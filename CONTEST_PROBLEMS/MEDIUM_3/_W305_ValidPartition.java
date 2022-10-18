package CONTEST_PROBLEMS.MEDIUM_3;

public class _W305_ValidPartition {
    int[] memo;
    public boolean validPartition(int[] nums) {
        memo = new int[nums.length+1];
        for(int i=0;i<=nums.length;i++)
            memo[i]=-1;
        return rec(0,nums);
    }
    boolean rec(int i,int[] nums){
        if(i==nums.length) return true;
        if(memo[i]!=-1) return memo[i]==1;
        boolean res = false;
        if(i+1<nums.length && nums[i]==nums[i+1]) {
            res= res||rec(i+2,nums);
            if(i+2<nums.length && nums[i]==nums[i+2])
                res  = res||rec(i+3,nums);
        }
        if(i+2<nums.length && nums[i]+1==nums[i+1] && nums[i+1]+1==nums[i+2])
            res= res|| rec(i+3,nums);
        memo[i] = res?1:0;
        return res;
    }
}
