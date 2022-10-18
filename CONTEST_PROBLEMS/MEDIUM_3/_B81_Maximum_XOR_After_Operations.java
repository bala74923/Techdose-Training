package CONTEST_PROBLEMS.MEDIUM_3;

public class _B81_Maximum_XOR_After_Operations {
    public int maximumXOR(int[] nums) {
        int res = 0;
        for(int n: nums) res|=n;
        return res;
    }
}
/*
            8 4 2 1
            =========
            0 0 0 0 -1
            0 0 1 0 -2
            0 0 1 1 -3
            1 0 0 1 -9
            0 0 1 0 -2

            to maximize result we have to remove overlapping ones
            which cause xor of 2 element to reduction

            we can do that for example
            in 2 - 0 0 1 0
            in 3 - 0 0 1 1
            here bit in 1'th position from right is unwanted
            we can remove that by 3^2 (2 is x -> which is non negative)
            so we can remove any unecessary set bits as we want

            so bitwise or of all elements is answer
            where all the bits is set in all elements of array are setted
            we dont think about xor of all elements (as per qn) will remove overlapping 1's
            we avoid that by removing overlapping 1's by xoring with required number
        */