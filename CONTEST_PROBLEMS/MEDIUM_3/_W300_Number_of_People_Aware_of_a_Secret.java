package CONTEST_PROBLEMS.MEDIUM_3;

public class _W300_Number_of_People_Aware_of_a_Secret {
    int[] memo;
    int mod = (int)1e9+7;
    public int peopleAwareOfSecret(int n, int d, int f) {
        memo = new int[n+1];
        for(int i=0;i<=n;i++)
            memo[i]=-1;
        return f(1,n,d,f)%mod;
    }
    int f(int day,int n,int d,int f){
        if(day>n) return 0;
        if(memo[day]!=-1) return memo[day];
        int sum = 0;
        for(int currDay = d;currDay<f;currDay++){
            sum=sum%mod + f(currDay+day,n,d,f)%mod;
        }
        // if current guy knows until last day (currday+forget>last day) he knows the secret in last day
        return memo[day] = ((day+f>n?1:0)%mod +sum%mod)%mod;
    }
}
