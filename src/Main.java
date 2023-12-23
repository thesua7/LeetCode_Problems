public class Main {
    public static void main(String[] args) {

        int[] prices = new int[]{1, 2, 3, 4};
        System.out.println("121. problem: " + maxProfit(prices));

        for (int i = 0; i < productExceptSelf(prices).length; i++) {
            System.out.println("57. problem: " + productExceptSelf(prices)[i]);
        }


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


    // 53. Maximum Subarray
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] result = new int[nums.length];

        int product = 1;

        for (int i = 0; i < prefix.length; i++) {
            prefix[i] = 1;
            postfix[i] = 1;
        }


        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = 1;
            } else {
                product = nums[i - 1] * product;
                prefix[i] = product;
            }
        }


        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfix[i] = 1;
            } else {
                product = nums[i + 1] * product;
                postfix[i] = product;
            }
        }

        for (int i = 0; i < prefix.length; i++) {
            prefix[i] = prefix[i] * postfix[i];
        }

        return prefix;
    }
}