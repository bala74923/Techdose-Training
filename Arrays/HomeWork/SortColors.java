package Arrays.HomeWork;

public class SortColors {
    public void sortColors(int[] nums) { //with extra space
        // low range , high frequency
        int[] arr= new int[3];
        // step 1
        for(int n:nums)
            arr[n]++;
        // step 2
        arr[1]+= arr[0];
        arr[2]+= arr[1];
        //step 3
        int[] out = new int[nums.length];

        for(int i= nums.length-1;i>=0;i--){
            out[--arr[nums[i]]] = nums[i];
        }
        for(int i=0;i<nums.length;i++)
            nums[i] = out[i];
    }
    void sort(int[] nums){ //without extra space
        int[] arr= new int[3];
        // step 1
        for(int n:nums)
            arr[n]++;
        int index=0;
        for(int i=0;i<=2;i++){
            while(arr[i]!=0){
                nums[index++] = i;
                arr[i]--;
            }
        }
    }
}
