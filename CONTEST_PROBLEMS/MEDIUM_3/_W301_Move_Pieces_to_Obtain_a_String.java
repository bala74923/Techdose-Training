package CONTEST_PROBLEMS.MEDIUM_3;

public class _W301_Move_Pieces_to_Obtain_a_String {
    public boolean canChange(String s, String t) {
        int i = 0,j =0;
        while(i<s.length() || j<t.length()){
            while(i<s.length() && s.charAt(i)=='_') i++;
            while(j<t.length() && t.charAt(j)=='_') j++;
            if(i==s.length() || j==t.length() || s.charAt(i)!=t.charAt(j) || (s.charAt(i)=='L' && i<j)
                    || (s.charAt(i)=='R' && i>j)) {
                break;
            }
            i++;j++;
        }
        return i==s.length() && j==t.length();
    }
}
