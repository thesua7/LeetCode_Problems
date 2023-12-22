public class Main {
    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));


    }

     // Blind - 75
    // 121. Best time to buy and sell stock
    public static int maxProfit(int[] prices) {

        int maxValue = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxValue = Math.max(profit, maxValue);
            } else {
                left = right;
            }
            right++;
        }
        return maxValue;

    }
}