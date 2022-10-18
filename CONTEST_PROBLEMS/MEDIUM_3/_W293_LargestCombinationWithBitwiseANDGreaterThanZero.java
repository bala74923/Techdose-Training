package CONTEST_PROBLEMS.MEDIUM_3;

public class _W293_LargestCombinationWithBitwiseANDGreaterThanZero {
    public int largestCombination(int[] arr) {
        int[] count = new int[32];
        for(int val: arr){
            int ind = 0;
            while((1<<ind)<=val){
                if((val&(1<<ind))!=0) count[ind]++;
                ind++;
            }
        }
        int max = 0;
        for(int n: count) max = Math.max(max,n);
        return max;
    }
}
