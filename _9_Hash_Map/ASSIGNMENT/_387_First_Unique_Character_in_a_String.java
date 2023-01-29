package _9_Hash_Map.ASSIGNMENT;

public class _387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()) arr[c-'a']++;
        int ind=0;
        for(char c: s.toCharArray()){
            if(arr[c-'a']==1)
                return ind;
            ind++;
        }
        return -1;
    }
}
