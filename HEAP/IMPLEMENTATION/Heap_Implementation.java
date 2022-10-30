package HEAP.IMPLEMENTATION;

import java.util.Arrays;

class Heap{ // here maxHeap
    static void heapify(int[] arr,int N, int index){ // tc->o(Log N)
        int left= index<<1;//(2*i)
        int right = (index<<1)|1;//(2*i+1)
        int largest = index;
        if(left<N && arr[left]>arr[largest]) largest = left;
        if(right<N && arr[right]>arr[largest]) largest = right;
        if(largest!=index){ // at wrong position
            swap(arr,largest,index);
            heapify(arr,N,largest); // go at check that position is suitable or not
        }
    }

    static void perculateDown(int[] arr,int N,int index){
        heapify(arr,N,index);
    }
    static void perculateUp(int[] arr,int N,int index){ // tc-> o(Log N)
        // 1 is root , elements above one has roots ,1 does'nt
        while(index>1 && arr[index/2]<arr[index]){
            swap(arr,index,index/2);
            index = index/2;
        }
    }

    static void buildHeap(int[] arr,int N){ //tc->o(N)
        // non leaf nodes 0 to ceil(n/2) or 0 to 2^(h-1)
        int mid = (N>>1)+(N&1);
        for(int index=mid;index>=1;index--){
            heapify(arr,N,index);
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp  =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int heap_pop(int[] arr,int N){
        int max = arr[1];
        arr[1]= arr[N-1]; // replace index 1 by last element
        N--; // decrease the size
        perculateDown(arr,N,1);
        return max;
    }
    static void heap_push(int[] arr,int N,int value){
        arr[N++] = value;
        perculateUp(arr,N,N-1) ; // perculate the last index
    }
    static void increase_key(int[] arr, int N, int index,int diff){
        if(diff<0) {
            return ; // wrong difference
        }
        arr[index]+=diff;
        perculateUp(arr,N,index);
    }
    static void decrease_key(int[] arr,int N,int index,int diff){
        if(diff>0){
            return; // wrong difference
        }
        arr[index]+=diff;
        perculateDown(arr,N,index);
    }
    static int[] heapSort(int[] arr,int N){
        buildHeap(arr,N); // now it is heap
        int heapSize = N;
        int[] res = new int[N-1]; //// skip 0 th element
        for(int i=1;i<N;i++) {
            res[i-1] = heap_pop(arr, heapSize);
            heapSize--;
        }
        return res;
    }
}
public class Heap_Implementation {
    public static void main(String[] args) {
        int[] arr = {0,8,6,9,3,4,2,1};
        int N = arr.length;

        arr = Heap.heapSort(arr,N);

        System.out.println(Arrays.toString(arr));
    }
}
