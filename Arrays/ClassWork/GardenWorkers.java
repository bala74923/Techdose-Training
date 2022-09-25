package Arrays.ClassWork;

public class GardenWorkers {
    public static void main(String[] args) {
        int[] arr = {5,8,2,10,11,12};
       int workers = 3;
        int min_value= arr[0], max_value = 0;
        for(int n: arr){
            min_value = Math.max(min_value,n);
            max_value +=n;
        }
        /*
        min_value = one worker for each garden (max of all time)
        max_value = one worker for all garden (sum of all time)
         */
        int lo = min_value, hi = max_value;
        while(lo<=hi){
            int mid = lo+ (hi-lo)/2;
            if(check(arr,workers,mid)){
                hi = mid-1;
            }else lo =mid+1;
        }
        System.out.println(min_value+" - "+max_value);
        System.out.println(lo);
    }
    static boolean check(int[] gardens,int workers,int ability){
        int  t = ability;
        for(int n: gardens){
            if(t<n) {
                if(workers==1) return false;
                t=  ability;
                workers--;
            }
            if(t>=n)t-=n;
            else return false;
        }
        return true;
    }

}
