package Arrays.HomeWork;

/*
only works for n/2 times -> moore voting algo

for n/k time do normal hashmap solution
 */
public class _169_Majority_Element {
    public int majorityElement(int[] nums) {
        int ele = -1,count = 0;
        for(int n: nums){
            if(count == 0){
                ele = n ;
                count = 1;
            }else{
                if(ele !=n ) count --;
                else count++;
            }
        }
        int res = 0;
        for(int n: nums) if(n ==  ele) res++;
        return res>(nums.length/2)? ele: -1;
    }
}
