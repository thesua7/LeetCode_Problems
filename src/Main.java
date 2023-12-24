public class Main {
    public static void main(String[] args) {

        int[] prices = new int[]{1, 2, 3, 4};
        System.out.println("121. problem: " + maxProfit(prices));


        for (int i = 0; i < productExceptSelf(prices).length; i++) {
            System.out.println("238. problem: " + productExceptSelf(prices)[i]);
        }
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("57. problem: " + maxSubArray(nums));

        int[] nums1 = new int[]{2, 3, -2, 4};
        System.out.println("152. problem: " + maxProduct(nums1));

        int[] nums2 = new int[]{3, 4, 5, 1, 2};
        System.out.println("153. problem: " + finMin(nums2));


        int[] nums3 = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println("33. problem: " + search(nums3, 0));


        int[] nums4 = new int[]{2,7,11,15};
        int[] result167 = twoSum(nums4, 9);

        for (int i=0;i<result167.length;i++){
            System.out.println("167. problem: "+result167[i]);
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

    // 238. Product of Array Except Self
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


    // 53. Maximum Subarray
    public static int maxSubArray(int[] nums) {

        int maxSub = nums[0];
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum = currentSum + nums[i];
            maxSub = Math.max(currentSum, maxSub);
        }

        return maxSub;
    }

    // 152. Maximum Product

    public static int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;

        int max = Integer.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));

        }

        return max;


    }


    // 153. Find Minimum in Rotated Sorted Array
    public static int finMin(int[] nums) {
        int result = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                result = Math.min(result, nums[left]);
                break;
            }
            int middle = (left + right) / 2;
            result = Math.min(nums[middle], result);
            if (nums[middle] >= nums[left]) {
                left = middle + 1;

            } else {
                right = middle - 1;
            }
        }
        return result;
    }



    // 33. Search in Rotated Sorted Array
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    // 167. Two Sum II - Input Array Is Sorted
    public static int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right= numbers.length-1;
        int currentSum = 0;
        while (left<right){
            currentSum = numbers[left]+numbers[right];
            if (currentSum>target){
                right = right-1;
            }
            else if (currentSum<target){
                left = left +1;
            }
            else {
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{};
    }
}