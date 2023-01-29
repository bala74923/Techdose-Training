package _17_Dp.Strings;

public class _161_One_Edit_Distance {
    public boolean isOneEditDistance(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        return f(n1,n2,1,s1,s2);
        // recursion is best because it can run until 3*n thats all
        // if we use dp will calculate unwanted cases more
    }
    // can we make one change and make it as same
    boolean f(int i,int j,int rem,String s1,String s2){
        if(i ==0 && j == 0) return rem==0;
        if(i==0 || j==0 ){
            // if remaining has 1chance we can change until one
            if(rem==1) return i==1 || j==1;
            return false; // if no chance still unequal then false
        }
        if(s1.charAt(i-1) ==  s2.charAt(j-1)){
            return f(i-1,j-1, rem, s1,s2);
        }else if(rem == 1){
            return f(i,j-1,0,s1,s2) || f(i-1,j,0,s1,s2) || f(i-1,j-1,0,s1,s2);
        }
        return false;
    }
}
