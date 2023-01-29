package _5_Arrays.HomeWork;

public class Count_Unique_Characters_of_All_Substrings_of_a_Given_String {
    public int uniqueLetterString(String s) {
        int res = 0;
        int[][] arr = new int[26][2];
        for(int i=0;i<26;i++)
            arr[i][0] = arr[i][1] = -1;
        for(int i=0;i<s.length();i++){
            int ind = s.charAt(i)-'A';
            res+=  (arr[ind][1]-arr[ind][0]) *(i-arr[ind][1]);
            arr[ind][0] = arr[ind][1];
            arr[ind][1] = i;
        }
        int N = s.length();
        for(int ind=0;ind<26;ind++){
            res+=  (arr[ind][1]-arr[ind][0])*(N-arr[ind][1]);
        }
        return res;
    }
}
