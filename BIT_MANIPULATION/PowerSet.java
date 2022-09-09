package BIT_MANIPULATION;
 class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int len = arr.length;

        for(int i=0;i<(1<<len);i++){
            for(int j=0;j<len;j++){
                if((i&(1<<j))!=0){
                    System.out.print(arr[j]+" ");
                }
            }
            System.out.println();
        }
    }
}
