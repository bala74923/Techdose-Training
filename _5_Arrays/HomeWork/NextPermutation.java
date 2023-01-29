package _5_Arrays.HomeWork;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int ind = findLastIncreasing(nums);
        if(ind==-1){
            rev(nums,0,nums.length-1);
            return ;
        }
        int mind = findMinLargeElement(nums,ind);
        swap(nums,ind,mind);
        rev(nums,ind+1,nums.length-1);
    }
    void rev(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }
    void swap(int[] nums,int i,int j){
        int temp= nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int findMinLargeElement(int[] nums,int i){
        int res = -1;
        for(int ind=i+1;ind<nums.length;ind++){
            if(nums[i]<nums[ind]){
                if(res==-1 || nums[res]>=nums[ind]) {
                    res = ind;
                    // should find last near because they are in descending order
                }
            }
        }
        return res;
    }
    int findLastIncreasing(int[] nums){
        for(int index=nums.length-2;index>=0;index--){
            if(nums[index]<nums[index+1])
                return index;
        }
        return -1;
    }
}
