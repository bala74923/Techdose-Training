package Arrays.HomeWork;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int N=prices.length,max=prices[N-1], res =0;
        for(int i=N-2;i>=0;i--){
            int buy = prices[i];
            res = Math.max(res,max-buy);
            max = Math.max(max,buy);
        }
        return res;
    }
}
