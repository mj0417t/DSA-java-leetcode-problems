public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = new int[]{7,6,4,3,1};
        int maxProfit=Integer.MIN_VALUE;

        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>0){
                    maxProfit=Math.max(maxProfit,prices[j]-prices[i]);
                }
            }
        }
maxProfit=(maxProfit>0)?maxProfit:0;
        System.out.println("Max Profit possible: "+maxProfit);
    }
}
